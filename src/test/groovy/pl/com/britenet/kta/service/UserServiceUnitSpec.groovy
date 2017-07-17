package pl.com.britenet.kta.service

import pl.com.britenet.kta.dtos.RoleDto
import pl.com.britenet.kta.dto.user.UserDto
import pl.com.britenet.kta.entity.user.Role
import pl.com.britenet.kta.entity.user.RoleType
import pl.com.britenet.kta.entity.user.User
import pl.com.britenet.kta.repositories.RoleRepository
import pl.com.britenet.kta.repository.UserRepository
import spock.lang.Specification
import spock.lang.Unroll

class UserServiceUnitSpec extends Specification {

    UserRepository userRepository = Mock(UserRepository)
    RoleRepository roleRepository = Mock(RoleRepository)

    UserService userResource = new UserService(userRepository, roleRepository)

    @Unroll("[#iterationCount]#featureName")
    def "should find users"() {
        when:
        def result = userResource.findAll()

        then:
        1 * userRepository.findAll() >> users

        result
        result.size() == expectedResult

        where:
        users                                                                                                                                                                                                                             || expectedResult
        [new User("id1", "login", "password", "email", "phoneNumber", new Role("roleId1", RoleType.ADMINISTRATOR, null))]                                                                                                                 || 1
        [new User("id1", "login", "password", "email", "phoneNumber", new Role("roleId1", RoleType.ADMINISTRATOR, null)), new User("id2", "login", "password", "email", "phoneNumber", new Role("roleId2", RoleType.WOLONTARIUSZ, null))] || 2
    }

    @Unroll("[#iterationCount]#featureName")
    def "should find user"() {
        given:
        def id = "id"
        def role = new Role("roleId", RoleType.ADMINISTRATOR, [] as Set)
        def user = new User(id, "login", "password", "email", "phoneNumber", role)

        when:
        def result = userResource.findOne(id)

        then:
        1 * userRepository.findOne(id) >> user

        result
        result.id == user.id
        result.login == user.login
        result.password == user.password
        result.role.id == user.role.id
        result.role.roleType == user.role.roleType
    }

    @Unroll("[#iterationCount]#featureName")
    def "should add user"() {
        given:
        def id = "id"
        def roleDto = new RoleDto(id: "roleId", roleType: RoleType.ADMINISTRATOR)
        def userDto = new UserDto(null, "login", "password", "email", "phoneNumber", roleDto)

        when:
        def result = userResource.add(userDto)

        then:
        1 * roleRepository.findOne(userDto.role.id) >> new Role("roleId", RoleType.ADMINISTRATOR, null)
        1 * userRepository.save(_ as User) >> { User user ->
            user.id = id
            user
        }
        result
    }

    @Unroll("[#iterationCount]#featureName")
    def "should throw exception during adding user"() {
        given:
        def newUser = new UserDto(null, "login", "password",
                "email", "phoneNumber", roleDto)
        when:
        userResource.add(newUser)

        then:
        a * roleRepository.findOne(newUser.role.id) >> findedRole

        def exception = thrown(RuntimeException)
        exception.message == expectedMessage

        where:
        roleDto                                   | a | findedRole                                       || expectedMessage
        new RoleDto(null, RoleType.ADMINISTRATOR) | 0 | null                                             || "nie ma takiej roli"
        new RoleDto("roleId", RoleType.KSIEGOWA)  | 1 | null                                             || "nie ma takiej roli"
        new RoleDto("roleId", RoleType.KSIEGOWA)  | 1 | new Role("roleId", RoleType.ADMINISTRATOR, null) || "nie ma takiej roli"
    }
}

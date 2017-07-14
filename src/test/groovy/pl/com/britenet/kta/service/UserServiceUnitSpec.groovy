package pl.com.britenet.kta.service

import pl.com.britenet.kta.entity.user.Permission
import pl.com.britenet.kta.entity.user.Role
import pl.com.britenet.kta.entity.user.RoleType
import pl.com.britenet.kta.entity.user.User
import pl.com.britenet.kta.repository.RoleRepository
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
        users                    || expectedResult
        [new User()]             || 1
        [new User(), new User()] || 2
    }

    @Unroll("[#iterationCount]#featureName")
    def "should find user"() {
        given:
        def id = "id"
        def permissions = [new Permission(description: "addUser")] as Set
        def role = new Role(id: "roleId", roleType: RoleType.ADMINISTRATOR, permissions: permissions)
        def user = new User(id, "login", "password", "email", "phoneNumber", role)

        when:
        def result = userResource.findOne(id)

        then:
        1 * userRepository.findOne(id) >> user

        result
        result.id == user.id
        result.login == user.login
        result.password == user.password
        result.role == user.role
        result.role.permissions == user.role.permissions
    }

    @Unroll("[#iterationCount]#featureName")
    def "should add user"() {
        given:
        def id = "id"
        def role = new Role(id: "roleId", roleType: RoleType.ADMINISTRATOR)
        def newUser = new User(null, "login", "password", "email", "phoneNumber", role)

        when:
        def result = userResource.add(newUser)

        then:
        1 * roleRepository.findOne(newUser.role.id) >> role
        1 * userRepository.save(newUser) >> { User user ->
            user.id = id
            user
        }
        result
    }

    @Unroll("[#iterationCount]#featureName")
    def "should throw exception during adding user"() {
        given:
        def newUser = new User(null, "login", "password",
                "email", "phoneNumber", userRole)
        when:
        userResource.add(newUser)

        then:
        a * roleRepository.findOne(newUser.role.id) >> findedRole

        def exception = thrown(RuntimeException)
        exception.message == expectedMessage

        where:
        userRole                                             | a | findedRole                                               || expectedMessage
        new Role(id: null, roleType: RoleType.ADMINISTRATOR) | 0 | null                                                     || "nie ma takiej roli"
        new Role(id: "roleId", roleType: RoleType.KSIEGOWA)  | 1 | null                                                     || "nie ma takiej roli"
        new Role(id: "roleId", roleType: RoleType.KSIEGOWA)  | 1 | new Role(id: "roleId", roleType: RoleType.ADMINISTRATOR) || "nie ma takiej roli"
    }
}

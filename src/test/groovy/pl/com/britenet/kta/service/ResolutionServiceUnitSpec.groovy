package pl.com.britenet.kta.service

import pl.com.britenet.kta.entity.membership.MemberOfAssociation
import pl.com.britenet.kta.entity.resolution.Resolution
import pl.com.britenet.kta.repositories.MemberOfAssociationRepository
import pl.com.britenet.kta.repositories.ResolutionRepository
import pl.com.britenet.kta.services.ResolutionsService
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate

/**
 * Created by Britenet on 2017-07-17.
 */
class ResolutionServiceUnitSpec extends Specification{


    ResolutionRepository resolutionRepository = Mock(ResolutionRepository);
    MemberOfAssociationRepository memberOfAssociationRepository = Mock(MemberOfAssociationRepository);

    ResolutionsService resolutionsService = new ResolutionsService(resolutionRepository);

    @Unroll("[#iterationCount]#featureName")
    def "should find resolution"(){
        when:
        def result = resolutionsService.getAllResolutions()

        then:
        1 * resolutionRepository.findAll() >> resolutions

        result
        result.size() == expectedResult

        where:
        resolutions || expectedResult
        [new Resolution("title", "desc", "num", LocalDate.now(), LocalDate.now(), new MemberOfAssociation())] || 1

    }
}

package io.areguig.sample

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

/**
 * Created by akli on 01/04/2017.
 */
@ActiveProfiles("test")
@SpringBootTest(classes = BootTestContainersSpockApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationContextIntegrationSpec extends Specification{

    @Autowired
    ApplicationContext context

    def "should boot up without errors"() {
        expect:
        context != null
        context.containsBean("bootTestContainersSpockApplication")
    }
}

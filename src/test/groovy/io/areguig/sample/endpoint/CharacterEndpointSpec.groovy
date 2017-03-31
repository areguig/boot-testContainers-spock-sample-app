package io.areguig.sample.endpoint

import io.areguig.sample.BootTestContainersSpockApplication
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import spock.lang.AutoCleanup
import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by akli on 01/04/2017.
 */
@ActiveProfiles("test")
@SpringBootTest(classes = BootTestContainersSpockApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CharacterEndpointSpec extends Specification {
    @Value('${local.server.port}')
    int port;


    @Shared
    @AutoCleanup
    def restClient

    def setup() {
        if(restClient == null){
            restClient =  new RESTClient("http://localhost:8000")
            login(restClient)
        }
    }
}

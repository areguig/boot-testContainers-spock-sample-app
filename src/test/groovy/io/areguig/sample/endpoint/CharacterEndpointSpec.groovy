package io.areguig.sample.endpoint

import io.areguig.sample.BootTestContainersSpockApplication
import io.areguig.sample.entity.Character
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.test.context.ActiveProfiles
import spock.lang.Specification

/**
 * Created by akli on 01/04/2017.
 */
@ActiveProfiles("test")
@SpringBootTest(classes = BootTestContainersSpockApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CharacterEndpointSpec extends Specification {

    @Autowired
    TestRestTemplate restTemplate

    void "should return 200 OK"() {
        when:
        ResponseEntity entity = restTemplate.getForEntity('/character', Character[].class)
        then:
        entity.statusCode == HttpStatus.OK
    }

    void "should return 404 when the endpoint doesn't exist"() {
        given: "An endpoint that doesn't exist (/nopEndpoint/)"
        when: "The endpoint is called using GET"
        ResponseEntity entity = restTemplate.getForEntity('/nopEndpoint/', String.class)
        then: "The returned status is 404 not found"
        entity.statusCode == HttpStatus.NOT_FOUND
    }


    void "should return the created object after creation (POST)"() {
        given: " The character Ragnar Lothbrok from the showName Vikings"
        def ragnar = new Character()
        ragnar.setFirstName("Ragnar")
        ragnar.setLastName("Lothbrok")
        ragnar.setShowName("Vikings")
        when: "The character is POSTED to /character endpoint"
        ResponseEntity entity = restTemplate.postForEntity('/character', ragnar, Character.class)
        then: "The returned status is 201 CREATED and the content is the created object with its id in the system."
        entity.statusCode == HttpStatus.CREATED
        entity.body.getFirstName() == ragnar.getFirstName()
        entity.body.getLastName() == ragnar.getLastName()
        entity.body.getShowName() == ragnar.getShowName()
        entity.body.getId() != null
    }

    void "should access a character via GET /character/{id} after creation via POST /character"() {
        given: " The character Walter White  from the showName Breaking Bad"
        def walter = new Character()
        walter.setFirstName("Walter")
        walter.setLastName("White")
        walter.setShowName("Breaking Bad")
        when: "The character Walter White is POSTED to /character endpoint"
        ResponseEntity created = restTemplate.postForEntity('/character', walter, Character.class)
        then: "The character is accessible via GET /character/{id} endpoint"
        ResponseEntity retrieved = restTemplate.getForEntity('/character/'+created.body.getId(), Character.class)
        retrieved.statusCode == HttpStatus.OK
        retrieved.body.getFirstName() == walter.getFirstName()
        retrieved.body.getLastName() == walter.getLastName()
        retrieved.body.getShowName() == walter.getShowName()
    }
}

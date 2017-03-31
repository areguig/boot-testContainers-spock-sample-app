package io.areguig.sample.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.areguig.sample.entity.Character;
import io.areguig.sample.repository.CharacterRepository;

/**
 * Created by akli on 31/03/2017.
 */
@RestController
@RequestMapping("/character")
public class CharacterEndpoint {

    @Autowired
    private CharacterRepository characterRepository;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Character>> getCharacters(){
        return new ResponseEntity<>(characterRepository.selectCharacters(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Character> getCharacter(@RequestParam Long id){
        return new ResponseEntity<>(characterRepository.selectCharacter(id), HttpStatus.OK);
    }

    @PostMapping(value = "",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
            ,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Character> postCharacter(@RequestBody Character character){
        return new ResponseEntity<>(character, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Character> deleteCharacter(@RequestParam Long id){
        return new ResponseEntity<>(characterRepository.selectCharacter(id), HttpStatus.OK);
    }
}

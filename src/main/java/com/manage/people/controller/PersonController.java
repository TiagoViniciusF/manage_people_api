package com.manage.people.controller;

import com.manage.people.dto.AdressDto;
import com.manage.people.dto.PersonDto;
import com.manage.people.model.Adress;
import com.manage.people.model.Person;
import com.manage.people.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin(origins ="*", maxAge = 3600)
public class PersonController {

    @Autowired
    PersonService personService;
    @PostMapping
    public ResponseEntity<Object> savePerson(@RequestBody @Valid PersonDto personDto){
        var personModel = new Person();
        var listAdress = new ArrayList<Adress>();

        BeanUtils.copyProperties(personDto, personModel);
        for (AdressDto adressDto:personDto.getAdress()) {
            var adressModel = new Adress();
            BeanUtils.copyProperties(adressDto,adressModel);
            listAdress.add(adressModel);
        }
        personModel.setAdress(listAdress);
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(personModel));
    }
    @PutMapping("/{pessoasId}")
    public ResponseEntity<Object> updatePerson(@PathVariable(value="pessoasId") Long id,
                                               @RequestBody @Valid PersonDto personDto) {
        Optional<Person> personOptional = personService.findById(id);
        if (!personOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course Not Found");
        }

        var personModel = personOptional.get();
        var listAdress = new ArrayList<Adress>();

        BeanUtils.copyProperties(personDto, personModel);
        for (AdressDto adressDto:personDto.getAdress()) {
            var adressModel = new Adress();
            BeanUtils.copyProperties(adressDto,adressModel);
            listAdress.add(adressModel);
        }
        personModel.setAdress(listAdress);
        return ResponseEntity.status(HttpStatus.OK).body(personService.save(personModel));
    }


    @GetMapping
    public ResponseEntity<List<Person>> getAllPerson(){
        return ResponseEntity.status(HttpStatus.OK).body(personService.findAll());
    }

    @GetMapping("/{pessoasId}")
    public ResponseEntity<Object> getOnePerson(@PathVariable(value="pessoasId") Long id) {
        Optional<Person> personOptional = personService.findById(id);
        if (!personOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Course Not Found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(personOptional.get());
    }

    @DeleteMapping("/{pessoasId}")
    public ResponseEntity<Object> deletePerson(@PathVariable(value="pessoasId") Long id){
        Optional<Person> personOptional = personService.findById(id);

        if(!personOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person Not Found");
        }
        personService.delete(personOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Course deleted successfully");
    }

}

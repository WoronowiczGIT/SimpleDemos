package com.example.demo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Url do controllera -> serveradress:port/api/people
@RequestMapping(path = "/api/people")
public class PersonRestController {

    @Autowired
    private PersonService personService;
    // controller wie o servisach i ich uzywa
    @RequestMapping(method = RequestMethod.GET, path = "/fetch")
    public List<Person> fetchAll(){
        return personService.fetchAll();
    }
    @RequestMapping(method = RequestMethod.POST, path = "/save")
    public Person save(@RequestBody PersonCommand personCommand ){
        return personService.save(personCommand);
    }

    @RequestMapping(method = RequestMethod.GET,path = "/fetch/{id}")
    public ResponseEntity fetch(@PathVariable Long id){
        Person person = personService.fetch(id);
        if(person == null){
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<Person>(person,HttpStatus.ACCEPTED);
    }
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete/{id}")
    public ResponseEntity<Person> delete (@PathVariable Long id){
        Person person = personService.delete(id);
        if(person == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<Person>(person,HttpStatus.OK);
    }


    // mapujemy jakim zapytaniem http ma byc ta metoda
    // jesli nie ustalimy scieżki, metoda zostanie wywolana automatycznie
    // dlatego dla akzdej metody publicznej powinna byc zadeklarowana inna sciezka
    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String sayHello(){
        return "Elo";
    }




}

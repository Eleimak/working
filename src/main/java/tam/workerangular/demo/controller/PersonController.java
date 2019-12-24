package tam.workerangular.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tam.workerangular.demo.model.Person;
import tam.workerangular.demo.services.PersonService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @RequestMapping("/get/list")
    List<Person> showAll(){
        return personService.getAll();
    }

    @RequestMapping("/get/list/{from}/{amount}")
    List<Person> showPage(@PathVariable("from")int from,
                          @PathVariable("amount")int amount){
        return personService.getAll().subList(from-1, amount);
        //return personService.getPage(from, amount);
    }

    @RequestMapping("/get/{id}")
    Person getId(@PathVariable("id")int id){
        return personService.get(id);
    }

    @RequestMapping("/delete/{id}")
    Person delete(@PathVariable("id")int id){
        return personService.delete(id);
    }

    @PostMapping("/create")
    Person create(@Valid @RequestBody Person person){
        return personService.create(person);
    }

    @RequestMapping("/list/name/{mode}")
    List<Person> showAllSorted(@PathVariable("mode")boolean mode){
        return (mode) ? personService.getAll().stream().sorted((person, t1)
                -> person.getName().compareTo(t1.getName())).collect(Collectors.toList())
                : personService.getAll().stream().sorted((person, t1)
                -> t1.getName().compareTo(person.getName())).collect(Collectors.toList());
    }

    @PostMapping("/delete/list")
    int deleteList(@Valid @RequestBody List<Integer> integerList){
//        for (Integer items :
//                integerList) {
//            this.delete(items);
//        }
//        return 0;
        return this.personService.deleteAll(integerList);
    }

}

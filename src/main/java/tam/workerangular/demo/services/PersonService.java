package tam.workerangular.demo.services;

import org.springframework.stereotype.Service;
import tam.workerangular.demo.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonService {

    private List<Person> people = new ArrayList<>(
            Arrays.asList(
                    new Person(1,"John Lennon", LocalDate.now().minusYears(70),true),
                    new Person(2,"Freddy Mercury", LocalDate.now().minusYears(60),true),
                    new Person(3,"Curt Cobain", LocalDate.now().minusYears(65),true),
                    new Person(4,"Till  Lindemann", LocalDate.now().minusYears(67),true),
                    new Person(5,"Tarja Turunen", LocalDate.now().minusYears(55),false)
            )
    );

    public Person create(Person person){
        person.setId(people.stream().mapToInt(Person::getId).boxed().max(Integer::compareTo).orElse(0) + 1);
        people.add(person);
        return person;
    };

    public Person get(int id){
        return people.stream().filter(person -> person.getId()==id).findFirst().orElse(null);
    }

    public Person delete(int id){
        Person personDelete = this.get(id);
        people.remove(personDelete);
        return personDelete;
    }

    public List<Person> getAll(){
        return this.people;
    }
}

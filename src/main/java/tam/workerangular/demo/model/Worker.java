package tam.workerangular.demo.model;

import java.util.Objects;

public class Worker {

    private int id;
    private Person person;
    private String speciality;
    private int salary;

    public Worker() {
    }

    public Worker(Person person, String speciality, int salary) {
        this.person = person;
        this.speciality = speciality;
        this.salary = salary;
    }

    public Worker(int id, Person person, String speciality, int salary) {
        this.id = id;
        this.person = person;
        this.speciality = speciality;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", person=" + person +
                ", speciality='" + speciality + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return id == worker.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

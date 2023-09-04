package Wissen;

//array- 1->n 1 duplicate

import java.util.Date;
import java.util.Objects;

public class Employee {

     String name;
     Date dob;
     int salary;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && Objects.equals(name, employee.name) && Objects.equals(dob, employee.dob);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode()+this.dob.hashCode()+this.salary;
    }
}



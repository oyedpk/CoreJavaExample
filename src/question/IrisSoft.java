package question;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public class IrisSoft {
    public static void main(String[] args) {
        Employee emp1=new Employee("1234","ABCD");
        Employee emp2=new Employee("1234","ABCD");

        Map<Employee,Integer> map = new HashMap<>();
        map.put(emp1,1);
        map.put(emp2,2);

        emp1.setId("1234");
        emp1.setName("ABCD");
        System.out.println(map);
        System.out.println(map.get(new Employee("1234","ABCD")));

    }
}

class Employee {
    private String id;
    private String name;

    Employee(String id,String name) {
        this.id=id;
        this.name=name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        Employee employee = (Employee) obj;
        if(this.getId()!=null && this.getName()!=null &&
            this.getId().equals(employee.getId()) && this.getName().equals(employee.getName()))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
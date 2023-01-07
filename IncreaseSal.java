//import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
class Employee{
int id;
String name;
double sal;

public Employee(int id, String name, double sal){
this.id = id;
this.name = name;
this.sal = sal;
}

@Override
public String toString(){
return "Employee [id="+id+" , name="+name+" , sal="+sal+"]";
}

}

public class IncreaseSal{
public static void main(String args[]){

//Increase salary by 3000 for list of employees, where salary salary lessthan 20000.
List<Employee> emps = new ArrayList<>();
Employee e1 = new Employee(1,"A", 21000);
Employee e2 = new Employee(2,"B", 21000);
Employee e3 = new Employee(3,"C", 15000);
Employee e4 = new Employee(4,"D", 22000);
Employee e5 = new Employee(5,"E", 19000);

emps.add(e1); emps.add(e2); emps.add(e3); emps.add(e4); emps.add(e5);
//Expected output

Predicate<Employee> predicate = e -> e.sal < 20000;
Function<Employee, Employee> function = e -> {
e.sal = e.sal+3000;
return e;
};

//Output Before Update:[Employee [id=1 , name=A , sal=21000.0], Employee [id=2 , name=B , sal=21000.0], Employee [id=3 , name=C , sal=15000.0], Employee [id=4 , name=D , sal=22000.0], Employee [id=5 , name=E , sal=19000.0]]
System.out.println("Before Update:"+emps);

List<Employee> updatedSalEmpList = emps.stream().filter(predicate).map(x -> function.apply(x))
.collect(Collectors.toList());

//After update sal by 3000 where sal < 20000. Only updated List :[Employee [id=3 , name=C , sal=18000.0], Employee [id=5 , name=E , sal=22000.0]]
System.out.println("After update sal by 3000 where sal < 20000. Only updated List :"+updatedSalEmpList);

//After update sal by 3000 where sal < 20000. Complete List :[Employee [id=1 , name=A , sal=21000.0], Employee [id=2 , name=B , sal=21000.0], Employee [id=3 , name=C , sal=18000.0], Employee [id=4 , name=D , sal=22000.0], Employee [id=5 , name=E , sal=22000.0]]
System.out.println("After update sal by 3000 where sal < 20000. Complete List :"+emps);


}
}

# java8
Increase salary by 3000 for list of employees, where salary salary lessthan 20000

Try running below code.
E:\java8>javac IncreaseSal.java

E:\java8>java IncreaseSal
==================================================================================================
Output
==================================================================================================

Before Update:
  [Employee [id=1 , name=A , sal=21000.0], Employee [id=2 , name=B , sal=21000.0], Employee [id=3 , name=C , **sal=15000.0**], Employee [id=4 , name=D , sal=22000.0],     Employee [id=5 , name=E , **sal=19000.0**]]

After update sal by 3000 where sal < 20000. Only updated List :
  [Employee [id=3 , name=C , **sal=18000.0**], Employee [id=5 , name=E , **sal=22000.0**]]

After update sal by 3000 where sal < 20000. Complete List :
  [Employee [id=1 , name=A , sal=21000.0], Employee [id=2 , name=B , sal=21000.0], Employee [id=3 , name=C , **sal=18000.0**], Employee [id=4 , name=D , sal=22000.0], Employee [id=5 , name=E , **sal=22000.0**]]

============================================================================================

Code:
**Method1 fully Java8 way code:**
**With Predicate and Function**

Predicate<Employee> predicate = e -> e.sal < 20000;

Function<Employee, Employee> function = e -> {
e.sal = e.sal+3000;
return e;
};
  
List<Employee> updatedSalEmpList = emps.stream().filter(**predicate**).map(x -> **function.apply(x)**)
.collect(Collectors.toList());
  

	
Code:
**Method2 Java8 way code:**
**With Predicate, Function and For loop**
	
Predicate<Employee> predicate = e -> e.sal < 20000;
						   
Function<Employee, Employee> function = e -> {
e.sal = e.sal+3000;
return e;
};

	
this is only changed. here l2 contains employee details whose salary got increased by 3000

List<Employee> l2 = new ArrayList<>();
		for (Employee e : emps) {
			if (predicate.test(e)) {
				l2.add(function.apply(e));
			}
		}
	
**Note:** **emps** list will have all details with updated salaries. 

	
	
Code:
**Method3 Java8 way code:**
**Without Predicate and Function**

	
this is only changed. here l2 contains employee details whose salary got increased by 3000

	
List<Employee> empList = emps.stream().filter(**e -> e.getSalary() < 20000**).map( x -> **new Employee(x.getId(), x.getName(),x.getSalary()+3000)**)
				.collect(Collectors.toList());
	
**Note:** **emps** list will not have all details with updated salaries. only **empList** will have updated salaries.

	

Code:
**Method4 Java11 way code:**
**With Predicate and Function**

Predicate<Employee> predicate = e -> e.sal < 20000;

Function<Employee, Employee> function = e -> {
e.sal = e.sal+3000;
return e;
};
  
List<Employee> updatedSalEmpList = emps.stream().filter(**predicate**).map(x -> **function.apply(x)**)
**.toList()**; // instead of .collect(Collectors.toList()); we can use **.toList()** 

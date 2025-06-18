package capgeminiInterview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;

public class ThirdHighestSalEmployee {

	
	public static void main(String[] args) {
		 List<Employee> employees = Arrays.asList(
		            new Employee(1, "Nitish", "IT", 75000),
		            new Employee(2, "Aman", "HR", 55000),
		            new Employee(3, "Ravi", "IT", 80000),
		            new Employee(4, "Sneha", "Finance", 50000),
		            new Employee(5, "Anjali", "IT", 60000),
		            new Employee(6, "Rahul", "HR", 90000)
		        );
		 //printing thirdHighest salaried employee
		 Optional<Employee> thirdHighest= employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).distinct().skip(2).findFirst();
		 thirdHighest.ifPresent(System.out::println);
		 //printing sorted list on sal
		 List<Employee> sortedist= employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).collect(Collectors.toList());
        sortedist.forEach(System.out::println);
        
        //group by department
        Map<String , List<Employee>> empByDept= employees.stream().collect(Collectors.groupingBy(Employee::getDepartent,Collectors.collectingAndThen(Collectors.toList(), list->list.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).collect(Collectors.toList())
        		)));
        empByDept.forEach((dept, emplist)-> {
        	System.out.println("Department: "+dept);
        	emplist.forEach(System.out::print);
        	System.out.println();
        });
        //count of employee belonging to each department
        
      Map<String, Long> countEmpByDept= employees.stream().collect(Collectors.groupingBy(Employee::getDepartent,Collectors.counting()));
      countEmpByDept.forEach((dept,count)-> System.out.println("Department: "+dept+ " and Count: "+count));
	}
}

class Employee {
	int id;
	String name;
	String departent;
	int salary;
	
	public Employee(int id, String name, String departent, int salary) {
	
		this.id = id;
		this.name = name;
		this.departent = departent;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", departent=" + departent + ", salary=" + salary + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartent() {
		return departent;
	}
	public void setDepartent(String departent) {
		this.departent = departent;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}

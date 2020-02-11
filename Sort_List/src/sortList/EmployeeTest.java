package sortList;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;


class Employee {
	private String name;
	   private double salary;

	   // constructor
	   public Employee(String name, double salary) {
	      this.name = name;
	      setSalary(salary);
	   } 

	   // getters
	   public String getName() {return name;}

	   public double getSalary() {return salary;}
	   
	   // setters
	   public void setSalary(double salary) {
		   if (salary <= 200) {
			   throw new IllegalArgumentException("Salary must be >= 200");
		   }
		   this.salary = salary;
	   }
	   
	   // toString
	   @Override
	   public String toString() {
	      return String.format("Name: %s Salary: %s", getName(), getSalary());
	   }
}

public class EmployeeTest {

	public static void main(String[] args) {
		
		// create three list and initialize them
		List<Employee> list = new ArrayList<>();

	    list.add(new Employee("Kate Hill", 600));
	    list.add(new Employee("Paul Scott", 400));
	    list.add(new Employee("Jack Powell", 300));
	      
	    // output List elements
	    System.out.printf("Unsorted array elements:%n%s%n", list);
	
	    // sort in order using a comparator          
	    Collections.sort(list, new SalaryComparator());
	
	    // output List elements
	    System.out.printf("Sorted list elements:%n%s%n", list);

	}
}

class SalaryComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee emp1, Employee emp2) {
		double salaryDifference = emp1.getSalary() - emp2.getSalary();
	    return (int)salaryDifference; 
	} 
} 
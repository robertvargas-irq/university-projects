import java.lang.IllegalArgumentException;
import java.util.Arrays;
import java.util.HashSet;

public class Employee implements Cloneable {
	private String name;
	private int employee_no;
	private int age;
	private String state;
	private int zip;
	private int advisors[];
	
	/**
	 * Create a new instance of Employee with all values set to default.
	 */
	public Employee() {
		this.name = null;
		this.employee_no = 0;
		this.age = 0;
		this.state = null;
		this.zip = 0;
		this.advisors = null;
	}
	
	/**
	 * Creates a new instance of Employee by copying the values of another Employee instance.
	 * @param obj The Employee object which to copy the data from.
	 * @precondition The object passed through the parameter should not be null, and should be an instance of Employee.
	 * @throws IllegalArgumentException if object is not an instance of Employee or is null.
	 */
	public Employee( Object obj ) {
		if ( obj == null )
			throw new IllegalArgumentException("The given object cannot be null!");
		if ( !( obj instanceof Employee ) )
			throw new IllegalArgumentException("The given object is not an instance of Employee.");
		
		// initialize null for objects and copy
		Employee copy = (Employee) obj;
		this.name = null;
		this.state = null;
		this.advisors = null;
		
		if ( copy.getName() != null ) this.name = new String( copy.getName() );		
		if ( copy.getState() != null ) this.state = new String( copy.getState() );		
		if ( copy.getAdvisors() != null ) this.advisors = Arrays.copyOf( copy.getAdvisors(), copy.getAdvisors().length );

		// copy primitives
		this.employee_no = copy.getEmployeeNo();
		this.age = copy.getAge();
		this.zip = copy.getZip();
	}
	
	/**
	 * Perform a deep-clone of an instance variable, returning a new instance of Employee.
	 */
	public Employee clone() {
		Employee clone = null;
		
		try {
			clone = (Employee) super.clone();
			
			// initialize null for objects and copy
			clone.name = null;
			clone.state = null;
			clone.advisors = null;
			
			if ( this.getName() != null ) clone.name = new String( this.getName() );
			if ( this.getState() != null ) clone.state = new String( this.getState() );
			if ( this.getAdvisors() != null )
				clone.advisors = Arrays.copyOf( this.getAdvisors(), this.getAdvisors().length );
			
			// copy primitives
			clone.employee_no = this.getEmployeeNo();
			clone.age = this.getAge();
			clone.zip = this.getZip();
			
		}
		catch ( CloneNotSupportedException e ) {
			System.out.println( e.getMessage() );
			throw new RuntimeException("This class does not implement Cloneable.");
		}
		
		return clone;
	}

	/**
	 * Gets Employee name.
	 * @return Employee name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set Employee name.
	 * @param name The new name to apply.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get Employee number.
	 * @return Employee number.
	 */
	public int getEmployeeNo() {
		return employee_no;
	}

	/**
	 * Set Employee no (Employee Id).
	 * @param no The new Employee number to apply.
	 */
	public void setEmployeeNo(int no) {
		this.employee_no = no;
	}

	/**
	 * Get the Employee's age.
	 * @return Employee age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Set the age of the Employee.
	 * @param age The new age to apply.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Get the state associated with the Employee.
	 * @return Employee state.
	 */
	public String getState() {
		return state;
	}

	/**
	 * Set the state of the Employee's residence.
	 * @param state The new state to apply.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Get the zip code of the Employee's residence.
	 * @return Employee zip code.
	 */
	public int getZip() {
		return zip;
	}

	/**
	 * Change the zip code on file for the Employee.
	 * @param zip The new zip code to apply.
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}

	/**
	 * Get the list of advisors by id/numbers belonging to the Employee.
	 * @return Array of advisors for the employee.
	 */
	public int[] getAdvisors() {
		return advisors;
	}

	/**
	 * Override the array of advisors for the Employee.
	 * @param advisors Array of the advisors assigned to the Employee.
	 * @precondition The given array must not exceed 3 advisors.
	 */
	public void setAdvisors(int[] advisors) {
		if ( advisors.length <= 3 )
			this.advisors = advisors;
		else {
			this.advisors = Arrays.copyOfRange( advisors, 0, 3 );
			System.out.println("Each employee can only have a maximum of 3 advisors. "
					+ "Trimming and only setting the first 3 advisors to array.");
		}
	}
	
	/**
	 * Formats Employee information into a human-readable string.
	 * @return Formatted String of stored Employee information.
	 */
	public String toString() {
		
		// stringify advisor array
		String advisors = "";
		if ( this.getAdvisors() != null )
			advisors = Arrays.toString( this.getAdvisors() );
		else
			advisors = "None (null)";
		
		// format Employee data into a human-readable string
		return String.format("\t"
				+ "Employee Name: %s%n\t"
				+ "Employee Number: %d%n\t"
				+ "Age: %d%n\t"
				+ "State and Zip Code: %s %05d%n\t"
				+ "Advisors (Employee Numbers): %s",
		         this.getName(),
		         this.getEmployeeNo(),
		         this.getAge(),
		         this.getState(),
		         this.getZip(),
		         advisors );
		
	}
	

	/**
	 * Check to see if both employee instances have the same employee number.
	 * @param obj The employee object to compare the employee to for equivalence.
	 * @precondition The given object must not be null, and must be of type Employee.
	 * @throws IllegalArgumentException if object is not an instance of Employee or is null.
	 * @return True if employee numbers are equal, else return false.
	 */
	public boolean equals(Object obj) {
		if ( obj == null || !(obj instanceof Employee) )
			throw new IllegalArgumentException("The given object must be an instance of Employee, and cannot be null.");
		
		// if employee numbers are equal, return true
		Employee comparison = (Employee) obj;
		if ( this.employee_no == comparison.employee_no )
			return true;
		
		return false;
	}
	
	/**
	 * Get all the unique, distinct advisors of two employees.
	 * @param e1 First Employee object.
	 * @param e2 Seconds Employee object.
	 * @precondition Both Employee object inputs must not be null.
	 * @return Integer array of advisor id's.
	 */
	public static int[] getAllAdvisors( Employee e1, Employee e2 ) {
		if ( e1 == null || e2 == null )
			throw new IllegalArgumentException("Employee instances inputted must not be null.");
		
		// declare HashSet to keep track of unique values
		HashSet<Integer> uniqueValues = new HashSet<Integer>();
		int advisorNumbers[] = new int[6];
		int advisorCount = 0;
		
		// iterate through once, keeping track of unique values
		if ( e1.getAdvisors() != null )
			for ( int e1Advisor : e1.getAdvisors() )
				if ( !uniqueValues.contains( e1Advisor ) ) {
					uniqueValues.add( e1Advisor );
					advisorNumbers[ advisorCount++ ] = e1Advisor;
				}
		
		// iterate through the second employee, checking if the value
		// has already been stored in the HashSet
		if ( e2.getAdvisors() != null )
			for ( int e2Advisor : e2.getAdvisors() )
				if ( !uniqueValues.contains( e2Advisor ) )
					advisorNumbers[ advisorCount++ ] = e2Advisor;
		
		// trim to get rid of null, un-initialized elements of the array in return
		return Arrays.copyOf( advisorNumbers, advisorCount );
	}
	
	public static void main(String[] args) {
		
		System.out.println("Initiate Test Cases");
		System.out.println("===================");
		
		
		
		//
		// Test 1: Create a new Employee with default values 
		System.out.println("Test 1: Create Employee #1 with values from the DEFAULT CONSTRUCTOR.");
		System.out.println("--------------------------------------------------------------------\n");
		
		Employee e1 = new Employee();
		
		System.out.println( e1 );
		System.out.println("\nEnd Test 1");
		System.out.println("==========\n");
		
		
		
		//
		// Test 2: Set new variables for Employee #1
		System.out.println("Test 2: SET new information for Employee #1, we'll name him Bob.");
		System.out.println("----------------------------------------------------------------\n");
		
		int e1Advisors[] = { 79936, 14404, 10015 };
		e1.setName("Bob Robinson");
		e1.setState("NM");
		e1.setZip(88003);
		e1.setEmployeeNo(791479);
		e1.setAge(20);
		e1.setAdvisors(e1Advisors);
		
		System.out.println( e1 );
		
		System.out.println("\nEnd Test 2");
		System.out.println("==========\n");
		
		
		
		//
		// Test 3: Create a new Employee object via constructor by copying from Employee #1
		System.out.println("Test 3: Create a NEW Employee object via constructor by COPYING from Employee #1");
		System.out.println("--------------------------------------------------------------------------------\n");
		
		Employee e1Copy = new Employee( e1 );
		System.out.println("Employee information for the new COPY of Employee #1 ( new Employee( e1 ) )\n" + e1Copy );
		
		System.out.println("\nEnd Test 3");
		System.out.println("==========\n");
		
		
		
		//
		// Test 4: Edit the values of Employee #1 COPY to show that objects are not references but brand new.
		System.out.println("Test 4: Edit the OBJECTS of Employee #1 COPY to show that objects are not references but brand new.");
		System.out.println("----------------------------------------------------------------------------------------------------\n");
		
		e1Copy.setName("John Trudeau");
		e1Copy.setState("TX");
		System.out.println("Employee #1:\n\tName: " + e1.getName() + "\n\tFrom: " + e1.getState() );
		System.out.println("Employee #1 COPY:\n\tName: " + e1Copy.getName() + "\n\tFrom: " + e1Copy.getState() );
		
		System.out.println("\nEnd Test 4");
		System.out.println("==========\n");
		
		
		
		//
		// Test 5: Create a CLONE of Employee object with the .clone() method from Employee #1
		System.out.println("Test 5: Create a CLONE of Employee object with the .clone() method from Employee #1");
		System.out.println("-----------------------------------------------------------------------------------\n");

		Employee e1Clone = e1.clone();
		System.out.println("Employee information for the CLONE of Employee #1 ( e1.clone() )\n" + e1Clone );
		
		System.out.println("\nEnd Test 5");
		System.out.println("==========\n");
		
		
		
		//
		// Test 6: Edit the values of Employee #1 CLONE to show that objects are not references but brand new.
		System.out.println("Test 6: Edit the OBJECTS of Employee #1 CLONE to show that objects are not references but brand new.");
		System.out.println("----------------------------------------------------------------------------------------------------\n");
		
		e1Clone.setName("Gavin Newsom");
		e1Clone.setState("CA");
		System.out.println("Employee #1:\n\tName: " + e1.getName() + "\n\tFrom: " + e1.getState() );
		System.out.println("Employee #1 CLONE:\n\tName: " + e1Clone.getName() + "\n\tFrom: " + e1Clone.getState() );
		
		System.out.println("\nEnd Test 6");
		System.out.println("==========\n");
		
		
		
		//
		// Test 7: getAllAdvisors() TEST
		System.out.println("Test 7: Test the getAllAdvisors() method, by running a few different test cases.");
		System.out.println("--------------------------------------------------------------------------------\n");
		
		Employee e2 = new Employee( e1 );
		
		
		
		// first test will be with NO duplicates in either array
		int[] e1FirstAdvisorTest = { 11000, 11001, 11002 };
		int[] e2FirstAdvisorTest = { 11003, 11004, 11005 };
		int[] combinedAdvisors;
		
		e1.setAdvisors( e1FirstAdvisorTest );
		e2.setAdvisors( e2FirstAdvisorTest );
		
		combinedAdvisors = getAllAdvisors( e1, e2 );
		
		// print first, clean, non-duplicating advisor list
		System.out.println("\u2023 e1 advisors: " + Arrays.toString( e1FirstAdvisorTest ) );
		System.out.println("\u2023 e2 advisors: " + Arrays.toString( e2FirstAdvisorTest ) );
		System.out.println("\u2023 Unique advisors between e1 and e2 (NO DUPLICATES IN LIST):\n");
		for ( int uniqueAdvisor : combinedAdvisors )
			System.out.println( "\t" + uniqueAdvisor );
		System.out.println();
		
		
		
		// second test will be WITH duplicates in both arrays to test filter
		int[] e1SecondAdvisorTest = { 11000, 11001, 11000 };
		int[] e2SecondAdvisorTest = { 11002, 11001, 11003 };
		
		e1.setAdvisors( e1SecondAdvisorTest );
		e2.setAdvisors( e2SecondAdvisorTest );
		
		combinedAdvisors = getAllAdvisors( e1, e2 );
		
		// print second, duplicate-ridden advisor list
		System.out.println("\u2023 e1 advisors: " + Arrays.toString( e1SecondAdvisorTest ) );
		System.out.println("\u2023 e2 advisors: " + Arrays.toString( e2SecondAdvisorTest ) );
		System.out.println("\u2023 Unique advisors between e1 and e2 (DUPLICATES EXIST IN THE LIST):\n");
		for ( int uniqueAdvisor : combinedAdvisors )
			System.out.println( "\t" + uniqueAdvisor );
		System.out.println();
		
		System.out.println("\nEnd Test 7");
		System.out.println("==========\n");
		
		
		
		//
		// Test 8: test .equals() method
		System.out.println("Test 8: Test the equals() method, checking both e1 and e2, which both have the same employee number.");
		System.out.println("----------------------------------------------------------------------------------------------------\n");

		Employee e3 = new Employee( e2 );
		e3.setEmployeeNo( 990010 );
		System.out.println("Employee #1 has the employee number: " + e1.getEmployeeNo() );
		System.out.println("Employee #2 has the employee number: " + e2.getEmployeeNo() );
		System.out.println("\tBy evaluating the two using .equals(), the return value is: " + e1.equals( e2 ));
		System.out.println("\n");
		
		System.out.println("Employee #1 has the employee number: " + e1.getEmployeeNo() );
		System.out.println("Employee #3 has the employee number: " + e3.getEmployeeNo() );
		System.out.println("\tBy evaluating the two using .equals(), the return value is: " + e1.equals( e3 ));
		System.out.println("\n");
		
		System.out.println("\nEnd Test 8");
		System.out.println("==========\n");
		
	}

}

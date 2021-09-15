package Employee;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * EmployeeSet data-type that dynamically stores a set of Employee objects. 
 * @author Robert Vargas
 */
public class EmployeeSet {

	private Employee[] employees;
	private int employeeCount;
	
	/**
	 * Sets default values for EmployeeSet, initial capacity defaulting to 10.
	 */
	public EmployeeSet() {
		
		final int INITIAL_CAPACITY = 10;
		employees = new Employee[ INITIAL_CAPACITY ];
		employeeCount = 0;
		
	}
	
	/**
	 * Create a new instance of EmployeeSet from an existing instance of EmployeeSet. 
	 * @param obj EmployeeSet to copy.
	 * @precondition The input must not be null, and must be an instance of EmployeeSet.
	 */
	public EmployeeSet( Object obj ) {
		if ( obj == null || !(obj instanceof EmployeeSet) )
			throw new IllegalArgumentException("Object must not be null and must be an instance of EmployeeSet.");
		
		EmployeeSet original = (EmployeeSet) obj;
		employeeCount = original.size();
		employees = Arrays.copyOf( original.getEmployees(), original.capacity() );
	}
	
	/**
	 * Retrieve the array of employees from the EmployeeSet.
	 * @return Array of stored employees.
	 */
	final public Employee[] getEmployees() {
		return this.employees;
	}
	
	/**
	 * Override employee array; useful helper for increasing array size.
	 * @param newArray The array to override the existing array of Employees.
	 */
	private void setEmployees( Employee[] newArray ) {
		this.employees = newArray;
	}
	
	/**
	 * Get the size of the collection.
	 * @return The size of how many employees are stored in the collection.
	 */
	final public int size() {
		return this.employeeCount;
	}
	
	/**
	 * Override the size of stored Employees; useful helper for keeping track of stored Employees.
	 * @param newSize The new size of the collection.
	 */
	private void setSize( int newSize ) {
		this.employeeCount = newSize;
	}
	
	/**
	 * Get the max capacity of the collection, returning the length of the array.
	 * @return Employee array length
	 */
	final public int capacity() {
		return this.employees.length;
	}
	
	/**
	 * Add a new Employee object to the collection, 
	 * @param e The Employee to add to the collection. 
	 * @precondition The employee object should NOT be null.
	 * @postcondition If the employee is a duplicate, no change will be made,
	 * if the Employee object is not null, the Employee will be added to the next
	 * available spot in the collection.
	 */
	public void add( Employee e ) {
		
		// ensure object is not null
		if ( e == null )
			throw new IllegalArgumentException("The employee object cannot be null.");
		
		if ( this.contains( e.getEmployeeId() ) ) {
			System.out.println("This employee already exists. (no.: " + e.getEmployeeId() + ")");
			return;
		}
		
		// check to make sure we have enough space, else double the size
		int size = this.size();
		this.ensureCapacity( size + 1 );

		// set and increment size
		this.getEmployees()[ size ] = e;
		this.setSize( size + 1 );
		
	}
	
	/**
	 * Remove an Employee object from the collection via their employee number.
	 * @param eno Employee number.
	 * @postcondition If employee was found in collection, returns true if it was removed,
	 * else, return false, as no employee was found with the given employee number.
	 * @return True if employee was successfully removed | False if no employee found.
	 */
	public boolean remove( int eno ) {
		
		Employee[] employeeList = this.getEmployees();
		int size = this.size();
		
		// loop through employees; if match, copy the last element into the index
		for ( int i = 0; i < this.size(); i++ ) {
			if ( employeeList[i].getEmployeeId() == eno ) {
				size--;
				this.setSize( size );
				employeeList[i] = employeeList[size];
				employeeList[size] = null;
				
				return true;
			}
		}
		
		// if no employee found, return false
		return false;
	}
	
	
	/**
	 * Check to ensure that there is enough capacity for another Employee object.
	 * @param minimumCapacity The minimum capacity that the set must have.
	 * @precondition The input capacity minimumCapacity must be positive.
	 * @postcondition If the minimumCapacity is greater than or equal to the size
	 * of the set, it will double the capacity of the set, then copy the original
	 * array to the new, larger array, and point the set to the new array.
	 * @throws IllegalArgumentException If value is negative.
	 */
	private void ensureCapacity( int minimumCapacity ) {
		
		Employee[] newArray;
		int newLength;
		
		// ensure the minimumCapacity is positive
		if ( minimumCapacity < 0 )
			throw new IllegalArgumentException("The minimum capacity must be positive.");
		
		// if the length is equal to or greater than, make the array double the needed size
		if ( this.capacity() <= minimumCapacity ) {
			newLength = ( minimumCapacity ) * 2;
			System.out.println("NEEDS MORE CAPACITY, DOUBLING FROM " + this.capacity() + " TO " + newLength );
			newArray = new Employee[ newLength ];
			System.arraycopy( this.getEmployees(), 0, newArray, 0, this.getEmployees().length );
			this.setEmployees( newArray );
			
		}
		
	}
	
	/**
	 * Cycle through the array to check if an Employee exists in the set via Employee Number.
	 * @param eno Employee number.
	 * @return True if Employee is in the set. | False if Employee is not found.
	 */
	public boolean contains( int eno ) {
		
		Employee[] employees = this.getEmployees();
		for ( Employee employee : employees )
			if ( employee != null && employee.getEmployeeId() == eno )
				return true;
		
		return false;
		
	}
	
	/**
	 * Convert EmployeeSet data into a human-readable string.
	 */
	public String toString() {
		
		String formattedEmployeeObjects = "";
		Employee[] containedEmployees = this.getEmployees();
		for ( int i = 0; i < this.size(); i++ )
			formattedEmployeeObjects += ("\u2192 " + containedEmployees[i] + "\n\n");
		
		return String.format("\n\t"
				+ "Size: %d\n\t"
				+ "Capacity: %d\n\t"
				+ "Stored Values:\n\n\n%s\n\n\t---\n\t"
				+ "End data.",
				this.size(),
				this.capacity(),
				formattedEmployeeObjects);
	}
	
	/**
	 * Read and instantiate employees from a given .csv document.
	 * @param filename The name of the .csv document.
	 * @return Array of Employees instantiated from the target .csv document.
	 * @throws IOException If file not found.
	 */
	public static Employee[] readEmployeesFromCsv( String filename ) throws IOException {
		
		// read data from csv file, and place it all on one string
		BufferedReader br = new BufferedReader( new FileReader( filename ) );
		String readLines = "";
		String line = "";
		int l = 0;
		while ( (line = br.readLine()) != null ) {
			if ( l++ == 0 ) continue;
			readLines += line;
			l++;
		}
		
		// loop through the file with a regex expression to capture each column, skipping the header row
		StringTokenizer tokenizer = new StringTokenizer( readLines, "[^\"]," );
		int createdEmployees = 0;
		int tokenCount = tokenizer.countTokens();
		Employee[] employeeList = new Employee[ tokenCount ];
		while ( tokenizer.hasMoreTokens() && ( createdEmployees < tokenCount ) ) {
			
			Employee e = new Employee();
			String lastName = tokenizer.nextToken().trim();
			String firstName = tokenizer.nextToken().trim();
			
			e.setName( firstName + " " + lastName );
			e.setEmployeeId( Integer.parseInt(tokenizer.nextToken()) );
			e.setState( tokenizer.nextToken() );
			e.setZip( Integer.parseInt( tokenizer.nextToken() ) );
			e.setAge( Integer.parseInt( tokenizer.nextToken() ) );
			
			// skip manager
			tokenizer.nextToken();
			
			System.out.println( e + "\n" );
			employeeList[ createdEmployees++ ] = e;
			
		}
		
		br.close();
		
		return Arrays.copyOf( employeeList, createdEmployees );
		
	}
	
	/**
	 * Custom header for organizing test cases in the main method.
	 * @param header The text to display in the header.
	 */
	public static void printTestHeader( String header ) {
		System.out.println( header );
		System.out.println( "-".repeat( header.length() ) + "\n" );
	}
	
	/**
	 * Custom footer for organizing test cases and their ending in the main method.
	 * @param testNumber The number of the test that has finalized.
	 */
	public static void printTestEnd( int testNumber ) {
		System.out.println("\n\nEnd Test " + testNumber);
		System.out.println("===========\n\n\n");
	}
	
	public static void main(String[] args) {
		
		// parse employee data from .csv file for testing
		Employee[] employees = null;
		System.out.println("Running readEmployeesFromCsv...\n");
		try {
			employees = readEmployeesFromCsv("core_dataset.csv");
			System.out.print("Reading finished. ");
			System.out.println("Got a total of " + employees.length + " employees read from .csv file.\n\n\n");
		}
		catch ( IOException e ) {
			System.out.println( e.getMessage() );
		}
		
		
		
		// begin tests for set
		printTestHeader("Initiate Test Cases");
		
		
		
		//
		// Test 1: Create a new set with default values
		printTestHeader("Test 1: Create a new set with values from the DEFAULT CONSTRUCTOR.");
		
		EmployeeSet eSet1 = new EmployeeSet();
		
		System.out.println("eSet1:\n" + eSet1);
		printTestEnd(1);
		
		
		
		//
		// Test 2: Add first 5 employees from core_dataset.csv
		printTestHeader("Test 2: Add first 5 employees from core_dataset.csv");
		
		for ( int i = 0; i < 5; i++ )
			eSet1.add( employees[i] );
		
		System.out.println("eSet1 after adding the first 5 employees:\n" + eSet1);
		
		printTestEnd(2);
		
		
		
		//
		// Test 3: Check to see if eSet1 has Employee #2 via Employee Number
		printTestHeader("Test 3: Check to see if eSet1 has Employee #2 via Employee Number");
		
		System.out.println("Resulting value after checking for " + employees[1].getEmployeeId() + ": "
				+ eSet1.contains( employees[1].getEmployeeId() ));
		
		printTestEnd(3);
		
		
		
		//
		// Test 4: Check to see if eSet1 has Employee #105 via Employee Number (set only has the first 5 employees)
		printTestHeader("Test 4: Check to see if eSet1 has Employee #105 via Employee Number (set only has the first 5 employees)");

		System.out.println("Resulting value after checking for " + employees[104].getEmployeeId() + ": "
				+ eSet1.contains( employees[104].getEmployeeId() ));
		
		printTestEnd(4);
		
		
		
		//
		// Test 5: Create a new set by COPYING eSet1 with the copy constructor.
		printTestHeader("Test 5: Create a new set by COPYING eSet1 with the copy constructor.");
		
		EmployeeSet eSet1Copy = new EmployeeSet( eSet1 );
		System.out.println("eSet1Copy:\n" + eSet1Copy);
		
		printTestEnd(5);
		
		
		
		//
		// Test 6: Remove the first 3 Employees from eSet1Copy
		printTestHeader("Test 6: Remove the first 3 Employees from eSet1Copy");
		
		for ( int i = 0; i < 3; i++ )
			eSet1Copy.remove( employees[i].getEmployeeId() );
		
		System.out.println("eSet1Copy after removing the first 3 Employee objects:\n" + eSet1Copy);
		
		printTestEnd(6);
		
		
		
		//
		// Test 7: Compare to the original eSet1 to show that eSet1Copy is independent and was a deep copy.
		printTestHeader("Test 7: Compare to the original eSet1 to show that eSet1Copy is independent and was a deep copy.");
		
		System.out.println("eSet1:\n" + eSet1 + "\n");
		System.out.println("eSet1Copy:\n" + eSet1Copy);
		
		printTestEnd(7);
		
		
		
		//
		// Test 8: Add EVERY value from core_dataset.csv to eSet1Copy
		printTestHeader("Test 8: Add EVERY value from core_dataset.csv to eSet1Copy");
		
		for ( int i = 0; i < employees.length; i++ )
			eSet1Copy.add( employees[i] );
		
		System.out.println("\neSet1Copy data after adding:\n\n\t"
				+ "Size: " + eSet1Copy.size() + "\n\t"
				+ "Capacity: " + eSet1Copy.capacity() + "\n");

		printTestEnd(8);

	}

}

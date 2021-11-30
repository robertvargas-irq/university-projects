public class EmployeeTable {
    
    private int num;
    private int[] keys;
    private Employee[] data;
    private boolean[] used;

    /**
     * Initialize with a large prime number
     */
    EmployeeTable() {

        // table sizes should be prime numbers
        final int SIZE = 193;
        this.num = 0;
        this.keys = new int[ SIZE ];
        this.data = new Employee[ SIZE ];
        this.used = new boolean[ SIZE ];

    }

    /**
     * Initialize with a user-inputted size
     * @param size Size of the table
     */
    EmployeeTable( int size ) {

        this.num = 0;
        this.keys = new int[ size ];
        this.data = new Employee[ size ];
        this.used = new boolean[ size ];

    }

    /**
     * Put object to table via key
     * @param key 
     * @param obj
     */
    public void put( Employee key ) {

        // if table is full, return
        if ( this.num == this.data.length )
            return;

        // if exists, set directly
        int idx = search( key.getEmployeeNo() );
        if ( idx >= 0 )
            this.data[idx] = key;
        // else, create
        else {

            idx = hash( key.getEmployeeNo() );
            
            // find next available spot
            while( idx < this.data.length && this.keys[idx] != 0 )
                if ( idx + 1 == this.data.length )
                    idx = 0;
                else
                    idx++;
            
            // if at the end of the array, return
            if ( idx >= this.data.length ) return;
            
            // set
            this.keys[idx] = key.getEmployeeNo();
            this.data[idx] = key;
            this.used[idx] = true;
            this.num++;

        }

        return;

    }

    /**
     * Remove a key from the table
     * @param emp_no Desired key to remove
     * @return Employee that was removed
     */
    public boolean remove( int emp_no ) {

        int idx = search( emp_no );

        // if does not exist, return null
        if ( idx < 0 )
            return false;
                    
        // remove from the table
        this.keys[idx] = 0;
        this.data[idx] = null;
        this.num--;

        return true;
        
    }

    /**
     * Find the index of a given employee number
     * @param emp_no Employee number to hash and find
     * @return Index if found | -1 if does not exist
     */
    private int search( int emp_no ) {

        int idx = hash( emp_no );
        for( int counter = 0; counter < this.data.length && used[idx] == true; counter++ ) {
            
            if ( emp_no == this.keys[idx] )
                return idx;
            else if ( idx + 1 == this.data.length )
                idx = 0;
            else
                idx++;
            
        }
        return -1;
    }

    private int hash( int key ) {

        return key % this.keys.length;

    }

    /**
     * Table formatted into a String for debugging
     */
    public String toString() {

        String format = "{\n  ";
        for ( int i = 0; i < this.keys.length; i++ ) {
            if ( this.keys[i] != 0 )
                format = format + "[" + this.keys[i] + ", " + this.data[i].getName() + "]";
            else if ( this.used[i] == true )
                format = format + "[USED]";
            else
                format = format + "[]";

            if ( i < this.keys.length - 1 )
                format = format + ", ";

            if ( ( i + 1 ) % 10 == 0 )
                format = format + "\n  ";
        }
        format = format + "\n}";
        return format;
                
    }

    public static void main( String[] args ) {

        EmployeeTable table = new EmployeeTable(500);
        Employee emp1 = new Employee();
        emp1.setEmployeeNo( 801501000 );
        emp1.setName("My first employee");

        Employee emp2 = new Employee();
        emp2.setEmployeeNo( 801501001 );
        emp2.setName("My second employee, electric boogaloo");
                
        Employee emp3 = new Employee();
        emp3.setEmployeeNo( 801501002 );
        emp3.setName("My third employee");
        
        Employee emp4 = new Employee();
        emp4.setEmployeeNo( 73100012 );
        emp4.setName("My crazy fourth employee");
        
        Employee emp5 = new Employee();
        emp5.setEmployeeNo( 10022 );
        emp5.setName("An ancient employee");

        System.out.println("Putting...");
        table.put( emp1 );
        table.put( emp2 );
        table.put( emp3 );
        table.put( emp4 );
        table.put( emp5 );

        System.out.println("Table: " + table );
        System.out.println("Removing employee #3...");
        System.out.println("Employee #3 successfully removed: " + table.remove( emp3.getEmployeeNo() ) );
        System.out.println("Table now: " + table );

    }

}

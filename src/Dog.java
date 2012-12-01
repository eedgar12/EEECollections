/**
 * This class is provided to demonstrate the need to override the 
 * methods: equals() and hashCode() -- inherited from the Object class, 
 * plus provide an implementation of compareTo() from the interface Comparable.
 * 
 * The class is used by several of the demo programs, where
 * sorting and equality are tested.
 * 
 * In general, you should always provide these methods, along with an
 * override of toString(), with any classes you create. It may seem
 * like overkill, but you never know when they might be needed.
 * 
 * Here's the bottom line: 
 *    Rule #1 -- if you want your objects to provide meaningful String
 *    values when the object is provided in place of a String parameter --
 *    e.g., System.out.println(myObject) -- you must override toString()
 *    
 *    Rule #2 -- if you want to be able to sort objects you must 
 *    implement Comparable and override equals(), unless your objects
 *    inherit this capability from some other class that does this
 *    
 *    Rule #3 -- if you want to test if ObjectA is equal to ObjectB,
 *    e.g., if(objA.equals(objB)), you must override equals(). Otherwise 
 *    you get the default implementation provided by the Object class which 
 *    tests only whether those two object references are pointing to the same 
 *    memory address. Once again, if your objects inherit from classes that 
 *    properly do override equals(), you would inherit this implementation and 
 *    would not need to implement it again.
 *    
 *    Rule #4 -- if you want to store your objects in Map data structures,
 *    you must properly override hashCode(). A proper hashCode is vital to
 *    storage and retrieval of objects from Maps.
 */
public class Dog implements Animal, Comparable {
	// Any or all of these properties can be used as a foundation for
	// implementing the equals(), hashCode() and compareTo() methods
	private String name;
	private int age;
	private int rabiesID;

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dog other = (Dog) obj;
        if (this.rabiesID != other.rabiesID) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.rabiesID;
        return hash;
    }
	
	// These constants are provided as a convenience for working with
	// the compareTo method. See the Javadoc for the Comparable interface
	// for more information on the values for these constants.
	private static final int EQUAL = 0;
	private static final int GREATER_THAN = 1;
	private static final int LESS_THAN = -1;
	
	/** Default constructor */
	public Dog() {}
	
	/** Overloaded constructor with parameters */
	public Dog(String name, int age, int rabiesID) {
		this.name = name;
		this.age = age;
		this.rabiesID = rabiesID;
	}
	
	/**
	 * This implementation fulfills the Comparable contract.
	 * It is used to determine how sorting should be done. For
	 * more information see the Javadoc for Comparable.
	 * 
	 * @param obj - the object to compare with respect to the active object (this)
	 * @throws IllegalArgumentException if obj == null or if 
	 * (obj.getClass().equals(this.getClass())) == false
	 */
	public int compareTo(Object obj) {
		// If either of these conditions is true, we cannot compare
		// the objects, so throw a unchecked exception
		if(obj == null || !obj.getClass().equals(this.getClass())) {
			throw new IllegalArgumentException("Argument is null");
		} else {
			// Note: this wouldn't be possible if the 2nd test above failed
			Dog testObj = (Dog)obj;
			// Obviously if both objects references point to the same
			// memory location, they are equal
			if(this == testObj ) return EQUAL;
			// This is a strange one. We also must test for equality using
			// the equals() method below because the SortedSet Interface specifies
			// that the equals() method WILL NOT be used for equality testing
			// in a SortedSet object, but rather that equality testing will be
			// determined by the implementation of the compareTo() method.
			// Note that the equals method WILL be used in all other equality tests.
			if(this.equals(obj)) return EQUAL;
			// If we get this far, we use the rabiesID value to determine
			// sort order ... greater or less than
			if(this.rabiesID < testObj.rabiesID) {
				return LESS_THAN;
			} else {
				return GREATER_THAN;
			}
		}
		
	}


	/**
	 * Overridden from the Object class. This method is needed so that
	 * we can control the String value of an object when that object
	 * is used in place of a String parameter is some other method --
	 * e.g., System.out.println(myObject)
	 * 
	 * @return the name of the Dog
	 */
	public String toString() {
		return name;
	}

	///////////////////////////////////////////////////////////////////////////////
	///////// The rest of this is unimportant -- just misc. getters/setters ///////
	///////////////////////////////////////////////////////////////////////////////
	
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the rabiesID
	 */
	public int getRabiesID() {
		return rabiesID;
	}

	/**
	 * @param rabiesID the rabiesID to set
	 */
	public void setRabiesID(int rabiesID) {
		this.rabiesID = rabiesID;
	}
}

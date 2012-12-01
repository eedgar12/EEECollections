import java.util.*;

/**
 * A demo driver program to test custom implementations of
 * equals(), hashCode() and compareTo()--using Comparable interface.
 * 
 * @see PhoneNumber
 */
public class PhoneNumberHashDemo {

	public static void main(String[] args) {
		// Just create a hashtable and then store one item
		Map hash = new Hashtable();
		PhoneNumber aPhoneNumber = new PhoneNumber(414, 695, 3492);
		hash.put( aPhoneNumber, "Jim Lombardo");
		
		// This fails if the equals() or hashCode() methods are not
		// implemented properly in the key class (PhoneNumber)
		System.out.println("Expected 'Jim Lombardo', got: " +
					hash.get( new PhoneNumber(414, 695, 3492) ) );
					
		// Comparison fails if equals() method not properly implemented
		if( (new PhoneNumber(414, 695, 3492)).equals(aPhoneNumber) )
			System.out.println("\nComparison success due to properly \n" +
					"defined equals method in PhoneNumber class");
		else
			System.out.println("\nComparison fails due to missing or improperly \n" +
					"defined equals method in PhoneNumber class");
		
		// OK, now let's see how implementing the Comparable interface
		// with it's compareTo() method helps with sorting issues
		
		// store two more items in the hashtable
		hash.put( new PhoneNumber(262, 666, 4444), "Bob Smith" );
		hash.put( new PhoneNumber(507, 333, 1111), "John Doe" );
		// retrieve the keys
		Set set = hash.keySet();
		// convert the keys to an array so we can easily sort if needed
		Object[] numbers = set.toArray();

		// loop through an print out array contents (unsorted)
		System.out.println("\nList before sort:");
		for(int i=0; i < numbers.length; i++) {
			System.out.println((PhoneNumber)numbers[i]);
		}
		
		// Now use static sort method of Arrays utility class to sort the array.
		// This only works because we have a custom implementations of equals() and
		// compareTo(). Try commenting out the equals() method. Will it sort?
		
		// Next, use the equals() method but remove the interface contract
		// from the PhoneNumber class declaration and comment out the compareTo()
		// method to see what happens. What was the result?
		
		// Lessons learned: you need BOTH the equals method and the
		// interface implementation using comareTo() to use Arrays.sort()
		System.out.println("\nList after sort:");
		Arrays.sort(numbers);
		for(int i=0; i < numbers.length; i++) {
			System.out.println((PhoneNumber)numbers[i]);
		}
	}
}

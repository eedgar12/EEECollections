import java.util.*;

/**
 * This class is provided to demonstrate how a TreeSet can both
 * sort objects AND remove duplicate objects from the collection.
 * This assumes, however, that the equals() and compareTo() methods
 * have been properly written in the Dog class. Please read the class
 * description for SortedSet which describes how this all works.
 */
public class SortedSetDemo {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declared polymorphically. What other options are available 
		// and at what cost?
		Set set = new TreeSet();
		
		// The 3rd parameter determines sort order (see the Dog class)
		set.add(new Dog("Spot", 5, 4444));
		set.add(new Dog("Fido", 12, 3333));
		set.add(new Dog("Max", 2, 1234));
		// This is the duplicate ... it will be automatically removed
		set.add(new Dog("Max2", 2, 1234));

		// We have no choice but to use an Interator for looping ...
		// No get(index) method is provided because Collection and Set
		// (superclass) objects don't have indexes.
		Iterator i = set.iterator();
		
		System.out.println("Sorting Dogs by Value, With Duplicates Removed...");
		while( i.hasNext() ) {
			System.out.println(i.next());
		}

	}

}

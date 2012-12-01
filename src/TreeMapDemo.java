import java.util.*;

/**
 * The class demonstrates how a TreeMap can be used to store key-value
 * pairs (Maps do this) where the keys are automatically sorted (Trees do this)
 * Remember, normally Maps are not ordered in any way. If you want ordering with 
 * a Map you must use a TreeMap. The sort order is determined by the implementation
 * of the compareTo() method in the class description for the key object. Note
 * that some classes in the Java API (e.g., String) already have this done. So
 * it should come as no surprise to you that the keys are sorted alphabetically
 * by the characters in the keys, which are Strings.
 */
public class TreeMapDemo {

	/**
	 * @param args - not used
	 */
	public static void main(String[] args) {
		// Declared polymorphically. What other options are available 
		// and at what cost?
		Map tree = new TreeMap();
		tree.put("Spot", new Dog("Spot", 5, 4444));
		tree.put("Fido", new Dog("Fido", 12, 3333));
		tree.put("Max", new Dog("Max", 2, 1234));
		// See what happens if you uncomment the next line
		// Can you identify what's going on here and why?
		//tree.put("Max2", new Dog("Max", 2, 1234));
		// Now what happens if we use the next line and why?
		//tree.put("Max", new Dog("Max", 2, 1234));

		// With Maps we can only iterate over a collection of keys or values.
		// So first we must call a method in the Map class that retrieves either
		// a Set of keys or a Collection of values. Furthermore, 
		// a TreeMap is sorted by the natural order of the key object,
		// which is determined by that object's compareTo() method implementation.
		// Therefore, we'll iterate over a keySet...
		Set keys = tree.keySet();
		Iterator i = keys.iterator();
		
		System.out.println("Sorting Dogs by Map key (not a Dog object)...");
		while( i.hasNext() ) {
			System.out.println(i.next());
		}
		
		// Here we retrieve a Collection of Map values -- Dog objects. We then
		// sort the Dog objects by their natural order, which is determined by
		// the implementation of the coompareTo() method. Note that to actually perform
		// the sort we must use the Arrays utility class' sort() method. This is 
		// because there are no sort methods in the Map interface that allow us to
		// sort a Collection. There are sort methods that allow sorting of List objects,
		// but not Collection objects.
		Collection c = tree.values();
		Object[] aDogs = c.toArray();  // represent the Collection as an array
		Arrays.sort(aDogs); // aDogs and TreeMap ARE NOT synchronized!!
		
		System.out.println("\nSorting Dogs by Dog.compareTo()...");
			
		for(int j=0; j < aDogs.length; j++) {
			// Note that the correct (Dog) compareTo() method is automatically
			// bound at runtime (Polymorphism)
			// The Object class version IS NOT used.
			System.out.println(aDogs[j]);
		}
	}

}

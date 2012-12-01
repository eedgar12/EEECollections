
import java.util.*;

/**
 * This class demonstrates the new GENERICS feature and the enhanced 
 * for loop in JDK 1.5. Add this to the sample "Collections" project provided
 * earlier by your instructor.
 */
public class New15 {

	/**
	 * @param args -- not used
	 */
	public static void main(String[] args) {
    // auto boxing and unboxing
    Integer j = 20;
    int x = j;

    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("one", 20);

		// The old way of declaring a List
		List oldList = new ArrayList();
		// The new way in JDK 1.5
		List<String>newList = new ArrayList<String>();
		
		// Adding items hasn't changed
		oldList.add("Hello");
		oldList.add("Darn");
		oldList.add("There");
		
		newList.add("Hello");
		newList.add("Darn");
		newList.add("There");
		
		// The old way of retrieving a value with an expicit cast
		String oldTitle = ((String)oldList.get(0)).toUpperCase();
		// The new way, without cast ... simple!
		String newTitle = newList.get(0).toUpperCase();
		
		// Check out these methods
		oldExpurgate(oldList);
		newExpurgate(newList);
		
		// The old way: a traditional for loop
		for(int i=0; i < oldList.size(); i++) {
			// a traditional cast
			String s = (String)oldList.get(i);
			s = s.toLowerCase();
		}
		
		// The old way: a for loop using an iterator
		for (Iterator i = oldList.iterator(); i.hasNext(); ) {
			// a traditional cast
			String s = (String)i.next();
			s = s.toLowerCase();
	    }
		
		// The new way is simple! Read as: for each String s in newList
		for (String s : newList) {
			// Look, ma, no cast needed!
			s = s.toLowerCase();
		}
		
	} // end main
	
	
	/**
	 * The old way: using an old for loop with a cast required.
	 * 
	 * Remove the four-letter words from the specified
	 * collection, which must contain only strings.
	 * 
	 * Why Collection? Because it's polymorphic -- can be a List or a Set.
	 */
	static void oldExpurgate(Collection c) {
	    for (Iterator i = c.iterator(); i.hasNext(); ) {
	        String s = (String) i.next();
	        if(s.length() == 4)
	            i.remove();
	    }
	}

	/**
	 * The new way, using an old for loop with GENERICS
	 * 
	 * Remove the four-letter words from the specified collection of strings.
	 */
	static void newExpurgate(Collection<String> c) {
	    for (Iterator<String> i = c.iterator(); i.hasNext(); )
	        if (i.next().length() == 4)
	            i.remove();
	}
	
	/**
	 * An even better new way, using the new enhanced for loop, plus GENERICS.
	 * Remove the four-letter words from the specified collection of strings.
	 */
	static void betterNewExpurgate(Collection<String> c) {
	    for (String s : c )
	        if (s.length() == 4)
	            c.remove(s);
	}


}

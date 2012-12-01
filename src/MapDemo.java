/*
 * @(#)MapDemo.java	1.00 Nov 17, 2003
 *
 * Copyright (c) 2003-2004 Waukesha County Technical College. All Rights Reserved.
 *
 * THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF 
 * THE ACADEMIC FREE LICENSE V2.0 ("AGREEMENT"). ANY USE, REPRODUCTION 
 * OR DISTRIBUTION OF THE PROGRAM CONSTITUTES RECIPIENT'S ACCEPTANCE 
 * OF THIS AGREEMENT. A COPY OF THE AGREEMENT MUST BE ATTACHED TO ANY
 * AND ALL ORIGINALS OR DERIVITIVES.
 */

import java.util.*;

/*******************************************************
 * Sample code to work with Map classes.
 */
public class MapDemo {

	public static void main(String[] args) {
		// Declared polymorphically. What other options are available 
		// and at what cost?
		Map hashmap = new HashMap();
		Map treemap = new TreeMap();
		// JDK 1.4+ only
		Map linkedMap = new LinkedHashMap();
		Set s;
		Iterator i;
		
		/// HASHMAP
		hashmap.put("Three", "Three");
		hashmap.put("Three", "Three"); // This entry overwrites the previous
		hashmap.put("One", "One");
		hashmap.put("Two", "Two");
		hashmap.put("Six", "Six");
		hashmap.put("Seven", "Seven");
		// Order is NOT guaranteed to be consistent; no duplicate keys
		System.out.println("Unordered Contents of HashMap:");
		
		/*
		 * To iterate over items in a Map, you must first retrieve a Set of all 
		 * of its keys. Then, iterate over the keys and use each key to retrieve 
		 * the value object from the Map.
		 */
		s = hashmap.keySet();
		// A Map does not have an iterator, but a Set DOES ... why?
		i = s.iterator();
		while( i.hasNext() ) {
			// Example of how to retreive and view the key
			Object key = i.next();
			System.out.println( key );
//			System.out.println( "Key: " + key );
			// Now retrieve and view the Map value using that key
//			String value = (String)hashmap.get(key);
//			System.out.println( "Value: " + value );
		}
		
		/// LINKEDHASHMAP
		linkedMap.put("Three", "Three");
		linkedMap.put("Three", "Three"); // This entry overwrites the previous
		linkedMap.put("One", "One");
		linkedMap.put("Two", "Two");
		linkedMap.put("Six", "Six");
		linkedMap.put("Seven", "Seven");
		// Order IS guaranteed to be consistent (LRU - Entry order)
		System.out.println("\nOrdered (Entry Order) Contents of LinkedHashMap:");
		s = linkedMap.keySet();
		i = s.iterator();
		while( i.hasNext() ) {
			System.out.println( i.next() );
		}

		/// TREEMAP
		treemap.put("Three", "Three");
		treemap.put("Three", "Three");
		treemap.put("Two", "Two");
		treemap.put("Seven", "Seven");
		treemap.put("One", "One");
		treemap.put("Six", "Six");
		// Keys guaranteed to be in sorted order, no duplicate keys
		System.out.println("\nOrdered (Sorted) Contents of TreeMap:");
		s = treemap.keySet();
		i = s.iterator();
		while( i.hasNext() ) {
			System.out.println( i.next() );
		}
		
		// Integer Object values
		hashmap = new HashMap();
		hashmap.put( "Three", new Integer(3) );
		hashmap.put( "Three", new Integer(3) );
		hashmap.put( "One", new Integer(1) );
		hashmap.put( "Two", new Integer(2) );
		hashmap.put( "Six", new Integer(6) );
		hashmap.put( "Seven", new Integer(7) );
		
		System.out.println("\nContents of HashMap:");
		s = hashmap.keySet();
		i = s.iterator();
		while( i.hasNext() ) {
			System.out.println( i.next() );
		}
		
		// Keys guaranteed to be in sorted order, no duplicate keys
		treemap = new TreeMap();
		treemap.put( "Three", new Integer(3) );
		treemap.put( "Three", new Integer(3) );
		treemap.put( "Two", new Integer(2) );
		treemap.put( "Seven", new Integer(7) );
		treemap.put( "One", new Integer(1) );
		treemap.put( "Six", new Integer(6) );
		
		System.out.println("\nContents of TreeMap:");
		s = treemap.keySet();
		i = s.iterator();
		
		while( i.hasNext() ) {
			System.out.println( i.next() );
		}
	}
}

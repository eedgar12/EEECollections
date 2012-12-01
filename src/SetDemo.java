/*
 * @(#)SetDemo.java	1.00 Nov 17, 2003
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
 * Sample code to work with HashSet and TreeSet classes.
 */
public class SetDemo {

	public static void main(String[] args) {
		// Declared polymorphically. What other options are available 
		// and at what cost?
		Set hashset = new HashSet();
		Set treeset = new TreeSet();
		Iterator i;
		
		/// String values
		hashset.add("Three");
		hashset.add("Three");
		hashset.add("One");
		hashset.add("Two");
		hashset.add("Six");
		hashset.add("Seven");
		
		System.out.println("Contents of HashSet:");
		i = hashset.iterator();
		while( i.hasNext() ) {
			System.out.println( i.next() );
		}
		
		// Values guaranteed to be in sorted order, no dupes
		treeset.add("Three");
		treeset.add("Three");
		treeset.add("Two");
		treeset.add("Seven");
		treeset.add("One");
		treeset.add("Six");
		
		System.out.println("\nContents of TreeSet:");
		i = treeset.iterator();
		while( i.hasNext() ) {
			System.out.println( i.next() );
		}
		
		// Integer Object values
		hashset = new HashSet();
		hashset.add( new Integer(3) );
		hashset.add( new Integer(3) );
		hashset.add( new Integer(1) );
		hashset.add( new Integer(2) );
		hashset.add( new Integer(6) );
		hashset.add( new Integer(7) );
		
		System.out.println("\nContents of HashSet:");
		i = hashset.iterator();
		while( i.hasNext() ) {
			System.out.println( i.next() );
		}
		
		// Values guaranteed to be in sorted order, no dupes
		treeset = new TreeSet();
		treeset.add( new Integer(3) );
		treeset.add( new Integer(3) );
		treeset.add( new Integer(2) );
		treeset.add( new Integer(7) );
		treeset.add( new Integer(1) );
		treeset.add( new Integer(6) );
		
		System.out.println("\nContents of TreeSet:");
		i = treeset.iterator();
		while( i.hasNext() ) {
			System.out.println( i.next() );
		}
	}
}

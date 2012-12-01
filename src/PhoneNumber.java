/**
 * A simple example of a class with custom implementations of
 * equals() and hashCode() methods.
 * <P>
 * Without these custom implementations, comparisons would fail.
 * Also, objects of this type could not be used as Map keys.
 * Finally, sorting would not work the way we want because sorting
 * uses comparisons
 * <P>
 * Try commenting out one or both of these methods and then run
 * the test program again.
 * 
 * @see PhoneNumberHashDemo - the test program class.
 */
public class PhoneNumber implements Comparable {
//public class PhoneNumber {
	private final short areaCode;
	private final short exchange;
	private final short extension;
	
	/**
	 * Custom constructor uses int args that are converted (downcasted) to short.
	 * Why? Mainly just to demonstrate downcasting. Although, it's not uncommon
	 * to expect more int requirements in a program than short requirements 
	 * @param areaCode
	 * @param exchange
	 * @param extension
	 */
	public PhoneNumber(int areaCode, int exchange, int extension) {
		rangeCheck(areaCode, 999, "areaCode");
		rangeCheck(exchange, 999, "exchange");
		rangeCheck(extension, 9999, "extension");
		
		this.areaCode = (short)areaCode;
		this.exchange = (short)exchange;
		this.extension = (short)extension;
	}
	
	// Validation example -- not commercial quality
	private static void rangeCheck(int arg, int max, String name) {
		if(arg < 0 || arg > max)
			throw new IllegalArgumentException(name + "; " + arg);
	}
	
	/**
	 * Override Object class method so that this class has
	 * comparison, Map retrieval (based on hashCode) and sort capability
	 * 
	 * @param o - an object of super type Object
	 * @see "Effective Java," by Joshua Block, Sun Engineer (Chapter 3)
	 * @see "Thinking in Java," by Bruce Eckel (Chapter 11: Collections)
	 */
	public boolean equals(Object o) {
		if(o == this)
			return true;
		if( !(o instanceof PhoneNumber) )
			return false;
		PhoneNumber pn = (PhoneNumber)o;
		return pn.areaCode == areaCode &&
			   pn.exchange == exchange &&
			   pn.extension == extension;
	}
	
	/**
	 * Override Object class method so that valid hashCodes
	 * can be generated. The code is based on the recipe
	 * described by Joshua Block in "Effective Java"
	 * 
	 * @see "Effective Java," by Joshua Block, Sun Engineer (Chapter 3)
	 * @see "Thinking in Java," by Bruce Eckel (Chapter 11: Collections)
	 */
	public int hashCode() {
		int result = 17;
		result = 37*result + areaCode;
		result = 37*result + exchange;
		result = 37*result + extension;
		return result;
	}
	
	/**
	 * Always implement method of Comparable interface to do
	 * sorting. NOTE: you also need a custom equals() implementation.
	 */
	public int compareTo(Object o) {
		PhoneNumber pn = (PhoneNumber)o;
		
		// Compare area codes
		if(areaCode < pn.areaCode)
			return -1;
		if(areaCode > pn.areaCode)
			return 1;
		
		// Area codes are equal, compare exchanges
		if(exchange < pn.exchange)
			return -1;
		if(exchange > pn.exchange)
			return 1;
		
		// Area codes and exhanges are equal, compare extensions
		if(extension < pn.extension)
			return -1;
		if(extension > pn.extension)
			return 1;
		
		// all fields are equal
		return 0;
	}
	
	/**
	 * Always override Object class method to do our bidding.
	 */
	public String toString() {
		return "(" + areaCode + ") " + exchange + "-" + extension;
	}
}

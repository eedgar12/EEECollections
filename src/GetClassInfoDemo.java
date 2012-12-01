/**
 * This class is provided to show how Object.getClass() and
 * Class.getSuperclass() and Class.getInterfaces() and Class.getMethods()
 * can be used to do object introspection.
 * 
 * The techniques demonstrated here provide answers to the question,
 * "What can we learn about an object, in terms of its data type (class name),
 * superclass, interface(s) and method(s), from program code?
 */
public class GetClassInfoDemo {

	// This shows how you can get info about your class using 
	// various "Class" class (not a typo!) methods
	// The "Class" class is designed to provide information about classes.
	public static void main(String[] args) {
		
		// Create an object and then learn about it below
		Dog dog = new Dog("Fido", 2, 1234);
		
		// Ask the object to construct a "Class" object
		Class c = dog.getClass();
		// Note that toString is automatically called for "c"
		System.out.println("I am a " + c + " instance");
		
		// Now discover dog's superclass and interfaces
		System.out.println("My super class is " + c.getSuperclass());
		System.out.print("I implement the following interfaces:\n ");
		Class[] interfaces = c.getInterfaces();
		for(int i=0; i < interfaces.length; i++) {
			System.out.print("\t" + interfaces[i] + "\n");
		}
		
		// And finally, discover dog's methods... 
		System.out.print("I implement the following methods:\n ");
		java.lang.reflect.Method[] methods = c.getMethods();
		for(int i=0; i < methods.length; i++) {
			System.out.print("\t" + methods[i] + "\n");
		}
		
	}

}

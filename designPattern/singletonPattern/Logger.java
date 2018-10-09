package designPattern.singletonPattern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * Singleton pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the java virtual machine.
The singleton class must provide a global access point to get the instance of the class.
Singleton pattern is used for logging, drivers objects, caching and thread pool.
Singleton design pattern is also used in other design patterns like Abstract Factory, Builder, Prototype, Facade etc.
Singleton design pattern is used in core java classes also, for example java.lang.Runtime, java.awt.Desktop.



1. Eager initialization


public class Logger {
    
    private static final Logger instance = new Logger();
    
    private Logger(){}

    public static Logger getInstance(){
        return instance;
    }
}

But in most of the scenarios, Singleton classes are created for resources such as File System, Database connections etc and we should 
avoid the instantiation until unless client calls the getInstance method


2. Static block initialization

public class Logger {

    private static Logger instance;
    
    private Logger(){}
    
    //static block initialization for exception handling
    static{
        try{
            instance = new Logger();
        }catch(Exception e){
            throw new RuntimeException("Exception occured in creating singleton instance");
        }
    }
    
    public static Logger getInstance(){
        return instance;
    }
}

public class Runtime {
    private static Runtime currentRuntime = new Runtime();

    public static Runtime getRuntime() {
        return currentRuntime;
    }

    private Runtime() {}
}



3. Lazy Initialization

public class Logger {

    private static Logger instance;
    
    private Logger(){}
    
    public static Logger getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}

The above implementation works fine in case of single threaded environment but when it comes to multithreaded systems.

4. Thread Safe Singleton

public class Logger {

	private static Logger instance;
	 
	private Logger(){}
	    
	public static Logger getInstanceUsingDoubleLocking(){
	    if(instance == null){
	        synchronized (Logger.class) {
	            if(instance == null){
	                instance = new Logger();
	            }
	        }
	    }
	    return instance;
	}
	    
}

5. Bill Pugh Singleton Implementation

public class Logger {
	
	private Logger() {};
	
	private static class Instance{
		public static final Instance INSTANCE = new Instance();
	}
	
	public static Instance getInstance() {
		return Instance.INSTANCE;
	}
}

I think Mr Pugh's version is held in high regard because it only performs the instantiation of the singleton when getInstance() 
is called i.e. not when the class (the class holding the getInstance method) is loaded.


When the class Logger is loaded by the JVM, the class goes through initialization. 
Since the class does not have any static variables to initialize, the initialization completes trivially. 
The static class definition Instance within it is not initialized until the JVM determines that Instance must be executed. 
The static class Instance is only executed when the static method getInstance is invoked on the class Logger, 
and the first time this happens the JVM will load and initialize the Instance class.
The initialization of the Instance class results in static variable INSTANCE being initialized by executing the (private) constructor for the outer class Logger. 
Since the class initialization phase is guaranteed by the JLS to be sequential, i.e., non-concurrent, no further synchronization is required in the static 
getInstance method during loading and initialization. And since the initialization phase writes the static variable INSTANCE in a sequential operation,
all subsequent concurrent invocations of the getInstance will return the same correctly initialized INSTANCE without incurring 
any additional synchronization overhead.

6. Using Reflection to destroy Singleton Pattern


7. Enum Singleton

8. Serialization and Singleton


 */
public class Logger implements Serializable{
	
	private Logger() {};
	
	private static class Instance{
		public static final Instance INSTANCE = new Instance();
	}
	
	public static Instance getInstance() {
		return Instance.INSTANCE;
	}
	/*
	 * 1. Thread safe
	 * 2. Resources safe
	 * 3. lazy loading
	 * 4. Reflection safe
	 * 5. class final static object cannot be clone
	 */
	
	protected Object readResolve() {
	    return getInstance();
	}
	/*
	 * Java serialization: readObject() vs. readResolve()
	 * readResolve is used for replacing the object read from the stream. The only use I've ever seen for this is enforcing singletons; 
	 * when an object is read, replace it with the singleton instance. This ensures that nobody can create another instance by serializing
	 *  and deserializing the singleton.
	 */
	/*
	 * 5. Serialization safe
	 */
	public static void main(String []args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException, ClassNotFoundException {
		
		Instance instanceOne = Logger.getInstance();
		Instance instanceTwo = null;
		for(Constructor constructor : Logger.Instance.class.getDeclaredConstructors()) {
			constructor.setAccessible(true);
			instanceTwo = (Instance) constructor.newInstance();
			break;
		}
		
		System.out.println(instanceOne.hashCode());
		System.out.println(instanceOne.hashCode());
		
		
		Instance firstOne = Logger.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("test.ser"));
		out.writeObject(firstOne);
		out.flush();
		out.close();
		
		
		ObjectInput input = new ObjectInputStream(new FileInputStream("test.ser"));
		Instance secondOne = (Logger.Instance)input.readObject();
		input.close();
		
		
		System.out.println(firstOne.hashCode());
		System.out.println(secondOne.hashCode());
		
	}
}



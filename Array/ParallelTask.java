package Array;
////https://practice.geeksforgeeks.org/problems/brothers-from-different-root/1
//package Array;
//
//class BrothersFromDifferentRoots {
//	
//}

import java.util.HashMap;
import java.util.Map;

//
//public class A{
//	int i = 1; 
//	{
//		i = 2;
//	}
//	
//	A(){
//		i = 3;
//	}
//	
//	A(int i){
//		this.i = i;
//	}
//	public void print() {
//		System.out.print(i);
//	}
//	public static void main(String []args) {
//		Object obj1 = new Object();
//		Object obj2 = new Object();
//		System.out.println(obj1==obj2);
//		System.out.println(obj1.equals(obj2));
//		obj1 = obj2;
//		System.out.println(obj1.equals(obj2));
//		
//		
//		
//		
//		System.out.println(2+4*9-3);
//		System.out.println((2+4)*9-3);
//		System.out.println(2+(4*9)-3);
//		System.out.println(2+4*(9-3));
//		System.out.println((2+4*9)-3);
//		
//		
//		System.out.println([String ]);
//		
//		new A().print();
//		new A(5).print();
//	}
//}
//

//
//public class Employee {
//	 
//    private String name;
//    private int age;
// 
//    public Employee() {
//    }
// 
//    public Employee(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
// 
//    public String getName() {
//       return name;
//    }
// 
//    public void setName(String name) {
//        this.name = name;
//    }
// 
//    public int getAge() {
//        return age;
//    }
// 
//    public void setAge(int age) {
//        this.age = age;
//    }
// 
//    @Override
//    public boolean equals(Object obj) {
//        return true;
//    }
// 
//    @Override
//    public int hashCode() {
//        return 1;
//    }
// 
//    public static void main(String[] args) {
//        Employee e = new Employee("muhammad", 24);
//        Map<Object,Object> m = new HashMap<Object,Object>(); 
//        m.put(e, "Muhammad Ali Khojaye");  
//     
//        // getting output 
//        System.out.println(m);
//        
//        
//        m.put(e, "Muhammad Ali111");  
//        System.out.println(m);
//        // it fails again
//    } 
//}





class TaskBase {
        int getStatusCode(Object obj) throws NullPointerException {
                if (obj != null ) {
                    return 1;
                } else {
                    return 0;
                }
        }
}

public class ParallelTask extends TaskBase {

	 long getStatusCode(String obj) throws NullPointerException {
         if (obj != null ) {
             return 1;
         } else {
             return 0;
         }
 }
public static void main(String []args) {
	System.out.println(new ParallelTask().getStatusCode(null));
	
	int i = 1;
	if(i++ == --i) {
		System.out.println("0");
	}else {
		System.out.println("1");
	}
}
}
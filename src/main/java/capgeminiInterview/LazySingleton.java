package capgeminiInterview;

public class LazySingleton {
private static LazySingleton instance;
private LazySingleton() {};

public static LazySingleton getInstance() {
	if(instance==null) {
		instance= new LazySingleton();
	}
	return instance;
}
}

/*
 * ❌ Problem:
Not thread-safe: Multiple threads can create multiple instances.
For thread safety (synchronized)-  Synchronized method ensures thread safety, but may impact performance.
 * */

//1.making thread safe 
class LazySingleton1{
	private static LazySingleton1 instance;
	private LazySingleton1() {};
	public static synchronized LazySingleton1 getInstance() {
		if(instance==null) {
			instance=new LazySingleton1();
		}
		return instance;
	}
}

//2. beast- increased performance and thread safe , lazy load-> Best: Double-Checked Locking (Efficient & Thread-safe)
 class SingletonDCL {
    private static volatile SingletonDCL instance;

    private SingletonDCL() {}

    public static SingletonDCL getInstance() {
        if (instance == null) {
            synchronized (SingletonDCL.class) {
                if (instance == null) {
                    instance = new SingletonDCL();
                }
            }
        }
        return instance;
    }
}
 /*
  * 🔸 volatile ensures changes are visible across threads.
🔸 Reduces synchronization overhead.
synchronized (SingletonDCL.class)-> Locks the class-level monitor of SingletonDCL.
Why?
Because getInstance() is a static method, there’s no object instance yet.

So, to prevent multiple threads from creating multiple objects, we lock the class object.

🔒 It ensures that only one thread can enter this block per class, not per object.


🔁 First check (outside synchronized):

if (instance == null) {
This prevents locking every time — improves performance when the instance is already created.
🚀 Fast path for most calls.

🔁 Second check (inside synchronized):

if (instance == null) {
Even after the first thread passes the first check and enters the block, another thread might have already created the object.
So we check again inside the lock to be 100% sure.


*/
//3. best- practice
 class SingletonDCL1 {
	 private static volatile SingletonDCL1 instance;
	 private SingletonDCL1() {};
	 public static SingletonDCL1 getInstance() {
		 if(instance==null) {
			 synchronized (SingletonDCL1.class) {
				if(instance==null) {
					instance= new SingletonDCL1();
				}
			}
		 }
		 return instance;
	 }
 }
 
 //4.
 class SingletonDCL2{
	 private static SingletonDCL2 instance;
	 private SingletonDCL2() {};
	 public static  SingletonDCL2 getinstance() {
		 if(instance==null) {
			 instance= new SingletonDCL2();
		 }
		 return instance;
	 }
}
 //synchronized
 class SingletonDCL2b{
	 private static SingletonDCL2b instance;
	 private SingletonDCL2b() {};
	 public static synchronized SingletonDCL2b getinstance() {
		 if(instance==null) {
			 instance= new SingletonDCL2b();
		 }
		 return instance;
	 }
}
 //best doule checked locking
 class SingletonDCL2c{
	 private static volatile SingletonDCL2c instance;
	 private SingletonDCL2c() {};
	 public static  SingletonDCL2c getinstance() {
		 if(instance==null) {
			 synchronized (SingletonDCL2c.class) {
				if(instance==null) {
					instance= new SingletonDCL2c();
				}
			}
			 
		 }
		 return instance;
	 }
}
 //5. 
 class LazySingleton5{
	 private static LazySingleton5 instance;
	 private LazySingleton5() {};
	 public static LazySingleton5 getinstance() {
		 if(instance==null) {
			 instance= new LazySingleton5();
		 }
		 return instance;
	 }
	 
 }
  // synchronized for thread safety
 
 class LazySingleton5b{
	 private static LazySingleton5b instance;
	 private LazySingleton5b() {};
	 public static synchronized LazySingleton5b getInstance() {
		 if(instance==null) {
			 instance= new LazySingleton5b();
			 
		 }
		 return instance;
	 }
 }
 
 // double checke locking
 class LazySingleton5c{
	 private static volatile LazySingleton5c instance;
	 private LazySingleton5c() {};
	 public static LazySingleton5c getInstance() {
		 if(instance==null) {
			 synchronized (LazySingleton5c.class) {
				if(instance== null) {
					instance=new LazySingleton5c();
				}
			}
		 }
		 return instance;
	 }
 }
 
 
 
 
 
 
 


 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

package capgeminiInterview;

public class EagerSingleton {
private static final EagerSingleton instance = new EagerSingleton();

//private constructor
private EagerSingleton() {};

public static EagerSingleton getInstance() {
	return instance;
}
}


/* 
 *  The singleton object is created as soon as the class is loaded, even if you never use it.
 * ✅ Pros:
Thread-safe by default (JVM loads static fields safely).->, because static initializations are handled by JVM classloader safely

Simple and fast.

❌ Cons:
Instance is created even if it's never used (wastes memory if unused).

✅ Use When:
The object is lightweight or cheap to create

You are sure it will be used in your application

Thread safety is a priority but performance must be fast */
 
//1.
class EagerSingleton1{
 private static final EagerSinglton1 instance =	new EagerSingleton1();
  
 private EagerSingleton1() {};
 
 public static EagerSingleton1 getInstance() {
	 return instance;
 }
 
}
//2.
class EagerSingleton2{
	private final static EagerSingleton2 instance= new EagerSingleton2();
	
	private EagerSingleton2() {};
	
	public static EagerSingleton2 getInstance() {
		return instance;
	}
}
//3.
class EagerSingleton3{
	private static final EagerSingleton3 instance = new EagerSingleton3();
	private EagerSingleton3() {};
	public static EagerSingleton3 getInstance() {
		return instance;
	}
}
//4.
class EagerSingleton4{
private static final EagerSingleton4 instance= new EagerSingleton4();
private EagerSingleton4() {};
public static EagerSingleton4 getInstance() {
	return instance;
}
}


//5. 
  class EagerLoading5{
	  private static final EagerLoading5 instance= new EagerLoading5();
	  private EagerLoading5() {};
	  public static EagerLoading5 getInstance() {
		  return instance;
	  }
  }
package singleton;

public class LazySingleton {
 private static LazySingleton instance;
 private LazySingleton() {};
 
 public LazySingleton getInstance() {
	 if(instance==null) instance= new LazySingleton();
	 
	 return instance;
 }
}

//thread safe using syncronished

class LazySingletonSync{
	private static LazySingletonSync instance;
	private LazySingletonSync() {};
		
		synchronized public static LazySingletonSync getInstance() {
		if(instance==null) {
			instance=new LazySingletonSync();
		}
		return instance;
	}
}

//double checked locing

class LazySingltonDCL{
	private static volatile LazySingltonDCL instance;
	private LazySingltonDCL() {};
	
	public static LazySingltonDCL getInstance() {
		if(instance==null) {
			synchronized (LazySingltonDCL.class) {
				if(instance==null) {
					instance= new LazySingltonDCL();
				}
			}
		}
		return instance;
	}
}
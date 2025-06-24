package BuilderPattern;

/*🔷 Builder Design Pattern
✅ Definition
The Builder Pattern separates the construction of a complex object from its representation so that the same construction process can create different representations.

🔑 Key Intent
To build complex objects with many optional fields without writing telescoping constructors or exposing object internals.

✅ When to Use Builder Pattern
When an object has many optional fields

To avoid constructor overloading

To ensure immutability

When you want a fluent interface (method chaining)

💡 Real-Life Analogy
Imagine building a meal at a restaurant. You select a starter, main course, drink, and dessert — you don’t need all of them every time. A builder lets you construct your customized meal step-by-step.

✅ Advantages
Clean and readable code (fluent interface)

Avoids constructor overloading

Helps build immutable objects

Easy to customize object creation

Supports step-by-step construction

❌ Disadvantages
Slightly more verbose (more code)

Not ideal for very simple objects

Need static inner class

🔥 Real-World Use Cases
StringBuilder, StringBuffer

StringJoiner

java.lang.ProcessBuilder

java.nio.ByteBuffer

Lombok's @Builder annotation

Building HTTP requests in libraries (e.g., OkHttp)

🔁 Summary vs Other Patterns
Pattern	Focus
Factory	Chooses which class to instantiate
Builder	Constructs object step-by-step
Prototype	Copies existing object
Singleton	Ensures one instance

*/


//Without Builder(Telescoping constructor--bad practice)
/*class User {
	private String name;
	private int age;
	private String email;
	private String phone;
	
	public User(String name,int age) {}
	public User(String name,int age, String email) {}
	public User(String name,int age, String email,String phone) {}
}*/

//with builder pattern
class User{
	//required
	private final String name;
	private final int age;
	//optional
	private final String email;
	private final String phone;
	
	private User(Builder builder) {
		this.name=builder.name;
		this.age=builder.age;
		this.email=builder.email;
		this.phone=builder.phone;
	}
	
	public static class Builder{
		private final String name;
		private final int age;
		private String email;
		private String phone;
		
		public Builder(String name,int age) {
			this.name=name;
			this.age=age;
			}
		public Builder email(String email) {
			this.email=email;
			return this;
		}
		public Builder phone(String phone) {
			this.phone=phone;
			return this;
		}
		
		public User build() {
			return new User(this);
		}
		
		
	}
	//getters- optional
			public String getName() {
				return name;
			}
			public String getEmail() {
				return email;
			}
}
public class BuilderDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        User user=new User.Builder("Nitish",26).email("nitish@gmail.com").phone("9876543210").build();
        
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
	}

}

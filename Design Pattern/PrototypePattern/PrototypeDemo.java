package PrototypePattern;

/*🔷 Prototype Design Pattern
✅ Definition
The Prototype Pattern allows you to create new objects by cloning existing ones instead of creating them from scratch (via new).
It’s useful when:

Object creation is costly (e.g., loading data, network call, DB access).

You want to avoid rebuilding object structure every time.

🔑 Key Intent
"Create new objects by copying a prototype instance, rather than creating new objects using constructors."

📦 Real-Life Analogy:
Imagine you’re filling out a job application form. Instead of writing from scratch every time, you copy a template and modify only a few fields.
That's prototype cloning.

✅ Java Implementation of Prototype
🔹 1. The Cloneable Interface
Java supports prototype pattern via the Cloneable interface and Object.clone() method.

🧠 Shallow vs Deep Copy
Type	Description
Shallow Copy	Copies object references (default clone())
Deep Copy	Copies actual objects recursively (manual cloning)

If your object has nested mutable objects, you’ll need to implement deep cloning manually.

✅ Advantages
Avoids the cost of creating objects from scratch

Useful when object creation is complex or time-consuming

Simplifies object creation logic

❌ Disadvantages
Cloning can be tricky when you have nested objects

Cloneable interface in Java is considered flawed (e.g., lacks a clone() method itself)

Deep cloning requires extra effort

🔥 Real-World Use Cases
Object pools (e.g., JDBC connections)

Game development (cloning enemies, weapons)

GUI editors where you duplicate widgets

Excel-style templates

🧠 Interview Tip
Q: Is Object.clone() a deep copy?
👉 No, it’s a shallow copy by default.

Q: What if your class has non-cloneable fields?
👉 You must manually clone those or replace clone() with a custom copy constructor or use serialization-based deep copy.

*/

//🔹 1. Prototype Class
class Document implements Cloneable{
	private String content;
	private String author;
	
	public Document(String content,String author) {
		this.content=content;
		this.author=author;
	}
	public void setContent(String content) {
		this.content=content;
	}
	public void show() {
		 System.out.println("Document by " + author + ": " + content);
	}
	
	//@override
	public Document clone() {
		try {
			return (Document) super.clone();  // Shallow copy
		} catch (CloneNotSupportedException  e) {
			throw new RuntimeException("Cloning Not Supported!");
		}
	}
	
	
}

public class PrototypeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document original= new Document("Original Content", "Nitish");
		original.show();
		
		Document copy=original.clone();
		copy.setContent("Editted content");
		copy.show();

	}

}

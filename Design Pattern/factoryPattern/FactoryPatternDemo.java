package factoryPattern;
/*
 * 🔷 Factory Design Pattern (Factory Method Pattern)
✅ Definition
The Factory Pattern defines an interface or abstract class for creating an object, but lets subclasses decide which class to instantiate.

It helps encapsulate object creation logic, promoting loose coupling.

🔑 Key Intent
“Create objects without exposing the instantiation logic to the client and refer to the newly created object using a common interface.”

✅ When to Use Factory Pattern?
When you don’t know the exact class of object to create.

When object creation logic is complex or based on conditions.

To avoid tight coupling between client code and specific classes.

When you want to follow Open/Closed Principle (O from SOLID).

🧱 Components
Product (Interface / Abstract Class)

Concrete Products (Subclasses)

Creator / Factory Class (with the method that returns objects)

*/
 interface Shape {
 void draw();
}
class Circle implements Shape{
	public void draw() {
		System.out.println("Drawing Circle");
	}
}

class Rectangle implements Shape{
	public void draw() {
		System.out.println("Drawing Rectangle");
	}
}

class ShapeFactory {
	public Shape getShape(String shapeType) {
		if(shapeType==null) return null;
		if(shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		}
		if(shapeType.equalsIgnoreCase("Rectangle")) {
			return new Rectangle();
		}
		
		return null;
	}
}

public class FactoryPatternDemo{
	public static void main(String[] args) {
		ShapeFactory factory= new ShapeFactory();
		Shape circle= factory.getShape("circle");
		circle.draw();
	}
}
package AbstractFactoryPattern;
/*
 * The Abstract Factory Pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes.

🔑 Key Intent
Create groups of related objects (e.g., buttons, menus, toolbars) without hardcoding their actual classes.

🧱 Participants in the Pattern
Component	Description
AbstractFactory	Declares interfaces for creating abstract products
ConcreteFactory	Implements creation of specific product variants
AbstractProduct	Interface for a product
ConcreteProduct	Concrete implementations of the abstract product
Client	Uses only the AbstractFactory and AbstractProduct interfaces

💡 Real-World Analogy:
Imagine you’re building a UI toolkit for both Windows and MacOS.
Each OS has its own style of buttons and text fields, but you want to use common interfaces.

✅ Advantages
Promotes consistency among products (same family)

Makes switching families of objects easy

Follows Open/Closed Principle

Decouples client code from specific classes

❌ Disadvantages
Increases number of classes

Adding new product types is hard (needs changing interface & all factories)

🔥 Real-World Use Cases
UI toolkits (cross-platform)

Dependency injection containers

Spring Framework bean configurations (using profiles)

Vehicle manufacturing (bike engine, bike frame, etc.)

🔁 Comparison: Factory vs Abstract Factory
Feature	Factory Pattern	Abstract Factory Pattern
Creates	One product	Family of related products
Complexity	Simple	More abstract and layered
Use case	ShapeFactory → Circle, Square	UIFactory → Button, TextField


 * */


//Abstract Products
interface Button{
	void click();
}
interface TextField {
	void type(String text);
}
//concrete Products
class WindowsButton implements Button{

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println("Windows Button clicked");
	}
	
}

class MacButton implements Button{

	@Override
	public void click() {
		// TODO Auto-generated method stub
	    System.out.println("Mac Button clcked");	
	}
	
}
class WindowsTextField implements TextField{

	@Override
	public void type(String text) {
		// TODO Auto-generated method stub
		System.out.println("Typing in Windows TextField: "+text);
	}
	
}

class MacTextField implements TextField{

	@Override
	public void type(String text) {
		// TODO Auto-generated method stub
		System.out.println("Typing in Mac Text Fields: "+text);
	}
	
}

//Abstract Factory
interface GUIFactory{
	Button createButton();
	TextField createTextField();
}
//Concrete Factories
class WindowsFactory implements GUIFactory{

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new WindowsButton();
	}

	@Override
	public TextField createTextField() {
		// TODO Auto-generated method stub
		return new WindowsTextField();
	}
	
}

class MacFactory implements GUIFactory{

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new MacButton();
	}

	@Override
	public TextField createTextField() {
		// TODO Auto-generated method stub
		return new MacTextField();
	}
	
}
public class AbstractFactoryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GUIFactory factory = getFactory("MAC");
		Button button=factory.createButton();
		TextField textfiled=factory.createTextField();
		button.click();
		textfiled.type("Hello world!");

	}
	static GUIFactory getFactory(String ostype) {
		if(ostype.equalsIgnoreCase("Windows")) return new WindowsFactory();
		else return new MacFactory();
	}

}

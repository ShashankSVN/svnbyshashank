package core.designpattern.creational;

enum ShapeEnum {
	CIRCLE, RECTANGLE
}

interface ShapeFactory {
	Shape getFactory(ShapeEnum name);
}

class ShapeFactoryImpl implements ShapeFactory {

	@Override
	public Shape getFactory(ShapeEnum name) {

		if (name == ShapeEnum.CIRCLE)
			return new Circle();
		else if (name == ShapeEnum.RECTANGLE)
			return new Reactangle();
		return null;
	}

}

interface Shape {
	void draw();
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Cicle drawn");
	}

}

class Reactangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Rectangle drawn");
	}
}

public class AbstractFactoryDPDemo {

	public static void main(String[] args) {

		ShapeFactory shapeFactory = new ShapeFactoryImpl();
		Shape cirShape = shapeFactory.getFactory(ShapeEnum.CIRCLE);
		Shape rectShape = shapeFactory.getFactory(ShapeEnum.RECTANGLE);
		cirShape.draw();
		rectShape.draw();

	}

}

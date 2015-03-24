package core.designpattern.creational;

class Car {
	private String engine;
	private String tyre;
	private String paint;

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public String getTyre() {
		return tyre;
	}

	public void setTyre(String tyre) {
		this.tyre = tyre;
	}

	public String getPaint() {
		return paint;
	}

	public void setPaint(String paint) {
		this.paint = paint;
	}

	public String toString() {
		return "CarEngine: " + this.engine + " Car Tyre: " + this.tyre
				+ " Car Paint: " + this.paint;
	}
}

interface CarBuilder {
	void makeEngine();

	void makeTyre();

	void makePaint();

	Car getCar();

	/* void makeCar(); */
}

class USCarBuilder implements CarBuilder {
	private Car car;

	public USCarBuilder() {
		car = new Car();
	}

	@Override
	public void makeEngine() {
		car.setEngine("Petrol Engine");
	}

	@Override
	public void makeTyre() {
		car.setTyre("Tubeless Tyre");
	}

	@Override
	public void makePaint() {
		car.setPaint("Blue");
	}

	@Override
	public Car getCar() {
		return car;
	}
	/*
	 * public void makeCar() { makeEngine(); makeTyre(); makePaint(); }
	 */

}

class GermanCarBuilder implements CarBuilder {
	private Car car;

	public GermanCarBuilder() {
		this.car = new Car();
	}

	@Override
	public void makeEngine() {
		car.setEngine("Deisel Engine");
	}

	@Override
	public void makeTyre() {
		car.setTyre("Tube Tyre");
	}

	@Override
	public void makePaint() {
		car.setPaint("White");
	}

	@Override
	public Car getCar() {
		return car;
	}

	/*
	 * public void makeCar() { makeEngine(); makeTyre(); makePaint(); }
	 */
}

//This is factory demonstration not include in builder DP concept
enum CarBuilderType{GermanCarBuilder,USCarBuilder
	
}

class Director {
	// 1. Its separate the make car common function associated with each builder
	// and named as buildCar
	// 2. Its can decide which attribute need to add or which is not need to add
	// 3. If a new Concrete builder added no change is required to this class

	private CarBuilder carBuilder;

	public Director(CarBuilder carBuilder) {
		this.carBuilder = carBuilder;
	}
	
	//This is factory demonstration not include in builder DP concept
	public Director(CarBuilderType carBuilderName) {
		if(CarBuilderType.USCarBuilder==carBuilderName)
		{
			this.carBuilder = new USCarBuilder();
		}
		if(CarBuilderType.GermanCarBuilder==carBuilderName)
		{
			this.carBuilder = new GermanCarBuilder();
		}
	
	}
	
	

	Car buildCar() { //Steps to create car
		carBuilder.makeEngine();
		carBuilder.makeTyre();
		carBuilder.makePaint();
		return carBuilder.getCar();

	}
}

public class BuilderDesignPattern {

	public static void main(String[] args) {

		/*
		 * CarBuilder usCarBuilder = new USCarBuilder(); usCarBuilder.makeCar();
		 * Car car1 = usCarBuilder.getCar();
		 * 
		 * CarBuilder germanCarBuilder = new GermanCarBuilder();
		 * germanCarBuilder.makeCar(); Car car2 = germanCarBuilder.getCar();
		 */

		Director director1 = new Director(new USCarBuilder());
		Car car1 = director1.buildCar();
		System.out.println(car1);

		Director director2 = new Director(new GermanCarBuilder());
		Car car2 = director2.buildCar();
		System.out.println(car2);
		
		
		//In factory pattern way
		Director director3 = new Director(CarBuilderType.USCarBuilder);
		Car car3 = director3.buildCar();
		System.out.println(car3);
		
		Director director4 = new Director(CarBuilderType.GermanCarBuilder);
		Car car4 = director4.buildCar();
		System.out.println(car4);

	}

}

package core.designpattern.structural;

import java.io.FilterInputStream;

interface Food {
	String prepareFood();

	double foodPrice();

}

class VegFood implements Food {

	@Override
	public String prepareFood() {
		return "VEG FOOD";

	}

	@Override
	public double foodPrice() {
		return 50;
	}

}

abstract class FoodDecorator implements Food {
	Food food;

	public FoodDecorator(Food food) {
		this.food = food;
	}

	
	@Override
	public String prepareFood() {

		return food.prepareFood();

	}

	@Override
	public double foodPrice() {

		return food.foodPrice();
	}

}

class NonVegFood extends FoodDecorator {
	public NonVegFood(Food food) {
		super(food);
	}

	@Override
	public String prepareFood() {

		return super.prepareFood() + "&& NON VEG";
	}

	@Override
	public double foodPrice() {

		return super.foodPrice() + 100;
	}
}

class ChineeseFood extends FoodDecorator {
	public ChineeseFood(Food food) {
		super(food);
	}

	@Override
	public String prepareFood() {

		return super.prepareFood() + "&& Chinese";
	}

	@Override
	public double foodPrice() {

		return super.foodPrice() + 25;
	}
}

public class DecoratorDPDemo {

	private static int choice;

	public static void main(String args[]) {

		VegFood vf = new VegFood();
		System.out.println(vf.prepareFood());
		System.out.println(vf.foodPrice());
		Food f1 = new NonVegFood(new ChineeseFood(new VegFood()));
		System.out.println(f1.prepareFood());
		System.out.println(f1.foodPrice());
		Food f2 = new ChineeseFood(new VegFood());
		System.out.println(f2.prepareFood());
		System.out.println(f2.foodPrice());
	}

}

package core.designpattern.structural;


class VegFoo implements Food {
	
	@Override
	public String prepareFood() {
		return "VEG FOOD";

	}
	@Override
	public double foodPrice() {
		System.out.println("food");
		return 50;
	}

}

class ChineseFoo implements Food {
	
	Food food;
	
	public ChineseFoo(Food food) {
		this.food = food;
	}
	@Override
	public String prepareFood() {
		return "Chinese FOOD";

	}
	@Override
	public double foodPrice() {
		System.out.println("chinese");
		return food.foodPrice()+ 20;
	}

}

class NonVegFoo implements Food {
	
	Food food;
	
	public NonVegFoo(Food food) {
		super();
		this.food = food;
	}
	@Override
	public String prepareFood() {
		return "Non VEG FOOD";

	}
	@Override
	public double foodPrice() {
		System.out.println("non veg");
		return food.foodPrice()+ 50;
	}

}

public class ChallengeToDecoratorDP {

	public static void main(String[] args) {
		
		Food food=new VegFoo();
		food = new ChineseFoo(new NonVegFoo(food));
		System.out.println(food.foodPrice());
		
		

	}

}

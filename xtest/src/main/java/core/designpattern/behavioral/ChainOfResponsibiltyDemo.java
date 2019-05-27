/**
 * 
 */
package core.designpattern.behavioral;

enum FuntionType {
	ADD, SUB, MUL, DIV, POW
}

interface Chain {
	void setNextChain(Chain chain);

	void calculate(int number1, int number2, FuntionType funType);
}

class AddNumbers implements Chain {
	Chain nextChain;

	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void calculate(int number1, int number2, FuntionType funType) {
		if (funType == FuntionType.ADD)
			System.out.println("Addition of number is:" + (number1 + number2));
		else
			nextChain.calculate(number1, number2, funType);
	}

}

class SubNumbers implements Chain {
	Chain nextChain;

	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void calculate(int number1, int number2, FuntionType funType) {
		if (funType == FuntionType.SUB)
			System.out.println("Subtraction of number is:"
					+ (number1 - number2));
		else
			nextChain.calculate(number1, number2, funType);
	}

}

class MulNumbers implements Chain {
	Chain nextChain;

	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void calculate(int number1, int number2, FuntionType funType) {
		if (funType == FuntionType.MUL)
			System.out.println("Multiplication of number is:"
					+ (number1 * number2));
		else
			nextChain.calculate(number1, number2, funType);
	}

}

class DivNumbers implements Chain {
	Chain nextChain;

	@Override
	public void setNextChain(Chain nextChain) {
		this.nextChain = nextChain;
	}

	@Override
	public void calculate(int number1, int number2, FuntionType funType) {
		if (funType == FuntionType.DIV)
			System.out.println("Division of number is:" + (number1 / number2));
		else
			System.out.println(FuntionType.POW.name() + " is not defined");
	}

}

public class ChainOfResponsibiltyDemo {

	 static public void main(String[] args) {
		Chain addChain = new AddNumbers();
		Chain subChain = new SubNumbers();
		Chain mulChain = new MulNumbers();
		Chain divChain = new DivNumbers();
		addChain.setNextChain(subChain);
		subChain.setNextChain(mulChain);
		mulChain.setNextChain(divChain);
		addChain.calculate(45, 34, FuntionType.MUL);
		addChain.calculate(12, 3, FuntionType.DIV);
		addChain.calculate(12, 3, FuntionType.DIV);
		addChain.calculate(12, 3, FuntionType.POW);
	}

}

package cc150;

public class FactoryMethod {
	public static Car getCar(String make) {
		if(make.equals("asian"))
			return new Toyota();
		else return new BMW();
	}

}

interface Car {
	void start();
}

class BMW implements Car {

	@Override
	public void start() {
		System.out.println("start BMW...");

	}

}

class Toyota implements Car {

	@Override
	public void start() {
		System.out.println("start Toyota...");
	}

}

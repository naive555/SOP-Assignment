package liverpool.cloth;

public class CartSingleton {
	private static CartSingleton instance = new CartSingleton();

	private CartSingleton() {
		
	}

	public static CartSingleton getInstance() {
		if (instance == null) {
			instance = new CartSingleton();
		}
		return instance;
	}
	

	public void showMessage() {
		System.out.println("Hello World!");
	}
}

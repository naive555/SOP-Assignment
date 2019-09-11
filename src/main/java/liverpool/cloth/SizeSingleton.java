package liverpool.cloth;

public class SizeSingleton {
	
	private String[] size = {"S", "M", "L", "XL", "XXL"};
	
	private static SizeSingleton instance = new SizeSingleton();

	private SizeSingleton() {
		
	}

	public static SizeSingleton getInstance() {
		if (instance == null) {
			instance = new SizeSingleton();
		}
		return instance;
	}

	public String getSize(int index) {
		return size[index];
	}
}

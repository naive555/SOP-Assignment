package liverpool.cloth;

public class Jumpers implements LiverpoolShop {
	private int id;
	private String model;
	private double price;
	
	public Jumpers(int id, String model, double price) {
		this.id = id;
		this.model = model;
		this.price = price;
	}

	public void makeCate() {
		// TODO Auto-generated method stub
		System.out.println("Jumpers::make()");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}

package liverpool.cloth;


abstract class LiverpoolShop {
	private int id;
	private String model;
	private double price;
	public LiverpoolShop(int id, String model, double price) 
	    {
			this.id = id;
			this.model = model;
			this.price = price;
	    } 
	public void setId(int id) 
	    { 
	        this.id = id; 
	    } 
	public int getId() 
	    { 
	        return id; 
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
	public void setPrice(float price) {
			this.price = price;
		}
}

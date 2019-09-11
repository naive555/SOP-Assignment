package liverpool.cloth;

public class LiverpoolShopFactory {
	public LiverpoolShop getCate(int id, String cate, String model, double price) {
		if (cate == null) {
			return null;
		}
		if (cate.equalsIgnoreCase("JacketsAndOutwears")) {
			return new JacketsAndOutwears(id, model, price);

		} else if (cate.equalsIgnoreCase("Jumpers")) {
			return new Jumpers(id, model, price);

		} else if (cate.equalsIgnoreCase("Shirt")) {
			return new Shirt(id, model, price);
		}

		return null;
	}
}

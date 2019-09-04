package liverpool.cloth;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration

public class LiverpoolShopManager {
	private Shirt shirt = new Shirt(1, "LFC Mens Charcoal Knitted Crest Tee LFC Mens Charcoal Knitted Crest Tee", 25.00);
	private Jumpers jumpers = new Jumpers(2, "LFC Mens Colour Block Crew Neck Sweat", 45.00);
	private JacketsAndOutwears jackets = new JacketsAndOutwears(3, "LFC Mens Green Harrington Jacket", 50.00);
	private Hoodies hoodies = new Hoodies(4, "LFC Mens Red Marl Liverbird Hoody", 30.00);
	private TrousersAndShorts trousers = new TrousersAndShorts(5, "LFC Mens Grey Marl Tapered Jog Pants", 20.00);
	private Underwear underwear = new Underwear(6, "LFC Mens Two Pack Boxed Boxer Shorts", 20.00);
	private Footwear footwear = new Footwear(7, "NB X LFC 997 Trainer", 85.00);
	
	@RequestMapping("/shirt")
	public String getShirt() {
		return "You selected "+shirt.getModel()+", Price: £"+shirt.getPrice();
	}
	
	@RequestMapping("/jumpers")
	public String getJumpers() {
		return "You selected "+jumpers.getModel()+", Price: £"+jumpers.getPrice();
	}
	
	@RequestMapping("/jackets")
	public String getJackgets() {
		return "You selected "+jackets.getModel()+", Price: £"+jackets.getPrice();
	}
	
	@RequestMapping("/hoodies")
	public String getHoodies() {
		return "You selected "+hoodies.getModel()+", Price: £"+hoodies.getPrice();
	}
	
	@RequestMapping("/trousers")
	public String getTrousers() {
		return "You selected "+trousers.getModel()+", Price: £"+trousers.getPrice();
	}
	
	@RequestMapping("/underwear")
	public String getUnderwear() {
		return "You selected "+underwear.getModel()+", Price: £"+underwear.getPrice();
	}
	
	@RequestMapping("/footwear")
	public String getFootwear() {
		return "You selected "+footwear.getModel()+", Price: £"+footwear.getPrice();
	}
}

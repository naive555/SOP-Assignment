package liverpool.cloth;

import java.util.*;  
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration

public class LiverpoolShopManager {
	private Shirt shirt = new Shirt(1, "LFC Mens Charcoal Knitted Crest Tee LFC Mens Charcoal Knitted Crest Tee", 25.00);
	private Jumpers jumpers = new Jumpers(2, "LFC Mens Colour Block Crew Neck Sweat", 45.00);
	private JacketsAndOutwears jackets = new JacketsAndOutwears(3, "LFC Mens Green Harrington Jacket", 50.00);
	List<LiverpoolShop> cateragory = new ArrayList<LiverpoolShop>(
			Arrays.asList(
					shirt,
					jumpers,
					jackets
					)
			);
	
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
	
	@RequestMapping("/cart/{id}")
	public String addCart(@PathVariable int id) {
		System.out.println(cateragory.size());
		for (int i=0; i<cateragory.size(); i++) {
			if (id > cateragory.size() || id < 1) {
				return "No Cateragory found.";
			} else if (cateragory.get(i) == cateragory.get(id-1)){
				return "Added to Cart.";
			}
		}
		return null;
	}
	
}

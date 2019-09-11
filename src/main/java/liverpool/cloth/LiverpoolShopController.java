package liverpool.cloth;

import java.util.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration

public class LiverpoolShopController {
// Shirt shirt = new Shirt(1, "LFC Mens Charcoal Knitted Crest Tee LFC Mens Charcoal Knitted Crest Tee",
//			25.00);
// Jumpers jumpers = new Jumpers(2, "LFC Mens Colour Block Crew Neck Sweat", 45.00);
// JacketsAndOutwears jackets = new JacketsAndOutwears(3, "LFC Mens Green Harrington Jacket", 50.00);
	LiverpoolShopFactory livFac = new LiverpoolShopFactory();
	ArrayList<LiverpoolShop> category = new ArrayList<LiverpoolShop>();
	
	@RequestMapping(value = "/allcate")
	public ArrayList<LiverpoolShop> getAll() {
		return category;
	}

	@RequestMapping(value = "/deletecate-{id}", method = RequestMethod.POST)
	public ArrayList<LiverpoolShop> deleteCate(@PathVariable("id") int id) {
		category.remove(id - 1);
		return category;
	}

	@RequestMapping(value = "/createcate/{id}-{type}-{model}-{price}", method = RequestMethod.POST)
	public ResponseEntity<LiverpoolShop> createCate(@PathVariable("id") int id, @PathVariable String cate,@PathVariable("model") String model,
			@PathVariable("price") double price) {
		category.add(livFac.getCate(id, cate, model, price));
		return new ResponseEntity<LiverpoolShop>(livFac.getCate(id, cate, model, price), HttpStatus.OK);
	}
}

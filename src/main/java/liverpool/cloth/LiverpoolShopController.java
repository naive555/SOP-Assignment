package liverpool.cloth;

import java.util.*;
import java.io.*;
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
	// Create Example...
	// Shirt (1-"shirt", "LFC Mens Charcoal Knitted Crest Tee LFC Mens Charcoal Knitted Crest Tee"-25.00)
	// Jumpers (2-"Jumpers"-"LFC Mens Colour Block Crew Neck Sweat"-45.00)
	// JacketsAndOutwears (3-"JacketsAndOutwears"-"LFC Mens Green Harrington Jacket"-50.00)
	LiverpoolShopFactory livFac = new LiverpoolShopFactory();
	ArrayList<LiverpoolShop> clothes = new ArrayList<LiverpoolShop>();
	private String size;
	private double price;
	SizeSingleton checkSize = SizeSingleton.getInstance();
	
	@RequestMapping(value = "/getallclothes", method = RequestMethod.GET)
	public ArrayList<LiverpoolShop> getAllclothes() {
		fileReader();
		return clothes;
	}

	@RequestMapping(value = "/createclothes-{id}-{cate}-{model}-{price}", method = RequestMethod.POST)
	public ResponseEntity<LiverpoolShop> createclothes(@PathVariable("id") int id, @PathVariable String cate, @PathVariable("model") String model,
			@PathVariable("price") double price) {
		clothes.add(livFac.getCate(id, cate, model, price));
		return new ResponseEntity<LiverpoolShop>(livFac.getCate(id, cate, model, price), HttpStatus.OK);
	}
	
	//Input your chest size(Male only)
	@RequestMapping(value = "/selectcloth-{id}-{wide}", method = RequestMethod.GET)
	public ResponseEntity<LiverpoolShop> selectCloth(@PathVariable("id") int id, @PathVariable("wide") int wide) {
		LiverpoolShop cloth = clothes.get(id-1);
		fileWriter(sumCost(cloth.getModel(), cloth.getPrice(), wide));
		return new ResponseEntity<LiverpoolShop>(cloth, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteclothes-{id}", method = RequestMethod.POST)
	public ArrayList<LiverpoolShop> deleteclothes(@PathVariable("id") int id) {
		clothes.remove(id-1);
		return clothes;
	}
	
	public String sumCost(String model, double price, int wide) {
		getSize(price, wide);
		return "You Select Model: "+model+", Size: "+size+", Cost: "+this.price+" £";
	}
	
	public String getSize(double price, int wide) {
		if (wide >= 36 && wide <= 38) {
			size = checkSize.getSize(0);
		} else if (wide >= 39 && wide <= 40) {
			size = checkSize.getSize(1);
			this.price = price + 3;
		} else if (wide >= 41 && wide <= 42) {
			size = checkSize.getSize(2);
			this.price = price + 5;
		} else if (wide >= 43 && wide <= 44) {
			size = checkSize.getSize(3);
			this.price = price + 7;
		} else if (wide > 44 && wide <= 46) {
			size = checkSize.getSize(4);
			this.price = price + 9;
		} else {
			size = "Not in size category.";
		}
		return size;
	}
	
	public static void fileWriter(String text) {
		try {
			FileWriter writer = new FileWriter("output.txt");
			writer.write(text);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void fileReader() {
		try {
			FileReader reader = new FileReader("output.txt");
			int text;
			while ((text = reader.read()) != -1) {
				System.out.printf("%c", text);
			}
			System.out.println("\n");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

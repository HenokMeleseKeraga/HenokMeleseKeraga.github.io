package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Product;


public class ProductDao {

	private Map<Integer, Product> productsDb = new HashMap<>();

	{
		//cat 1
		productsDb.put(1, new Product(1, "House Special", "pizza6.png","The best of the House!!","  Mellow red sauce with mozzarella, pepperoni, sausage, ground beef, ham, applewood smoked bacon, mushrooms, black olives, roma tomatoes, green peppers, onions topped with extra mozzarella.y", 17.99, 1));
		productsDb.put(2, new Product(2, "Great White", "pizzaGreatWhite.png","Best of the Veggies","Olive oil and garlic base with sun-dried roasted tomatoes, provolone, broccoli,feta cheese, seasoned ricotta, fresh basil, mozzarella, roma tomatoes and onions. ", 29.99, 1));
		productsDb.put(3, new Product(3, "Chicken Supreme Pizza", "chicken.png","Chicken breast, mushrooms & caramelised onions","Top lightly and evenly with the cooked chicken, olives, green pepper, mushrooms and red chilli. (Also place the pepperoni over the pizza if using) Sprinkle the surface of the Pizza with oregano. ... Bake till the crust is cooked golden and the cheese is melted.", 23.99, 1));
		productsDb.put(4, new Product(4, "Ultimate Cheese Lover's Pizza ", "cheese.jpg","Lover's recipe for cheese","All About Cheese. It had a cheese lover's pie before, but they're calling this tomato-less pie Ultimate Cheese Lover's. ... Instead of tomato sauce, this pizza has a layer of Alfredo sauce..", 19.99, 1));
		productsDb.put(5, new Product(5, "BBQ Beef Pizza ", "bbq.png","Spread the bbq beef mixture over the crust, spreading it evenly."," In a large skillet over medium-high heat, brown the ground beef, breaking it up as it cooks. ... Spread the bbq beef mixture over the crust, spreading it evenly. Sprinkle the cheese over the beef. Bake in the oven until the crust is golden brown and the cheese is melted, 8-12 minutes.", 29.99, 1));
		productsDb.put(6, new Product(6, "Simple Vegan Pizza", "veggan.jpg","The perfect golden vegan pizza!","The BEST vegan pizza made with a garlic-herb crust, simple tomato sauce, TONS of sauteed veggies, and vegan parmesan cheese. Thin crust, tons of flavor, and ridiculously satisfying.", 19.7, 1));

//
//		//cat 2
//		productsDb.put(7, new Product(7, "House Special", "pizza6.png","The best of the House!!","  Mellow red sauce with mozzarella, pepperoni, sausage, ground beef, ham, applewood smoked bacon, mushrooms, black olives, roma tomatoes, green peppers, onions topped with extra mozzarella.y", 10.99, 2));
//		productsDb.put(8, new Product(8, "Great White", "pizzaGreatWhite.png","Best of the Veggies","Olive oil and garlic base with sun-dried roasted tomatoes, provolone, broccoli,feta cheese, seasoned ricotta, fresh basil, mozzarella, roma tomatoes and onions. ", 20.99, 2));
//		productsDb.put(9, new Product(9, "Chicken Supreme Pizza", "chicken.png","Chicken breast, mushrooms & caramelised onions","Top lightly and evenly with the cooked chicken, olives, green pepper, mushrooms and red chilli. (Also place the pepperoni over the pizza if using) Sprinkle the surface of the Pizza with oregano. ... Bake till the crust is cooked golden and the cheese is melted.", 18.99, 2));
//		productsDb.put(10, new Product(10, "Ultimate Cheese Lover's Pizza ", "cheese.jpg","Lover's recipe for cheese","All About Cheese. It had a cheese lover's pie before, but they're calling this tomato-less pie Ultimate Cheese Lover's. ... Instead of tomato sauce, this pizza has a layer of Alfredo sauce..", 19.99, 2));
//		productsDb.put(11, new Product(11, "BBQ Beef Pizza ", "bbq.png","Spread the bbq beef mixture over the crust, spreading it evenly."," In a large skillet over medium-high heat, brown the ground beef, breaking it up as it cooks. ... Spread the bbq beef mixture over the crust, spreading it evenly. Sprinkle the cheese over the beef. Bake in the oven until the crust is golden brown and the cheese is melted, 8-12 minutes.", 21.99, 2));
//		productsDb.put(12, new Product(12, "Simple Vegan Pizza", "veggan.jpg","The perfect golden vegan pizza!","The BEST vegan pizza made with a garlic-herb crust, simple tomato sauce, TONS of sauteed veggies, and vegan parmesan cheese. Thin crust, tons of flavor, and ridiculously satisfying.", 12.99, 2));

	}


//	public List<Product> getProductByCategoryId(int categoryId) {
//		return productsDb.entrySet().stream()
//				.filter(p -> p.getValue().getCategoryId() == categoryId)
//				.map(p -> p.getValue()).collect(Collectors.toList());
//	}

	public List<Product> getProduct() {
		return productsDb.entrySet().stream()
				.map(p -> p.getValue()).collect(Collectors.toList());
	}

	public Product getProductById(int id) {

		return productsDb.get(id);
	}
}

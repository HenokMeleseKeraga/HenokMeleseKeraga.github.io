package dao;

import model.CartProduct;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShoppingCartDao {
	private ProductDao productDao = new ProductDao();
	private List<CartProduct> myCart = new ArrayList<>();
//	{
//		Product p=new Product(7, "House Special", "pizza6.png","The best of the House!!","  Mellow red sauce with mozzarella, pepperoni, sausage, ground beef, ham, applewood smoked bacon, mushrooms, black olives, roma tomatoes, green peppers, onions topped with extra mozzarella.y", 10.99, 2);
//		myCart.add(new CartProduct(p,45,2));
//	}

	public void addProduct(int productId) {
		// Check whether the product is existing in the current cart
		boolean present=false;
		for(CartProduct p:myCart){
			if(p.getProduct().getId()==productId){
				present=true;
			}
		}
		if(!present){
			Product newp=productDao.getProductById(productId);
			myCart.add(new CartProduct(newp,newp.getPrice(),1));
		}else {
			for(CartProduct p:myCart){
				if(p.getProduct().getId()==productId){
					p.setQty(p.getQty()+1);
				}
			}
		}


	}

	public void removeProduct(int productId) {
		myCart = myCart.stream().filter(p -> p.getProduct().getId() != productId).collect(Collectors.toList());
	}

	public void updateQty(int productId, int qty) {
		myCart = myCart.stream().map(p -> {
			if (p.getProduct().getId() == productId) {
				p.setQty(qty);
			}
			return p;
		}).collect(Collectors.toList());
	}

	public List<CartProduct> getMyCart() {
		return myCart;
	}

}

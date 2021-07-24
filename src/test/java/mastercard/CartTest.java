package mastercard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.mastercard.model.CartItem;
import com.mastercard.model.Product;
import com.mastercard.model.Promotion;
import com.mastercard.result.Cart;

public class CartTest {

	@Test
	public void testShouldCreateCartWithNoItemsAndPromotionTobeApplied() {
		Cart custCart = new Cart(new Promotion(Collections.emptyList(), false, false, false));
		assertNotNull(custCart.getPromotionOffered());
	}
	
	@Test
	public void testShouldCreateCartWithOneItemAndPromotionApplied() {
		Cart custCart = new Cart(new Promotion(Collections.emptyList(), false, false, false));
		custCart.addCartItems(new CartItem(null));
		assertEquals(1, custCart.getListOfItems().size());
	}
	
	@Test
	public void testShouldCreateCartWithOneItemAndPromotionDiscountOffered() {
		Product a = new Product("a","test",10f);
		Product b = new Product("b","test",20f);
		List<Product> promotionalProduct = Arrays.asList(a,b);
		Cart custCart = new Cart(new Promotion(promotionalProduct, true, false, false));
		custCart.addCartItems(new CartItem(a));
		assertEquals(a, custCart.getListOfItems().get(0).getProduct());
	}
	
	@Test
	public void testShouldCreateCartWithOneItemAndAddOneMoreSameItemLater() {
		Product a = new Product("a","test",10f);
		Product b = new Product("b","test",20f);
		List<Product> promotionalProduct = Arrays.asList(a,b);
		Cart custCart = new Cart(new Promotion(promotionalProduct, true, false, false));
		custCart.addCartItems(new CartItem(a));
		custCart.addCartItems(new CartItem(a));
		assertEquals(1, custCart.getListOfItems().size());
		assertEquals(2, custCart.getListOfItems().get(0).getQuantity());
	}
}

package mastercard;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.mastercard.model.CartItem;
import com.mastercard.model.Product;

public class CartItemTest {

	
	@Test
	public void testAddItemToCartSuccessfully() {
		CartItem cartItem = new CartItem(new Product("A","test",10f), 1);
		
		assertNotNull(cartItem.getProduct());
		assertEquals(1, cartItem.getQuantity());
	}
	
	@Test
	public void testTwoItemsToCartItemSuccessfully() {
		CartItem cartItem = new CartItem(new Product("B","testb",30f), 2);
		
		assertNotNull(cartItem.getProduct());
		assertEquals(2, cartItem.getQuantity());
	}
	
	@Test
	public void testAddMoreItemsToCartItemSuccessfully() {
		CartItem cartItem = new CartItem(new Product("B","testb",30f), 2);
		cartItem.addProductQuantity(2);
		assertNotNull(cartItem.getProduct());
		assertEquals(4, cartItem.getQuantity());
	}
	
	@Test
	public void testDefaultItemIsCountOneAddedToCartItemSuccessfully() {
		CartItem cartItem = new CartItem(new Product("C","testb",30f));
		
		assertNotNull(cartItem.getProduct());
		assertEquals(1, cartItem.getQuantity());
	}
	
	@Test
	public void testReduceItemFromCartItemSuccessfully() {
		CartItem cartItem = new CartItem(new Product("A","testb",30f),2);
		cartItem.reduceByOneProductQuantity();
		assertNotNull(cartItem.getProduct());
		assertEquals(1, cartItem.getQuantity());
	}
}

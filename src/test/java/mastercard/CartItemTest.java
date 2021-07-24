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
}

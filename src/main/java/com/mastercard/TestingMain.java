package com.mastercard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.mastercard.model.CartItem;
import com.mastercard.model.Product;
import com.mastercard.model.Promotion;
import com.mastercard.result.Cart;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestingMain {

	public static void main(String[] args) {
			Product a = new Product("A", "Cup", 10.0f);
			Product b = new Product("B", "pen", 12.0f);
			Product c = new Product("C", "googles", 40f);
			
			//Promotion Policy 1
			List<Product> promotionalProducts = Arrays.asList(a,b);
			Promotion policy1 = new Promotion(promotionalProducts, true, false, false); // half price on b
			policy1.applyHalfPriceOnItem(b);
			
			CartItem cartItemProduct1 = new CartItem(a, 1);
			CartItem cartItemProduct2 = new CartItem(b, 2);
			
			//make customer cart with some Promotion policy
			Cart customerCart = new Cart(policy1);
			customerCart.addCartItems(cartItemProduct1);
			customerCart.addCartItems(cartItemProduct2);
			customerCart.calculateTotalPrice();
			System.out.println("Price Before discount:" + customerCart.getPriceBeforeDiscount());
			System.out.println("Price Before discount:" + customerCart.getPriceBeforeDiscount());
			
			System.out.println("Price After discount:" + customerCart.getPriceAfterDiscount());
	}
	
}

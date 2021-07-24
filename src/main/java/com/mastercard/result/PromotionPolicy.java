package com.mastercard.result;

import java.util.List;
import java.util.stream.Collectors;

import com.mastercard.model.CartItem;
import com.mastercard.model.Product;
import com.mastercard.model.Promotion;

public class PromotionPolicy {
	
	private Promotion promotionApplied;

	public Promotion getPromotionApplied() {
		return promotionApplied;
	}

	public void setPromotionApplied(Promotion promotionApplied) {
		this.promotionApplied = promotionApplied;
	}

	public Float calculateDiscountOffered(List<CartItem> ItemsInCart) {
		return applyPromotionIfCartContainsAllPromotionalItems(ItemsInCart) ? promotionApplied.getDiscountOfferedInDollors() : null;
	}
	
	private boolean applyPromotionIfCartContainsAllPromotionalItems(List<CartItem> ItemsInCart) {
		List<Product> productListInCart = ItemsInCart.stream().map(item -> item.getProduct()).collect(Collectors.toList());
		return productListInCart.containsAll(promotionApplied.getPromotionalProducts());
	}
}

package com.mastercard.model;

import java.util.Comparator;
import java.util.List;

public class Promotion {
	
	private List<Product> promotionalProducts;

	private Float discountOfferedInDollors;
	
	private boolean halfPriceItemSet;
	
	private boolean discountOnTotalCartItems;
	
	private boolean cheapestFree;
	
	
	public Promotion(List<Product> promotionalProducts, boolean halfPriceItemSet, boolean discountOnTotalCartItems,
			boolean cheapestFree) {
		super();
		this.promotionalProducts = promotionalProducts;
		this.halfPriceItemSet = halfPriceItemSet;
		this.discountOnTotalCartItems = discountOnTotalCartItems;
		this.cheapestFree = cheapestFree;
	}

	public List<Product> getPromotionalProducts() {
		return promotionalProducts;
	}

	public Float getDiscountOfferedInDollors() {
		return discountOfferedInDollors;
	}

	public boolean isHalfPriceItemSet() {
		return halfPriceItemSet;
	}

	public boolean isDiscountOnTotalCartItems() {
		return discountOnTotalCartItems;
	}

	public boolean isCheapestFree() {
		return cheapestFree;
	}

	public void applyPromotionOnProducts(List<Product> productList){ 
		promotionalProducts = productList;
	}
	
	public void applyHalfPriceOnItem(Product appliedHalfPriceOnProduct) {
		halfPriceItemSet = true;
		discountOfferedInDollors = appliedHalfPriceOnProduct.getPrice()/2;
	}
	
	public void applyMoneyDiscountOnTotalCartItems(Float amount) {
		discountOnTotalCartItems = true;
		discountOfferedInDollors = amount;
	}
	
	public void cheapestFreeDiscountOnCartItems() {
		cheapestFree = true;
		Product minValueProduct = promotionalProducts
				.stream().min(Comparator.comparing(Product::getPrice)).get();
		discountOfferedInDollors = minValueProduct.getPrice();
	}
	
}

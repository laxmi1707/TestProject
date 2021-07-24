package com.mastercard.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mastercard.model.CartItem;
import com.mastercard.model.Promotion;

public class Cart {

	private List<CartItem> listOfItems = new ArrayList<>();
	
	private float discountOffered;
	
	private float priceBeforeDiscount;
	
	private float priceAfterDiscount;
	
	private Promotion promotionOffered;

	public Cart() {
		
	}
	
	public Cart(Promotion promotionToApply) {
        super();
        this.promotionOffered = promotionToApply;
    }	
	
	public List<CartItem> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<CartItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

	public float getDiscountOffered() {
		return discountOffered;
	}

	public void setDiscountOffered(float discountOffered) {
		this.discountOffered = discountOffered;
	}

	public float getPriceBeforeDiscount() {
		return priceBeforeDiscount;
	}

	public void setPriceBeforeDiscount(float priceBeforeDiscount) {
		this.priceBeforeDiscount = priceBeforeDiscount;
	}

	public float getPriceAfterDiscount() {
		return priceAfterDiscount;
	}

	public void setPriceAfterDiscount(float priceAfterDiscount) {
		this.priceAfterDiscount = priceAfterDiscount;
	}

	public Promotion getPromotionOffered() {
		return promotionOffered;
	}

	public void setPromotionOffered(Promotion promotionOffered) {
		this.promotionOffered = promotionOffered;
	}
	
	public void addCartItems(CartItem item) {
		Optional<CartItem> cartItem =  listOfItems.stream().filter(selected -> selected.getProduct().getId().equals(item.getProduct().getId())).findFirst();
		if(cartItem.isPresent()) {
			int pos = listOfItems.indexOf(cartItem.get());
			CartItem retrievedItem = listOfItems.get(pos);
			retrievedItem.addProductQuantity(item.getQuantity());
		}else {
			listOfItems.add(item);
		}
	}
	
	public void calculateTotalPrice() {
		if(promotionOffered != null) {
			listOfItems.forEach(item -> priceBeforeDiscount += item.getProduct().getPrice() * item.getQuantity());
			priceAfterDiscount = priceBeforeDiscount - promotionOffered.getDiscountOfferedInDollors();
		} else {
			listOfItems.forEach(item -> priceAfterDiscount += item.getProduct().getPrice() * item.getQuantity());
			priceBeforeDiscount = priceAfterDiscount;
		}
		
	}
	
	
}

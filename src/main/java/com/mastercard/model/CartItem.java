package com.mastercard.model;

public class CartItem {

	private Product product;
	
	private int quantity = 1; //default is 1
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	public CartItem(Product product) {
        super();
        this.product = product;
    }
	
    public CartItem(Product product, int quantity) {
        super();
        this.product = product;
        this.quantity = quantity;
    }
    
    public float getPriceBeforeDiscount(){
    	return product.getPrice() * quantity;
    }
    
    public int addProductQuantity(int numberOfItem) {
    	return quantity += numberOfItem;
    }
    
    public int reduceByOneProductQuantity() {
    	return quantity >0 ? quantity -= 1 : 0;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;

		CartItem other = (CartItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	
    
}

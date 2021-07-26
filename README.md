# TestProject for calculating price of Cart after applying promotions
This project is specifically named as TestProject so that it gives very less idea about what this project is all about as this repo is public.
This project deals with Calculating total price of cart after applying the discounts by various promotions.

PromotionPolicy class deals with creation of promotion and applying that promotion on cart.

CartItems as added by customer , should have all items which are defined using a promotion.

The design can be enhanced with different patterns to create promotions.
Unit test can be more extensive to cover each line of code provided more time.
Have used lombok in pom but since cannot use external lib so decided not to go ahead.
Enhancements
1) Factory pattern can be applied for creating promotions using offer enum and factory to create.

Assumption
1) only 1 promotion can be applied on a cart.
2) For promotion to be applied all products in that promotion should be present within cart.

  

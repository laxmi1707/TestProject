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

This project has CI CD pipeline set up to deploy as web app directly to Azure web app 
Firstly create webapp on azure indepdently . Download the app publich profile which has nothing but credentials of connecting by github to azure.
Now save this profile under a particular secert named in github

Now from github actions tab create github actions i.e deploy you code as webapp directly. We can do via docker as well or azure container registry as well.
But here we are doing directly
So after choosing the appropriate action a yml file will be created which will have some secrets holder (which shoudl match ur sceret saved earlier)

The pipeline works by 
building the code
creating the jar file in github
Now using az credentials it logs into azure portal and deploys your application to your webapp named earlier.

There are oter ways i.e you can upload your application as an image on docker registry or azure registry and then use it to deploy your application

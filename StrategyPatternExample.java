package com.apex.designpattern.behavioralpattern;

/*
 * 
 * 
 In this program:

We have a PaymentStrategy interface defining a method pay(int amount) 
for different payment strategies.

CreditCardPayment and PayPalPayment are concrete strategy classes 
implementing the PaymentStrategy interface.They represent different payment methods.
 
ShoppingCart is the context class that holds a reference to the current payment strategy.

In the Main class, we create a shopping cart, 
set different payment strategies (credit card and PayPal), 
and perform checkout operations using each payment strategy. 
This demonstrates how the strategy pattern allows us 
to encapsulate interchangeable behaviors and switch between them at runtime.
 * **/

//Strategy interface
interface PaymentStrategy {
 void pay(int amount);
}

//Concrete Strategy classes
class CreditCardPayment implements PaymentStrategy {
 private String cardNumber;
 private String expirationDate;
 private String cvv;

 public CreditCardPayment(String cardNumber, String expirationDate, String cvv) {
     this.cardNumber = cardNumber;
     this.expirationDate = expirationDate;
     this.cvv = cvv;
 }

 @Override
 public void pay(int amount) {
     System.out.println("Paid " + amount + " dollars using credit card.");
 }
}

class PayPalPayment implements PaymentStrategy {
 private String email;
 private String password;

 public PayPalPayment(String email, String password) {
     this.email = email;
     this.password = password;
 }

 @Override
 public void pay(int amount) {
     System.out.println("Paid " + amount + " dollars using PayPal.");
 }
}

//Context class
class ShoppingCart {
 private PaymentStrategy paymentStrategy;

 public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
     this.paymentStrategy = paymentStrategy;
 }

 public void checkout(int amount) {
     paymentStrategy.pay(amount);
 }
}

//Client code
public class StrategyPatternExample {
 public static void main(String[] args) {
     // Create a shopping cart
     ShoppingCart cart = new ShoppingCart();

     // Set credit card payment strategy
     cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9101-1121", "12/24", "123"));

     // Checkout using credit card payment
     cart.checkout(100);

     // Set PayPal payment strategy
     cart.setPaymentStrategy(new PayPalPayment("example@example.com", "password"));

     // Checkout using PayPal payment
     cart.checkout(50);
 }
}



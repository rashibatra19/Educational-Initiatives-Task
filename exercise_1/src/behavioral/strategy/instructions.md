# **Strategy Pattern - Payment Processing System**

## **Introduction**

This example demonstrates the **Strategy Design Pattern**, where the payment processing system allows users to select different payment methods dynamically. The strategy pattern is useful for scenarios where an object needs to choose a specific algorithm (strategy) at runtime.

In this implementation:
- **PaymentStrategy**: The interface that defines the `pay()` method.
- **CreditCardPayment** and **PayPalPayment**: Concrete implementations of the `PaymentStrategy` interface.
- **ShoppingCart**: The context class that uses the payment strategies to process payments.
  
---

## **Project Structure**

```bash
exercise_1/src/behavioral/strategy/
│
├── PaymentStrategy.java    # Strategy interface for payment processing
├── CreditCardPayment.java  # Concrete strategy for credit card payments
├── PayPalPayment.java      # Concrete strategy for PayPal payments
├── ShoppingCart.java       # Context class that uses the strategies
└── Main.java               # Main class that executes the program

- Example Run
Here’s an example of how the program interacts with the user:

Enter payment amount: 
100

Choose payment method (CreditCard/PayPal): 
CreditCard

Paid $95.0 using Credit Card with 5% discount.
If you select PayPal:

Enter payment amount: 
200

Choose payment method (CreditCard/PayPal): 
PayPal

Paid $194.0 using PayPal with 3% discount.

**Design Pattern Explanation**
Strategy Pattern
The Strategy Pattern is a behavioral design pattern that enables selecting an algorithm’s implementation at runtime. It defines a family of algorithms (in this case, payment methods), encapsulates each one, and makes them interchangeable.

In this example:

Context: The ShoppingCart class.
Strategy Interface: The PaymentStrategy interface, which defines the pay() method.
Concrete Strategies: The CreditCardPayment and PayPalPayment classes that implement the PaymentStrategy interface.
This pattern is useful for situations where you want to vary the behavior of an object dynamically, based on user input or other runtime conditions.


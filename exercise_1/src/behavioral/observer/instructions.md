# **Observer Pattern - Stock Market Monitoring System**

## **Introduction**

This example demonstrates the **Observer Design Pattern**, where a **Stock** (the subject) notifies multiple **Traders** (observers) when the stock price changes. This pattern is useful in scenarios where multiple objects need to be updated automatically when the state of another object changes.

In this implementation:
- **Stock**: The subject that holds the stock price and notifies observers when the price changes.
- **Trader**: Observers that register to the stock and receive notifications when the price is updated.

---

## **Project Structure**

```bash
exercise_1/src/behavioral/observer/
│
├── StockObserver.java    # Observer interface for updating observers
├── Trader.java           # Concrete implementation of the observer
├── Stock.java            # Subject class that holds the stock and manages observers
└── Main.java             # Main class that executes the program

---

- **Steps :**
- Navigate to the Project Directory

- Open a terminal or your IDE and navigate to the exercise_1/src/behavioral/observer/ folder.

-Compile the Code

    In your terminal, compile the Java files by running:
    ```bash
       javac *.java
    This command compiles all the .java files in the directory.

- Run the Program

- Once compiled, run the program using:
    ```bash
        java Main
        Interact with the Program

The program will first ask you to register traders by entering the number of traders you wish to add.
For each trader, you'll be asked to enter the trader's name.
Once the traders are registered, the program will prompt you to enter a new stock price, and all registered traders will be notified of the price update.
You can continue updating the stock price until you choose to stop.
Example Run
Here is an example of how the program interacts with the user:


Enter number of traders to register: 
2

Enter trader name: 
Alice

Enter trader name: 
Bob

Enter the new stock price: 
155.50
Trader Alice notified. AAPL price updated to $155.5
Trader Bob notified. AAPL price updated to $155.5

Would you like to continue updating stock prices? (yes/no)
yes

Enter the new stock price: 
160.00
Trader Alice notified. AAPL price updated to $160.0
Trader Bob notified. AAPL price updated to $160.0

Would you like to continue updating stock prices? (yes/no)
no

Ending stock price updates.
Design Pattern Explanation
Observer Pattern
The Observer Pattern is a behavioral design pattern where an object (subject) maintains a list of its dependents (observers) and notifies them of any changes in its state. In this example:

Subject: The Stock class, which holds the stock price.
Observers: The Trader class, which gets notified of stock price updates.

package FacadePattern;

import BuilderPattern.Pizza;
import DecoratorPattern.Cheese;
import DecoratorPattern.Pepperoni;
import DecoratorPattern.PlainPizza;
import ObserverPattern.Customer;
import ObserverPattern.Order;
import ObserverPattern.Observer;
import SingletonPattern.OrderManager;

import javax.swing.*;

public class PizzaOrderFacade {
    public void placeOrder(String size, String crust, String toppingsInput, String pizzaType, JTextArea logTextArea, JFrame frame) {
        String[] toppings = toppingsInput.split(",");

        try {
            // Build the pizza using the Builder pattern
            Pizza.Builder pizzaBuilder = new Pizza.Builder().size(size).crust(crust);
            for (String topping : toppings) {
                pizzaBuilder.addTopping(topping.trim());
            }
            Pizza pizza = pizzaBuilder.build();
            logMessage("Built pizza: " + pizza, logTextArea);

            // Process the order using the Singleton pattern
            OrderManager orderManager = OrderManager.getInstance();
            orderManager.processOrder(pizza);

            // Apply the selected pizza type using the Decorator pattern
            switch (pizzaType) {
                case "cheese":
                    pizza = new Cheese(pizza);
                    logMessage("Cheese pizza ordered: " + pizza, logTextArea);
                    break;
                case "pepperoni":
                    pizza = new Pepperoni(pizza);
                    logMessage("Pepperoni pizza ordered: " + pizza, logTextArea);
                    break;
                case "plain":
                default:
                    pizza = new PlainPizza(pizza);
                    logMessage("Plain pizza ordered: " + pizza, logTextArea);
                    break;
            }

            // Prompt for customer name and update order status using the Observer pattern
            String customerName = JOptionPane.showInputDialog(frame, "Enter customer name:");
            if (customerName != null && !customerName.isEmpty()) {
                Order order = new Order();
                Observer customer = new Customer(customerName);
                order.registerObserver(customer);
                order.setStatus("Preparing");
                logMessage("Order status set to 'Preparing' for customer: " + customerName, logTextArea);
            } else {
                logMessage("No customer name provided. Order status not updated.", logTextArea);
            }
        } catch (Exception ex) {
            logMessage("Error processing order: " + ex.getMessage(), logTextArea);
            ex.printStackTrace();
        }
    }

    private void logMessage(String message, JTextArea logTextArea) {
        logTextArea.append(message + "\n");
    }
}

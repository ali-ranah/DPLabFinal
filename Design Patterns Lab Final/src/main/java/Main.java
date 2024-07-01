//import BuilderPattern.Pizza;
//import DecoratorPattern.Cheese;
//import DecoratorPattern.Pepperoni;
//import DecoratorPattern.PlainPizza;
//import FactoryPattern.ConcretePizzaFactory;
//import FactoryPattern.PizzaFactory;
//import ObserverPattern.Customer;
//import ObserverPattern.Order;
//import ObserverPattern.Observer;
//import SingletonPattern.OrderManager;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class Main {
//    private static final Logger logger = Logger.getLogger(Main.class.getName());
//
//    private JFrame frame;
//    private JPanel panel;
//    private JButton orderButton;
//    private JTextArea logTextArea;
//
//    private JTextField sizeTextField;
//    private JTextField crustTextField;
//    private JTextField toppingsTextField;
//    private JTextField pizzaTypeTextField;
//
//    private PizzaFactory pizzaFactory;
//
//    public Main() {
//        pizzaFactory = new ConcretePizzaFactory();
//
//        // Initialize the main frame
//        frame = new JFrame("Pizza Ordering System");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(1000, 600);
//        frame.setLocationRelativeTo(null); // Center the frame on screen
//
//        // Create a panel with a border layout
//        panel = new JPanel(new BorderLayout());
//        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
//
//        // Create input panel with grid layout
//        JPanel inputPanel = createInputPanel();
//        panel.add(inputPanel, BorderLayout.CENTER);
//
//        // Create order button
//        orderButton = new JButton("Place Order");
//        orderButton.setFont(new Font("Arial", Font.BOLD, 14));
//        panel.add(orderButton, BorderLayout.SOUTH);
//
//        // Create log text area with scroll pane
//        logTextArea = new JTextArea(10, 60);
//        logTextArea.setEditable(false);
//        JScrollPane scrollPane = new JScrollPane(logTextArea);
//        panel.add(scrollPane, BorderLayout.EAST);
//
//        // Add panel to the frame and make it visible
//        frame.add(panel);
//        frame.setVisible(true);
//
//        // Action listener for the order button
//        orderButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                placeOrder();
//            }
//        });
//    }
//
//    private JPanel createInputPanel() {
//        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
//
//        // Components for pizza size
//        JLabel sizeLabel = new JLabel("Pizza Size:");
//        sizeTextField = new JTextField();
//        inputPanel.add(sizeLabel);
//        inputPanel.add(sizeTextField);
//
//        // Components for pizza crust
//        JLabel crustLabel = new JLabel("Pizza Crust:");
//        crustTextField = new JTextField();
//        inputPanel.add(crustLabel);
//        inputPanel.add(crustTextField);
//
//        // Components for pizza toppings
//        JLabel toppingsLabel = new JLabel("Pizza Toppings (comma-separated):");
//        toppingsTextField = new JTextField();
//        inputPanel.add(toppingsLabel);
//        inputPanel.add(toppingsTextField);
//
//        // Components for pizza type selection
//        JLabel pizzaTypeLabel = new JLabel("Pizza Type (plain/cheese/pepperoni):");
//        pizzaTypeTextField = new JTextField();
//        inputPanel.add(pizzaTypeLabel);
//        inputPanel.add(pizzaTypeTextField);
//
//        return inputPanel;
//    }
//
//    private void placeOrder() {
//        String size = sizeTextField.getText().trim();
//        String crust = crustTextField.getText().trim();
//        String toppingsInput = toppingsTextField.getText().trim();
//        String[] toppings = toppingsInput.split(",");
//
//        try {
//            // Build the pizza using the Builder pattern
//            Pizza.Builder pizzaBuilder = new Pizza.Builder().size(size).crust(crust);
//            for (String topping : toppings) {
//                pizzaBuilder.addTopping(topping.trim());
//            }
//            Pizza pizza = pizzaBuilder.build();
//            logMessage("Built pizza: " + pizza);
//
//            // Process the order using the Singleton pattern
//            OrderManager orderManager = OrderManager.getInstance();
//            orderManager.processOrder(pizza);
//
//            // Apply the selected pizza type using the Decorator pattern
//            String pizzaType = pizzaTypeTextField.getText().trim().toLowerCase();
//            switch (pizzaType) {
//                case "cheese":
//                    pizza = new Cheese(pizza);
//                    logMessage("Cheese pizza ordered: " + pizza);
//                    break;
//                case "pepperoni":
//                    pizza = new Pepperoni(pizza);
//                    logMessage("Pepperoni pizza ordered: " + pizza);
//                    break;
//                case "plain":
//                default:
//                    pizza = new PlainPizza(pizza);
//                    logMessage("Plain pizza ordered: " + pizza);
//                    break;
//            }
//
//            // Prompt for customer name and update order status using the Observer pattern
//            String customerName = JOptionPane.showInputDialog(frame, "Enter customer name:");
//            if (customerName != null && !customerName.isEmpty()) {
//                Order order = new Order();
//                Observer customer = new Customer(customerName);
//                order.registerObserver(customer);
//                order.setStatus("Preparing");
//                logMessage("Order status set to 'Preparing' for customer: " + customerName);
//            } else {
//                logMessage("No customer name provided. Order status not updated.");
//            }
//        } catch (Exception ex) {
//            logger.log(Level.SEVERE, "Error processing order: " + ex.getMessage(), ex);
//            logMessage("Error processing order: " + ex.getMessage());
//        }
//    }
//
//    private void logMessage(String message) {
//        logTextArea.append(message + "\n");
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
//                    e.printStackTrace();
//                }
//                new Main();
//            }
//        });
//    }
//}

import BuilderPattern.Pizza;
import FactoryPattern.ConcretePizzaFactory;
import FactoryPattern.PizzaFactory;
import FacadePattern.PizzaOrderFacade;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    private JFrame frame;
    private JPanel panel;
    private JButton orderButton;
    private JTextArea logTextArea;

    private JTextField sizeTextField;
    private JTextField crustTextField;
    private JTextField toppingsTextField;
    private JTextField pizzaTypeTextField;

    private PizzaFactory pizzaFactory;
    private PizzaOrderFacade pizzaOrderFacade;

    public Main() {
        pizzaFactory = new ConcretePizzaFactory();
        pizzaOrderFacade = new PizzaOrderFacade();

        // Initialize the main frame
        frame = new JFrame("Pizza Ordering System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null); // Center the frame on screen

        // Create a panel with a border layout
        panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        // Create input panel with grid layout
        JPanel inputPanel = createInputPanel();
        panel.add(inputPanel, BorderLayout.CENTER);

        // Create order button
        orderButton = new JButton("Place Order");
        orderButton.setFont(new Font("Arial", Font.BOLD, 14));
        panel.add(orderButton, BorderLayout.SOUTH);

        // Create log text area with scroll pane
        logTextArea = new JTextArea(10, 60);
        logTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logTextArea);
        panel.add(scrollPane, BorderLayout.EAST);

        // Add panel to the frame and make it visible
        frame.add(panel);
        frame.setVisible(true);

        // Action listener for the order button
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placeOrder();
            }
        });
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        // Components for pizza size
        JLabel sizeLabel = new JLabel("Pizza Size:");
        sizeTextField = new JTextField();
        inputPanel.add(sizeLabel);
        inputPanel.add(sizeTextField);

        // Components for pizza crust
        JLabel crustLabel = new JLabel("Pizza Crust:");
        crustTextField = new JTextField();
        inputPanel.add(crustLabel);
        inputPanel.add(crustTextField);

        // Components for pizza toppings
        JLabel toppingsLabel = new JLabel("Pizza Toppings (comma-separated):");
        toppingsTextField = new JTextField();
        inputPanel.add(toppingsLabel);
        inputPanel.add(toppingsTextField);

        // Components for pizza type selection
        JLabel pizzaTypeLabel = new JLabel("Pizza Type (plain/cheese/pepperoni):");
        pizzaTypeTextField = new JTextField();
        inputPanel.add(pizzaTypeLabel);
        inputPanel.add(pizzaTypeTextField);

        return inputPanel;
    }

    private void placeOrder() {
        String size = sizeTextField.getText().trim();
        String crust = crustTextField.getText().trim();
        String toppingsInput = toppingsTextField.getText().trim();
        String pizzaType = pizzaTypeTextField.getText().trim().toLowerCase();

        pizzaOrderFacade.placeOrder(size, crust, toppingsInput, pizzaType, logTextArea, frame);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    e.printStackTrace();
                }
                new Main();
            }
        });
    }
}

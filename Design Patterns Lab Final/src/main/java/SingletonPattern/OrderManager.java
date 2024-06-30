package SingletonPattern;

import BuilderPattern.Pizza;

import java.util.logging.Logger;

public class OrderManager {
    private static OrderManager instance;
    private static final Logger logger = Logger.getLogger(OrderManager.class.getName());

    private OrderManager() {}

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public void processOrder(Pizza pizza) {
        if (pizza == null) {
            logger.severe("Cannot process order: pizza is null");
            throw new IllegalArgumentException("Pizza cannot be null");
        }
        logger.info("Processing order: " + pizza);
    }
}

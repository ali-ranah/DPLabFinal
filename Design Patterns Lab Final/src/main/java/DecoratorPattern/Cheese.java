package DecoratorPattern;

import BuilderPattern.Pizza;

public class Cheese extends Pizza {
    private Pizza pizza;

    public Cheese(Pizza pizza) {
        super(new Pizza.Builder().size(pizza.getSize()).crust(pizza.getCrust()).addTopping("cheese"));
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return pizza.toString() + " with extra cheese";
    }
}

package DecoratorPattern;

import BuilderPattern.Pizza;

public class Pepperoni extends Pizza {
    private Pizza pizza;

    public Pepperoni(Pizza pizza) {
        super(new Pizza.Builder().size(pizza.getSize()).crust(pizza.getCrust()).addTopping(pizza.getToppings().toString()));
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return pizza.toString()+ " with pepperoni";
    }
}

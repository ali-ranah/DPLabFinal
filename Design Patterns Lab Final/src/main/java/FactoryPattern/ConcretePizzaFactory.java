package FactoryPattern;

import BuilderPattern.Pizza;
public class ConcretePizzaFactory extends PizzaFactory {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza;
        switch (type.toLowerCase()) {
            case "veggie":
                pizza = new Pizza.Builder().size("medium").crust("thin").addTopping("veggies").build();
                break;
            case "pepperoni":
                pizza = new Pizza.Builder().size("large").crust("thick").addTopping("pepperoni").build();
                break;
            default:
                throw new IllegalArgumentException("Unknown pizza type: " + type);
        }
        return pizza;
    }
}

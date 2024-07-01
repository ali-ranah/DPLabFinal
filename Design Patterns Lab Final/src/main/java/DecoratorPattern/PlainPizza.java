//package DecoratorPattern;
//
//import BuilderPattern.Pizza;
//
//public class PlainPizza extends Pizza {
//    private Pizza pizza;
//
//    public PlainPizza(Pizza pizza) {
//        super(new Pizza.Builder()
//                .size(pizza.getSize())
//                .crust(pizza.getCrust())
//                .addTopping(pizza.getToppings().toString())); // Pass the toppings
//        this.pizza = pizza;
//    }
//}

package DecoratorPattern;

import BuilderPattern.Pizza;

public class PlainPizza extends Pizza {
    public PlainPizza(Pizza pizza) {
        super(new Pizza.Builder().size(pizza.getSize()).crust(pizza.getCrust()).addTopping(pizza.getToppings().toString()));
    }

    @Override
    public String toString() {
        return super.toString() + " (plain)";
    }
}

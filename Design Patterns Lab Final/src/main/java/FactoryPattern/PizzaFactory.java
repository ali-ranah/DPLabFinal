package FactoryPattern;

import BuilderPattern.Pizza;

public abstract class PizzaFactory {
    public abstract Pizza createPizza(String type);
}

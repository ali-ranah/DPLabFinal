package BuilderPattern;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String size;
    private String crust;
    private List<String> toppings;

    protected Pizza(Builder builder) {
        this.size = builder.size;
        this.crust = builder.crust;
        this.toppings = builder.toppings;
    }

    public String getSize() {
        return size;
    }

    public String getCrust() {
        return crust;
    }

    public List<String> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return "Pizza [size=" + size + ", crust=" + crust + ", toppings=" + toppings + "]";
    }

    public static class Builder {
        private String size;
        private String crust;
        private List<String> toppings = new ArrayList<>();

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder crust(String crust) {
            this.crust = crust;
            return this;
        }

        public Builder addTopping(String topping) {
            this.toppings.add(topping);
            return this;
        }

        public Pizza build() {
            if (size == null || crust == null) {
                throw new IllegalStateException("Size and crust must be provided");
            }
            return new Pizza(this);
        }
    }
}

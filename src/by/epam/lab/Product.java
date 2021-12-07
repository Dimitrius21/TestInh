package by.epam.lab;

import by.epam.lab.Byn;

public class Product {
    String name;
    Byn price;

    public Product() {
    }

    public Product(String name, Byn byn) {
        this.name = name;
        price = byn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byn getPrice() {
        return price;
    }

    public void setPrice(Byn price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name+";"+ price.toString();
    }

}

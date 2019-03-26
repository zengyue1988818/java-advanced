package com.soft1841.Collection;

public class Computer implements Comparable<Computer>{
    private String type;
    private String name;
    private Integer price;

    public Computer(String type, String name, Integer price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer{" + "type='" + type + '\'' + ", name='" + name + '\'' + ", price=" + price + '}';
    }

    @Override
    public int compareTo(Computer computer) {
        return this.getPrice()-computer.getPrice();
    }
}

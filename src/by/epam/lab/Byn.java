package by.epam.lab;

import java.util.Objects;

public class Byn implements Comparable<Byn> {
    private int value;

    public Byn() {
    }

    public Byn(int value) {
        this.value = value;
    }

    public Byn(int rubs, int coins) {
        if (rubs > 0 && coins > 0) {
            value = rubs * 100 + coins;
        } else value = 0;
    }

    public Byn clone() {
        return new Byn(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Byn o) {
        return value - o.value;
    }

    @Override
    public String toString() {
        String st = value / 100 + "." + (value % 100 / 10) + (value % 10);
        return st;
    }

    public Byn add(int val) {
        value += val;
        return this;
    }

    public Byn sub(int val) throws IllegalArgumentException {
        if (isSubPossible(val)) {
            value -= val;
            return this;
        } else throw new IllegalArgumentException("Result can be negative");
    }

    public boolean isSubPossible(int val) {
        return (value >= val) ? true : false;

    }

    public Byn mul(int val) {
        value *= val;
        return this;
    }

}


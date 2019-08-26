package vending;

public class Bucket<E1, E2> {
    public E1 first;
    public E2 second;

    public Bucket(E1 first, E2 second) {
        this.first = first;
        this.second = second;
    }
}

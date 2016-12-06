package it.car.her_.graph;

/**
 * Created by carmeloiriti, 05/12/16.
 */

class WgEdge<T> {

    T node;
    int weigth;

    public WgEdge(T node, int weigth) {
        this.node = node;
        this.weigth = weigth;
    }

    public T getNode() {
        return node;
    }

    public int getWeigth() {
        return weigth;
    }
}

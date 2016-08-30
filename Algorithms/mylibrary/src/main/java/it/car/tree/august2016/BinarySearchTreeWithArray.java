package it.car.tree.august2016;

/**
 * Created by carmeloiriti, 30/08/16.
 */
public class BinarySearchTreeWithArray<T> {

    T[] array;
    int numElements;
    int dim;

    public BinarySearchTreeWithArray(int dim) {
        this.dim = dim;
        array = (T[])new Object[dim+1];
        numElements = 0;
    }
    
    
    public void addChild(T t){
        if(numElements == 0){
            array[0] = t;
            numElements++;
        }
    }
    
}

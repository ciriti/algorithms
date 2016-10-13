package it.car.wayfair.datastructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by carmeloiriti, 13/10/16.
 */
public class ShoppingCartTest {

    ShoppingCart<String> cart;

    @Before
    public void setup(){
        cart = new ShoppingCart<>();
    }


    @Test
    public void add(){
        cart.add("chair");
        cart.add("chair", 2);
        cart.add("table");
        cart.add("table", 4);

        Assert.assertEquals(3, cart.get("chair"));
        Assert.assertEquals(5, cart.get("table"));
    }

    @Test
    public void remove(){
        cart.add("chair");
        cart.add("chair", 2);
        cart.add("table");
        cart.add("table", 4);
        cart.remove("chair");

        Assert.assertEquals(0, cart.get("chair"));
        Assert.assertEquals(5, cart.get("table"));
    }

}

package com.techelevator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;

public class ItemTest {

    private Item item = null;

    @Before
    public void setup() {
        this.item = new Item("A1", "Snickers", new BigDecimal("1.50"), "Candy");

    }

    @After
    public void cleanup() {
        this.item = null;

    }

    @Test
    public void testSlot() {

        String slot = item.getSlot();


        Assert.assertEquals("A1", slot);
    }

    @Test
    public void testName() {

        String name = item.getName();


        Assert.assertEquals("Snickers", name);
    }

    @Test
    public void testPrice() {

        BigDecimal price = item.getPrice();


        Assert.assertEquals(new BigDecimal("1.50"), price);
    }

    @Test
    public void testCategory() {

        String category = item.getCategory();


        Assert.assertEquals("Candy", category);
    }

    @Test
    public void testRemaining() {

        int remaining = item.getRemaining();


        Assert.assertEquals(5, remaining);
    }

    @Test
    public void testTakeAwayRemaining() {


        item.takeAwayRemaining();

        Assert.assertEquals(4, item.getRemaining());
    }

    @Test
    public void testDispenseMessage() {


        String message = item.getDispenseMessage("Candy");


        Assert.assertEquals("Munch Munch, Yum!", message);
    }

}

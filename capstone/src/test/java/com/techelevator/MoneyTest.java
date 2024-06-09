package com.techelevator;




import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.math.BigDecimal;

public class MoneyTest {

    private Money money = null;

    @Before
    public void setup() {
        this.money = new Money();
    }

    @After
    public void cleanup() {
        this.money = null;
    }

    @Test
    public void testInitialBalance() {


        BigDecimal balance = money.getBalance();


        Assert.assertEquals(BigDecimal.ZERO, balance);
    }

    @Test
    public void testFeedMoney() {

        BigDecimal amount = new BigDecimal("5");


        money.feedMoney(amount);


        Assert.assertEquals(new BigDecimal("5"), money.getBalance());
    }

}

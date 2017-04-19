package com.example.agupta1409.testing;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Created by a.gupta1409 on 30-07-2016.
 */
public class FareTest {

    @Test
    public void testFareFromkmAndTime(){
        Assert.assertEquals(0,MainActivity.getFare(-3,16),0.001);
    }
}

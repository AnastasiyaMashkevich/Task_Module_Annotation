package com.epam;

import org.testng.Assert;
import org.testng.annotations.Test;
import static com.epam.Action.TypeAction.*;


public class TestWithCustomAnnotation {

    private int a;
    private int b;
    private int result;

    @Action(action = ADD)
    @Test
    public void oneCanAddPositiveTest () {
        a = 2;
        b = 3;
        result = 5;
        Assert.assertEquals(result, a + b);
    }

    @Action(action = ADD)
    @Test
    public void oneCanAddNegativeTest () {
        a = 3;
        b = 3;
        result = 5;
        Assert.assertEquals(result, a + b);
    }

    @Action(action = DEDUCT)
    @Test
    public void oneCanDeductPositiveTest () {
        a = 8;
        b = 3;
        result = 5;
        Assert.assertEquals(result, a - b);
    }

    @Action(action = DEDUCT)
    @Test
    public void oneCanDeductNegativeTest () {
        a = 5;
        b = 3;
        result = 5;
        Assert.assertEquals(result, a - b);
    }
}

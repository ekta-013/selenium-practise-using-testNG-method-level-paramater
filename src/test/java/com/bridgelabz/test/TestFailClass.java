package com.bridgelabz.test;

import com.bridgelabz.main.BaseClass;
import com.bridgelabz.main.ReporterListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReporterListener.class)
public class TestFailClass extends BaseClass {

    @Test
    public void testPassed() {
        Assert.assertTrue(true);
    }

    @Test
    public void testFailed() {
        Assert.assertFalse(false);
    }

    @Test
    public void testDepend() {
        Assert.assertTrue(true);
    }
}
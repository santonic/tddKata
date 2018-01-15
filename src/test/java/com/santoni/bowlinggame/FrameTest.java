package com.santoni.bowlinggame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrameTest {
    protected Frame frame;

    @Before
    public void initFrame(){
        frame = new Frame();
    }

    @Test
    public void testRoll() throws Exception {
        frame.roll(3);
        frame.roll(2);
        Assert.assertEquals(5, frame.knockedDownPinsDuringFrame());
    }

    @Test
    public void testSpare() throws Exception {
        frame.roll(3);
        frame.roll(7);
        Assert.assertTrue(frame.isSpare());
    }


    @Test
    public void testStrike() throws Exception {
        frame.roll(10);
        Assert.assertTrue(frame.isStrike());
    }

}
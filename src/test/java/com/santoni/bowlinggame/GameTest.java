package com.santoni.bowlinggame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    private Game g;

    @Before
    public void initGame(){
        g = new Game();
    }

    @Test
    public void testGutterGame() throws Exception {
        rollMany(20, 0);
        Assert.assertEquals(0, g.score());
    }

    @Test
    public void testAllOnes() throws Exception {
        rollMany(20, 1);
        assertEquals(20, g.score());
    }

    @Test
    public void testOneSpare() throws Exception {
        rollSpare();
        g.roll(3);
        rollMany(19,0);
        assertEquals(16,g.score());
    }

    @Test
    public void testOneStrike() throws Exception {
        rollStrike();
        g.roll(3);
        g.roll(4);
        rollMany(18, 0);
        assertEquals(24, g.score());
    }

    @Test
    public void testPerfectGame() throws Exception {
        rollMany(12,10);
        assertEquals(300, g.score());
    }

    @Test
    public void testSpareByKnockingDownTenOnSecondTry() throws Exception {
        g.roll(0);
        g.roll(10);
        g.roll(1);
        g.roll(2);
        rollMany(16,0);
        assertEquals(14, g.score());
    }

    ////////////////////////////////////////////

    private void rollStrike() {
        g.roll(10);
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

    private void rollMany(int times, int knockedDownPinsCount) {
        for (int i = 0; i < times; i++) {
            g.roll(knockedDownPinsCount);
        }
    }

}
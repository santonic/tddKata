package com.santoni.bowlinggame;

public class Frame {
    protected int firstRoll;
    protected int secondRoll;
    protected int nbRolls;

    public int score() {
        return 0;
    }

    public void roll(int knockedDownPinsCount) {
        if(nbRolls == 0){
            firstRoll = knockedDownPinsCount;
        } else {
            secondRoll = knockedDownPinsCount;
        }
        nbRolls++;
    }


    public int knockedDownPinsDuringFrame() {
        return firstRoll+secondRoll;
    }

    public boolean isStrike() {
        return firstRoll ==10;
    }

    public boolean isSpare() {
        return !isStrike() && firstRoll+secondRoll ==10;
    }

    public boolean secondRollIsDone() {
        return nbRolls == 2;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }
}

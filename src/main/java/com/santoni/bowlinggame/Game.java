package com.santoni.bowlinggame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    /* nb of knocked down pins in each roll. If there is a strike, a "fake" 0-pins roll is automatically set by roll()
      */
    protected List<Frame> frames = new ArrayList<>(10);
    int currentFrameIndex = 0;

    /**
    call each time the player rolls a ball.
    @param knockedDownPinsCount count of pins knocked down.
    */
    public void roll(int knockedDownPinsCount){
        Frame currentFrame;
        if (frames.size()==currentFrameIndex+1) {
            currentFrame = frames.get(currentFrameIndex);
        } else {
            currentFrame = new Frame();
            frames.add(currentFrame);
        }
        currentFrame.roll(knockedDownPinsCount);

        if(currentFrame.secondRollIsDone() || currentFrame.isStrike()){
            currentFrameIndex++;
        }

    }

    /**
     call only at the very end of the game.
     @return the total score for that game
     */
    public int score(){
        int score = 0;
        for (int frameIndex = 0; frameIndex < 10 ; frameIndex++) {
            Frame frame = frames.get(frameIndex);
            score += frame.knockedDownPinsDuringFrame();


            if(frame.isSpare()){
                Frame nextFrame = frames.get(frameIndex + 1);
                score += nextFrame.getFirstRoll();
            } else if(frame.isStrike()){
                Frame nextFrame = frames.get(frameIndex + 1);
                score += nextFrame.getFirstRoll();
                if(nextFrame.isStrike()){
                    score += frames.get(frameIndex + 2).getFirstRoll();
                } else {
                    score += nextFrame.getSecondRoll();
                }
            }

        }
        return score;
    }

}

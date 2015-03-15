package com.example.james.nwhack2015;

import java.lang.String;

/**
 * Created by james on 14/03/15.
 */
public class Action {
    private String name; // name of the action
    private String description; // a brief description of the action
    private boolean positive; // whether it is positive
    private boolean daily; // whether it is daily
    private int difficulty; // 1 for easy, 2 for medium, 3 for hard

    public Action() {
        positive = true;
        daily = false;
        difficulty = 1;
    }

    public Action(String fred, String derf) {
        name = fred;
        description = derf;
        positive = true;
        daily = true;
        difficulty = 1;
    }

    // add exp if positive, reduce health if negative
    public void effect(Avatar dude) {
        if (positive) {
            dude.expUp(difficulty);
        } else {
            dude.damage(difficulty);
        }
    }

    // setters && getters
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public boolean isPositive() {
        return positive;
    }
    public boolean isDaily() {
        return daily;
    }
    public int getDifficulty() {
        return difficulty;
    }

    public void setName(String fred) {
        name = fred;
    }
    public void setDescription(String fred) {
        description = fred;
    }
    public void setPositive(boolean fred) {
        positive = fred;
    }
    public void setDaily(boolean fred) {
        daily = fred;
    }
    public void setDifficulty(int fred) {
        difficulty = fred;
    }
}

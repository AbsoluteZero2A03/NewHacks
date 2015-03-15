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
    private int value; // value used for exp and damage

    public Action() {
        name = "";
        description = "";
        positive = true;
        daily = false;
        value = 1;
    }

    public Action(String fred, String derf) {
        name = fred;
        description = derf;
        positive = true;
        daily = false;
        value = 1;
    }

    public Action(String fred, String derf, boolean pos, boolean day, int val) {
        name = fred;
        description = derf;
        positive = pos;
        daily = day;
        value = val;
    }

    // add exp if positive, reduce health if negative
    public void effect(Avatar dude) {
        if (positive) {
            dude.expUp(value);
        } else {
            dude.damage(value);
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
    public int getValue() {
        return value;
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
    public void setValue(int fred) {
        value = fred;
    }
}

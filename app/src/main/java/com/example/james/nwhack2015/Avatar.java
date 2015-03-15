package com.example.james.nwhack2015;

import java.lang.String;

/**
 * Created by james on 14/03/15.
 */
public class Avatar {
    private String name; // name of dude
    private int level; // level of dude
    private int health; // health of dude
    private int maxHealth; // maximum health of dude
    private int exp; // experience of dude
    private int maxExp; // experience needed for next level

    public Avatar(String dude) {
        setName(dude);
        setLevel(1);
        setHealth(10);
        setMaxHealth(10);
        setExp(0);
        setMaxExp(10);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public int getHealth() {
        return health;
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public int getExp() {
        return exp;
    }
    public int getMaxExp() {
        return maxExp;
    }

    public void setName(String fred) {
        name = fred;
    }
    public void setLevel(int fred) {
        level = fred;
    }
    public void setHealth(int fred) {
        health = fred;
    }
    public void setMaxHealth(int fred) {
        maxHealth = fred;
    }
    public void setExp(int fred) {
        exp = fred;
    }
    public void setMaxExp(int fred) {
        maxExp = fred;
    }

    public void expUp(int experience) {
        int fred = calExp(experience);
        exp += fred;
        if (exp >= maxExp) {
            level++;
            exp = 0;
            maxExp += 20;
            maxHealth += 15;
            health = maxHealth;
        }
    }

    public void damage(int loss) {
        int fred = calDam(loss);
        health -= fred;
        if (health <= 0 && level > 1) {
            level--;
            exp = 0;
            maxExp -= 20;
            maxHealth -= 15;
            health = maxHealth;
        } else if (health <= 0 && level == 1) {
            exp = 0;
            health = maxHealth;
        }
    }

    private int calDam(int loss) {
        return loss * level;
    }

    private int calExp(int gain) {
        return gain;
    }
}

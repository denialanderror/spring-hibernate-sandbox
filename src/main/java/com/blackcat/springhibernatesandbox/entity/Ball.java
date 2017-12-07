package com.blackcat.springhibernatesandbox.entity;

import javax.persistence.Entity;

@Entity
public class Ball extends Item {

    private int bounciness;

    public Ball() {
    }

    public int getBounciness() {
        return this.bounciness;
    }

    public void setBounciness(int bounciness) {
        this.bounciness = bounciness;
    }

    public String toString() {
        return "Ball(bounciness=" + this.getBounciness() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Ball)) {
            return false;
        }
        final Ball other = (Ball) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        if (this.getBounciness() != other.getBounciness()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + super.hashCode();
        result = result * PRIME + this.getBounciness();
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Ball;
    }
}

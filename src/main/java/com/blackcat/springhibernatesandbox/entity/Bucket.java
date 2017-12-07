package com.blackcat.springhibernatesandbox.entity;

import javax.persistence.Entity;

@Entity
public class Bucket extends Item {

    private boolean fullOfSand;

    public Bucket() {
    }

    public boolean isFullOfSand() {
        return this.fullOfSand;
    }

    public void setFullOfSand(boolean fullOfSand) {
        this.fullOfSand = fullOfSand;
    }

    public String toString() {
        return "Bucket(fullOfSand=" + this.isFullOfSand() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Bucket)) {
            return false;
        }
        final Bucket other = (Bucket) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        if (this.isFullOfSand() != other.isFullOfSand()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + super.hashCode();
        result = result * PRIME + (this.isFullOfSand() ? 79 : 97);
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Bucket;
    }
}

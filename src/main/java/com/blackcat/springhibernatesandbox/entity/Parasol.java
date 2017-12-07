package com.blackcat.springhibernatesandbox.entity;

import javax.persistence.Entity;

@Entity
public class Parasol extends Item {

    private double opacity;

    public Parasol() {
    }

    public double getOpacity() {
        return this.opacity;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }

    public String toString() {
        return "Parasol(opacity=" + this.getOpacity() + ")";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Parasol)) {
            return false;
        }
        final Parasol other = (Parasol) o;
        if (!other.canEqual((Object) this)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        if (Double.compare(this.getOpacity(), other.getOpacity()) != 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + super.hashCode();
        final long $opacity = Double.doubleToLongBits(this.getOpacity());
        result = result * PRIME + (int) ($opacity >>> 32 ^ $opacity);
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Parasol;
    }
}

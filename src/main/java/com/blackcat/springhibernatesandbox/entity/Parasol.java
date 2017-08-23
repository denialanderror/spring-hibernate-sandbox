package com.blackcat.springhibernatesandbox.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Parasol extends Item {

	private double opacity;
}

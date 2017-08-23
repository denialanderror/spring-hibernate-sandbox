package com.blackcat.springhibernatesandbox.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Getter
	private Long id;

	@Setter @Getter
	private String name;
}

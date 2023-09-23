package com.ty.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
@Entity
@Data
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private int p_id;
	@Column(nullable = false)
   private String name;
	@OneToMany(cascade = CascadeType.REMOVE)
   private List<Encounter> encounter;
}

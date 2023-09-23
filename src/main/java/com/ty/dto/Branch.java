package com.ty.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int b_id;
	private long phono;
	@ManyToOne(cascade = CascadeType.REMOVE)
	private Hospital hospital;
	@OneToOne(cascade = CascadeType.REMOVE)
	Address address;
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<Encounter> encounter;

}

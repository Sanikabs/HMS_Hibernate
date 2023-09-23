package com.ty.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Encounter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int e_id;
	@Column(nullable = false)
	private String d_name;
	@ManyToOne(cascade = CascadeType.REMOVE)
	private Branch branch;
	@ManyToOne(cascade = CascadeType.REMOVE)
	private Person person;
	@OneToMany(cascade = CascadeType.REMOVE)
   private List<MedOraders> medorders;
	private int quan_medorder;
}

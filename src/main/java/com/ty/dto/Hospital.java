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
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Hospital {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int h_id;
	@Column(nullable = false)
	private String name;
	private long phono;
	@OneToMany(cascade = CascadeType.REMOVE)
	private List<Branch> branch;

}

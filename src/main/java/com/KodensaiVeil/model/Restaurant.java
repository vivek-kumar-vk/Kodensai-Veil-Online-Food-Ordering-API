package com.KodensaiVeil.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private User owner;
	
	private String name;
	private String description;
	private String cuisineType;
	
	@OneToOne
	private Address address;
	
	@Embedded
	private ContactInformation contactInformation; 
	private String  openingHours;
	
	@OneToMany(mappedBy = "restaurant" , cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Orders> orders = new ArrayList<Orders>();
	
	@ElementCollection
	@Column(length = 10000)
	private List<String>Images;
	
	private LocalDateTime registrationDate;
	
	private boolean open;
	
	@JsonIgnore
	@OneToMany(mappedBy = "restaurant" , cascade = CascadeType.ALL , orphanRemoval = true)
	private List<Food> food  = new ArrayList<>();
	
	
}

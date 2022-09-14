package com.thang.Entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.util.List;


/**
 * The persistent class for the Category database table.
 * 
 */
@Data
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;
	//bi-directional many-to-one association to Product
	@JsonIgnore
	@OneToMany(mappedBy="category")
	private List<Product> products;

}
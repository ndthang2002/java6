package com.thang.Entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Product database table.
 * 
 */
@Data
@Entity
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private boolean available;

	@Temporal(TemporalType.DATE)
	@Column(name = "Createdate")	
	Date createDate = new Date();


	private String imgproduct;

	private String name;

	private BigDecimal price;

	//bi-directional many-to-one association to Hoadonchitiet
	@JsonIgnore
	@OneToMany(mappedBy="product")
	private List<Hoadonchitiet> hoadonchitiets;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="CategoryId")
	private Category category;


}
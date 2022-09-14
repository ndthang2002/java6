package com.thang.Entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

import java.math.BigDecimal;


/**
 * The persistent class for the Hoadonchitiet database table.
 * 
 */
@Data
@Entity
@NamedQuery(name="Hoadonchitiet.findAll", query="SELECT h FROM Hoadonchitiet h")
public class Hoadonchitiet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int mahoadonchitiet;

	private BigDecimal price;

	private int soluong;

	//bi-directional many-to-one association to Hoadon
	
	@ManyToOne
	@JoinColumn(name="mahoadon")
	private Hoadon hoadon;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="masanpham")
	private Product product;

}
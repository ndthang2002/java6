package com.thang.Entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Hoadon database table.
 * 
 */
@Data
@Entity
@NamedQuery(name="Hoadon.findAll", query="SELECT h FROM Hoadon h")
public class Hoadon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int mahoadon;

	@Temporal(TemporalType.DATE)
	@Column(name = "Createdate")	
	Date createDate = new Date();

	private String diachi;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="username")
	private Account account;

	//bi-directional many-to-one association to Hoadonchitiet
	@JsonIgnore
	@OneToMany(mappedBy="hoadon")
	private List<Hoadonchitiet> hoadonchitiets;


}
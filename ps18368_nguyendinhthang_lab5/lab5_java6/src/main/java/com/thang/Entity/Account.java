package com.thang.Entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

import java.util.List;


/**
 * The persistent class for the Accounts database table.
 * 
 */
@Data
@Entity
@Table(name="Accounts")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String username;

	private String email;

	private String fullname;

	private String password;

	private String photo;

	//bi-directional many-to-one association to Hoadon
	@JsonIgnore
	@OneToMany(mappedBy="account")
	private List<Hoadon> hoadons;

	

}
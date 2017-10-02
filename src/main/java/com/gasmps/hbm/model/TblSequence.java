package com.gasmps.hbm.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tbl_sequence database table.
 * 
 */
@Entity
@Table(name="tbl_sequence")
@NamedQuery(name="TblSequence.findAll", query="SELECT t FROM TblSequence t")
public class TblSequence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="name")
	private String name;

	@Column(name="increase")
	private int increase = 1;

	@Column(name="max_value")
	private String maxValue = "9999999999";

	@Column(name="min_value")
	private String minValue = "0000000000";

	@Column(name="value")
	private String value = "0000000000";

	public TblSequence() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIncrease() {
		return this.increase;
	}

	public void setIncrease(int increase) {
		this.increase = increase;
	}

	public String getMaxValue() {
		return this.maxValue;
	}

	public void setMaxValue(String maxValue) {
		this.maxValue = maxValue;
	}

	public String getMinValue() {
		return this.minValue;
	}

	public void setMinValue(String minValue) {
		this.minValue = minValue;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
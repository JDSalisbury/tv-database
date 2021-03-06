package com.example.tvdatabase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TV {

	@Id
	@GeneratedValue
	private long id;
	private String model;
	private String dateUpdated;
	private String price;

	protected TV() {
	}

	public TV(String model, String dateUpdated, String price) {
		this.model = model;
		this.dateUpdated = dateUpdated;
		this.price = price;
	}

	public Object getModel() {
		return model;
	}

	@Override
	public String toString() {
		return "Model = " + model + ", Date price was updated = " + dateUpdated + ", Price = " + price;
	}
}

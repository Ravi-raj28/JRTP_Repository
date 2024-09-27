package com.boot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="INDIAN_RAILWAYS_INFO")
@Data
public class Trains {
	
	@Id
	@GeneratedValue(generator="trains_no", strategy =GenerationType.SEQUENCE)
	@SequenceGenerator(name = "trains_no",initialValue =500001,allocationSize = 1)
	private Integer trainNo;
	
	@Column(name="trainName", nullable = false)
	private String trainName;
	
	@Column(name="originStation",nullable = false)
	private String originStation;
	
	@Column(name="destinationStation", nullable = false)
	private String destinationStation;
	
	@Column(name="trainType")
	private String trainType;
	

}

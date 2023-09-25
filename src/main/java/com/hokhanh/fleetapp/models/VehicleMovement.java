package com.hokhanh.fleetapp.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class VehicleMovement { // chuyển động của xe

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "vehicleid", insertable = false, updatable = false)
	private Vehicle vehicle;
	private int vehicleid;

	@ManyToOne
	@JoinColumn(name = "locationid1", insertable = false, updatable = false)
	private Location location1; // địa điểm ban đầu
	private int locationid1;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date1; // thời gian bắt đầu đi

	@ManyToOne
	@JoinColumn(name = "locationid2", insertable = false, updatable = false)
	private Location location2; // địa điểm sau khi di chuyển
	private int locationid2;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date2; // thời gian sau khi di chuyển

	private String remarks;
}

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
public class Vehicle {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "vehicletypeid", insertable = false, updatable = false)
	private VehicleType vehicleType;
	private Integer vehicletypeid;
	
	private String vehicleNumber;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDate; // ngày đăng kí
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date acquisitionDate; // ngày mua lại
	
	private String description;
	
	@ManyToOne
	@JoinColumn(name="vehiclemakeid", insertable=false, updatable=false)
	private VehicleMake vehicleMake; // chế tạo xe
	private Integer vehiclemakeid;
	
	private String power; // quyền lực
	private String fuelCapacity; // lượng nhiên liệu
	
	@ManyToOne
	@JoinColumn(name = "vehiclestatusid", insertable = false, updatable = false)
	private VehicleStatus vehicleStatus;
	private Integer vehiclestatusid; // tình trạng xe
	
	private String netWeight; // khối lượng tịnh
	
	@ManyToOne
	@JoinColumn(name = "employeeid", insertable = false, updatable = false)
	private Employee inCharge; // phụ trách
	private Integer employeeid;
	
	@ManyToOne
	@JoinColumn(name = "vehiclemodelid", insertable = false, updatable = false)
	private VehicleModel vehicleModel; // mô hình xe
	private Integer vehiclemodelid;
	
	@ManyToOne
	@JoinColumn(name = "locationid", insertable = false, updatable = false)
	private Location location;
	private Integer locationid;
	
	private String remarks;
}

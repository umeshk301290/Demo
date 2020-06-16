package com.example.demo.controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="data")
public class DataEntity {

@Id
@Column(name = "dataid")
Long id;

@Column(name = "dataname")
String dataName;

/*
@Column(name = "demoid")
Long demoId;*/

/*@ManyToOne
@JoinColumn(name = "demomappingid", referencedColumnName = "demoid")*/
@ManyToMany(mappedBy = "entity")
List<DemoEntity> demoMappingId;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getDataName() {
	return dataName;
}

public void setDataName(String dataName) {
	this.dataName = dataName;
}

}

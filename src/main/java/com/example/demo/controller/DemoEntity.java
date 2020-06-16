package com.example.demo.controller;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="demo")
public class DemoEntity {

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name = "demoid")

Long demoId;	

@Column(name ="stuname")
@Enumerated(EnumType.STRING)
DemoType name;

//@OneToMany(fetch = FetchType.EAGER,mappedBy = "demoMappingId")
@ManyToMany
@JoinTable(name = "demodata",
joinColumns = { @JoinColumn(name = "demoid") },
inverseJoinColumns = { @JoinColumn(name = "dataid") })
List<DataEntity> entity;
}


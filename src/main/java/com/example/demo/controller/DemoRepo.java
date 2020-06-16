package com.example.demo.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  DemoRepo extends JpaRepository<DemoEntity, Long> {

}

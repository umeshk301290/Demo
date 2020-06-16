package com.example.demo.controller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface AddressRepository extends JpaRepository<Address, Long>{


	@Query("SELECT t FROM Address t where t.distric = :distric")
	public Optional<Address> findByDistric(@Param("distric") String distric);
}

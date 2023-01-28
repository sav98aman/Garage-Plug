package com.app.customer.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.model.CurrentSession;

@Repository
public interface CurrentSessionDao extends JpaRepository<CurrentSession, Integer>{

	@Query("SELECT c FROM CurrentSession c WHERE c.customer_id=?1")
	public CurrentSession findByCustomer_id(Integer customer_id);
	
	@Query("SELECT c FROM CurrentSession c WHERE c.uuid=?1")
	public CurrentSession findByUuid(String uuid);
	
	
}

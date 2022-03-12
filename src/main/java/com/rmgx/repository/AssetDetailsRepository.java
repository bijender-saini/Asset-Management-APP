package com.rmgx.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmgx.entity.AssetDetails;

public interface AssetDetailsRepository extends JpaRepository<AssetDetails, Integer> {
	
	List<AssetDetails> findByName(String name);

}

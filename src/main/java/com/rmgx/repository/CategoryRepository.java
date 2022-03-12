package com.rmgx.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rmgx.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Serializable> {
	


}

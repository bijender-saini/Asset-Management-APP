package com.rmgx.service;

import java.util.List;


import com.rmgx.dto.CategoryDto;
import com.rmgx.entity.Category;

public interface CategoryService {

	public Category saveCategory(CategoryDto categoryDto);

	public List<Category> getAllCategory();

	public Category getOneCategory(Integer id);

	public String updateCategory(Integer id,CategoryDto categoryDto);
	
	public String deleteCategory(Integer id);

}

package com.rmgx.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.rmgx.dto.CategoryDto;
import com.rmgx.entity.Category;
import com.rmgx.exception.CategoryNotFoundException;
import com.rmgx.repository.CategoryRepository;
import com.rmgx.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(CategoryDto categoryDto) {

		Category category = new Category();
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> categoryList = categoryRepository.findAll();
		if (CollectionUtils.isEmpty(categoryList)) {
			throw new CategoryNotFoundException("category not found");
		}

		return categoryList;
	}

	@Override
	public Category getOneCategory(Integer id) {
		Optional<Category> findById = categoryRepository.findById(id);
		if (!findById.isPresent()) {
			throw new CategoryNotFoundException("category not found");

		}
		return findById.get();
	}

	@Override
	public String updateCategory(Integer id, CategoryDto categoryDto) {
		Category category = getOneCategory(id);
		category.setName(categoryDto.getName());
		category.setDescription(categoryDto.getDescription());
		categoryRepository.save(category);
		return "category updated successfully.";
	}

	@Override
	public String deleteCategory(Integer id) {
		if (!categoryRepository.existsById(id)) {
			throw new CategoryNotFoundException("category not found");
		}
		categoryRepository.deleteById(id);
		return "category deleted successfully";
	}

}

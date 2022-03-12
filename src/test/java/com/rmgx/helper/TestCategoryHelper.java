package com.rmgx.helper;

import java.util.ArrayList;
import java.util.List;

import com.rmgx.dto.CategoryDto;
import com.rmgx.entity.Category;

public class TestCategoryHelper {

	static CategoryDto buildCategoryDto() {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setName("electronics");
		categoryDto.setDescription("electornics items");
		return categoryDto;
	}

	static List<Category> buildCategoryList() {
		Category category = new Category();
		category.setName("electronics");
		category.setDescription("electornics items");
		Category category2 = new Category();
		category2.setName("electronics");
		category2.setDescription("electornics items");
		ArrayList<Category> al = new ArrayList<>();
		al.add(category);
		al.add(category2);
		return al;
	}

	static Category buildCategory() {
		Category category = new Category(); 
//		category.setId(1);
		category.setName("electronics");
		category.setDescription("electornics items");
		return category;
	}
}

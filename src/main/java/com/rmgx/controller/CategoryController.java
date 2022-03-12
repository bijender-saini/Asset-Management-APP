package com.rmgx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rmgx.dto.CategoryDto;
import com.rmgx.service.CategoryService;
import com.rmgx.utils.ResponseHandler;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("saveCategory")
	ResponseEntity<Object> saveCategory(@RequestBody CategoryDto categoryDto) {
		return ResponseHandler.generateResponse(HttpStatus.CREATED, true, "category saved successfully.",
				categoryService.saveCategory(categoryDto));
	}

	@GetMapping("/getAllCategory")
	ResponseEntity<Object> fetchAllCategory() {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "success", categoryService.getAllCategory());
	}

	@GetMapping("/getCategory/{id}")
	ResponseEntity<Object> getOneCategory(@PathVariable("id") Integer id) {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, "success", categoryService.getOneCategory(id));

	}

	@PutMapping("/updateCategory/{id}")
	ResponseEntity<Object> updateCategory(@PathVariable("id") Integer id, @RequestBody CategoryDto categoryDto) {
		return ResponseHandler.generateResponse(HttpStatus.OK, true, categoryService.updateCategory(id, categoryDto));
	}
	
	@DeleteMapping("/deleteCAtegory/{id}")
	ResponseEntity<Object> deleteCategory(@PathVariable("id") Integer id){
		return ResponseHandler.generateResponse(HttpStatus.OK, true, categoryService.deleteCategory(id));
		
	}

}

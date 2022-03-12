package com.rmgx.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import com.rmgx.entity.Category;
import com.rmgx.repository.CategoryRepository;
import com.rmgx.service.impl.CategoryServiceImpl;

@ExtendWith(MockitoExtension.class)
public class TestCategoryServiceImpl {

	@InjectMocks
	CategoryServiceImpl categoryService;
	@Mock
	private CategoryRepository categoryRepository;

	@Test
	@MockitoSettings(strictness = Strictness.LENIENT)
	public void buildCategory() {
		when(categoryRepository.save(TestCategoryHelper.buildCategory()))
				.thenReturn(TestCategoryHelper.buildCategory());
		assertNotNull(categoryService.saveCategory(TestCategoryHelper.buildCategoryDto()));
	}

	@Test
	public void fetchAllCategoryTest() {
		when(categoryRepository.findAll()).thenReturn(TestCategoryHelper.buildCategoryList());
		assertEquals(2, categoryRepository.findAll().size());
	}

	@Test
	public void fetchCategoryDetailsTest() {
		when(categoryRepository.findById(1)).thenReturn(Optional.of(TestCategoryHelper.buildCategory()));
		assertNotNull(categoryService.getOneCategory(1));
	}

	@Test
	@MockitoSettings(strictness = Strictness.LENIENT)
	public void deleteCategoryest() throws Exception {
		when(categoryRepository.existsById(1)).thenReturn(true);
		categoryService.deleteCategory(1);
		verify(categoryRepository, times(1)).deleteById(1);

	}

	@Test
	@MockitoSettings(strictness = Strictness.LENIENT)
	public void updatePatientTest() {
		when(categoryRepository.findAll()).thenReturn(TestCategoryHelper.buildCategoryList());
		when(categoryRepository.findById(1)).thenReturn(Optional.of(TestCategoryHelper.buildCategory()));
		Category buildCategory = TestCategoryHelper.buildCategory();
		buildCategory.setId(1);
		buildCategory.setName("xxx");
		categoryRepository.save(TestCategoryHelper.buildCategory());
		verify(categoryRepository, times(1)).save(TestCategoryHelper.buildCategory());

	}

}

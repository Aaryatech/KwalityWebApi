package com.ats.webapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.Category;
import com.ats.webapi.repository.CategoryRepository;

@Service
public class CategoryService {
	
	
	@Autowired
	private CategoryRepository categoryRepository;

	public Category saveCategory(Category category) throws DataIntegrityViolationException {

		Category categorySaveResponse = categoryRepository.save(category);

		if (Objects.isNull(categorySaveResponse)) {
			
			throw new DataIntegrityViolationException("Unable to save a category " + category.getName());
		}

		return categorySaveResponse;

	}
	public List<Category> findAll()
	{
        return categoryRepository.findAll();
    }

	public Category findCategoryById(int id) throws ResourceNotFoundException {

		Category categoryOpt = categoryRepository.findById(id);
		
		if (Objects.isNull(categoryOpt)) {

			throw new ResourceNotFoundException("Category Not Found With Id " +id);
			}

		return categoryOpt;

	}
	
	public int deleteCategoryById(int id) throws ResourceNotFoundException {


		return categoryRepository.deleteCategoryById(id);

	}
	
	

}

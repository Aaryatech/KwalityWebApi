package com.ats.webapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.entity.Category;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ServiceResponse saveCategory(@RequestBody @Valid Category category) {

		return ServiceResponse.asSuccess(categoryService.saveCategory(category));

	}

	@PostMapping("/save")
	public Category saveCategoryResponse(@RequestBody @Valid Category category) throws DataIntegrityViolationException {

		System.err.println("in category save");

		return categoryService.saveCategory(category);

	}

	@GetMapping("/{id}")
	public ServiceResponse getCategoryById(@PathVariable int id) {

		Category category = categoryService.findCategoryById(id);
		return ServiceResponse.asSuccess(category);

	}

	@GetMapping
	public ServiceResponse findAll() throws Exception {

		return ServiceResponse.asSuccess(categoryService.findAll());

	}

	@GetMapping("get-all")
	public List<Category> getAll() throws Exception {

		return categoryService.findAll();

	}

	@DeleteMapping("/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		categoryService.deleteCategoryById(id);

		return ServiceResponse.asSuccess("success");
	}

}

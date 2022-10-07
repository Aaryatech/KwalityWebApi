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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.entity.Category;
import com.ats.webapi.model.Info;
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

		return categoryService.saveCategory(category);

	}

	@GetMapping("/{id}")
	public ServiceResponse getCategoryById(@PathVariable int id) {

		Category category = categoryService.findCategoryById(id);
		return ServiceResponse.asSuccess(category);

	}
	
	@GetMapping("/{id}/get-by-id")
	public Category findCategoryById(@PathVariable int id) {

		Category category = categoryService.findCategoryById(id);
		return category;

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
	
	@GetMapping("/{id}/delete-by-id")
	public int deleteCategoryById(@PathVariable int id) throws ResourceNotFoundException {

		return categoryService.deleteCategoryById(id);
	}
	

	@GetMapping("/{id}/delete-by-category-id")
	public  Info deleteCity(@PathVariable("id") int id) {

		Info info = new Info();

		try {

			int delete = categoryService.deleteCategoryById(id);

			if (delete > 0) {
				info.setError(false);
				info.setMsg("Category Deleted Successfully");
			} else {
				info.setError(true);
				info.setMsg("Failed To Delete Category");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMsg("Failed To Delete Category");
			e.printStackTrace();
		}

		return info;

	}

}

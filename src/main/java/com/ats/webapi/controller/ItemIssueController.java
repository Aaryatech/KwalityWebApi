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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.entity.ItemIssue;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.ItemIssueService;

@RestController
@RequestMapping("/item-issue")
public class ItemIssueController {
	
	@Autowired
	private ItemIssueService itemIssueService;

	@PostMapping
	public ServiceResponse saveItemIssue(@RequestBody @Valid ItemIssue itemIssue)
			throws DataIntegrityViolationException {

		return ServiceResponse.asSuccess(itemIssueService.saveItemIssue(itemIssue));

	}

	@GetMapping("/{id}")
	public ServiceResponse getItemIssueById(@PathVariable int id) {

		ItemIssue itemIssue = itemIssueService.findItemIssueById(id);
		return ServiceResponse.asSuccess(itemIssue);

	}

	@GetMapping
	public ServiceResponse findAll() throws Exception {

		return ServiceResponse.asSuccess(itemIssueService.findAll());

	}
	
	@GetMapping("get-all")
	public List<ItemIssue> getAll() throws Exception {

		return itemIssueService.findAll();

	}

	@DeleteMapping("/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		itemIssueService.deleteItemIssueById(id);

		return ServiceResponse.asSuccess("success");
	}
	
	@GetMapping("/{id}/delete-by-issue-id")
	public  Info deleteCity(@PathVariable("id") int id) {

		Info info = new Info();

		try {

			int delete = itemIssueService.deleteItemIssueById(id);

			if (delete > 0) {
				info.setError(false);
				info.setMsg("Item Issue Deleted Successfully");
			} else {
				info.setError(true);
				info.setMsg("Failed To Delete Item Issue");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMsg("Failed To Delete Item Issue");
			e.printStackTrace();
		}

		return info;

	}
	
	
	
	
	
	
	
	@GetMapping("/{id}/delete-by-issue-detail-id")
	public  Info deleteIssueDetailById(@PathVariable("id") int id) {

		Info info = new Info();

		try {

			int delete = itemIssueService.deleteIssueDetailById(id);

			if (delete > 0) {
				info.setError(false);
				info.setMsg("Item Issue Deleted Successfully");
			} else {
				info.setError(true);
				info.setMsg("Failed To Delete Item Issue");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMsg("Failed To Delete Item Issue");
			e.printStackTrace();
		}

		return info;

	}
	
	@PostMapping("/get-issue-by-date")
	public List<ItemIssue> getIssueByDate(@RequestParam String fromDate,@RequestParam String toDate)  {

		return itemIssueService.getIssueByDate(fromDate,toDate);

	}
	


}

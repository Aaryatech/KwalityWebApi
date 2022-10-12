package com.ats.webapi.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.ItemIssue;
import com.ats.webapi.repository.ItemIssueDetailRepository;
import com.ats.webapi.repository.ItemIssueRepository;

@Service
public class ItemIssueService {
	
	@Autowired
	private ItemIssueRepository itemIssueRepository;
	
	@Autowired
	private ItemIssueDetailRepository itemIssueDetailRepository;

	public ItemIssue saveItemIssue(ItemIssue itemIssue) {

		ItemIssue itemIssueSaveResponse = itemIssueRepository.save(itemIssue);

		if (Objects.isNull(itemIssueSaveResponse)) {

			throw new DataIntegrityViolationException("Unable to save a itemIssue " );
		}

		return itemIssueSaveResponse;

	}

	public List<ItemIssue> findAll() {
		return itemIssueRepository.findAll();
	}

	public ItemIssue findItemIssueById(int id) throws ResourceNotFoundException {

		ItemIssue itemIssueOpt = itemIssueRepository.findById(id);

		if (Objects.isNull(itemIssueOpt)) {

			throw new ResourceNotFoundException("ItemIssue Not Found With Id " + id);
		}

		return itemIssueOpt;

	}

	public int deleteItemIssueById(int id) throws ResourceNotFoundException {

		return itemIssueRepository.deleteItemIssueById(id);

	}

	public int deleteIssueDetailById(int id) {
		// TODO Auto-generated method stub
		return itemIssueDetailRepository.deleteIssueDetailById(id);
	}

	public List<ItemIssue> getIssueByDate(String fromDate, String toDate) {
		// TODO Auto-generated method stub
		return itemIssueRepository.getIssueByDate(fromDate,toDate);
	}

}

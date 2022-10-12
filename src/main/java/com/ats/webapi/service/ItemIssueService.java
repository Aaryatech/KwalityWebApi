package com.ats.webapi.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.ItemIssue;
import com.ats.webapi.entity.Tconfig;
import com.ats.webapi.repository.ItemIssueDetailRepository;
import com.ats.webapi.repository.ItemIssueRepository;
import com.ats.webapi.repository.TconfigRepository;

@Service
public class ItemIssueService {
	
	@Autowired
	private ItemIssueRepository itemIssueRepository;
	
	@Autowired
	private ItemIssueDetailRepository itemIssueDetailRepository;
	
	@Autowired
	private TconfigRepository tConfigRepository;

	public ItemIssue saveItemIssue(ItemIssue itemIssue) {
		
		String key="Issue";
		Tconfig tconfig=tConfigRepository.findTconfigByKey(key);
		String value=tconfig.getValue();
		
		String number = value;
		int numberLength = number.length();
		int temp = Integer.parseInt(number);

		temp = temp + 1;

		int digit = Integer.toString(Math.abs(temp)).trim().length();

		for (int j = 1; j <= numberLength; j++) {

			if (digit == j) {

				int n = numberLength - j;
				String appendZero = IntStream.range(0, n).mapToObj(k -> "0").collect(Collectors.joining(""));
				number = appendZero + temp;

			}
		}

		ItemIssue itemIssueSaveResponse = itemIssueRepository.save(itemIssue);
		
		int result=tConfigRepository.updateTconfig(number,key);

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

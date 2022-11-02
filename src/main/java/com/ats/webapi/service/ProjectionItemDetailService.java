package com.ats.webapi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.ItemSKU;
import com.ats.webapi.entity.ProjectionItemDetail;
import com.ats.webapi.repository.ProjectionItemDetailRepository;

@Service
public class ProjectionItemDetailService {

	@Autowired
	private ProjectionItemDetailRepository projectionItemDetailRepository;

	@Autowired
	private ItemSKUService itemSKUService;

	@Autowired
	private ItemSKUDetailService itemSKUDetailService;

	public List<ProjectionItemDetail> saveProjectionItemDetail(List<ProjectionItemDetail> projectionItemDetail) {

		return projectionItemDetailRepository.saveAll(projectionItemDetail);
	}

	public ProjectionItemDetail getDetailById(int id) {
		Optional<ProjectionItemDetail> projectionItem = projectionItemDetailRepository.findById(id);

		if (Objects.isNull(projectionItem.get())) {

			throw new ResourceNotFoundException("Item Not found with Id " + id);
		}

		return projectionItem.get();
	}

	public List<ProjectionItemDetail> findAll() {
		return projectionItemDetailRepository.findAll();
	}

	public int deleteById(int id) {

		return projectionItemDetailRepository.deleteProjectionItemDetailById(id);
	}

	public List<ProjectionItemDetail> findByProjectionItemId(int id) {
		return projectionItemDetailRepository.findByItemId(id);
	}

	public int deleteByprojectionItemId(int id) {
		// TODO Auto-generated method stub
		List<Integer> ids = itemSKUService.getIdByProjectionId(id);
		projectionItemDetailRepository.deleteProjectionItemDetailByProjectionItemId(id);
		itemSKUService.deleteByprojectionItemId(id);
		itemSKUDetailService.deleteByprojectionItemId(ids);
		return 0;
	}

}

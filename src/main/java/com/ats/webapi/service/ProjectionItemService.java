package com.ats.webapi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.ats.webapi.entity.ProjectionItem;
import com.ats.webapi.entity.Vendor;
import com.ats.webapi.repository.ProjectionItemRepository;

@Service
public class ProjectionItemService {

	@Autowired
	private ProjectionItemRepository projectionItemRepository;

	public ProjectionItem saveProjectionItem(ProjectionItem projectionItem) {

		return projectionItemRepository.save(projectionItem);
	}

	public ProjectionItem getItemById(int id) {
		ProjectionItem projectionItem = projectionItemRepository.getItemById(id);

		if (Objects.isNull(projectionItem)) {

			throw new ResourceNotFoundException("Item Not found with Id " + id);
		}

		return projectionItem;
	}

	public List<ProjectionItem> findAll() {
		return projectionItemRepository.findProjectionItemAll();
	}

	public int deleteById(int id) {
		return projectionItemRepository.deleteProjectionItemById(id);

	}

}

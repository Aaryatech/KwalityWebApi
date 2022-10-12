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

import com.ats.webapi.entity.Mrn;
import com.ats.webapi.entity.MrnDetail;
import com.ats.webapi.model.Info;
import com.ats.webapi.model.ServiceResponse;
import com.ats.webapi.service.MrnService;

@RestController
@RequestMapping("mrn")
public class MrnController {

	@Autowired
	private MrnService mrnService;

	@PostMapping
	public ServiceResponse saveMrn(@RequestBody @Valid Mrn mrn)
			throws DataIntegrityViolationException {

		return ServiceResponse.asSuccess(mrnService.saveMrn(mrn));

	}

	@GetMapping("/{id}")
	public ServiceResponse getMrnById(@PathVariable int id) {

		Mrn mrn = mrnService.findMrnById(id);
		return ServiceResponse.asSuccess(mrn);

	}

	@GetMapping
	public ServiceResponse findAll() throws Exception {

		return ServiceResponse.asSuccess(mrnService.findAll());

	}
	
	@GetMapping("get-all")
	public List<Mrn> getAll() throws Exception {

		return mrnService.findAll();

	}

	@DeleteMapping("/{id}")
	public ServiceResponse deleteSubject(@PathVariable int id) throws ResourceNotFoundException {

		mrnService.deleteMrnById(id);

		return ServiceResponse.asSuccess("success");
	}
	
	@GetMapping("/{id}/delete-by-mrn-id")
	public  Info deleteCity(@PathVariable("id") int id) {

		Info info = new Info();

		try {

			int delete = mrnService.deleteMrnById(id);

			if (delete > 0) {
				info.setError(false);
				info.setMsg("Mrn Deleted Successfully");
			} else {
				info.setError(true);
				info.setMsg("Failed To Delete Mrn Issue");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMsg("Failed To Delete Mrn Issue");
			e.printStackTrace();
		}

		return info;

	}
	
	@GetMapping("/{id}/delete-by-mrn-detail-id")
	public  Info deleteMrnDetailById(@PathVariable("id") int id) {

		Info info = new Info();

		try {

			int delete = mrnService.deleteMrnDetailById(id);

			if (delete > 0) {
				info.setError(false);
				info.setMsg("Mrn Detail Deleted Successfully");
			} else {
				info.setError(true);
				info.setMsg("Failed To Delete Mrn Detail");
			}

		} catch (Exception e) {
			info.setError(true);
			info.setMsg("Failed To Delete Mrn Detail");
			e.printStackTrace();
		}

		return info;

	}
	
	
	
	@GetMapping("/get-remaining-qty/{id}")
	public MrnDetail findRemainingQuantityByItemId(@PathVariable int id)  {

		return mrnService.findRemainingQuantityByItemId(id);

	}
	
	@PostMapping("/get-mrn-by-date")
	public List<Mrn> getMrnByDate(@RequestParam String fromDate,@RequestParam String toDate)  {

		return mrnService.getMrnByDate(fromDate,toDate);

	}
	
	@GetMapping("/{itemId}/get-mrn-detail-by-item")
	public List<MrnDetail> getMrnDetailByItemId(@PathVariable int itemId)  {
	
		return mrnService.getMrnDetailByItemId(itemId);

	}
	
	@PostMapping("save-all-mren-detail")
	public ServiceResponse saveAllMrnDetail(@RequestBody @Valid List<MrnDetail> mrnDetail)
			throws DataIntegrityViolationException {

		return ServiceResponse.asSuccess(mrnService.saveAllMrnDetail(mrnDetail));

	}
}

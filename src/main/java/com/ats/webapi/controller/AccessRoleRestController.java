package com.ats.webapi.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.webapi.entity.AccessRightModule;
import com.ats.webapi.entity.AccessRightSubModule;
import com.ats.webapi.entity.EmpType;
import com.ats.webapi.model.Info;
import com.ats.webapi.repository.AccessRightModuleRepository;
import com.ats.webapi.repository.AccessRightSubModuleRepository;
import com.ats.webapi.repository.EmpTypeRepository;

@RestController
public class AccessRoleRestController {

	@Autowired
	AccessRightModuleRepository accessRightModuleRepository;

	@Autowired
	AccessRightSubModuleRepository accessRightSubModuleRepository;

	@Autowired
	EmpTypeRepository empTypeRepository;

	@RequestMapping(value = { "/saveAceessRole" }, method = RequestMethod.POST)
	public @ResponseBody EmpType saveAceessRole(@RequestBody EmpType empType) {

		EmpType save = new EmpType();
		try {

			save = empTypeRepository.saveAndFlush(empType);

		} catch (Exception e) {

			e.printStackTrace();
			save.setError(true);
		}

		return save;

	}

	@RequestMapping(value = { "/getAceessRoleList" }, method = RequestMethod.GET)
	public @ResponseBody List<EmpType> getAceessRoleList() {

		List<EmpType> list = new ArrayList<EmpType>();
		try {

			list = empTypeRepository.findByDelStatusOrderByEmpTypeIdDesc(1);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return list;

	}

	@RequestMapping(value = { "/deleteAceessRole" }, method = RequestMethod.POST)
	public @ResponseBody Info deleteAceessRole(@RequestParam("accessRoleId") int accessRoleId) {

		Info info = new Info();

		try {

			int delete = empTypeRepository.deleteAceessRole(accessRoleId);

			if (delete > 0) {
				info.setError(false);
				info.setMsg("deleted");
			} else {
				info.setError(true);
				info.setMsg("failed");
			}

		} catch (Exception e) {

			e.printStackTrace();
			info.setError(true);
			info.setMsg("failed");
		}

		return info;

	}

	@RequestMapping(value = { "/getAceessRoleById" }, method = RequestMethod.POST)
	public @ResponseBody EmpType getAceessRoleById(@RequestParam("accessRoleId") int accessRoleId) {

		EmpType location = new EmpType();
		try {

			location = empTypeRepository.findByEmpTypeIdAndDelStatus(accessRoleId, 1);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return location;

	}

	@RequestMapping(value = { "/getModuleAndSubModuleList" }, method = RequestMethod.GET)
	public @ResponseBody List<AccessRightModule> getModuleAndSubModuleList() {

		List<AccessRightModule> accessRightModuleList = new ArrayList<>();
		try {

			accessRightModuleList = accessRightModuleRepository.getModule();
			List<AccessRightSubModule> accessRightSubModuleList = accessRightSubModuleRepository.getSubModuleAll();

			for (int i = 0; i < accessRightModuleList.size(); i++) {

				List<AccessRightSubModule> list = new ArrayList<>();

				for (int j = 0; j < accessRightSubModuleList.size(); j++) {

					if (accessRightModuleList.get(i).getModuleId() == accessRightSubModuleList.get(j).getModuleId()) {
						list.add(accessRightSubModuleList.get(j));
					}

				}

				accessRightModuleList.get(i).setAccessRightSubModuleList(list);

			}
			// System.out.println(accessRightModuleList);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return accessRightModuleList;

	}

	@RequestMapping(value = { "/getEmpTypeList" }, method = RequestMethod.GET)
	public @ResponseBody List<EmpType> getEmpTypeList() {

		List<EmpType> empTypeList = new ArrayList<>();
		try {

			empTypeList = empTypeRepository.findByDelStatus(1);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return empTypeList;

	}

}

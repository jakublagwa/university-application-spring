package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import model.UniversityData;
import model.UniversityForm;
import pojo.UniversityPojo;
import service.ApiException;
import service.UniversityService;

@Api
@RestController
public class EmployeeApiController {

	@Autowired
	private UniversityService service;

	@ApiOperation(value = "Adds an employee")
	@RequestMapping(path = "/api/employee", method = RequestMethod.POST)
	public void add(@RequestBody UniversityForm form) throws ApiException {
		UniversityPojo p = convert(form);
		service.add(p);
	}

	
	@ApiOperation(value = "Deletes and employee")
	@RequestMapping(path = "/api/employee/{id}", method = RequestMethod.DELETE)
	// /api/1
	public void delete(@PathVariable int id) {
		service.delete(id);
	}

	@ApiOperation(value = "Gets an employee by ID")
	@RequestMapping(path = "/api/employee/{id}", method = RequestMethod.GET)
	public UniversityData get(@PathVariable int id) throws ApiException {
		UniversityPojo p = service.get(id);
		return convert(p);
	}

	@ApiOperation(value = "Gets list of all employees")
	@RequestMapping(path = "/api/employee", method = RequestMethod.GET)
	public List<UniversityData> getAll() {
		List<UniversityPojo> list = service.getAll();
		List<UniversityData> list2 = new ArrayList<UniversityData>();
		for (UniversityPojo p : list) {
			list2.add(convert(p));
		}
		return list2;
	}

	@ApiOperation(value = "Updates an employee")
	@RequestMapping(path = "/api/employee/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable int id, @RequestBody UniversityForm f) throws ApiException {
		UniversityPojo p = convert(f);
		service.update(id, p);
	}
	

	private static UniversityData convert(UniversityPojo p) {
		UniversityData d = new UniversityData();
		d.setNip(p.getAge());
		d.setName(p.getName());
		d.setId(p.getId());
		return d;
	}

	private static UniversityPojo convert(UniversityForm f) {
		UniversityPojo p = new UniversityPojo();
		p.setAge(f.getNip());
		p.setName(f.getName());
		return p;
	}

}

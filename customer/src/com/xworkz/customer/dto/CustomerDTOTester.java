package com.xworkz.customer.dto;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import com.xworkz.customer.constants.EducationType;
import com.xworkz.customer.dao.CustomerServiceDAO;
import com.xworkz.customer.dao.CustomerServiceDAOImpl;

public class CustomerDTOTester {

	public static void main(String[] args) {
		CustomerDTO dto = new CustomerDTO("Arun", "Banglore", "Chennai", "@HanumanNagar", false, "HU56PO",
				EducationType.BE);
		
		CustomerServiceDAO dao = new CustomerServiceDAOImpl();
		dao.validateAndSave(dto);
		

		Collection<CustomerDTO> collect = Arrays.asList(dto);
		dao.validateAndSaveAll(collect);
		

		Optional<CustomerDTO> one = dao.findOne(d -> d.getName().equals("Sunita"));
		if (one.isPresent()) {
			CustomerDTO name = one.get();
			System.out.println(name);
		}

		Collection<CustomerDTO> all = dao.findAll();
		all.forEach(t -> System.out.println(t));
		

		Collection<CustomerDTO> findAll = dao.findAll(r -> r.getId() == 9);
		findAll.forEach(r -> System.out.println(r));
		
		Collection<CustomerDTO> byName = dao.findAllSortByNameDesc();
		byName.forEach(f -> System.out.println(f));
		int total = dao.total();
		CustomerServiceDAO da = new CustomerServiceDAOImpl();

	}

}

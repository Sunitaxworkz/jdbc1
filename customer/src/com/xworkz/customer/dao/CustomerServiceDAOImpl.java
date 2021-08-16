package com.xworkz.customer.dao;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

import com.xworkz.customer.constants.EducationType;
import com.xworkz.customer.dto.CustomerDTO;
import com.xworkz.customer.dao.CustomerDAO;
import com.xworkz.customer.dao.CustomerDAOImpl;

public class CustomerServiceDAOImpl implements CustomerServiceDAO {
	CustomerDAO dao = new CustomerDAOImpl();

	@Override
	public int validateAndSave(CustomerDTO dto) {

		boolean nameValid = false;
		boolean fromValid = false;
		boolean toValid = false;
		boolean addressValid = false;
		boolean marriedValid = false;
		boolean passportValid = false;
		boolean educationTypeValid = false;
		if (dto != null) {
			System.out.println("dto is not null,Validation is started");
			String name = dto.getName();
			if (name != null && !name.isEmpty() && name.length() >= 3 && name.length() <= 20) {
				System.out.println("name is valid");
				nameValid = true;
			} else {
				System.out.println("name is invalid");
				nameValid = false;
			}
			String from = dto.getName();
			if (from != null && !from.isEmpty() && from.length() >= 8 && from.length() <= 50) {
				System.out.println("from is valid");
				fromValid = true;
			} else {
				System.out.println("from is invalid");
				fromValid = false;
			}
			String to = dto.getTo();
			if (to != null && !to.isEmpty() && to.length() >= 4 && to.length() <= 30) {
				System.out.println("GetTo is valid");
				toValid = true;
			} else {
				System.out.println("GetTo is not invlid");
				toValid = false;
			}
			String address = dto.getAddress();
			if (address != null && !address.isEmpty() && address.length() >= 6 && address.length() <= 20) {
				System.out.println("to is valid");
				addressValid = true;
			} else {
				System.out.println("to is invlid");
				addressValid = false;

}
			Boolean married = dto.isMarried();
			if (married != null) {
				System.out.println("Married is valid");
				marriedValid = true;
			} else {
				System.out.println("married is not invalid");
				marriedValid = false;
			}
			String passport = dto.getPassPortNo();
			if (passport != null && !passport.isEmpty() && passport.length() >= 4 && passport.length() <= 16) {
				System.out.println("valid");
				passportValid = true;
			} else {
				System.out.println("invlid");
				passportValid = false;
			}
			EducationType educationType = dto.getEducationType();
			if (educationType != null) {
				System.out.println("EducationType is valid");
				educationTypeValid = true;
			} else {
				System.out.println("EducationType is not invalid");
				educationTypeValid = false;
			}
			if (nameValid && fromValid && toValid && addressValid && marriedValid && passportValid && educationTypeValid) {
				System.out.println("data is valid returning success");
				return 1;
	}
			System.out.println("data is invalid and returning failed");

			return 0;
		}
		return 0;
	}

	@Override
	public void validateAndSaveAll(Collection<CustomerDTO> collection) {

		dao.saveAll(collection);

	}

	@Override
	public Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate) {
		return dao.findOne(predicate);

	}
	@Override
	public Collection<CustomerDTO> findAll() {
		return dao.findAll();

	}

	@Override
	public Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate) {
		return dao.findAll(predicate);

	}

	@Override
	public Collection<CustomerDTO> findAllSortByNameDesc() {
		return dao.findAllSortByNameDesc();

	}

	@Override
	public int total() {
		return dao.total();

	}
}

			

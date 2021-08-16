package com.xworkz.customer.dao;

import com.xworkz.customer.dto.CustomerDTO;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public interface CustomerServiceDAO {
	int validateAndSave(CustomerDTO dto) ;
		
	
	  void validateAndSaveAll(Collection<CustomerDTO> collection);
	  
	  Optional<CustomerDTO> findOne(Predicate<CustomerDTO> predicate);
	  
	  Collection<CustomerDTO> findAll();
	  
	  Collection<CustomerDTO> findAll(Predicate<CustomerDTO> predicate);
	  
	  Collection<CustomerDTO> findAllSortByNameDesc();
	  
	  int total();
	 

}

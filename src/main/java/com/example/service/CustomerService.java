package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.domain.Customer;
import com.example.repository.CustomerRepository;

@Service
@Transactional
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Page<Customer> findAll(Pageable pageable) { //페이징을 사용할 수 있게 해주는 강력한 편리한 기능
		return customerRepository.findAll(pageable);
	}
	
	public List<Customer> findAll() { //페이징을 사용할 수 있게 해주는 강력한 편리한 기능
		return customerRepository.findAll();
	}
	
	public Optional<Customer> findOne(Integer id) {
		return customerRepository.findById(id);
	}
	
	public Customer create(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void delete(Integer id) {
		customerRepository.deleteById(id);
	}
	
}

package com.example.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Customer;
import com.example.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerRestController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET)
	Page<Customer> getCustomers (@PageableDefault Pageable pageable) { // 페이징을 사용할 수 있게 해주는 편리한 기능.
		Page<Customer> customers = customerService.findAll(pageable);
		return customers;
	}
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	Customer getCustomer(@PathVariable Integer id) {
		Customer customer  = customerService.findOne(id); // Optional<Customer> 은 언제 쓰는건지 처음 써보네
		return customer;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED) // API가 정상적으로 보내졌을떄 응답을 201 CREATED로 보내준다.
	Customer postCustomers (@RequestBody Customer customer) {
		return customerService.create(customer);
	}
/*	
	@RequestMapping(method = RequestMethod.POST)
	ResponseEntity<Customer> postCustomers (@RequestBody Customer customer,
			UriComponentsBuilder uriBilder) { // 컨택스트 상대경로 URI를 만들어 주는 인자이다. 그러나 위의 방식으로 같은 결론을 낼 수 있다.
		Customer created = customerService.create(customer);
		URI location = uriBilder.path("api/customers/{id}").buildAndExpand(created.getId()).toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(location);
		
		return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
	}
	*/
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	Customer putCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		customer.setId(id);
		return customerService.update(customer);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT) // 정상으로 작동하면 204 NO_CONTENT로 반환합니다.
	void deleteCustomer(@PathVariable Integer id) {
		customerService.delete(id);
	}
}

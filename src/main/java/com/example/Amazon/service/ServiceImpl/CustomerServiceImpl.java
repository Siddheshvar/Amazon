package com.example.Amazon.service.ServiceImpl;

import com.example.Amazon.entity.Customer;
import com.example.Amazon.repository.CustomerRepository;
import com.example.Amazon.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveSignUp(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllSignUps() {
        return this.customerRepository.findAll();
    }

    @Override
    public Customer getSignUpById(long id) {
        return this.customerRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
    }

    @Override
    public Customer updateSignUpById(Customer customer, long id) {
        Customer oldCustomer = customerRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));

        oldCustomer.setFullName(oldCustomer.getFullName());
        oldCustomer.setPhoneNo(customer.getPhoneNo());
        oldCustomer.setEmailId(customer.getEmailId());
        oldCustomer.setCreatePass(customer.getCreatePass());

        return this.customerRepository.save(oldCustomer);
    }

    @Override
    public void deleteSignUpById(long id) {
        customerRepository.findById(id).orElseThrow(()->
                new RuntimeException("Data not found!"));
        customerRepository.deleteById(id);
    }
}

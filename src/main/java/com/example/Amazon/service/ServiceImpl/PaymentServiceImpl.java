package com.example.Amazon.service.ServiceImpl;

import com.example.Amazon.entity.Payment;
import com.example.Amazon.repository.PaymentsRepository;
import com.example.Amazon.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentsRepository paymentsRepository;

    @Override
    public Payment savePayment(Payment payment) {
        return paymentsRepository.save(payment);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentsRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return paymentsRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... payment details not found!"));
    }

    @Override
    public Payment updatePaymentById(Payment payment, Integer id) {
        Payment oldPayment = paymentsRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... payment details not found to update!"));
        System.out.println("Oops... you can't do changes with payment!");
        return null;
    }

    @Override
    public void deletePaymentById(Integer id) {
        paymentsRepository.findById(id).orElseThrow(()->
                new RuntimeException("Oops... payment details not found to delete!"));
        paymentsRepository.deleteById(id);
    }
}

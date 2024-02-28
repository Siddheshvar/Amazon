package com.example.Amazon.service;

import com.example.Amazon.entity.Payment;

import java.util.List;

public interface PaymentService {

    Payment savePayment(Payment payment);
    List<Payment> getAllPayments();
    Payment getPaymentById(Integer id);
    Payment updatePaymentById(Payment payment,Integer id);
    void deletePaymentById(Integer id);
}

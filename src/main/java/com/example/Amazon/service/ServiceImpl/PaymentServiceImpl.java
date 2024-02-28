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
        return null;
    }

    @Override
    public List<Payment> getAllPayments() {
        return null;
    }

    @Override
    public Payment getPaymentById(Integer id) {
        return null;
    }

    @Override
    public Payment updatePaymentById(Payment payment, Integer id) {
        return null;
    }

    @Override
    public void deletePaymentById(Integer id) {

    }
}

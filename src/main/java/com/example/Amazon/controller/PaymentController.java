package com.example.Amazon.controller;

import com.example.Amazon.entity.Payment;
import com.example.Amazon.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/save")
    public ResponseEntity<String> savePayment(@RequestBody Payment payment){
        paymentService.savePayment(payment);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/getall")
    public List<Payment> getAllPayment(){
        return new ArrayList<Payment>(paymentService.getAllPayments());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id")Integer id){
        return new ResponseEntity<Payment>(paymentService.getPaymentById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updatePaymentById(@PathVariable("id")Integer id,
                                                    @RequestBody Payment payment){
        paymentService.updatePaymentById(payment,id);
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePaymentById(@PathVariable("id")Integer id){
        paymentService.deletePaymentById(id);
        return ResponseEntity.ok("ok");
    }
}

package com.mateus.demo.services;

import org.springframework.stereotype.Service;

@Service
public interface OnlinePaymentService {

    public Double paymentFee(Double amount);
    public Double interest(Double amount, Integer months);

}

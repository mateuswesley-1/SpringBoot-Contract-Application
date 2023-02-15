package com.mateus.demo.services;

import org.springframework.stereotype.Service;

@Service
public class PayPalService implements OnlinePaymentService{


    @Override
    public Double paymentFee(Double amount) {
        return amount*0.02;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount*months*0.01;
    }

}

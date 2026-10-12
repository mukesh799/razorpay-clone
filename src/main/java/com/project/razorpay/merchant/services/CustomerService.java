package com.project.razorpay.merchant.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface CustomerService {

    UUID findOrCreate(UUID merchantId,String email,String name,String phone);


}

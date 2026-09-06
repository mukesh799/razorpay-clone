package com.project.razorpay.merchant.services;


import com.project.razorpay.merchant.dto.request.MerchantSignupRequest;
import com.project.razorpay.merchant.dto.response.MerchantResponse;
import jakarta.validation.Valid;

public interface AuthService {
    MerchantResponse signup(@Valid MerchantSignupRequest merchantRequest);
}

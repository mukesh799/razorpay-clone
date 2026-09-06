package com.project.razorpay.merchant.dto.request;

import com.project.razorpay.common.enums.BusinessType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MerchantSignupRequest(

        @NotNull(message="Name should be provided")
        @Size(max=50,message="Name should not exceed 50 characters")
        String name,
        @Email(message="Email should be valid")
        @NotNull(message = "Email is required")
        String email,
        @NotNull(message = "Password is required")
        @Size(min=0,message="Password should be at least 8 characters long")
        String password,
        @Size(max = 50, message = "Business name should not be more than 50 characters long")
        String businessName,
        BusinessType businessType) {


}

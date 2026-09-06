package com.project.razorpay.merchant.services;

import com.project.razorpay.merchant.dto.request.CreateApiKeyRequest;
import com.project.razorpay.merchant.dto.response.ApiKeyCreateResponse;
import com.project.razorpay.merchant.dto.response.ApiKeyResponse;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;

public interface ApiKeyService {
    ApiKeyCreateResponse create(UUID merchantId, @Valid CreateApiKeyRequest request);

    List<ApiKeyResponse> listByMerchant(UUID merchantId);

    void revoke(UUID merchantId, UUID keyId);

    ApiKeyCreateResponse rotate(UUID merchantId, UUID keyId);
}

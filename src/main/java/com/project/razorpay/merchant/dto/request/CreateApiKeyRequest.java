package com.project.razorpay.merchant.dto.request;

import com.project.razorpay.common.enums.Environment;

import java.util.UUID;

public record CreateApiKeyRequest(
                                  Environment environment) {
}

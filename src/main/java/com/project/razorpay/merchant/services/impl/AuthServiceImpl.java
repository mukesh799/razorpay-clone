package com.project.razorpay.merchant.services.impl;

import com.project.razorpay.common.enums.MerchantStatus;
import com.project.razorpay.common.enums.UserRole;
import com.project.razorpay.common.exceptions.DuplicateResourceException;

import com.project.razorpay.merchant.dto.request.MerchantSignupRequest;
import com.project.razorpay.merchant.dto.response.MerchantResponse;
import com.project.razorpay.merchant.entity.AppUser;
import com.project.razorpay.merchant.entity.Merchant;
import com.project.razorpay.merchant.mapper.MerchantMapper;
import com.project.razorpay.merchant.repository.AppUserRepository;
import com.project.razorpay.merchant.repository.MerchantRepository;
import com.project.razorpay.merchant.services.AuthService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AppUserRepository appUserRepository;
    private final MerchantRepository merchantRepository;
    private final MerchantMapper merchantMapper;

    @Override
    @Transactional
    public MerchantResponse signup(MerchantSignupRequest request) {
        if(merchantRepository.existsByEmail(request.email())){
            throw new DuplicateResourceException("DUPLICATE_MERCHANT", "Merchant with email already exists");
        }
        Merchant merchant=merchantMapper.toEntityFromSignUpRequest(request);
        merchant.setStatus(MerchantStatus.PENDEIND_KYC);
        merchant=merchantRepository.save(merchant);

        AppUser appUser=AppUser.builder()
                .email(request.email())
                .passwordHash(request.password())
                .role(UserRole.OWNER)
                .merchant(merchant)
                .build();
        appUserRepository.save(appUser);

        return merchantMapper.toResponse(merchant);
    }


}

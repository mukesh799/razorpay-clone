package com.project.razorpay.merchant.entity;


import com.project.razorpay.common.entity.BaseEntity;
import com.project.razorpay.common.enums.BusinessType;
import com.project.razorpay.common.enums.MerchantStatus;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cache.annotation.EnableCaching;

import java.util.UUID;

@Entity
@Table(name = "merchant", indexes = {
        @Index(name = "idx_merchant_status", columnList = "status")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Merchant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private UUID id;
    @Column(nullable = false,length = 200)
    private String name;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(length = 20)
    private String contactNumber;
    @Column(length = 100)
    private String businessName;
    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private BusinessType businessType;
    @Column(length = 200)
    private String websiteUrl;

    @Column(length = 200,nullable = false)
    @Enumerated(EnumType.STRING)
    private MerchantStatus status=MerchantStatus.PENDEIND_KYC;
    @Column(length = 20)
    private String gstId;
    @Column(length = 20)
    private String panId;

    @Column(length = 200)
    private String settlementBankAccount;
    @Column(length = 20)
    private String settlementBankAcctIfsc;
    @Column(length = 200)
    private String settlementAccountHolderName;
}

package com.project.razorpay.vault.entity;

import com.project.razorpay.common.entity.BaseEntity;
import com.project.razorpay.common.enums.CardBrand;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name="vault_card")
@Setter
@Getter
@Builder
public class VaultCard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.UUID)
    private UUID id;
    @Column(nullable = false,length = 4)
    private String lastFour;
    @Column(nullable = false,length = 6)
    private String bin;
    @Column(nullable = false)
    private byte[] encryptedPan;
    @Column(nullable = false)
    private byte[] encryptedDek;
    @Column(nullable = false)
    private CardBrand brand;
    @Column(nullable = false)
    private String expiryMonth;
    @Column(nullable = false)
    private String expiryYear;
    @Column(nullable = false)
    private String cardHolderName;
    private LocalDateTime deletedAt;

}

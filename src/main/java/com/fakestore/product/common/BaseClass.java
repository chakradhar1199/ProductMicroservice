package com.fakestore.product.common;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseClass {
    @CreatedDate
    private String createdAt;

    @LastModifiedDate
    private String updatedAt;
}

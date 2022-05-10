package com.acme.model.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Component
public class BaseEntityListener extends AuditingEntityListener {


    @PrePersist
    public void onPrePersist(BaseEntity baseEntity) {
        baseEntity.setCreatedAt(LocalDateTime.now());
        baseEntity.setUpdatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void onPreUpdate(BaseEntity baseEntity) {
        baseEntity.setUpdatedAt(LocalDateTime.now());
    }


}

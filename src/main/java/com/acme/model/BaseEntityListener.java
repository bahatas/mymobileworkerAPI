package com.acme.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@Component
public class BaseEntityListener extends AuditingEntityListener {


    @PrePersist
    public void onPrePersist(BaseEntity baseEntity) {
        baseEntity.setCreated(LocalDateTime.now());
        baseEntity.setUpdated(LocalDateTime.now());
    }

    @PreUpdate
    public void onPreUpdate(BaseEntity baseEntity) {
        baseEntity.setUpdated(LocalDateTime.now());
    }


}

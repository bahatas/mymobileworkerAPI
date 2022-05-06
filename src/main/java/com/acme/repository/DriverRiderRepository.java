package com.acme.repository;

import com.acme.model.entity.DriverRider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRiderRepository extends JpaRepository<DriverRider, Long>, JpaSpecificationExecutor<DriverRider> {
}
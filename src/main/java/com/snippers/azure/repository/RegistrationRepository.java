package com.snippers.azure.repository;

import com.snippers.azure.model.Registration_Master;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration_Master,Long> {

}

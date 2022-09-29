package com.snipers.azure.repository;

import com.snipers.azure.model.School_Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRegistrationRepository extends JpaRepository<School_Registration, String> {
}

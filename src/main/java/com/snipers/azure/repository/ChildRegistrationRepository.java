package com.snipers.azure.repository;

import com.snipers.azure.model.Child_Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRegistrationRepository extends JpaRepository<Child_Registration,Long> {

}

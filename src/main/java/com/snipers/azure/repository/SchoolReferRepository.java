package com.snipers.azure.repository;

import com.snipers.azure.model.School_Refer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolReferRepository extends JpaRepository<School_Refer,String> {

}

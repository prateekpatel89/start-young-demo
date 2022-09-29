package com.snipers.azure.repository;

import com.snipers.azure.model.Sign_Up;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository<Sign_Up, String> {
}

package com.snipers.azure.repository;

import com.snipers.azure.model.Login_Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login_Credentials,String> {

}

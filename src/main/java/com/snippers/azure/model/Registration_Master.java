package com.snippers.azure.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration_Master {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name="RegistrationId")
    private String RegistrationId;
    private String RegistrationType;
    private String RegistrationDate;
    private String RegistrationStatus;
    private String UserId;

    public void setRegistrationId(String registrationId) {
        RegistrationId = registrationId;
    }

    public String getRegistrationId() {
        return RegistrationId;
    }

    public String getRegistrationType() {
        return RegistrationType;
    }

    public void setRegistrationType(String registrationType) {
        RegistrationType = registrationType;
    }



    public String getRegistrationStatus() {
        return RegistrationStatus;
    }

    public void setRegistrationStatus(String registrationStatus) {
        RegistrationStatus = registrationStatus;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        RegistrationDate = registrationDate;
    }
}

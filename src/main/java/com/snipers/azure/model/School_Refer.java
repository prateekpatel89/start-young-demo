package com.snipers.azure.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class School_Refer{
    @Id
    private String ReferralId;
    private String SchoolAddressLine1;
    private String SchoolAddressLine2;
    private String SchoolAddressLine3;
    private String PostCode;
    private String Country;
    private String City;
    private String SchoolName;
    private String SchoolEmail;
    private String SchoolPhone;
    private String Title;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Designation;
    private String Email;
    private String PhoneNumber;

    public String getSchoolPhone() {
        return SchoolPhone;
    }

    public void setSchoolPhone(String schoolPhone) {
        SchoolPhone = schoolPhone;
    }

    public String getReferralId() {
        return ReferralId;
    }

    public void setReferralId(String referralId) {
        ReferralId = referralId;
    }

    public String getSchoolAddressLine1() {
        return SchoolAddressLine1;
    }

    public void setSchoolAddressLine1(String schoolAddressLine1) {
        SchoolAddressLine1 = schoolAddressLine1;
    }

    public String getSchoolAddressLine2() {
        return SchoolAddressLine2;
    }

    public void setSchoolAddressLine2(String schoolAddressLine2) {
        SchoolAddressLine2 = schoolAddressLine2;
    }

    public String getSchoolAddressLine3() {
        return SchoolAddressLine3;
    }

    public void setSchoolAddressLine3(String schoolAddressLine3) {
        SchoolAddressLine3 = schoolAddressLine3;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getSchoolEmail() {
        return SchoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        SchoolEmail = schoolEmail;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}

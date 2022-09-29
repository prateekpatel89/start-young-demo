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
public class School_Registration {
    @Id
    private String UserId;
    private String SchoolName;
    private String AddressLine1;
    private String AddressLine2;
    private String AddressLine3;
    private String PostCode;
    private String Country;
    private String City;
    private String Title1;
    private String FirstName1;
    private String MiddleName1;
    private String LastName1;
    private String Designation1;
    private String Email1;
    private String PhoneNumber1;
    private String Title2;
    private String FirstName2;
    private String MiddleName2;
    private String LastName2;
    private String Designation2;
    private String Email2;
    private String PhoneNumber2;
    private String SchoolEmail;
    private String SchoolPhone;
    private String SchoolDescription;
    private String EstalishedDate;
    private String RegistrationDate;
    private String CountryOfRegistration;
    private String ReferralId;
    private Long ChildrenCount;
    private Long ChildrenInNeedCount;
    private String HelpType;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getAddressLine1() {
        return AddressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        AddressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return AddressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        AddressLine2 = addressLine2;
    }

    public String getAddressLine3() {
        return AddressLine3;
    }

    public void setAddressLine3(String addressLine3) {
        AddressLine3 = addressLine3;
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

    public String getTitle1() {
        return Title1;
    }

    public void setTitle1(String title1) {
        Title1 = title1;
    }

    public String getFirstName1() {
        return FirstName1;
    }

    public void setFirstName1(String firstName1) {
        FirstName1 = firstName1;
    }

    public String getMiddleName1() {
        return MiddleName1;
    }

    public void setMiddleName1(String middleName1) {
        MiddleName1 = middleName1;
    }

    public String getLastName1() {
        return LastName1;
    }

    public void setLastName1(String lastName1) {
        LastName1 = lastName1;
    }

    public String getDesignation1() {
        return Designation1;
    }

    public void setDesignation1(String designation1) {
        Designation1 = designation1;
    }

    public String getEmail1() {
        return Email1;
    }

    public void setEmail1(String email1) {
        Email1 = email1;
    }

    public String getPhoneNumber1() {
        return PhoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        PhoneNumber1 = phoneNumber1;
    }

    public String getTitle2() {
        return Title2;
    }

    public void setTitle2(String title2) {
        Title2 = title2;
    }

    public String getFirstName2() {
        return FirstName2;
    }

    public void setFirstName2(String firstName2) {
        FirstName2 = firstName2;
    }

    public String getMiddleName2() {
        return MiddleName2;
    }

    public void setMiddleName2(String middleName2) {
        MiddleName2 = middleName2;
    }

    public String getLastName2() {
        return LastName2;
    }

    public void setLastName2(String lastName2) {
        LastName2 = lastName2;
    }

    public String getDesignation2() {
        return Designation2;
    }

    public void setDesignation2(String designation2) {
        Designation2 = designation2;
    }

    public String getEmail2() {
        return Email2;
    }

    public void setEmail2(String email2) {
        Email2 = email2;
    }

    public String getPhoneNumber2() {
        return PhoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        PhoneNumber2 = phoneNumber2;
    }

    public String getSchoolEmail() {
        return SchoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        SchoolEmail = schoolEmail;
    }

    public String getSchoolPhone() {
        return SchoolPhone;
    }

    public void setSchoolPhone(String schoolPhone) {
        SchoolPhone = schoolPhone;
    }

    public String getSchoolDescription() {
        return SchoolDescription;
    }

    public void setSchoolDescription(String schoolDescription) {
        SchoolDescription = schoolDescription;
    }

    public String getEstalishedDate() {
        return EstalishedDate;
    }

    public void setEstalishedDate(String estalishedDate) {
        EstalishedDate = estalishedDate;
    }

    public String getRegistrationDate() {
        return RegistrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        RegistrationDate = registrationDate;
    }

    public String getCountryOfRegistration() {
        return CountryOfRegistration;
    }

    public void setCountryOfRegistration(String countryOfRegistration) {
        CountryOfRegistration = countryOfRegistration;
    }

    public String getReferralId() {
        return ReferralId;
    }

    public void setReferralId(String referralId) {
        ReferralId = referralId;
    }

    public Long getChildrenCount() {
        return ChildrenCount;
    }

    public void setChildrenCount(Long childrenCount) {
        ChildrenCount = childrenCount;
    }

    public Long getChildrenInNeedCount() {
        return ChildrenInNeedCount;
    }

    public void setChildrenInNeedCount(Long childrenInNeedCount) {
        ChildrenInNeedCount = childrenInNeedCount;
    }

    public String getHelpType() {
        return HelpType;
    }

    public void setHelpType(String helpType) {
        HelpType = helpType;
    }
}

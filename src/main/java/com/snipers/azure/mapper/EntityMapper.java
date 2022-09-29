package com.snipers.azure.mapper;

import com.snipers.azure.beans.ReferSchool;
import com.snipers.azure.beans.SchoolRegistration;
import com.snipers.azure.beans.SignUp;
import com.snipers.azure.model.School_Refer;
import com.snipers.azure.model.School_Registration;
import com.snipers.azure.model.Sign_Up;
import org.springframework.stereotype.Component;

@Component
public class EntityMapper {
    public School_Registration mapToSchoolRegistrationEntity(SchoolRegistration schoolRegistration){
        School_Registration school_registration = new School_Registration();
        school_registration.setUserId(schoolRegistration.getUserId());
        school_registration.setCountryOfRegistration(schoolRegistration.getCountryOfRegistration());
        school_registration.setSchoolEmail(schoolRegistration.getSchoolEmail());
        school_registration.setSchoolPhone(schoolRegistration.getSchoolPhone());
        school_registration.setSchoolName(schoolRegistration.getSchoolName());
        school_registration.setChildrenCount(schoolRegistration.getChildrenCount());
        school_registration.setChildrenInNeedCount(schoolRegistration.getChildrenInNeedCount());
        school_registration.setEstalishedDate(schoolRegistration.getEstalishedDate());
        school_registration.setHelpType(schoolRegistration.getHelpType().toString());
        school_registration.setReferralId(schoolRegistration.getReferralId());
        school_registration.setRegistrationDate(schoolRegistration.getRegistrationDate());
        school_registration.setSchoolDescription(schoolRegistration.getSchoolDescription());

        //address mapping
        school_registration.setCountry(schoolRegistration.getCountry());
        school_registration.setAddressLine1(schoolRegistration.getAddressLine1());
        school_registration.setAddressLine2(schoolRegistration.getAddressLine2());
        school_registration.setAddressLine3(schoolRegistration.getAddressLine3());
        school_registration.setCity(schoolRegistration.getCity());
        school_registration.setPostCode(schoolRegistration.getPostCode());

        //first contact
        school_registration.setDesignation1(schoolRegistration.getDesignation1());
        school_registration.setFirstName1(schoolRegistration.getFirstName1());
        school_registration.setMiddleName1(schoolRegistration.getMiddleName1());
        school_registration.setLastName1(schoolRegistration.getLastName1());
        school_registration.setTitle1(schoolRegistration.getTitle1());
        school_registration.setEmail1(schoolRegistration.getEmail1());
        school_registration.setPhoneNumber1(schoolRegistration.getPhoneNumber1());

        //second contact
        school_registration.setDesignation2(schoolRegistration.getDesignation2());
        school_registration.setFirstName2(schoolRegistration.getFirstName2());
        school_registration.setMiddleName2(schoolRegistration.getMiddleName2());
        school_registration.setLastName2(schoolRegistration.getLastName2());
        school_registration.setTitle2(schoolRegistration.getTitle2());
        school_registration.setEmail2(schoolRegistration.getEmail2());
        school_registration.setPhoneNumber2(schoolRegistration.getPhoneNumber2());

        return school_registration;
    }

    public Sign_Up mapToSignUpEntity(SignUp signUp){
        Sign_Up sign_up = new Sign_Up();
        sign_up.setEmail(signUp.getEmail());
        sign_up.setName(signUp.getName());
        sign_up.setSignUpType(signUp.getSignUpType());
        sign_up.setPhoneNumber(signUp.getPhoneNumber());
        sign_up.setVolunteerType(signUp.getVolunteerType());
        sign_up.setHelpType(signUp.getHelpType());
        return sign_up;
    }

    public School_Refer mapToSchoolReferEntity(ReferSchool referSchool){
        School_Refer school_refer = new School_Refer();

        school_refer.setCity(referSchool.getCity());
        school_refer.setCountry(referSchool.getCountry());
        school_refer.setSchoolAddressLine1(referSchool.getAddressLine1());
        school_refer.setSchoolAddressLine2(referSchool.getAddressLine2());
        school_refer.setSchoolAddressLine3(referSchool.getAddressLine3());
        school_refer.setPostCode(referSchool.getPostCode());

        school_refer.setDesignation(referSchool.getDesignation());
        school_refer.setEmail(referSchool.getEmail());
        school_refer.setPhoneNumber(referSchool.getPhoneNumber());
        school_refer.setFirstName(referSchool.getFirstName());
        school_refer.setMiddleName(referSchool.getMiddleName());
        school_refer.setLastName(referSchool.getLastName());
        school_refer.setTitle(referSchool.getTitle());

        school_refer.setSchoolEmail(referSchool.getSchoolEmail());
        school_refer.setSchoolName(referSchool.getSchoolName());
        school_refer.setSchoolPhone(referSchool.getSchoolPhone());

        return school_refer;
    }
}

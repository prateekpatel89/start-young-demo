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
public class Child_Registration {
    @Id
    private String ChildId;
    private String userId;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Gender;
    private String Phone;
    private String Email;
    private String TypeOfHelp;


}

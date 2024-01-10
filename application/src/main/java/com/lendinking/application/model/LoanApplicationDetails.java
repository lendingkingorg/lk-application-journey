package com.lendinking.application.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "lending_inf")
public class LoanApplicationDetails {

    @Id
    private Long mobileNo;

    // Personal Information
    private String name;
    private Date dob;
    private String gender;

    // Residential Information
    private String residentialPincode;
    private String residentialAddress;

    // PAN Information
    private String pan;

    // Financial Information
    private double annualTurnover;
    private int yearsInCurrentBusiness;

    // Business Information
    private String businessPincode;
    private String businessAddress;
    private String businessRegisteredAs;
    private String productCategory;
    private String natureOfBusiness;
    private String businessRunBy;

    // Loan Request Information
    private double requestedLoanAmount;
    private int loanDurationInMonths;



}

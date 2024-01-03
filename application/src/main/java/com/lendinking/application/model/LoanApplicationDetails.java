package com.lendinking.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class LoanApplicationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

package com.lendinking.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "document_inf")
public class DocumentUploadDetails {

    @Id
    private Long mobileNo;

    String PanCardUrl;

    String BankStatementUrlOne;
    String BankInfoOne;
    String BankStatementOneDocType;

    String BankStatementUrlTwo;
    String BankInfoTwo;
    String BankStatementTwoDocType;

    String BankStatementUrlThree;
    String BankInfoThree;
    String BankStatementThreeDocType;

    String BankStatementUrlFour;
    String BankInfoFour;
    String BankStatementFourDocType;

    String BankStatementUrlFive;
    String BankInfoFive;
    String BankStatementFiveDocType;

    String BusinessRegistrationProofUrl;

    String BusinessAddressProofUrl;

    String IDProofOfGuarantorUrl;


}

package com.lendinking.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "document_inf")
@Getter
@Setter
public class DocumentUploadDetails {

    @Id
    private Long mobileNo;

    String PanCardUrl;

    String BankStatementUrlOne;
    String BankInfoOne;
    String BankStatementOneDocFormat;

    String BankStatementUrlTwo;
    String BankInfoTwo;
    String BankStatementTwoDocFormat;

    String BankStatementUrlThree;
    String BankInfoThree;
    String BankStatementThreeDocFormat;

    String BankStatementUrlFour;
    String BankInfoFour;
    String BankStatementFourDocFormat;

    String BankStatementUrlFive;
    String BankInfoFive;
    String BankStatementFiveDocFormat;

    String BusinessRegistrationProofUrl;

    String BusinessAddressProofUrl;

    String IDProofOfGuarantorUrl;


}

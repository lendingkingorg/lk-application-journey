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

    String BankStatementUrl;

    String BusinessRegistrationProofUrl;

    String BusinessAddressProofUrl;

    String IDProofOfGuarantorUrl;


}

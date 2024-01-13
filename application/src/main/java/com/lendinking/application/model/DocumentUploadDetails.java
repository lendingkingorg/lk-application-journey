package com.lendinking.application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "document_inf")
public class DocumentUploadDetails {

    @Id
    private Long mobileNo;

    String PanCardUrl;
    String BankStatementOneDocType;

    List<String> documentBankName;

    List<String> documentURL;

    String BusinessAddressProofUrl;

    String IDProofOfGuarantorUrl;

    public DocumentUploadDetails() {
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        this.documentURL = list;
        this.documentBankName= list1;
    }
}

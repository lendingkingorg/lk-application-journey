package com.lendinking.application.entity;

import com.lendinking.application.model.DocumentUploadDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class DocumentURL {



     String PanCardUrl;

      String BankStatementUrlOne;


      String BankStatementUrlTwo;


     String BankStatementUrlThree;


     String BankStatementUrlFour;


     String BankStatementUrlFive;


     String BusinessRegistrationProofUrl;

     String BusinessAddressProofUrl;

     String IDProofOfGuarantorUrl;


    public DocumentURL(DocumentUploadDetails res) {
        setBankStatementUrlOne(res.getBankStatementUrlOne());
        setBankStatementUrlTwo(res.getBankStatementUrlTwo());
        setBankStatementUrlThree(res.getBankStatementUrlThree());
        setBankStatementUrlFour(res.getBankStatementUrlFour());
        setBankStatementUrlFive(res.getBankStatementUrlFive());

        setIDProofOfGuarantorUrl(res.getIDProofOfGuarantorUrl());
        setPanCardUrl(res.getPanCardUrl());
        setBusinessAddressProofUrl(res.getBusinessAddressProofUrl());
        setBusinessRegistrationProofUrl(res.getBusinessRegistrationProofUrl());
    }
}

package com.lendinking.application.service;

import com.lendinking.application.model.DocumentUploadDetails;
import com.lendinking.application.model.LoanApplicationDetails;


public interface LoanApplicationServiceInterface {

 public LoanApplicationDetails saveLoanApplication(LoanApplicationDetails loanApplication);

 public DocumentUploadDetails uploadStatus(long mobNo);

}

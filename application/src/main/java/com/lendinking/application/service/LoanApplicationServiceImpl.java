package com.lendinking.application.service;

import com.lendinking.application.model.DocumentUploadDetails;
import com.lendinking.application.model.LoanApplicationDetails;
import com.lendinking.application.repository.DocumentRepository;
import com.lendinking.application.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationServiceInterface {


    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    @Autowired
    private DocumentRepository documentRepository;
    public LoanApplicationDetails saveLoanApplication(LoanApplicationDetails loanApplication) {
        LoanApplicationDetails save = loanApplicationRepository.save(loanApplication);
        return save;
    }

    public Boolean docUploadStatus(Long mobNo){

        return loanApplicationRepository.existsById(mobNo);

    }
    public DocumentUploadDetails uploadStatus(long mobNo){

        return documentRepository.findByMobileNo(mobNo);
    }
}

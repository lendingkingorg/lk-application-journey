package com.lendinking.application.service;

import com.lendinking.application.model.LoanApplicationDetails;
import com.lendinking.application.repository.LoanApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationServiceInterface {


    @Autowired
    private LoanApplicationRepository loanApplicationRepository;

    public LoanApplicationDetails saveLoanApplication(LoanApplicationDetails loanApplication) {
        LoanApplicationDetails save = loanApplicationRepository.save(loanApplication);
        return loanApplication;
    }
}

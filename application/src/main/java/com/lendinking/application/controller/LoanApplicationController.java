package com.lendinking.application.controller;

import com.lendinking.application.model.LoanApplicationDetails;
import com.lendinking.application.service.LoanApplicationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/document-api")
public class LoanApplicationController {
@Autowired
    LoanApplicationServiceInterface loanApplicationServiceInterface;
@PostMapping("/bl-save-personal-and-business-info/{mobNo}")

    public ResponseEntity<?> saveBusinessDetails(@PathVariable String mobNo,
            @RequestBody LoanApplicationDetails loanApplication){

    loanApplicationServiceInterface.saveLoanApplication(loanApplication);
    return new ResponseEntity<>( "DATA SAVED", HttpStatus.OK);
}

}

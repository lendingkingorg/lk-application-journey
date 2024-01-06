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

   try {
        // Return a success response with a status code of 200 and a custom message
        String message = "Data saved successfully";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
   catch (Exception e){
        // Return an error response with a status code of 500 and a custom message
        String errorMessage = "Failed to save data";
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

}

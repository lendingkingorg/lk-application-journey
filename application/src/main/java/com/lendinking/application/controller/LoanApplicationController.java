package com.lendinking.application.controller;

import com.lendinking.application.model.DocumentUploadDetails;
import com.lendinking.application.model.LoanApplicationDetails;
import com.lendinking.application.service.LoanApplicationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/document-api")
public class LoanApplicationController {
@Autowired
    LoanApplicationServiceInterface loanApplicationServiceInterface;
@PostMapping("/bl-save-personal-and-business-info/")

    public ResponseEntity<?> saveBusinessDetails(@RequestBody LoanApplicationDetails loanApplication){



   try {
        // Return a success response with a status code of 200 and a custom message
       LoanApplicationDetails res= loanApplicationServiceInterface.saveLoanApplication(loanApplication);
       String message = "Data saved successfully";

       // Create a Map for the JSON response
       Map<String, Object> jsonResponse = new HashMap<>();
       jsonResponse.put("isSaved", res!=null);
       jsonResponse.put("message", message);

       return new ResponseEntity<>(jsonResponse, HttpStatus.OK);

   }
   catch (Exception e){
        // Return an error response with a status code of 500 and a custom message
        String errorMessage = "Failed to save data";
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

    @GetMapping("/bl-loan-application-status/{mobNo}")

    public ResponseEntity<?> uploadStatus(@PathVariable Long mobNo){
        try {
            DocumentUploadDetails res=  loanApplicationServiceInterface.uploadStatus(mobNo);
            Boolean userDetailsStatus=  loanApplicationServiceInterface.docUploadStatus(mobNo);

            Map<String, Object> jsonResponse = new HashMap<>();
            jsonResponse.put("userDetailsStatus", userDetailsStatus);
            jsonResponse.put("DocumentURL", res);

            return new ResponseEntity<>(jsonResponse, HttpStatus.OK);

        }
        catch (Exception e){
            // Return an error response with a status code of 500 and a custom message
            String errorMessage = "Failed to Fetch Status";
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}

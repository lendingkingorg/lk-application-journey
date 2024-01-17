package com.lendinking.application.controller;

import com.lendinking.application.model.LoanApplicationDetails;
import com.lendinking.application.service.BusinessEngineServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/business-engine-api")
public class BusinessEngineController {

@Autowired
BusinessEngineServiceInterface businessEngineServiceInterface;
    @PostMapping("/{mobNo}")

    public ResponseEntity<?> sendDocToLenders(@PathVariable Long mobNo){

        try {

            businessEngineServiceInterface.runBusinessEngine(mobNo);
            return new ResponseEntity<>("errorMessage", HttpStatus.INTERNAL_SERVER_ERROR);

        }
        catch (Exception errorMessage){
            return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }




}

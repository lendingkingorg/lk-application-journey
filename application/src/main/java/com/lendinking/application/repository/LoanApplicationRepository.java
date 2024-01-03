package com.lendinking.application.repository;

import com.lendinking.application.model.LoanApplicationDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanApplicationRepository extends CrudRepository<LoanApplicationDetails,Long> {
}

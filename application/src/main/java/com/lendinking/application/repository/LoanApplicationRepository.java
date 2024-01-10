package com.lendinking.application.repository;

import com.lendinking.application.model.LoanApplicationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface LoanApplicationRepository extends JpaRepository<LoanApplicationDetails,Long> {
}

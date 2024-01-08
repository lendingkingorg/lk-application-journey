package com.lendinking.application.repository;

import com.lendinking.application.model.DocumentUploadDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface DocumentRepository extends JpaRepository<DocumentUploadDetails,Long> {
}

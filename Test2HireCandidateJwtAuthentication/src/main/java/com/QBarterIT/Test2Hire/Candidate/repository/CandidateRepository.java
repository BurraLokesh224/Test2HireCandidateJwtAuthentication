package com.QBarterIT.Test2Hire.Candidate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.QBarterIT.Test2Hire.Candidate.model.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

	Candidate findByEmail(String email);

	Candidate findById(long id);

	boolean existsByEmail(String email);

}
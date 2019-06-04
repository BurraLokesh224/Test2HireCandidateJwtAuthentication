package com.QBarterIT.Test2Hire.Candidate.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.QBarterIT.Test2Hire.Candidate.model.Candidate;
import com.QBarterIT.Test2Hire.Candidate.repository.CandidateRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    CandidateRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
    	
        Candidate user = userRepository.findByEmail(email);
       
        		/*
                	.orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + email)
        );
*/
        return UserPrinciple.Create(user);
    }
}
package com.example.Amazon.repository;


import com.example.Amazon.entity.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SignUpRepository extends JpaRepository<SignUp,Integer> {
    Optional<SignUp> findByIsDeletedAndId(boolean b, Integer id);
    Optional<SignUp> findByIsDeletedAndEmailId(boolean b, String emailId);
    Optional<SignUp> findByIsDeletedAndPhoneNo(boolean b, String phoneNo);
}

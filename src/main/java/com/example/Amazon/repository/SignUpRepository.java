package com.example.Amazon.repository;

import com.example.Amazon.entity.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends JpaRepository<SignUp,Long> {
//    void deleteCartById(long );
}

package com.example.Amazon.repository;

import com.example.Amazon.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
    Optional<Address> findByIsDeletedAndId(boolean b, Integer id);
}

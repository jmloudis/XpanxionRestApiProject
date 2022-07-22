package com.xpanxion.restproject.repository;

import com.xpanxion.restproject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>
{
    List<Customer> findByLastName(String lastName);

    @Query(value = "SELECT * FROM Customer c WHERE c.first_name = :firstName", nativeQuery = true)
    List<Customer> findByFirstNameNative(@Param("firstName") String firstName);
}

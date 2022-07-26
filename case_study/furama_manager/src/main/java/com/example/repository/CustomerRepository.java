package com.example.repository;

import com.example.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where delete_status = false ", nativeQuery = true)
    Page<Customer> findAll(Pageable pageable);

    @Modifying
    @Query(value = "update customer set delete_status = true where id =:id",nativeQuery = true)
    void remove(@Param("id") int id);
}

package com.example.phone_manger.repository;

import com.example.phone_manger.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPhoneRepository extends JpaRepository<Phone,Long> {
}

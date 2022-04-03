package com.example.emt_lab2.repository;

import com.example.emt_lab2.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JPACountryRepo extends JpaRepository<Country,Long> {
}

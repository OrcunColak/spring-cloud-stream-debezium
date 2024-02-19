package com.colak.springcloudstreamdebezium.repository;

import com.colak.springcloudstreamdebezium.jpa.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}

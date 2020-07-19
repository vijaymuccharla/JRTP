package com.vj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vj.entities.CountryEntity;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {

}

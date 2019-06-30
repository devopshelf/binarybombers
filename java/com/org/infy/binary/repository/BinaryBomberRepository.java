package com.org.infy.binary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.infy.binary.entity.Phrase;

public interface BinaryBomberRepository extends JpaRepository<Phrase, Integer>{

}

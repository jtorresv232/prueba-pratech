package com.pratechtest.pratechtestbackend.irepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratechtest.pratechtestbackend.entity.Form;

@Repository
public interface IFormRepository extends JpaRepository<Form, Integer>{
}

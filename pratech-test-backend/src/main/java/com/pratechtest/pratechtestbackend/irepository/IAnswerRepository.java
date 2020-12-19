package com.pratechtest.pratechtestbackend.irepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratechtest.pratechtestbackend.entity.Answer;

@Repository
public interface IAnswerRepository extends JpaRepository<Answer, Integer>{
	
	
}

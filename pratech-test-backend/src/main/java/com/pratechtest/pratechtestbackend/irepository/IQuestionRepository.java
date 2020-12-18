package com.pratechtest.pratechtestbackend.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pratechtest.pratechtestbackend.entity.Question;


public interface IQuestionRepository extends JpaRepository<Question, Integer>{
	
	@Query(nativeQuery=true, value="SELECT * FROM question as q WHERE q.form_id=:formid")
	List<Question> findByFormId(@Param("formid") int formId);
}

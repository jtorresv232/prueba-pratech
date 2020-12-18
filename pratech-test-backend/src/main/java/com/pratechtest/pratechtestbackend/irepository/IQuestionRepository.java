package com.pratechtest.pratechtestbackend.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pratechtest.pratechtestbackend.entity.Question;


public interface IQuestionRepository extends JpaRepository<Question, Integer>{
	
	@Query(nativeQuery=true, value="SELECT * FROM question as q WHERE q.form_id=:formid")
	List<Question> findByFormId(@Param("formid") int formId);
	
	//@Query("Select q from Form f JOIN f.questions q JOIN q.answer a where f.id=:formid AND a.user.id=:userid")
	
	@Query(nativeQuery=true, value="Select q.* from question q inner join answer a on a.question_id = q.id where a.user_id = :userid and q.form_id = :formid")
	List<Question> findByFormAndUser(@Param("formid") int formId, @Param("userid") int id);
}

package com.pratechtest.pratechtestbackend.irepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pratechtest.pratechtestbackend.entity.Try;

public interface ITryRepository extends JpaRepository<Try, Integer>{

	@Query(nativeQuery=true, value="SELECT * from try as t WHERE t.user_id=:userid")
	List<Try> findAllByUser(@Param("userid") int id);
}

package com.pratechtest.pratechtestbackend.irepository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratechtest.pratechtestbackend.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
	
	@Query(nativeQuery=true, value="SELECT * FROM app_user as u WHERE u.email=:email AND u.password=:password")
	Optional<User> findByEmailPassword(@Param("email") String email, @Param("password") String password);
}

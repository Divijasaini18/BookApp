package com.example.login.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.login.Model.User;


@Repository
@Transactional
public interface UserRepository extends JpaRepository<User,String>{
	@Query(value="Select * from User", nativeQuery=true)
    List<User> findAllUsersFromEmailId(String email);
    @Query(value="Select * from User where email= ?",nativeQuery=true)
    Optional<User> findByEmailId(String email);

}
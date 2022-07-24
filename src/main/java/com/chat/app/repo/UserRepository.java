package com.chat.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chat.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "Select * from users_1  where lower(name) like %:name% order by name LIMIT 50", nativeQuery = true)
	public List<User> getUsers(@Param("name")String name);
	public User findByName(String name);
}

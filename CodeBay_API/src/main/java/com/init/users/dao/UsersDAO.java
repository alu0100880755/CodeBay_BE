package com.init.users.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.init.users.entities.User;

public interface UsersDAO extends JpaRepository<User, Long> {

	List<User> findByCityStartingWith(String string);

	List<User> findByOrderByCreationdateAsc();

	List<User> findByOrderByCreationdateDesc();

	@Query(value = "select city from users where city like ?1%", nativeQuery = true)
	List<String> findAllCitiesByLetter(String city);

	@Query(value = "select name from users where active = true", nativeQuery = true)
	List<String> findActiveUsersName();

	@Query(value = "select name from users order by creationdate asc", nativeQuery = true)
	List<String> findByNameOrderByCreationdateAsc();

	@Query(value = "select name from users order by creationdate desc", nativeQuery = true)
	List<String> findByNameOrderByCreationdateDesc();

}

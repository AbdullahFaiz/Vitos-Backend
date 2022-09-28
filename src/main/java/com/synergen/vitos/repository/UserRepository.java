package com.synergen.vitos.repository;

import com.synergen.vitos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

	public List<User> findByStatus(String status);

	public User findByUserId(long userId);

	public User findByContactNo(String contactNo);
}

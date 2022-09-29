package com.synergen.vitos.repository;

import com.synergen.vitos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{


	public User findByContactNo(String contactNo);
}

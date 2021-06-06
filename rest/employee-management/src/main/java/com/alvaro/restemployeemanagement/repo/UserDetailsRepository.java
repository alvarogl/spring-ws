package com.alvaro.restemployeemanagement.repo;

import com.alvaro.restemployeemanagement.model.UserDetails;
import org.springframework.data.repository.CrudRepository;

public interface UserDetailsRepository extends CrudRepository<UserDetails, Long> {

}
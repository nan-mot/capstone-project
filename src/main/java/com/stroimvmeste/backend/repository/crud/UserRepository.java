package com.stroimvmeste.backend.repository.crud;

import com.stroimvmeste.backend.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}

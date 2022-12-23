package com.stroimvmeste.backend.repository.inmemory;


import com.stroimvmeste.backend.model.Initiative;
import com.stroimvmeste.backend.model.User;
import com.stroimvmeste.backend.repository.UserRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@Profile("inmemory")
public class UserRepositoryInMemoryImpl extends AbstractInMemory<User> implements UserRepository {

    public UserRepositoryInMemoryImpl() {
        super(UserRepositoryInMemoryImpl.class.getSimpleName(), User.class);
    }

    @Override
    public User save(User user) {
        return get(put(user.getId(), user));
    }
}

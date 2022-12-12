package com.stroimvmeste.backend.repository.crud;

import com.stroimvmeste.backend.model.Initiative;
import com.stroimvmeste.backend.repository.InitiativeRepository;
import org.springframework.data.repository.CrudRepository;

public interface InitiativeRepositoryCrudImpl extends CrudRepository<Initiative, Integer>, InitiativeRepository {
}

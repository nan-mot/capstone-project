package com.stroimvmeste.backend.repository.crud;

import com.stroimvmeste.backend.model.Initiative;
import com.stroimvmeste.backend.repository.InitiativeRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("crud")
public interface InitiativeRepositoryCrudImpl extends CrudRepository<Initiative, Long>, InitiativeRepository {

}


package com.stroimvmeste.backend.repository.crud;

import com.stroimvmeste.backend.model.Specialization;
import com.stroimvmeste.backend.repository.SpecializationRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("crud")
public interface SpecializationRepositoryCrudImpl extends CrudRepository<Specialization, Long>, SpecializationRepository {
}


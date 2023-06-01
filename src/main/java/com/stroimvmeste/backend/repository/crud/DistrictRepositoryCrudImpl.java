package com.stroimvmeste.backend.repository.crud;

import com.stroimvmeste.backend.model.District;
import com.stroimvmeste.backend.repository.DistrictRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;

@Profile("crud")
public interface DistrictRepositoryCrudImpl extends CrudRepository<District, Long>, DistrictRepository {

}

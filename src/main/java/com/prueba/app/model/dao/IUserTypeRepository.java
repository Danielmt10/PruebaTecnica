package com.prueba.app.model.dao;

import com.prueba.app.model.entity.UserType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserTypeRepository extends CrudRepository<UserType, Integer> {
}

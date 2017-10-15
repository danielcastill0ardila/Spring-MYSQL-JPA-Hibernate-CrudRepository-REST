package com.crudrepository.DAO.implement;

import org.springframework.data.repository.CrudRepository;

import com.crudrepository.entity.model.User;

public interface IUser extends CrudRepository<User, Long>{

}

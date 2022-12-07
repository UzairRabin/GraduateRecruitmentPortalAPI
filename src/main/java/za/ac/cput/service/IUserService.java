package za.ac.cput.service;

import za.ac.cput.model.User;

import java.util.List;

public interface IUserService extends IService<User, String>{

    List<User> findAll();

}

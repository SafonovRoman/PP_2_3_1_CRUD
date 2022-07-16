package ru.safonovroman.kata.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.safonovroman.kata.crud.dao.UserDao;
import ru.safonovroman.kata.crud.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   @Autowired
   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   public User getUser(Long id) {
      return userDao.getUser(id);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public void update(User user) {
   }

   @Override
   public void delete(Long id) {
      userDao.delete(id);
   }
}

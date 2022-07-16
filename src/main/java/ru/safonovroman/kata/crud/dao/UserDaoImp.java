package ru.safonovroman.kata.crud.dao;

import org.springframework.stereotype.Repository;
import ru.safonovroman.kata.crud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

   @Override
   public void add(User user) {
      entityManager.persist(user);
   }

   @Override
   public User getUser(Long id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public List<User> listUsers() {
      return entityManager.createQuery("select u from User u").getResultList();
   }

   @Override
   public void update(User user) {

   }

   @Override
   public void delete(Long id) {
      entityManager.detach(15);
   }
}

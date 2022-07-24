package ru.safonovroman.kata.crud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;
import ru.safonovroman.kata.crud.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;

//   @Autowired
//   private TransactionManager transactionManager;

   @Override
   @Transactional
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
   @Transactional
   public void update(User user) {
      entityManager.persist(user);
   }

   @Override
   @Transactional
   public void delete(Long id) {
      try {
         entityManager.remove(getUser(15L));
      } catch (IllegalArgumentException e) {
         entityManager.remove(getUser(id));
      }
   }
}

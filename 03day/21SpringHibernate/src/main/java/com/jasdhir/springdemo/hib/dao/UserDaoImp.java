package com.jasdhir.springdemo.hib.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jasdhir.springdemo.hib.model.User;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

 

@Override
public void add(User user) {
	sessionFactory.getCurrentSession().save(user);
	
}

@Override
public List<User> listUsers() {
	  @SuppressWarnings("unchecked")
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
}

    @Override
    public void update(Long id) {
       User user= sessionFactory.getCurrentSession().get(User.class,id);
       user.setFirstName("Pranay");
       sessionFactory.getCurrentSession().saveOrUpdate(user);

    }

}

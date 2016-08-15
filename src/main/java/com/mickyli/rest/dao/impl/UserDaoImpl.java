package com.mickyli.rest.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mickyli.rest.bean.User;
import com.mickyli.rest.dao.UserDao;
import com.mickyli.rest.util.HibernateUtil;

public class UserDaoImpl implements UserDao{

	@Override  
    public User getUserById(String id) {  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();   
        Session s = null;  
        Transaction t = null;  
        User user = null;  
        try{  
         s = sessionFactory.openSession();  
         t = s.beginTransaction();  
         String hql = "from User where userId="+id;    
         Query query = s.createQuery(hql);    
         user = (User) query.uniqueResult();   
         t.commit();  
        }catch(Exception err){  
        t.rollback();  
        err.printStackTrace();  
        }finally{  
        s.close();  
        }  
        return user;  
    }  
  
    @Override  
    public boolean deleteUserById(String id) {  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();   
        Session s = null;  
        Transaction t = null;  
        boolean flag = false;  
        try{  
         s = sessionFactory.openSession();  
         t = s.beginTransaction();  
         User user = new User();    
         user.setUserId(id);  
         s.delete(user);  
         t.commit();  
         flag = true;  
        }catch(Exception err){  
        t.rollback();  
        err.printStackTrace();  
        }finally{  
        s.close();  
        }  
        return flag;  
    }  
  
    @Override  
    public boolean createUser(User user) {  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();   
        Session s = null;  
        Transaction t = null;  
        boolean flag = false;  
        try{  
         s = sessionFactory.openSession();  
         t = s.beginTransaction();  
         s.save(user);  
         t.commit();  
         flag = true;  
        }catch(Exception err){  
        t.rollback();  
        err.printStackTrace();  
        }finally{  
        s.close();  
        }  
        return flag;  
    }  
  
    @Override  
    public boolean updateUser(User user) {  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();   
        Session s = null;  
        Transaction t = null;  
        boolean flag = false;  
        try{  
         s = sessionFactory.openSession();  
         t = s.beginTransaction();  
         s.update(user);  
         t.commit();  
         flag = true;  
        }catch(Exception err){  
        t.rollback();  
        err.printStackTrace();  
        }finally{  
        s.close();  
        }  
        return flag;  
    }  
  
    @Override  
    public List<User> getAllUsers() {  
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();   
        Session s = null;  
        Transaction t = null;  
        List<User> uesrs = null;  
        try{  
         s = sessionFactory.openSession();  
         t = s.beginTransaction();  
         String hql = "select * from t_user";    
         Query query = s.createSQLQuery(hql).addEntity(User.class);    
         query.setCacheable(true); // 设置缓存    
         uesrs = query.list();    
         t.commit();  
        }catch(Exception err){  
        t.rollback();  
        err.printStackTrace();  
        }finally{  
        s.close();  
        }  
        return uesrs;  
    }  

}

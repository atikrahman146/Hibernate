/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.test.service;

import com.test.dao.CommonDao;
import com.test.util.NewHibernateUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author J2EE-33
 */
public class CommonService<E> implements CommonDao<E> {

    SessionFactory sessFact = NewHibernateUtil.getSessionFactory();
    Session session = sessFact.getCurrentSession();
    Transaction tr = session.beginTransaction();

    protected E instance;
    private Class<E> entityClass;

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }


    /**
     *
     * @param e
     * @throws Exception
     */
    @Override
    public void persist(E e) throws Exception {
        getSession().persist(e);
        tr.commit();
        getSession().close();
    }

    @Override
    public void merge(E e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(E e) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E findById(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E> findAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E> findByProperty(String prop, Object val) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E> findInRange(int firstResult, int maxResults) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long count() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Class<E> getEntityClass() throws Exception {
        if (entityClass == null) {
            Type type = getClass().getGenericSuperclass();

            if (type instanceof ParameterizedType) {
                ParameterizedType paramtype = (ParameterizedType) type;

                if (paramtype.getActualTypeArguments().length == 2) {
                    if (paramtype.getActualTypeArguments()[1] instanceof TypeVariable) {
                        throw new IllegalArgumentException(
                                "Can't find class using reflection"
                        );
                    } else {
                        entityClass = (Class<E>) paramtype.getActualTypeArguments()[1];
                    }

                } else {
                    entityClass = (Class<E>) paramtype.getActualTypeArguments()[0];
                }
            } else {
                throw new Exception("Can't find class using reflection");
            }
        }
        return entityClass;
    }
}

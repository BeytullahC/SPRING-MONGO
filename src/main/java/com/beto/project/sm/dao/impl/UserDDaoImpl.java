package com.beto.project.sm.dao.impl;

import com.beto.project.sm.dao.UserMDap;
import com.beto.project.sm.model.document.User;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class UserDDaoImpl implements UserMDap {

    @Autowired
    private MongoOperations mongo;

    @Override
    public User saveUser(User t) throws Exception {
        mongo.save(t);
        Query searchUserQuery = new Query(Criteria.where("username").is(
                t.getUsername()));
        return mongo.findOne(searchUserQuery, User.class);
       
    }

    @Override
    public User updateUser(User t) throws Exception {
        mongo.findOne(getFindQuery("id", t.getId()), User.class);
        mongo.updateFirst(getFindQuery("id", t.getId()), 
                         Update.update("password", t.getPassword()),User.class);
        return findUser(t.getId());
    }

    @Override
    public boolean deleteUser(User t) throws Exception {

        mongo.remove(t);
        return true;

    }

    @Override
    public User findUser(Serializable id) throws Exception {
        return mongo.findOne(getFindQuery("id", id), User.class);
    }

    @Override
    public List<User> findAll() throws Exception {
       return mongo.findAll(User.class);
    }

    public Query getFindQuery(String key, Object value) {
        Query searchUserQuery = new Query(Criteria.where(key).is(
                value));
        return searchUserQuery;
    }

}

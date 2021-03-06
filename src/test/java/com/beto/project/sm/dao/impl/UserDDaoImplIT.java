/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beto.project.sm.dao.impl;

import com.beto.project.sm.conf.SpringMongoConfig;
import com.beto.project.sm.dao.UserMDap;
import com.beto.project.sm.model.document.User;
import java.util.List;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author 912867
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMongoConfig.class)
public class UserDDaoImplIT {
    private static final Logger logger = LoggerFactory.getLogger(UserDDaoImplIT.class);
    @Autowired
    private UserMDap ms;

    static User t;

    public UserDDaoImplIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    	logger.debug("MONGO DB TEST IS STARTING...");
        t = new User(1, "TEST_USER", "1234");
    }

    @AfterClass
    public static void tearDownClass() {
    	logger.debug("MONGO DB TEST FINISHED...");
    }

    @Before
    public void setUp() {
    	
    }

    @After
    public void tearDown() {
    	
    }

    /**
     * Test of saveUser method, of class UserDDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testSaveUser() throws Exception {
        logger.debug("saveUser");
        User expResult = null;
        User result = ms.saveUser(t);
        logger.debug("result : " + result);
        Assert.assertThat(expResult, Is.is(IsNot.not(result)));
    }

    /**
     * Test of updateUser method, of class UserDDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testUpdateUser() throws Exception {
        logger.debug("updateUser");
        User expResult = null;
        t.setPassword("12345");
        User result = ms.updateUser(t);
        logger.debug("result : " + result);
        Assert.assertThat(expResult, Is.is(IsNot.not(result)));
    }

    /**
     * Test of findUser method, of class UserDDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFindUser() throws Exception {
        logger.debug("findUser");
        User expResult = null;
        User result = ms.findUser(t.getId());
        Assert.assertThat(expResult, Is.is(IsNot.not(result)));
    }

    /**
     * Test of findAll method, of class UserDDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testFindAll() throws Exception {
        logger.debug("findAll");
        List<User> expResult = null;
        List<User> result = ms.findAll();
        logger.debug("result size : " + result.size());
        Assert.assertThat(expResult, Is.is(IsNot.not(result)));
    }

    /**
     * Test of deleteUser method, of class UserDDaoImpl.
     *
     * @throws java.lang.Exception
     */
    @Test
    public void testDeleteUser() throws Exception {
        logger.debug("deleteUser");
        boolean expResult = false;
        boolean result = ms.deleteUser(t);
        logger.debug("result : " + result);
        Assert.assertThat(expResult, Is.is(IsNot.not(result)));
    }
    
}

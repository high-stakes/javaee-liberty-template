package com.avatao.javaee;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@Dependent
public class Message {

    @Inject
    EntityDao entityDao;

    public String read() {
        entityDao.update("message", "Hello World!");
        return entityDao.read("message").getName();
    }
}
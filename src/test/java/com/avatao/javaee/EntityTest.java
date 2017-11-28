package com.avatao.javaee;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@RunWith(Arquillian.class)
public class EntityTest {
    
    @Deployment
    public static WebArchive createDeployment() {
        WebArchive war =  ShrinkWrap.create(WebArchive.class, "test.war")
            .addClass(Message.class)
            .addClass(Entity.class)
            .addClass(EntityDao.class)
            .addAsResource(new File("src/main/resources/META-INF/persistence.xml"), "META-INF/persistence.xml")
            .addAsResource(new File("src/main/resources/META-INF/beans.xml"), "META-INF/beans.xml");
        return war;
    }

    @Test
    public void shouldPingWebresource(Message message) throws IOException {
        Assert.assertEquals(message.read(), "Hello World!");
    }
}
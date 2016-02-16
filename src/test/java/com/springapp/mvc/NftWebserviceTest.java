package com.springapp.mvc;

import com.springapp.mvc.orm.NfcScanEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by russellmilburn on 29/06/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public class NftWebserviceTest
{
    private MockMvc mockMvc;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    protected WebApplicationContext wac;

    @Autowired
    protected EntityManagerFactory localEntityManagerFactoryBean;

    @Autowired
    MockHttpSession session;


    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
    }

    @Test
    public void testNfdDBController() throws Exception
    {
        String uid = "9876543210";
        String product_code = "product_a";

        //this.mockMvc.perform(get("/service/nfc/scan/{uid}", uid).session(session)).andExpect(status().is(204));

        mockMvc.perform(get("/service/nfc/{uid}/{product_code}", uid, product_code))
            .andExpect(status().isOk());


//        assertNotNull(localEntityManagerFactoryBean);
//        EntityManager entityManager = localEntityManagerFactoryBean.createEntityManager();
//        assertNotNull(entityManager);
//        entityManager.getTransaction().begin();
//
//        NfcScanEntity scan = new NfcScanEntity();
//        scan.setNfcUid(uid);
//        scan.setScanDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
//        entityManager.persist(scan);
//        entityManager.getTransaction().commit();
//        entityManager.close();





    }
}

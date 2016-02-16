package com.springapp.mvc;

import com.springapp.mvc.orm.NfcScanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.logging.Logger;

/**
 * Created by russellmilburn on 28/06/15.
 */
@RestController
@RequestMapping(value = "/service/nfc")
public class NfcDatabaseController
{
    @Autowired
    private NfcScanRepository nfcScanRepository;

    @Autowired
    private LocalEntityManagerFactoryBean localEntityManagerFactoryBean;


    @RequestMapping(method = RequestMethod.GET)
    public void printWelcome()
    {

    }

    @RequestMapping(value = "/{uid}/{product_code}", method = RequestMethod.GET)
    @Transactional
    public String addScan(@PathVariable String uid, @PathVariable String product_code)
    {

        EntityManager entityManager = localEntityManagerFactoryBean.getNativeEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        NfcScanEntity scan = new NfcScanEntity();
        scan.setNfcUid(uid);
        scan.setProductCode(product_code);
        scan.setScanDate(new Timestamp(Calendar.getInstance().getTimeInMillis()));
        entityManager.persist(scan);
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "true";
    }
}

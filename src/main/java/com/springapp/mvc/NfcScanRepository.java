package com.springapp.mvc;

import com.springapp.mvc.orm.NfcScanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by russellmilburn on 27/06/15.
 */
public interface NfcScanRepository extends JpaRepository<NfcScanEntity, Long>
{

}

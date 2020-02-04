package com.gx.soft.sys.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.sys.persistence.domain.PeripheralMatching;
import org.springframework.stereotype.Service;


@Service("peripheralMatchingManager")
public class PeripheralMatchingManager extends HibernateEntityDao<PeripheralMatching>{

}

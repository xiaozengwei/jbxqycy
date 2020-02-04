package com.gx.soft.sd.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.soft.sd.persistence.domain.DeviceOnAndOff;
import org.springframework.stereotype.Service;

@Service("deviceOnAndOffManager")
public class DeviceOnAndOffManager extends HibernateEntityDao<DeviceOnAndOff> {
}

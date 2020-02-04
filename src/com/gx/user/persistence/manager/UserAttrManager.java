package com.gx.user.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.user.persistence.domain.UserAttr;


import org.springframework.stereotype.Service;

@Service
public class UserAttrManager extends HibernateEntityDao<UserAttr> {
}

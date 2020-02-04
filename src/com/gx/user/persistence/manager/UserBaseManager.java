package com.gx.user.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.user.persistence.domain.UserBase;


import org.springframework.stereotype.Service;

@Service
public class UserBaseManager extends HibernateEntityDao<UserBase> {
}

package com.gx.user.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.user.persistence.domain.UserSchema;


import org.springframework.stereotype.Service;

@Service
public class UserSchemaManager extends HibernateEntityDao<UserSchema> {
}

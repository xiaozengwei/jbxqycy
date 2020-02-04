package com.gx.user.persistence.manager;

import com.gx.core.hibernate.HibernateEntityDao;
import com.gx.user.persistence.domain.UserRepo;


import org.springframework.stereotype.Service;

@Service
public class UserRepoManager extends HibernateEntityDao<UserRepo> {
}

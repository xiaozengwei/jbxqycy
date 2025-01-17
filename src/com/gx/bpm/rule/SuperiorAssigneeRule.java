package com.gx.bpm.rule;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.gx.api.org.OrgConnector;
import com.gx.core.spring.ApplicationContextHelper;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.dao.EmptyResultDataAccessException;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 获得指定用户的上级领导.
 * 
 */
public class SuperiorAssigneeRule implements AssigneeRule {
    private static Logger logger = LoggerFactory
            .getLogger(SuperiorAssigneeRule.class);
    private OrgConnector orgConnector;

    public List<String> process(String value, String initiator) {
        return Collections.singletonList(this.process(initiator));
    }

    /**
     * 获得员工的直接上级.
     */
    public String process(String initiator) {
        if (orgConnector == null) {
            orgConnector = ApplicationContextHelper.getBean(OrgConnector.class);
        }

        return orgConnector.getSuperiorId(initiator);
    }
}

package com.gx.bpm.rule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.gx.api.org.OrgConnector;
import com.gx.core.spring.ApplicationContextHelper;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 获得部门最接近的对应的岗位的人的信息.
 * 
 */
public class PositionAssigneeRule implements AssigneeRule {
    private static Logger logger = LoggerFactory
            .getLogger(PositionAssigneeRule.class);
    private JdbcTemplate jdbcTemplate;
    private OrgConnector orgConnector;

    public List<String> process(String value, String initiator) {
        return ApplicationContextHelper.getBean(OrgConnector.class)
                .getPositionUserIds(initiator, value);
    }

    public String process(String initiator) {
        return null;
    }
}

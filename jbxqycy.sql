/*
Navicat MySQL Data Transfer

Source Server         : watch.njitrip.cn
Source Server Version : 50624
Source Host           : watch.njitrip.cn:3306
Source Database       : jbxqycy

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2020-02-04 15:49:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for attachment
-- ----------------------------
DROP TABLE IF EXISTS `attachment`;
CREATE TABLE `attachment` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `relation_id` varchar(40) DEFAULT NULL COMMENT '关联ID',
  `attach_name` varchar(200) DEFAULT NULL COMMENT '附件名称',
  `attach_type` varchar(40) DEFAULT NULL COMMENT '附件类型',
  `attach_file_identify_name` varchar(200) DEFAULT NULL COMMENT '文件上传保存名',
  `attach_path` varchar(200) DEFAULT NULL COMMENT '保存路径',
  `upload_user_id` varchar(40) DEFAULT NULL COMMENT '上传人ID',
  `upload_user_name` varchar(40) DEFAULT NULL COMMENT '上传人姓名',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='附件表';

-- ----------------------------
-- Table structure for check_out_amount_record
-- ----------------------------
DROP TABLE IF EXISTS `check_out_amount_record`;
CREATE TABLE `check_out_amount_record` (
  `row_id` varchar(80) NOT NULL COMMENT 'UUID',
  `room_name` varchar(80) DEFAULT NULL COMMENT '房间号',
  `user_name` varchar(80) DEFAULT NULL COMMENT '人名',
  `user_id_card` varchar(80) DEFAULT NULL COMMENT '身份证',
  `user_phone` varchar(80) DEFAULT NULL COMMENT '手机',
  `electric_balance` varchar(80) DEFAULT NULL COMMENT '电余额',
  `water_money` varchar(80) DEFAULT NULL COMMENT '水费用',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `status` varchar(80) DEFAULT NULL COMMENT '状态 0/已退款 1/未退款 2/欠费 3/已补',
  `refund_money` varchar(80) DEFAULT NULL COMMENT '退金额 / 补金额',
  `ext` varchar(255) DEFAULT NULL,
  `ext2` varchar(255) DEFAULT NULL,
  `ext3` date DEFAULT NULL,
  PRIMARY KEY (`row_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for check_out_room
-- ----------------------------
DROP TABLE IF EXISTS `check_out_room`;
CREATE TABLE `check_out_room` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `room_id` varchar(40) DEFAULT NULL COMMENT '房间号',
  `wx_user_id` varchar(40) DEFAULT NULL COMMENT '微信openid',
  `user_name` varchar(40) DEFAULT NULL COMMENT '姓名',
  `user_id_card` varchar(40) DEFAULT NULL COMMENT '身份证号',
  `user_phone` varchar(40) DEFAULT NULL COMMENT '手机号',
  `electric_balance` double DEFAULT NULL COMMENT '电费余额',
  `water_balance` double DEFAULT NULL COMMENT '水费余额',
  `water_number_one` double DEFAULT NULL COMMENT '当前水表数值，表1',
  `water_number_two` double DEFAULT NULL COMMENT '当前水表数值，表2',
  `cb_time` date DEFAULT NULL COMMENT '抄表时间',
  `last_water_number_one` double DEFAULT NULL COMMENT '上次水表数值，表1',
  `last_water_number_two` double DEFAULT NULL COMMENT '上次水表数值，表2',
  `last_cb_time` date DEFAULT NULL COMMENT '上次抄表时间',
  `water_use` double DEFAULT NULL COMMENT '水费使用量',
  `refund_money` double DEFAULT NULL COMMENT '退款金额',
  `back_money` double DEFAULT NULL COMMENT '补缴费用',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `data_type` varchar(40) DEFAULT NULL,
  `data_status` varchar(40) DEFAULT NULL,
  `data_order` varchar(40) DEFAULT NULL,
  `data_delete` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for device_on_and_off
-- ----------------------------
DROP TABLE IF EXISTS `device_on_and_off`;
CREATE TABLE `device_on_and_off` (
  `device_id` varchar(80) NOT NULL,
  `on_and_off` varchar(80) DEFAULT NULL COMMENT '1是通/2是断',
  `action_time` datetime DEFAULT NULL COMMENT '更新时间',
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for electric_day_record
-- ----------------------------
DROP TABLE IF EXISTS `electric_day_record`;
CREATE TABLE `electric_day_record` (
  `device_id` varchar(80) NOT NULL COMMENT '电表id',
  `total_energy` varchar(80) DEFAULT NULL COMMENT '实时电量',
  `tip_energy` varchar(80) DEFAULT NULL COMMENT '尖',
  `peak_energy` varchar(80) DEFAULT NULL COMMENT '峰',
  `valley_energy` varchar(80) DEFAULT NULL COMMENT '谷',
  `flat_energy` varchar(80) DEFAULT NULL COMMENT '平',
  `balance` varchar(80) DEFAULT NULL COMMENT '余额',
  `time` date DEFAULT NULL COMMENT '时间',
  `time_local_record` datetime DEFAULT NULL COMMENT '记录本地时间',
  `ext` varchar(80) DEFAULT NULL,
  `ext2` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for electric_every_day_record
-- ----------------------------
DROP TABLE IF EXISTS `electric_every_day_record`;
CREATE TABLE `electric_every_day_record` (
  `row_id` varchar(80) NOT NULL,
  `device_id` varchar(80) DEFAULT NULL COMMENT '电表id',
  `total_energy_start` varchar(80) DEFAULT NULL COMMENT '开始总值',
  `total_energy_end` varchar(80) DEFAULT NULL COMMENT '结束总值',
  `tip_energy` varchar(80) DEFAULT NULL COMMENT '尖',
  `peak_energy` varchar(80) DEFAULT NULL COMMENT '峰',
  `valley_energy` varchar(80) DEFAULT NULL COMMENT '谷',
  `flat_energy` varchar(80) DEFAULT NULL COMMENT '平',
  `balance` varchar(80) DEFAULT NULL COMMENT '余额',
  `time` date DEFAULT NULL COMMENT '时间(日)',
  `local_record_time` datetime DEFAULT NULL COMMENT '记录时间',
  `ext` varchar(80) DEFAULT NULL,
  `ext2` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for electric_history_record
-- ----------------------------
DROP TABLE IF EXISTS `electric_history_record`;
CREATE TABLE `electric_history_record` (
  `row_id` varchar(80) NOT NULL,
  `device_id` varchar(80) DEFAULT NULL COMMENT '电表id',
  `total_energy` varchar(80) DEFAULT NULL COMMENT '实时总电量',
  `tip_energy` varchar(80) DEFAULT NULL COMMENT '尖',
  `peak_energy` varchar(80) DEFAULT NULL COMMENT '峰',
  `valley_energy` varchar(80) DEFAULT NULL COMMENT '谷',
  `flat_energy` varchar(80) DEFAULT NULL COMMENT '平',
  `balance` varchar(80) DEFAULT NULL COMMENT '余额',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `time_local_record` datetime DEFAULT NULL COMMENT '记录时间',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for electric_month_record
-- ----------------------------
DROP TABLE IF EXISTS `electric_month_record`;
CREATE TABLE `electric_month_record` (
  `row_id` varchar(80) NOT NULL,
  `device_id` varchar(80) DEFAULT NULL,
  `month_energy` varchar(80) DEFAULT NULL,
  `total_energy_start` varchar(80) DEFAULT NULL,
  `total_energy_end` varchar(80) DEFAULT NULL,
  `tip_energy` varchar(80) DEFAULT NULL,
  `peak_energy` varchar(80) DEFAULT NULL,
  `valley_energy` varchar(80) DEFAULT NULL,
  `flat_energy` varchar(80) DEFAULT NULL,
  `balance` varchar(80) DEFAULT NULL,
  `time` varchar(80) DEFAULT NULL,
  `ext` varchar(80) DEFAULT NULL,
  `ext2` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`row_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for electric_water_reduction
-- ----------------------------
DROP TABLE IF EXISTS `electric_water_reduction`;
CREATE TABLE `electric_water_reduction` (
  `row_id` varchar(80) NOT NULL,
  `time` datetime DEFAULT NULL COMMENT '时间',
  `device_id` varchar(80) DEFAULT NULL COMMENT '设备id',
  `room_name` varchar(80) DEFAULT NULL COMMENT '房间号',
  `money` varchar(80) DEFAULT NULL COMMENT '扣金额',
  `user_id` varchar(80) DEFAULT NULL COMMENT '操作人',
  `type` varchar(80) DEFAULT NULL COMMENT '0/电，1/水',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for enterprise_info
-- ----------------------------
DROP TABLE IF EXISTS `enterprise_info`;
CREATE TABLE `enterprise_info` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `enterprise_name` varchar(100) DEFAULT NULL COMMENT '企业名称',
  `enterprise_id` varchar(40) DEFAULT NULL COMMENT '账号',
  `password` varchar(40) DEFAULT NULL COMMENT '密码',
  `create_user_id` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `is_first` varchar(40) DEFAULT NULL COMMENT '是否首次登录',
  `org_tyshxydm` varchar(40) DEFAULT NULL COMMENT '统一社会信用代码',
  `org_address` varchar(100) DEFAULT NULL COMMENT '地址',
  `floor_num` int(11) DEFAULT NULL COMMENT '所在楼层',
  `enterprise_type` varchar(40) DEFAULT NULL COMMENT '企业类型',
  `contact_name` varchar(40) DEFAULT NULL COMMENT '联系人姓名',
  `contact_phone` varchar(40) DEFAULT NULL COMMENT '联系电话',
  `business_license` varchar(40) DEFAULT NULL COMMENT '营业执照',
  `legal_person` varchar(40) DEFAULT NULL COMMENT '法人',
  `data_status` varchar(40) DEFAULT NULL,
  `data_type` varchar(40) DEFAULT NULL,
  `data_order` int(11) DEFAULT NULL,
  `data_delete` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for floor_room
-- ----------------------------
DROP TABLE IF EXISTS `floor_room`;
CREATE TABLE `floor_room` (
  `row_id` varchar(11) NOT NULL,
  `row_name` varchar(80) DEFAULT NULL,
  `p_floor_id` varchar(11) DEFAULT NULL,
  `p_floor_name` varchar(80) DEFAULT NULL,
  `floor_type` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for floor_room_in_device
-- ----------------------------
DROP TABLE IF EXISTS `floor_room_in_device`;
CREATE TABLE `floor_room_in_device` (
  `room_id` varchar(80) NOT NULL COMMENT '房间id',
  `room_name` varchar(80) DEFAULT NULL COMMENT '房间名',
  `device_id` varchar(80) DEFAULT NULL COMMENT '电表id',
  `device_name` varchar(80) DEFAULT NULL COMMENT '电表别名',
  `start_date` datetime DEFAULT NULL COMMENT '设置时间',
  `settle_type_out` varchar(80) DEFAULT NULL COMMENT '预付费1/后付费2',
  `settle_type_name` varchar(80) DEFAULT NULL,
  `ext` varchar(80) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `ext2` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`room_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for gx_sys_dic_index
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_dic_index`;
CREATE TABLE `gx_sys_dic_index` (
  `ROW_ID` varchar(40) NOT NULL DEFAULT '',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建日期',
  `CREATE_USER_ID` varchar(40) DEFAULT NULL COMMENT '创建用户id',
  `DIC_FUNCTION_NAME` varchar(80) DEFAULT NULL COMMENT '索引名称',
  `DIC_FUNCTION_ID` varchar(40) DEFAULT NULL COMMENT '索引功能ID',
  `DIC_FUNCTION_DEC` varchar(220) DEFAULT NULL COMMENT '索引显示内容',
  `DIC_FUNCTION_TYPE` varchar(10) DEFAULT NULL COMMENT '索引类型',
  `STATUS` varchar(10) DEFAULT NULL COMMENT '字典状态',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '最后更新时间',
  `ORDER_NUM` bigint(22) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`ROW_ID`),
  UNIQUE KEY `PK_SYS_DIC_INDEX` (`ROW_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_sys_dic_record
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_dic_record`;
CREATE TABLE `gx_sys_dic_record` (
  `ROW_ID` varchar(40) NOT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `CREATE_USER_ID` varchar(40) DEFAULT NULL,
  `DIC_NAME` varchar(100) DEFAULT NULL,
  `DIC_ID` varchar(40) DEFAULT NULL,
  `DIC_SHOW_VAL` varchar(1000) DEFAULT NULL,
  `DIC_VALUE` int(11) DEFAULT NULL,
  `DIC_TYPE` varchar(100) DEFAULT NULL,
  `STATUS` varchar(10) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `ORDER_NUM` bigint(22) DEFAULT NULL,
  `DIC_FUNCTION` varchar(10) DEFAULT NULL,
  `TABLE_ID` varchar(32) DEFAULT NULL,
  `PARENT_ID` varchar(40) DEFAULT NULL,
  `PARENT_NAME` varchar(40) DEFAULT NULL,
  `FLAG_ZM` varchar(40) DEFAULT NULL,
  `FLAG_RQ` varchar(40) DEFAULT NULL,
  `FLAG_NUM` varchar(40) DEFAULT NULL,
  `FLAG_WRITE` varchar(40) DEFAULT NULL,
  `max_status` varchar(40) DEFAULT NULL COMMENT '是否启用最大值配置（1启用，0否）',
  `max_id` varchar(40) DEFAULT NULL COMMENT '最大值的ID',
  PRIMARY KEY (`ROW_ID`),
  UNIQUE KEY `PK_SYS_DIC_RECORD` (`ROW_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for gx_sys_function
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_function`;
CREATE TABLE `gx_sys_function` (
  `row_id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `function_name` varchar(80) NOT NULL COMMENT '菜单名称',
  `function_show_name` varchar(180) DEFAULT NULL COMMENT '菜单显示名称',
  `function_en_name` varchar(580) DEFAULT NULL COMMENT '菜单英文名称',
  `function_intro` varchar(40) DEFAULT NULL COMMENT '菜单说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` bigint(11) DEFAULT NULL COMMENT '排序',
  `parent_function_id` varchar(40) DEFAULT NULL COMMENT '父菜单ID',
  `parent_function_name` varchar(80) DEFAULT NULL COMMENT '父菜单名称',
  `function_type` varchar(40) DEFAULT NULL COMMENT '菜单类别',
  `is_main_page` varchar(40) DEFAULT NULL COMMENT '是否为为主页图标',
  `function_icon` varchar(80) DEFAULT NULL COMMENT '菜单图标',
  `main_page_icon` varchar(40) DEFAULT NULL COMMENT '主页图标',
  `main_function_name` varchar(80) DEFAULT NULL COMMENT '主页显示名称',
  `main_order` int(11) DEFAULT NULL COMMENT '主页排序位',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3470 DEFAULT CHARSET=utf8 COMMENT='系统权限菜单表';

-- ----------------------------
-- Table structure for gx_sys_function_bf
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_function_bf`;
CREATE TABLE `gx_sys_function_bf` (
  `row_id` bigint(40) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `function_name` varchar(80) NOT NULL COMMENT '菜单名称',
  `function_show_name` varchar(180) DEFAULT NULL COMMENT '菜单显示名称',
  `function_en_name` varchar(580) DEFAULT NULL COMMENT '菜单英文名称',
  `function_intro` varchar(40) DEFAULT NULL COMMENT '菜单说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` bigint(11) DEFAULT NULL COMMENT '排序',
  `parent_function_id` varchar(40) DEFAULT NULL COMMENT '父菜单ID',
  `parent_function_name` varchar(80) DEFAULT NULL COMMENT '父菜单名称',
  `function_type` varchar(40) DEFAULT NULL COMMENT '菜单类别',
  `is_main_page` varchar(40) DEFAULT NULL COMMENT '是否为为主页图标',
  `function_icon` varchar(80) DEFAULT NULL COMMENT '菜单图标',
  `main_page_icon` varchar(40) DEFAULT NULL COMMENT '主页图标',
  `main_function_name` varchar(80) DEFAULT NULL COMMENT '主页显示名称',
  `main_order` int(11) DEFAULT NULL COMMENT '主页排序位',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3469 DEFAULT CHARSET=utf8 COMMENT='系统权限菜单表';

-- ----------------------------
-- Table structure for gx_sys_org
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_org`;
CREATE TABLE `gx_sys_org` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `org_name` varchar(80) DEFAULT NULL COMMENT '组织名称',
  `org_show_name` varchar(180) DEFAULT NULL COMMENT '组织显示名称',
  `org_en_name` varchar(80) DEFAULT NULL COMMENT '菜单英文名称',
  `org_intro` varchar(40) DEFAULT NULL COMMENT '组织说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` bigint(11) DEFAULT NULL COMMENT '排序',
  `parent_org_id` varchar(40) DEFAULT NULL COMMENT '父组织ID',
  `parent_org_name` varchar(80) DEFAULT NULL COMMENT '父组织名称',
  `org_type` varchar(40) DEFAULT NULL COMMENT '组织类别',
  `is_main_page` varchar(40) DEFAULT NULL COMMENT '是否为虚拟组织',
  `org_com_id` varchar(40) DEFAULT NULL COMMENT '组织所属单位ID',
  `is_show` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统组织单位';

-- ----------------------------
-- Table structure for gx_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_role`;
CREATE TABLE `gx_sys_role` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `role_name` varchar(80) DEFAULT NULL COMMENT '角色名称',
  `role_id` varchar(80) DEFAULT NULL COMMENT '角色ID',
  `role_intro` varchar(40) DEFAULT NULL COMMENT '角色说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` bigint(11) DEFAULT NULL COMMENT '排序',
  `parent_role_id` varchar(40) DEFAULT NULL COMMENT '父角色ID',
  `parent_role_name` varchar(80) DEFAULT NULL COMMENT '父角色名称',
  `role_type` varchar(40) DEFAULT NULL COMMENT '角色类别',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色';

-- ----------------------------
-- Table structure for gx_sys_role_has_function
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_role_has_function`;
CREATE TABLE `gx_sys_role_has_function` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `function_id` bigint(80) NOT NULL COMMENT '菜单ID',
  `role_id` varchar(80) NOT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` bigint(11) DEFAULT NULL COMMENT '排序',
  `rl_type` varchar(40) DEFAULT NULL COMMENT '关系类别',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统角色与权限关系表（注意关系表不存在更新操作）';

-- ----------------------------
-- Table structure for gx_sys_role_has_user
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_role_has_user`;
CREATE TABLE `gx_sys_role_has_user` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `user_id` varchar(80) NOT NULL COMMENT '用户ID',
  `role_id` varchar(80) NOT NULL COMMENT '角色ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` bigint(11) DEFAULT NULL COMMENT '排序',
  `rl_type` varchar(40) DEFAULT NULL COMMENT '关系类别',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统人员与角色关系表（注意关系表不存在更新操作）';

-- ----------------------------
-- Table structure for gx_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_user`;
CREATE TABLE `gx_sys_user` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `user_name` varchar(80) DEFAULT NULL COMMENT '用户名称',
  `user_show_name` varchar(180) DEFAULT NULL COMMENT '用户别名',
  `user_en_name` varchar(80) DEFAULT NULL COMMENT '用户英文名称',
  `user_id` varchar(40) DEFAULT NULL COMMENT '用户帐号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `data_status` varchar(100) DEFAULT NULL COMMENT '状态',
  `data_order` int(11) DEFAULT NULL COMMENT '排序',
  `user_mobile_num` varchar(40) DEFAULT NULL COMMENT '手机号',
  `user_sex` varchar(80) DEFAULT NULL COMMENT '性别',
  `user_type` varchar(40) DEFAULT NULL COMMENT '用户类型',
  `user_photo` varchar(80) DEFAULT NULL COMMENT '用户头像',
  `user_mail` varchar(80) DEFAULT NULL COMMENT '邮件',
  `user_level` varchar(80) DEFAULT NULL COMMENT '学历',
  `power_level` int(11) DEFAULT NULL COMMENT '用户鉴权级别',
  `user_card_id` varchar(80) DEFAULT NULL COMMENT '身份证',
  `sys_color_id` varchar(80) DEFAULT NULL COMMENT '系统皮肤',
  PRIMARY KEY (`row_id`),
  KEY `gxsysuseri1` (`row_id`,`user_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统用户';

-- ----------------------------
-- Table structure for gx_sys_user_in_org
-- ----------------------------
DROP TABLE IF EXISTS `gx_sys_user_in_org`;
CREATE TABLE `gx_sys_user_in_org` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `user_id` varchar(80) NOT NULL COMMENT '用户ID',
  `org_id` varchar(80) NOT NULL COMMENT '组织ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建者ID',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` int(11) DEFAULT NULL COMMENT '排序',
  `rl_type` varchar(40) DEFAULT NULL COMMENT '关系类别',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统组织与人员关系表（注意关系表不存在更新操作）';

-- ----------------------------
-- Table structure for gzh_article
-- ----------------------------
DROP TABLE IF EXISTS `gzh_article`;
CREATE TABLE `gzh_article` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `column_title` varchar(40) DEFAULT NULL COMMENT '栏目标题',
  `column_context` varchar(1000) DEFAULT NULL COMMENT '栏目内容',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '创建人姓名',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `modify_user_name` varchar(40) DEFAULT NULL COMMENT '修改人姓名',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公众号文章栏目表';

-- ----------------------------
-- Table structure for history_opinion
-- ----------------------------
DROP TABLE IF EXISTS `history_opinion`;
CREATE TABLE `history_opinion` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `table_id` varchar(40) DEFAULT NULL COMMENT '关联业务表ID',
  `pi_id` varchar(40) DEFAULT NULL COMMENT '流程实例ID',
  `handle_stage` varchar(40) DEFAULT NULL COMMENT '办理阶段名称',
  `handle_process` varchar(40) DEFAULT NULL COMMENT '办理过程',
  `handle_user` varchar(40) DEFAULT NULL COMMENT '办理人',
  `handle_time` datetime DEFAULT NULL COMMENT '办理时间',
  `handle_opinion` varchar(200) DEFAULT NULL COMMENT '办理意见',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` int(11) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for holiday_record
-- ----------------------------
DROP TABLE IF EXISTS `holiday_record`;
CREATE TABLE `holiday_record` (
  `row_id` varchar(40) NOT NULL,
  `day_no` varchar(40) DEFAULT NULL,
  `holiday` varchar(40) DEFAULT NULL,
  `year` varchar(40) DEFAULT NULL,
  `data_status` varchar(40) DEFAULT NULL,
  `data_type` varchar(40) DEFAULT NULL,
  `data_order` int(11) DEFAULT NULL,
  `data_delete` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for hys_zzfw
-- ----------------------------
DROP TABLE IF EXISTS `hys_zzfw`;
CREATE TABLE `hys_zzfw` (
  `row_id` varchar(40) NOT NULL,
  `relation_id` varchar(40) DEFAULT NULL COMMENT '关联表ID',
  `tea_num` int(11) DEFAULT NULL COMMENT '茶水数量',
  `water_num` int(11) DEFAULT NULL COMMENT '矿泉水数量',
  `artisan_num` int(11) DEFAULT NULL COMMENT '信息化技术人员数量',
  `ceremony_num` int(11) DEFAULT NULL COMMENT '礼仪服务数量',
  `mat_num` int(11) DEFAULT NULL COMMENT '席卡数量',
  `print_num` int(11) DEFAULT NULL COMMENT '打印数量',
  `cx_luxury_num` int(11) DEFAULT NULL COMMENT '茶歇豪华数量',
  `cx_high_num` int(11) DEFAULT NULL COMMENT '茶歇高档数量',
  `cx_routine_num` int(11) DEFAULT NULL COMMENT '茶歇常规数量',
  `create_user_id` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_user_id` varchar(40) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `data_type` varchar(40) DEFAULT NULL,
  `data_status` varchar(40) DEFAULT NULL,
  `data_delete` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for inside_user
-- ----------------------------
DROP TABLE IF EXISTS `inside_user`;
CREATE TABLE `inside_user` (
  `row_id` varchar(40) NOT NULL,
  `mobile_phone` varchar(40) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for meeting_room_info
-- ----------------------------
DROP TABLE IF EXISTS `meeting_room_info`;
CREATE TABLE `meeting_room_info` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `build_area` varchar(40) DEFAULT NULL COMMENT '建筑面积',
  `length_width` varchar(40) DEFAULT NULL COMMENT '长度*宽度',
  `screen_size` varchar(40) DEFAULT NULL COMMENT '屏幕尺寸',
  `resolution` varchar(40) DEFAULT NULL COMMENT '分辨率',
  `site_fee_all` int(11) DEFAULT NULL COMMENT '场地费（全天）',
  `site_fee_half` int(11) DEFAULT NULL COMMENT '场地费（半天）',
  `park_lz_all` int(11) DEFAULT NULL COMMENT '园区六折（全天）',
  `park_lz_half` int(11) DEFAULT NULL COMMENT '园区六折（半天）',
  `capacity_kzs` varchar(40) DEFAULT NULL,
  `capacity_jys` varchar(40) DEFAULT NULL,
  `capacity_ux` varchar(40) DEFAULT NULL,
  `room_name` varchar(40) DEFAULT NULL COMMENT '会议室名称',
  `room_address` varchar(120) DEFAULT NULL COMMENT '地址',
  `room_number` varchar(40) DEFAULT NULL COMMENT '房间号',
  `room_building` int(11) DEFAULT NULL COMMENT '多少栋',
  `room_floor` int(11) DEFAULT NULL COMMENT '楼层数',
  `room_status` varchar(40) DEFAULT NULL COMMENT '会议室状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会议室信息表';

-- ----------------------------
-- Table structure for meeting_room_lease_apply
-- ----------------------------
DROP TABLE IF EXISTS `meeting_room_lease_apply`;
CREATE TABLE `meeting_room_lease_apply` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `applicant_name` varchar(40) DEFAULT NULL COMMENT '姓名',
  `applicant_phone` varchar(40) DEFAULT NULL COMMENT '手机号',
  `applicant_id_card` varchar(40) DEFAULT NULL COMMENT '身份证',
  `company_name` varchar(40) DEFAULT NULL COMMENT '公司名称',
  `start_time` datetime DEFAULT NULL COMMENT '会议开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '会议结束时间',
  `selected_room` varchar(40) DEFAULT NULL COMMENT '选择会议室',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '创建人姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `modify_user_name` varchar(40) DEFAULT NULL COMMENT '修改人姓名',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会议室租赁申请表';

-- ----------------------------
-- Table structure for meeting_room_use_info
-- ----------------------------
DROP TABLE IF EXISTS `meeting_room_use_info`;
CREATE TABLE `meeting_room_use_info` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `room_id` varchar(40) DEFAULT NULL COMMENT '会议室ID',
  `start_time` datetime DEFAULT NULL COMMENT '使用开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '使用结束时间',
  `business_id` varchar(40) DEFAULT NULL COMMENT '申请表ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会议室使用情况表';

-- ----------------------------
-- Table structure for one_card_apply
-- ----------------------------
DROP TABLE IF EXISTS `one_card_apply`;
CREATE TABLE `one_card_apply` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `applicant_name` varchar(40) DEFAULT NULL COMMENT '申请人姓名',
  `applicant_phone` varchar(40) DEFAULT NULL COMMENT '申请人手机号',
  `identity_document` varchar(40) DEFAULT NULL COMMENT '身份证件',
  `applicant_id_card` varchar(40) DEFAULT NULL COMMENT '申请人身份证',
  `company_name` varchar(40) DEFAULT NULL COMMENT '公司名称',
  `receive_place` varchar(40) DEFAULT NULL COMMENT '领取点位置',
  `verification_code` varchar(40) DEFAULT NULL COMMENT '验证码',
  `card_number` int(11) DEFAULT NULL COMMENT '办卡数目',
  `pay_money` int(11) DEFAULT NULL COMMENT '支付金额',
  `out_trade_no` varchar(40) DEFAULT NULL COMMENT '商户订单号',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '创建人姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `modify_user_name` varchar(40) DEFAULT NULL COMMENT '修改人姓名',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  `is_receive` varchar(40) DEFAULT NULL COMMENT '是否领取',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='一卡通自助申请表';

-- ----------------------------
-- Table structure for one_card_import_record
-- ----------------------------
DROP TABLE IF EXISTS `one_card_import_record`;
CREATE TABLE `one_card_import_record` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `file_name` varchar(100) DEFAULT NULL COMMENT '附件名称',
  `file_type` varchar(100) DEFAULT NULL COMMENT '附件类型',
  `file_identify_name` varchar(100) DEFAULT NULL COMMENT '附件上传后保存名',
  `file_path` varchar(100) DEFAULT NULL COMMENT '附件路径',
  `upload_user_id` varchar(40) DEFAULT NULL COMMENT '上传人ID',
  `upload_user_name` varchar(40) DEFAULT NULL COMMENT '上传人姓名',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_delete` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='附件记录表';

-- ----------------------------
-- Table structure for one_card_info
-- ----------------------------
DROP TABLE IF EXISTS `one_card_info`;
CREATE TABLE `one_card_info` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `card_number` varchar(40) DEFAULT NULL COMMENT '卡号',
  `card_holder` varchar(40) DEFAULT NULL COMMENT '持卡人',
  `password` varchar(40) DEFAULT NULL COMMENT '密码',
  `account_balance` varchar(40) DEFAULT NULL COMMENT '账户余额',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `account_status` varchar(40) DEFAULT NULL COMMENT '账户状态',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='一卡通信息表';

-- ----------------------------
-- Table structure for one_card_order
-- ----------------------------
DROP TABLE IF EXISTS `one_card_order`;
CREATE TABLE `one_card_order` (
  `row_id` varchar(40) NOT NULL,
  `out_trade_no` varchar(32) DEFAULT NULL COMMENT '商户订单号',
  `total_fee` int(11) DEFAULT NULL COMMENT '标价金额',
  `spbill_create_ip` varchar(40) DEFAULT NULL COMMENT '终端ip',
  `prepay_id` varchar(40) DEFAULT NULL COMMENT '预支付id',
  `openid` varchar(40) DEFAULT NULL COMMENT '用户标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `order_state` varchar(40) DEFAULT NULL COMMENT '订单状态',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_delete` varchar(40) DEFAULT NULL COMMENT '删除',
  `relation_id` varchar(40) DEFAULT NULL COMMENT '关联业务表主键',
  `recharge_type` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for one_card_person_detail
-- ----------------------------
DROP TABLE IF EXISTS `one_card_person_detail`;
CREATE TABLE `one_card_person_detail` (
  `row_id` varchar(40) NOT NULL,
  `relation_id` varchar(40) DEFAULT NULL,
  `user_name` varchar(40) DEFAULT NULL,
  `user_id_card` varchar(40) DEFAULT NULL,
  `user_phone` varchar(40) DEFAULT NULL,
  `create_user_id` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `data_type` varchar(40) DEFAULT NULL,
  `data_status` varchar(40) DEFAULT NULL,
  `data_order` int(11) DEFAULT NULL,
  `data_delete` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for one_card_solution
-- ----------------------------
DROP TABLE IF EXISTS `one_card_solution`;
CREATE TABLE `one_card_solution` (
  `row_id` varchar(80) NOT NULL,
  `card_num` varchar(80) DEFAULT NULL,
  `card_holder` varchar(80) DEFAULT NULL,
  `password` varchar(80) DEFAULT NULL,
  `account_balance` varchar(80) DEFAULT NULL,
  `create_time` varchar(80) DEFAULT NULL,
  `account_status` varchar(80) DEFAULT NULL,
  `user_id_card` varchar(80) DEFAULT NULL,
  `user_phone` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for peripheral_matching
-- ----------------------------
DROP TABLE IF EXISTS `peripheral_matching`;
CREATE TABLE `peripheral_matching` (
  `row_id` varchar(40) NOT NULL,
  `pt_name` varchar(40) DEFAULT NULL COMMENT '配套名称',
  `pt_address` varchar(120) DEFAULT NULL COMMENT '配套地址',
  `pt_detail` varchar(500) DEFAULT NULL COMMENT '配套详细',
  `create_user_id` varchar(40) DEFAULT NULL,
  `create_user_name` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `modify_user_id` varchar(40) DEFAULT NULL,
  `modify_user_name` varchar(40) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  `data_type` varchar(40) DEFAULT NULL,
  `data_status` varchar(40) DEFAULT NULL,
  `data_order` int(11) DEFAULT NULL,
  `data_delete` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for proc_act
-- ----------------------------
DROP TABLE IF EXISTS `proc_act`;
CREATE TABLE `proc_act` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `process_id` varchar(40) DEFAULT NULL COMMENT '关联流程模板表流程ID',
  `act_id` varchar(40) DEFAULT NULL COMMENT '节点ID',
  `act_name` varchar(40) DEFAULT NULL COMMENT '节点名称',
  `act_explain` varchar(240) DEFAULT NULL COMMENT '节点说明',
  `handle_user_name` varchar(40) DEFAULT NULL COMMENT '办理人',
  `handle_user_name1` varchar(40) DEFAULT NULL COMMENT '预备办理人',
  `back_act` varchar(40) DEFAULT NULL COMMENT '上一步',
  `next_act` varchar(40) DEFAULT NULL COMMENT '下一步',
  `act_order` decimal(8,0) DEFAULT NULL COMMENT '顺序',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_deleted` varchar(40) DEFAULT '1' COMMENT '删除状态',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='流程节点表';

-- ----------------------------
-- Table structure for proc_act_instance
-- ----------------------------
DROP TABLE IF EXISTS `proc_act_instance`;
CREATE TABLE `proc_act_instance` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `process_id` varchar(40) DEFAULT NULL COMMENT '关联流程模板表的流程ID ',
  `instance_id` varchar(40) DEFAULT NULL COMMENT '关联流程实例表流程实例ID',
  `business_id` varchar(40) DEFAULT NULL COMMENT '流程业务ID',
  `act_id` varchar(40) DEFAULT NULL COMMENT '关联流程节点表节点ID',
  `act_name` varchar(40) DEFAULT NULL COMMENT '流程节点名称',
  `handle_user` varchar(40) DEFAULT NULL COMMENT '办理人',
  `handle_user1` varchar(40) DEFAULT NULL COMMENT '预备办理人',
  `act_back` varchar(40) DEFAULT NULL COMMENT '上一步',
  `act_next` varchar(40) DEFAULT NULL COMMENT '下一步',
  `act_order` decimal(8,0) DEFAULT NULL COMMENT '顺序',
  `act_inst_remark` varchar(240) DEFAULT NULL COMMENT '备注',
  `active_state` varchar(40) DEFAULT NULL COMMENT '激活状态',
  `active_user_id` varchar(40) DEFAULT NULL COMMENT '激活人ID',
  `active_user_name` varchar(40) DEFAULT NULL COMMENT '激活人姓名',
  `active_time` datetime DEFAULT NULL COMMENT '激活（开始）时间',
  `finish_time` datetime DEFAULT NULL COMMENT '完成（结束）时间',
  `step_state` varchar(40) DEFAULT NULL COMMENT '节点状态',
  `time_limit` datetime DEFAULT NULL COMMENT '监督时限',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_deleted` varchar(40) DEFAULT '1' COMMENT '删除状态',
  PRIMARY KEY (`row_id`),
  KEY `流程实例ID` (`instance_id`) USING BTREE COMMENT '流程实例ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='流程节点实例表';

-- ----------------------------
-- Table structure for proc_instance
-- ----------------------------
DROP TABLE IF EXISTS `proc_instance`;
CREATE TABLE `proc_instance` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `process_id` varchar(40) DEFAULT NULL COMMENT '关联流程模板表流程ID',
  `process_name` varchar(40) DEFAULT NULL COMMENT '流程名称',
  `business_id` varchar(40) DEFAULT NULL COMMENT '关联业务表ID',
  `instance_state` varchar(40) DEFAULT NULL COMMENT '流程实例状态',
  `active_state` varchar(40) DEFAULT NULL COMMENT '激活状态',
  `active_user_name` varchar(40) DEFAULT NULL COMMENT '激活人姓名',
  `time_limit` datetime DEFAULT NULL COMMENT '监督时限',
  `create_time` datetime DEFAULT NULL COMMENT '实例创建时间',
  `end_time` datetime DEFAULT NULL COMMENT '实例结束时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '创建人姓名',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` decimal(8,0) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT '1' COMMENT '删除状态',
  PRIMARY KEY (`row_id`),
  KEY `业务表ID` (`business_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='流程实例表';

-- ----------------------------
-- Table structure for proc_signature
-- ----------------------------
DROP TABLE IF EXISTS `proc_signature`;
CREATE TABLE `proc_signature` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `table_id` varchar(40) DEFAULT NULL COMMENT '业务表ID',
  `table_name` varchar(40) DEFAULT NULL COMMENT '业务表名称',
  `pi_id` varchar(40) DEFAULT NULL COMMENT '流程ID',
  `control_name` varchar(40) DEFAULT NULL COMMENT '意见NAME',
  `option_context` varchar(120) DEFAULT NULL COMMENT '意见内容',
  `create_id` varchar(40) DEFAULT NULL COMMENT '办理人ID',
  `create_name` varchar(40) DEFAULT NULL COMMENT '办理人名字',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '办理时间',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='流程意见表';

-- ----------------------------
-- Table structure for proc_template
-- ----------------------------
DROP TABLE IF EXISTS `proc_template`;
CREATE TABLE `proc_template` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `process_name` varchar(40) DEFAULT NULL COMMENT '流程名称',
  `process_key` varchar(40) DEFAULT NULL COMMENT '流程key',
  `process_id` varchar(40) DEFAULT NULL COMMENT '流程ID',
  `process_explain` varchar(240) DEFAULT NULL COMMENT '流程说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '创建人姓名',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `modify_user_name` varchar(40) DEFAULT NULL COMMENT '修改人姓名',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` decimal(8,0) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT '1' COMMENT '删除状态 0：删除 1：有效',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='审批流程模板表';

-- ----------------------------
-- Table structure for rcgy_info
-- ----------------------------
DROP TABLE IF EXISTS `rcgy_info`;
CREATE TABLE `rcgy_info` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `room_name` varchar(40) DEFAULT NULL COMMENT '房间名称',
  `room_number` varchar(40) DEFAULT NULL COMMENT '房间号',
  `room_type` varchar(40) DEFAULT NULL COMMENT '房间类型',
  `room_area` double DEFAULT NULL COMMENT '房间面积',
  `room_address` varchar(200) DEFAULT NULL COMMENT '房间地址',
  `room_status` varchar(40) DEFAULT NULL COMMENT '房间状态',
  `room_floor` int(11) DEFAULT NULL COMMENT '房间楼层',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='人才公寓信息表';

-- ----------------------------
-- Table structure for rcgy_lese_apply
-- ----------------------------
DROP TABLE IF EXISTS `rcgy_lese_apply`;
CREATE TABLE `rcgy_lese_apply` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `enterprise_name` varchar(120) DEFAULT NULL COMMENT '申请企业名称',
  `apply_date` date DEFAULT NULL COMMENT '申请日期',
  `enterprise_manager` varchar(40) DEFAULT NULL COMMENT '企业经办人',
  `contact_number` varchar(40) DEFAULT NULL COMMENT '联系电话',
  `apartment_type` varchar(40) DEFAULT NULL COMMENT '需求公寓类型',
  `apartment_number` int(11) DEFAULT NULL COMMENT '需求公寓数量',
  `is_accord_tzxyyd` varchar(40) DEFAULT NULL COMMENT '是否符合投资协议约定',
  `check_in_time` date DEFAULT NULL COMMENT '拟入住时间',
  `lease_term` varchar(40) DEFAULT NULL COMMENT '租赁期限',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '创建人姓名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `modify_user_name` varchar(40) DEFAULT NULL COMMENT '修改人姓名',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `date_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='人才公寓租赁申请表';

-- ----------------------------
-- Table structure for rcgy_model
-- ----------------------------
DROP TABLE IF EXISTS `rcgy_model`;
CREATE TABLE `rcgy_model` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `model_name` varchar(40) DEFAULT NULL COMMENT '样板间名称',
  `picture_name` varchar(200) DEFAULT NULL COMMENT '图片名称',
  `picture_identify_name` varchar(200) DEFAULT NULL COMMENT '图片保存名',
  `picture_address` varchar(200) DEFAULT NULL COMMENT '图片地址',
  `picture_remark` varchar(200) DEFAULT NULL COMMENT '图片说明',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='公寓样板间信息表';

-- ----------------------------
-- Table structure for scope_info
-- ----------------------------
DROP TABLE IF EXISTS `scope_info`;
CREATE TABLE `scope_info` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) DEFAULT NULL,
  `CODE` varchar(50) DEFAULT NULL,
  `REF` varchar(50) DEFAULT NULL,
  `SHARED` int(11) DEFAULT NULL,
  `USER_REPO_REF` varchar(50) DEFAULT NULL,
  `TYPE` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for sd_month_bill
-- ----------------------------
DROP TABLE IF EXISTS `sd_month_bill`;
CREATE TABLE `sd_month_bill` (
  `rowId` varchar(40) NOT NULL,
  `room_id` varchar(40) DEFAULT NULL COMMENT '一卡通ID',
  `water_device_id` varchar(40) DEFAULT NULL COMMENT '水设备ID',
  `electric_device_id` varchar(40) DEFAULT NULL COMMENT '电设备ID',
  `year` varchar(40) DEFAULT NULL COMMENT '年份',
  `month` varchar(40) DEFAULT NULL COMMENT '月份',
  `month_water_use` double DEFAULT NULL COMMENT '当月水消耗',
  `month_electric_use` double DEFAULT NULL COMMENT '当月电消耗',
  `history_water_use` double DEFAULT NULL COMMENT '历史水消耗',
  `history_electric_use` double DEFAULT NULL COMMENT '历史电消耗',
  `month_water_fee` double DEFAULT NULL COMMENT '当月水费',
  `month_electric_fee` double DEFAULT NULL COMMENT '当月电费',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_order` int(11) DEFAULT NULL COMMENT '排序',
  `data_delete` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`rowId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for sd_recharge_fail_record
-- ----------------------------
DROP TABLE IF EXISTS `sd_recharge_fail_record`;
CREATE TABLE `sd_recharge_fail_record` (
  `row_id` varchar(40) NOT NULL,
  `out_trade_no` varchar(40) DEFAULT NULL COMMENT '订单号',
  `room_id` varchar(40) DEFAULT NULL COMMENT '房间号',
  `device_id` varchar(40) DEFAULT NULL COMMENT '水电设备ID',
  `user_name` varchar(40) DEFAULT NULL COMMENT '姓名',
  `open_id` varchar(40) DEFAULT NULL COMMENT '微信公众号唯一ID',
  `user_id_card` varchar(40) DEFAULT NULL COMMENT '身份证号',
  `user_phone` varchar(40) DEFAULT NULL COMMENT '手机号',
  `recharge_type` varchar(40) DEFAULT NULL COMMENT '充值类型 1：水费充值 2：电费充值',
  `pay_type` varchar(40) DEFAULT NULL COMMENT '支付类型 1：微信充值 2：现金充值',
  `recharge_money` double DEFAULT NULL COMMENT '充值金额',
  `recharge_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '充值时间',
  `data_status` varchar(40) DEFAULT NULL,
  `data_type` varchar(40) DEFAULT NULL,
  `data_delete` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for sd_recharge_record
-- ----------------------------
DROP TABLE IF EXISTS `sd_recharge_record`;
CREATE TABLE `sd_recharge_record` (
  `row_id` varchar(40) NOT NULL,
  `out_trade_no` varchar(40) DEFAULT NULL COMMENT '订单号',
  `room_id` varchar(40) DEFAULT NULL COMMENT '房间号',
  `device_id` varchar(40) DEFAULT NULL COMMENT '水电设备ID',
  `user_name` varchar(40) DEFAULT NULL COMMENT '姓名',
  `open_id` varchar(40) DEFAULT NULL COMMENT '微信公众号唯一ID',
  `user_id_card` varchar(40) DEFAULT NULL COMMENT '身份证号',
  `user_phone` varchar(40) DEFAULT NULL COMMENT '手机号',
  `recharge_type` varchar(40) DEFAULT NULL COMMENT '充值类型 1：水费充值 2：电费充值',
  `pay_type` varchar(40) DEFAULT NULL COMMENT '支付类型 1：微信充值 2：现金充值',
  `recharge_money` double DEFAULT NULL COMMENT '充值金额',
  `recharge_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '充值时间',
  `data_status` varchar(40) DEFAULT NULL,
  `data_type` varchar(40) DEFAULT NULL,
  `data_delete` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for sd_refund_record
-- ----------------------------
DROP TABLE IF EXISTS `sd_refund_record`;
CREATE TABLE `sd_refund_record` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `roomId` varchar(40) DEFAULT NULL COMMENT '房间号',
  `device_id` varchar(40) DEFAULT NULL COMMENT '设备ID',
  `refund_type` varchar(40) DEFAULT NULL COMMENT '退款类型（1：水费退款2：电费退款）',
  `refund_money` double DEFAULT NULL COMMENT '退款金额',
  `refund_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '退款时间',
  `pay_type` varchar(40) DEFAULT NULL COMMENT '现金退款、微信退款',
  `out_trade_no` varchar(40) DEFAULT NULL COMMENT '商户订单号',
  `out_refund_no` varchar(40) DEFAULT NULL COMMENT '商户退款单号',
  `refund_desc` varchar(200) DEFAULT NULL COMMENT '退款原因',
  `refund_user_id` varchar(40) DEFAULT NULL COMMENT '退款人ID',
  `refund_user_name` varchar(40) DEFAULT NULL COMMENT '退款人姓名',
  `operate_user_id` varchar(40) DEFAULT NULL COMMENT '操作人ID',
  `operate_user_name` varchar(40) DEFAULT NULL COMMENT '操作人姓名',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for send_message_record
-- ----------------------------
DROP TABLE IF EXISTS `send_message_record`;
CREATE TABLE `send_message_record` (
  `row_id` varchar(40) NOT NULL,
  `room_id` varchar(40) DEFAULT NULL,
  `balance` varchar(40) DEFAULT NULL,
  `user_name` varchar(40) DEFAULT NULL,
  `user_phone` varchar(40) DEFAULT NULL,
  `task_id` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for tk_attachment
-- ----------------------------
DROP TABLE IF EXISTS `tk_attachment`;
CREATE TABLE `tk_attachment` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `relation_id` varchar(40) DEFAULT NULL COMMENT '关联ID',
  `attach_explain` varchar(40) DEFAULT NULL COMMENT '附件说明',
  `attach_name` varchar(200) DEFAULT NULL COMMENT '附件名称',
  `attach_type` varchar(40) DEFAULT NULL COMMENT '附件类型',
  `attach_file_identify_name` varchar(200) DEFAULT NULL COMMENT '文件上传保存名',
  `attach_path` varchar(200) DEFAULT NULL COMMENT '保存路径',
  `upload_user_id` varchar(40) DEFAULT NULL COMMENT '上传人ID',
  `upload_user_name` varchar(40) DEFAULT NULL COMMENT '上传人姓名',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='附件表';

-- ----------------------------
-- Table structure for user_agreement
-- ----------------------------
DROP TABLE IF EXISTS `user_agreement`;
CREATE TABLE `user_agreement` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `open_id` varchar(40) DEFAULT NULL COMMENT '微信用户ID',
  `is_agree` varchar(40) DEFAULT NULL COMMENT '是否同意',
  `agreement_type` varchar(40) DEFAULT NULL COMMENT '协议类型',
  `data_type` varchar(40) DEFAULT NULL,
  `data_status` varchar(40) DEFAULT NULL,
  `data_order` varchar(40) DEFAULT NULL,
  `data_delete` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for user_device_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_device_relation`;
CREATE TABLE `user_device_relation` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `user_card_id` varchar(40) DEFAULT NULL COMMENT '身份证号',
  `user_ykt_id` varchar(40) DEFAULT NULL COMMENT '一卡通账号',
  `water_device_id` varchar(40) DEFAULT NULL COMMENT '水设备ID',
  `electric_device_id` varchar(40) DEFAULT NULL COMMENT '点设备ID',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `data_type` varchar(40) DEFAULT NULL,
  `data_status` varchar(40) DEFAULT NULL,
  `data_delete` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for user_repo
-- ----------------------------
DROP TABLE IF EXISTS `user_repo`;
CREATE TABLE `user_repo` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(50) DEFAULT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  `ref` varchar(64) DEFAULT NULL,
  `SCOPE_ID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for water_account
-- ----------------------------
DROP TABLE IF EXISTS `water_account`;
CREATE TABLE `water_account` (
  `room_name` varchar(80) NOT NULL COMMENT '房间名',
  `balance` double(80,2) DEFAULT NULL COMMENT '余额',
  `last_recharge_money` double(80,2) DEFAULT NULL COMMENT '最后一次充值金额',
  `last_recharge_time` datetime DEFAULT NULL COMMENT '最后一次充值时间',
  `total_money` double(80,2) DEFAULT NULL COMMENT '已充金额',
  `recent_reduce_money` double(80,2) DEFAULT NULL COMMENT '最近一次扣费金额',
  `recent_reduce_time` datetime DEFAULT NULL COMMENT '最近一次扣费时间',
  `ext` varchar(255) DEFAULT NULL,
  `ext2` varchar(255) DEFAULT NULL,
  `ext3` date DEFAULT NULL,
  `ext4` datetime DEFAULT NULL,
  `data_order` int(255) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`room_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for water_data_record
-- ----------------------------
DROP TABLE IF EXISTS `water_data_record`;
CREATE TABLE `water_data_record` (
  `row_id` varchar(40) NOT NULL,
  `device_id` varchar(40) DEFAULT NULL,
  `current_number` double DEFAULT NULL,
  `send_time` datetime DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for water_device_info
-- ----------------------------
DROP TABLE IF EXISTS `water_device_info`;
CREATE TABLE `water_device_info` (
  `device_id` varchar(40) NOT NULL COMMENT '设备ID',
  `device_name` varchar(40) DEFAULT NULL COMMENT '设备名称',
  `build_num` varchar(40) DEFAULT NULL COMMENT '楼栋号',
  `room_num` varchar(40) DEFAULT NULL COMMENT '房间号',
  `use_status` varchar(40) DEFAULT NULL COMMENT '使用状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `data_status` varchar(40) DEFAULT NULL,
  `data_type` varchar(40) DEFAULT NULL,
  `data_order` int(11) DEFAULT NULL,
  `data_delete` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for water_floor_room
-- ----------------------------
DROP TABLE IF EXISTS `water_floor_room`;
CREATE TABLE `water_floor_room` (
  `row_id` varchar(80) NOT NULL,
  `row_name` varchar(80) DEFAULT NULL,
  `p_floor_id` varchar(80) DEFAULT NULL,
  `p_floor_name` varchar(80) DEFAULT NULL,
  `floor_type` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for water_floor_room_in_device
-- ----------------------------
DROP TABLE IF EXISTS `water_floor_room_in_device`;
CREATE TABLE `water_floor_room_in_device` (
  `room_id` varchar(80) DEFAULT NULL,
  `room_name` varchar(80) DEFAULT NULL,
  `device_id` varchar(80) NOT NULL,
  `device_name` varchar(80) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `addr` varchar(255) DEFAULT NULL COMMENT '水表唯一识别码',
  `status` varchar(255) DEFAULT NULL COMMENT '是否异常 0/异常',
  `ext` date DEFAULT NULL,
  `ext2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for water_month_bill
-- ----------------------------
DROP TABLE IF EXISTS `water_month_bill`;
CREATE TABLE `water_month_bill` (
  `row_id` varchar(80) NOT NULL,
  `room_name` varchar(80) DEFAULT NULL COMMENT '房间名',
  `device_id` varchar(80) DEFAULT NULL,
  `water_history_use` double(80,2) DEFAULT NULL COMMENT '上次抄表',
  `water_current_use` double(80,2) DEFAULT NULL COMMENT '本次抄表',
  `water_month_use` double(80,2) DEFAULT NULL COMMENT '月用量',
  `water_month_money` double(80,2) DEFAULT NULL COMMENT '月消费金额',
  `water_balance` double(80,2) DEFAULT NULL COMMENT '余额',
  `water_before_balance` double(80,2) DEFAULT NULL COMMENT '上月结余',
  `time` varchar(80) DEFAULT NULL COMMENT '月账单月时间(年月2019-08)',
  `time_section` varchar(255) DEFAULT NULL COMMENT '区间(2019-08-30/2019-09-25)',
  `localRecordTime` datetime DEFAULT NULL COMMENT '结算时间',
  `ext` date DEFAULT NULL,
  `ext2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`row_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for water_month_record
-- ----------------------------
DROP TABLE IF EXISTS `water_month_record`;
CREATE TABLE `water_month_record` (
  `row_id` varchar(80) NOT NULL COMMENT '主键随机',
  `device_id` varchar(80) DEFAULT NULL COMMENT '水表id',
  `total_water` varchar(80) DEFAULT NULL COMMENT '总水量',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `ext` varchar(80) DEFAULT NULL COMMENT '上次抄表',
  `ext2` varchar(80) DEFAULT NULL COMMENT '消耗金额',
  `ext3` varchar(80) DEFAULT NULL COMMENT '耗水量',
  `ext4` varchar(80) DEFAULT NULL COMMENT '时间从-至',
  `ext5` date DEFAULT NULL,
  `ext6` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`row_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for water_now_record
-- ----------------------------
DROP TABLE IF EXISTS `water_now_record`;
CREATE TABLE `water_now_record` (
  `device_id` varchar(80) NOT NULL COMMENT '电表id',
  `total_water` varchar(80) DEFAULT NULL COMMENT '当前值',
  `time` datetime DEFAULT NULL COMMENT '时间',
  `ext` varchar(80) DEFAULT NULL,
  `ext2` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for wechat_record
-- ----------------------------
DROP TABLE IF EXISTS `wechat_record`;
CREATE TABLE `wechat_record` (
  `row_id` varchar(80) NOT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for wechat_sq
-- ----------------------------
DROP TABLE IF EXISTS `wechat_sq`;
CREATE TABLE `wechat_sq` (
  `row_id` varchar(80) NOT NULL,
  `sq_id` varchar(80) DEFAULT NULL COMMENT '申请id',
  `sq_name` varchar(80) DEFAULT NULL COMMENT '申请name',
  `sh_name` varchar(80) DEFAULT NULL COMMENT '授权name',
  `sh_id` varchar(255) DEFAULT NULL COMMENT '授权id',
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `upload_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT NULL COMMENT '控制微信水电1可编辑/0不可编辑',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for weekend_week_record
-- ----------------------------
DROP TABLE IF EXISTS `weekend_week_record`;
CREATE TABLE `weekend_week_record` (
  `row_id` varchar(40) NOT NULL,
  `day_no` varchar(40) DEFAULT NULL,
  `remark` varchar(40) DEFAULT NULL,
  `year` varchar(40) DEFAULT NULL,
  `data_status` varchar(40) DEFAULT NULL,
  `data_type` varchar(40) DEFAULT NULL,
  `data_order` int(11) DEFAULT NULL,
  `data_delete` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for wx_attachment
-- ----------------------------
DROP TABLE IF EXISTS `wx_attachment`;
CREATE TABLE `wx_attachment` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `relation_id` varchar(40) DEFAULT NULL COMMENT '关联ID',
  `attach_name` varchar(200) DEFAULT NULL COMMENT '附件名称',
  `attach_type` varchar(40) DEFAULT NULL COMMENT '附件类型',
  `attach_file_identify_name` varchar(200) DEFAULT NULL COMMENT '文件上传保存名',
  `attach_path` varchar(200) DEFAULT NULL COMMENT '保存路径',
  `upload_user_id` varchar(40) DEFAULT NULL COMMENT '上传人ID',
  `upload_user_name` varchar(40) DEFAULT NULL COMMENT '上传人姓名',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='附件表';

-- ----------------------------
-- Table structure for wx_message_release
-- ----------------------------
DROP TABLE IF EXISTS `wx_message_release`;
CREATE TABLE `wx_message_release` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `wx_message` varchar(2000) DEFAULT NULL COMMENT '微信消息',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '修改人姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `modify_user_name` varchar(40) DEFAULT NULL COMMENT '修改人姓名',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_delete` varchar(40) DEFAULT '1' COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for wx_pay_result
-- ----------------------------
DROP TABLE IF EXISTS `wx_pay_result`;
CREATE TABLE `wx_pay_result` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `result_code` varchar(16) DEFAULT NULL COMMENT '业务结果',
  `err_code` varchar(32) DEFAULT NULL COMMENT '错误代码',
  `err_code_des` varchar(128) DEFAULT NULL COMMENT '错误代码描述',
  `openid` varchar(40) DEFAULT NULL COMMENT '用户标识',
  `is_subscribe` varchar(1) DEFAULT NULL COMMENT '是否关注该公众号',
  `bank_type` varchar(16) DEFAULT NULL COMMENT '付款银行',
  `total_fee` int(100) DEFAULT NULL COMMENT '订单金额',
  `settlement_total_fee` int(100) DEFAULT NULL COMMENT '应结订单金额',
  `fee_type` varchar(8) DEFAULT NULL COMMENT '货币种类',
  `cash_fee` int(100) DEFAULT NULL COMMENT '现金支付金额',
  `cash_fee_type` varchar(16) DEFAULT NULL COMMENT '现金支付货币类型',
  `coupon_fee` int(10) DEFAULT NULL COMMENT '总代金券金额',
  `coupon_count` int(1) DEFAULT NULL COMMENT '代金券使用数量',
  `coupon_type_single` varchar(20) DEFAULT NULL COMMENT '代金券类型',
  `coupon_id_single` varchar(20) DEFAULT NULL,
  `coupon_fee_single` int(100) DEFAULT NULL COMMENT '单个代金券支付金额',
  `transaction_id` varchar(32) DEFAULT NULL COMMENT '微信支付订单号',
  `out_trade_no` varchar(32) DEFAULT NULL COMMENT '商户订单号',
  `time_end` varchar(14) DEFAULT NULL COMMENT '支付完成时间',
  `data_status` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_delete` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for wx_refund_result
-- ----------------------------
DROP TABLE IF EXISTS `wx_refund_result`;
CREATE TABLE `wx_refund_result` (
  `row_id` varchar(40) NOT NULL,
  `transaction_id` varchar(40) DEFAULT NULL COMMENT '微信订单号',
  `out_trade_no` varchar(40) DEFAULT NULL COMMENT '商户订单号',
  `out_refund_no` varchar(40) DEFAULT NULL COMMENT '商户退款单号',
  `refund_id` varchar(40) DEFAULT NULL COMMENT '微信退款单号',
  `refund_fee` int(11) DEFAULT NULL COMMENT '退款总金额',
  `total_fee` int(11) DEFAULT NULL COMMENT '订单总金额',
  `cash_fee` int(11) DEFAULT NULL COMMENT '现金支付金额',
  `refund_time_end` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '退款完成时间',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_order` int(11) DEFAULT NULL COMMENT '排序',
  `data_delete` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for wx_unified_order
-- ----------------------------
DROP TABLE IF EXISTS `wx_unified_order`;
CREATE TABLE `wx_unified_order` (
  `row_id` varchar(40) NOT NULL,
  `out_trade_no` varchar(32) DEFAULT NULL COMMENT '商户订单号',
  `total_fee` int(11) DEFAULT NULL COMMENT '标价金额',
  `spbill_create_ip` varchar(40) DEFAULT NULL COMMENT '终端ip',
  `prepay_id` varchar(40) DEFAULT NULL COMMENT '预支付id',
  `openid` varchar(40) DEFAULT NULL COMMENT '用户标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `order_state` varchar(40) DEFAULT NULL COMMENT '订单状态',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_delete` varchar(40) DEFAULT NULL COMMENT '删除',
  `room_id` varchar(40) DEFAULT NULL COMMENT '房间号',
  `recharge_type` varchar(40) DEFAULT NULL COMMENT '充值类型',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for wx_user
-- ----------------------------
DROP TABLE IF EXISTS `wx_user`;
CREATE TABLE `wx_user` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `openid` varchar(40) DEFAULT NULL COMMENT '用户的唯一标识',
  `nickname` varchar(40) DEFAULT NULL COMMENT '用户昵称',
  `sex` int(11) DEFAULT NULL COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `province` varchar(40) DEFAULT NULL COMMENT '省份',
  `city` varchar(40) DEFAULT NULL COMMENT '城市',
  `country` varchar(40) DEFAULT NULL COMMENT '国家',
  `headimgurl` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `privilege` varchar(200) DEFAULT NULL COMMENT '用户特权信息',
  `unionid` varchar(40) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_delete` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for wx_user_room
-- ----------------------------
DROP TABLE IF EXISTS `wx_user_room`;
CREATE TABLE `wx_user_room` (
  `row_id` varchar(40) NOT NULL,
  `wx_user_id` varchar(40) DEFAULT NULL COMMENT '微信用户ID',
  `room_id` varchar(40) DEFAULT NULL COMMENT '房间号',
  `user_name` varchar(40) DEFAULT NULL COMMENT '姓名',
  `user_id_card` varchar(40) DEFAULT NULL COMMENT '身份证号',
  `user_phone` varchar(40) DEFAULT NULL COMMENT '手机号码',
  `bind_time` datetime DEFAULT NULL COMMENT '绑定时间',
  `unbind_time` datetime DEFAULT NULL COMMENT '解绑时间',
  `in_time` datetime DEFAULT NULL COMMENT '入住时间',
  `out_time` datetime DEFAULT NULL COMMENT '退租时间',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_order` int(11) DEFAULT NULL COMMENT '排序',
  `data_delete` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for wx_user_ykt
-- ----------------------------
DROP TABLE IF EXISTS `wx_user_ykt`;
CREATE TABLE `wx_user_ykt` (
  `row_id` varchar(40) NOT NULL,
  `wx_user_id` varchar(40) DEFAULT NULL COMMENT '微信用户ID',
  `ykt_id` varchar(40) DEFAULT NULL COMMENT '一卡通账号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `data_status` varchar(40) DEFAULT NULL,
  `data_type` varchar(40) DEFAULT NULL,
  `data_delete` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for ykt_bk_apply
-- ----------------------------
DROP TABLE IF EXISTS `ykt_bk_apply`;
CREATE TABLE `ykt_bk_apply` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `ykt_number` varchar(40) DEFAULT NULL COMMENT '一卡通卡号',
  `applicant_name` varchar(40) DEFAULT NULL COMMENT '申请人姓名',
  `applicant_phone` varchar(40) DEFAULT NULL COMMENT '申请人手机号',
  `applicant_id_card` varchar(40) DEFAULT NULL COMMENT '申请人身份证',
  `company_name` varchar(40) DEFAULT NULL COMMENT '公司名称',
  `receive_place` varchar(40) DEFAULT NULL COMMENT '领取点位置',
  `verification_code` varchar(40) DEFAULT NULL COMMENT '验证码',
  `card_number` int(11) DEFAULT NULL COMMENT '办卡数目',
  `pay_money` int(11) DEFAULT NULL COMMENT '支付金额',
  `out_trade_no` varchar(40) DEFAULT NULL COMMENT '商户订单号',
  `create_user_id` varchar(40) DEFAULT NULL COMMENT '创建人ID',
  `create_user_name` varchar(40) DEFAULT NULL COMMENT '创建人姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_user_id` varchar(40) DEFAULT NULL COMMENT '修改人ID',
  `modify_user_name` varchar(40) DEFAULT NULL COMMENT '修改人姓名',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  `is_receive` varchar(40) DEFAULT NULL COMMENT '是否领取卡片',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='一卡通自助申请表';

-- ----------------------------
-- Table structure for ykt_bk_order
-- ----------------------------
DROP TABLE IF EXISTS `ykt_bk_order`;
CREATE TABLE `ykt_bk_order` (
  `row_id` varchar(40) NOT NULL,
  `out_trade_no` varchar(32) DEFAULT NULL COMMENT '商户订单号',
  `total_fee` int(11) DEFAULT NULL COMMENT '标价金额',
  `spbill_create_ip` varchar(40) DEFAULT NULL COMMENT '终端ip',
  `prepay_id` varchar(40) DEFAULT NULL COMMENT '预支付id',
  `openid` varchar(40) DEFAULT NULL COMMENT '用户标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `order_state` varchar(40) DEFAULT NULL COMMENT '订单状态',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_delete` varchar(40) DEFAULT NULL COMMENT '删除',
  `relation_id` varchar(40) DEFAULT NULL COMMENT '关联业务表主键',
  `recharge_type` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for ykt_tk_apply
-- ----------------------------
DROP TABLE IF EXISTS `ykt_tk_apply`;
CREATE TABLE `ykt_tk_apply` (
  `row_id` varchar(40) NOT NULL,
  `user_name` varchar(40) DEFAULT NULL,
  `user_id_card` varchar(40) DEFAULT NULL,
  `user_phone` varchar(40) DEFAULT NULL,
  `ykt_number` varchar(40) DEFAULT NULL,
  `bank_card` varchar(40) DEFAULT NULL,
  `bank_name` varchar(40) DEFAULT NULL,
  `bank_subbranch` varchar(100) DEFAULT NULL,
  `refund_money` double DEFAULT NULL,
  `is_confirm` varchar(40) DEFAULT NULL,
  `refund_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `create_user_id` varchar(40) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `id_card_front` varchar(40) DEFAULT NULL,
  `id_card_reverse` varchar(40) DEFAULT NULL,
  `bank_photo` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for zbpt_attachment
-- ----------------------------
DROP TABLE IF EXISTS `zbpt_attachment`;
CREATE TABLE `zbpt_attachment` (
  `row_id` varchar(40) NOT NULL COMMENT '主键',
  `relation_id` varchar(40) DEFAULT NULL COMMENT '关联ID',
  `attach_name` varchar(200) DEFAULT NULL COMMENT '附件名称',
  `picture_type` varchar(40) DEFAULT NULL COMMENT '图片类型 0：列表图片 1：详情图片',
  `attach_file_identify_name` varchar(200) DEFAULT NULL COMMENT '文件上传保存名',
  `attach_path` varchar(200) DEFAULT NULL COMMENT '保存路径',
  `upload_user_id` varchar(40) DEFAULT NULL COMMENT '上传人ID',
  `upload_user_name` varchar(40) DEFAULT NULL COMMENT '上传人姓名',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `data_type` varchar(40) DEFAULT NULL COMMENT '类别',
  `data_status` varchar(40) DEFAULT NULL COMMENT '状态',
  `data_order` varchar(40) DEFAULT NULL COMMENT '排序',
  `data_deleted` varchar(40) DEFAULT NULL COMMENT '删除',
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='附件表';

-- ----------------------------
-- View structure for v_bk_inst_act
-- ----------------------------
DROP VIEW IF EXISTS `v_bk_inst_act`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER  VIEW `v_bk_inst_act` AS SELECT
	b.row_id AS business_id,
	b.applicant_name,
	b.ykt_number,
	b.applicant_phone,
	b.applicant_id_card,
	b.company_name,
	b.card_number,
	b.create_user_id,
	b.create_user_name,
	b.create_time,
	pi.process_id,
	pi.row_id AS instance_id,
	pi.instance_state,
	ai.row_id,
	ai.act_id,
	ai.act_name,
	ai.handle_user,
	ai.handle_user1,
	ai.act_back,
	ai.act_next,
	ai.active_state,
	ai.active_time,
	ai.finish_time,
	ai.step_state
FROM
	ykt_bk_apply b,
	proc_instance pi,
	proc_act_instance ai
WHERE
	b.row_id = pi.business_id
AND pi.row_id = ai.instance_id ;

-- ----------------------------
-- View structure for v_bk_pi
-- ----------------------------
DROP VIEW IF EXISTS `v_bk_pi`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER  VIEW `v_bk_pi` AS SELECT
	b.row_id,
	b.ykt_number,
	b.applicant_name,
	b.applicant_phone,
	b.applicant_id_card,
	b.company_name,
	b.card_number,
	b.receive_place,
	b.create_user_id,
	b.create_user_name,
	b.create_time,
	pi.process_id,
	pi.row_id AS instance_id,
	pi.instance_state,
	pi.active_state,
	pi.active_user_name,
	pi.create_time AS start_time,
	pi.end_time
FROM
	ykt_bk_apply b,
	proc_instance pi
WHERE
	b.row_id = pi.business_id ;

-- ----------------------------
-- View structure for v_fwzl_inst_act
-- ----------------------------
DROP VIEW IF EXISTS `v_fwzl_inst_act`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER  VIEW `v_fwzl_inst_act` AS SELECT
	r.row_id AS business_id,
	r.enterprise_name,
	r.apply_date,
	r.enterprise_manager,
	r.contact_number,
	r.apartment_type,
	r.apartment_number,
	r.is_accord_tzxyyd,
	r.check_in_time,
	r.lease_term,
	r.create_user_id,
	r.create_user_name,
	pi.process_id,
	pi.row_id AS instance_id,
	pi.instance_state,
	ai.row_id,
	ai.act_id,
	ai.act_name,
	ai.handle_user,
	ai.handle_user1,
	ai.act_back,
	ai.act_next,
	ai.active_state,
	ai.active_time,
	ai.finish_time,
	ai.step_state
FROM
	rcgy_lese_apply r,
	proc_instance pi,
	proc_act_instance ai
WHERE
	r.row_id = pi.business_id
AND pi.row_id = ai.instance_id ;

-- ----------------------------
-- View structure for v_fwzl_procinst
-- ----------------------------
DROP VIEW IF EXISTS `v_fwzl_procinst`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER  VIEW `v_fwzl_procinst` AS SELECT
	r.row_id,
	r.enterprise_name,
	r.apply_date,
	r.enterprise_manager,
	r.contact_number,
	r.apartment_type,
	r.apartment_number,
	r.is_accord_tzxyyd,
	r.check_in_time,
	r.lease_term,
	r.create_user_id,
	r.create_user_name,
	r.create_time,
	pi.process_id,
	pi.row_id AS instance_id,
	pi.instance_state,
	pi.active_state,
	pi.active_user_name,
	pi.create_time AS start_time,
	pi.end_time
FROM
	rcgy_lese_apply r,
	proc_instance pi
WHERE
	r.row_id = pi.business_id ;

-- ----------------------------
-- View structure for v_index_agency
-- ----------------------------
DROP VIEW IF EXISTS `v_index_agency`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_index_agency` AS SELECT
	r.row_id AS business_id,
	r.enterprise_name AS company_name,
	r.enterprise_manager AS applicant_name,
	r.create_time,
	pi.process_id,
	pi.process_name,
	pi.row_id AS instance_id,
	pi.instance_state,
	ai.row_id,
	ai.act_id,
	ai.act_name,
	ai.handle_user,
	ai.handle_user1,
	ai.active_state
FROM
	rcgy_lese_apply r,
	proc_instance pi,
	proc_act_instance ai
WHERE
	r.row_id = pi.business_id
AND pi.row_id = ai.instance_id
UNION
	SELECT
		m.row_id AS business_id,
		m.company_name,
		m.applicant_name,
		m.create_time,
		pi.process_id,
		pi.process_name,
		pi.row_id AS instance_id,
		pi.instance_state,
		ai.row_id,
		ai.act_id,
		ai.act_name,
		ai.handle_user,
		ai.handle_user1,
		ai.active_state
	FROM
		meeting_room_lease_apply m,
		proc_instance pi,
		proc_act_instance ai
	WHERE
		m.row_id = pi.business_id
	AND pi.row_id = ai.instance_id
	UNION
		SELECT
			o.row_id AS business_id,
			o.company_name,
			o.applicant_name,
			o.create_time,
			pi.process_id,
			pi.process_name,
			pi.row_id AS instance_id,
			pi.instance_state,
			ai.row_id,
			ai.act_id,
			ai.act_name,
			ai.handle_user,
			ai.handle_user1,
			ai.active_state
		FROM
			one_card_apply o,
			proc_instance pi,
			proc_act_instance ai
		WHERE
			o.row_id = pi.business_id
		AND pi.row_id = ai.instance_id ;

-- ----------------------------
-- View structure for v_meet_inst_act
-- ----------------------------
DROP VIEW IF EXISTS `v_meet_inst_act`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER  VIEW `v_meet_inst_act` AS SELECT
	m.row_id AS business_id,
	m.applicant_name,
	m.applicant_phone,
	m.applicant_id_card,
	m.company_name,
	m.start_time,
	m.end_time,
	m.selected_room,
	m.create_user_id,
	m.create_user_name,
	m.create_time,
	pi.process_id,
	pi.row_id AS instance_id,
	pi.instance_state,
	ai.row_id,
	ai.act_id,
	ai.act_name,
	ai.handle_user,
	ai.handle_user1,
	ai.act_back,
	ai.act_next,
	ai.active_state,
	ai.active_time,
	ai.finish_time,
	ai.step_state
FROM
	meeting_room_lease_apply m,
	proc_instance pi,
	proc_act_instance ai
WHERE
	m.row_id = pi.business_id
AND pi.row_id = ai.instance_id ;

-- ----------------------------
-- View structure for v_meet_procinst
-- ----------------------------
DROP VIEW IF EXISTS `v_meet_procinst`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER  VIEW `v_meet_procinst` AS SELECT
	m.row_id,
	m.applicant_name,
	m.applicant_phone,
	m.applicant_id_card,
	m.company_name,
	m.start_time AS meet_start_time,
	m.end_time AS meet_end_time,
	m.selected_room,
	m.create_user_id,
	m.create_user_name,
	m.create_time,
	pi.process_id,
	pi.row_id AS instance_id,
	pi.instance_state,
	pi.active_state,
	pi.active_user_name,
	pi.create_time AS start_time,
	pi.end_time
FROM
	meeting_room_lease_apply m,
	proc_instance pi
WHERE
	m.row_id = pi.business_id ;

-- ----------------------------
-- View structure for v_order_result
-- ----------------------------
DROP VIEW IF EXISTS `v_order_result`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_order_result` AS SELECT
	o.room_id,
	o.recharge_type,
	r.out_trade_no,
	o.total_fee,
	r.total_fee AS confirm_fee,
	o.create_time
FROM
wx_pay_result r
LEFT JOIN wx_unified_order o ON o.out_trade_no = r.out_trade_no
AND o.total_fee > 1
ORDER BY
	o.create_time DESC ;

-- ----------------------------
-- View structure for v_recharge_result
-- ----------------------------
DROP VIEW IF EXISTS `v_recharge_result`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_recharge_result` AS SELECT
	r.device_id,
	r.open_id,
	r.recharge_money,
	r.recharge_time,
	r.room_id,
	v.room_id AS pay_room_id,
	v.recharge_type,
	v.total_fee,
v.create_time
FROM
	sd_recharge_record r
RIGHT JOIN v_order_result v ON r.out_trade_no = v.out_trade_no ;

-- ----------------------------
-- View structure for v_role_user
-- ----------------------------
DROP VIEW IF EXISTS `v_role_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER  VIEW `v_role_user` AS select concat(`r`.`role_id`,`u`.`user_id`) AS `v_role_user_key`,`u`.`row_id` AS `user_key`,`u`.`user_name` AS `user_name`,`u`.`user_show_name` AS `user_show_name`,`u`.`user_en_name` AS `user_en_name`,`u`.`user_id` AS `user_id`,`u`.`create_time` AS `create_time`,`u`.`create_user_id` AS `create_user_id`,`u`.`modify_time` AS `modify_time`,`u`.`modify_user_id` AS `modify_user_id`,`u`.`data_status` AS `data_status`,`u`.`data_order` AS `data_order`,`u`.`user_mobile_num` AS `user_mobile_num`,`u`.`user_sex` AS `user_sex`,`u`.`user_type` AS `user_type`,`r`.`row_id` AS `role_key`,`r`.`role_name` AS `role_name`,`r`.`role_id` AS `role_id`,`r`.`role_intro` AS `role_intro`,`r`.`create_time` AS `r_create_time`,`r`.`create_user_id` AS `r_create_user_id`,`r`.`modify_time` AS `r_modify_time`,`r`.`modify_user_id` AS `r_modify_user_id`,`r`.`data_status` AS `r_data_status`,`r`.`data_order` AS `r_data_order`,`r`.`parent_role_id` AS `parent_role_id`,`r`.`parent_role_name` AS `parent_role_name`,`r`.`role_type` AS `role_type`,`ru`.`rl_type` AS `rl_type`,`ru`.`row_id` AS `rhu_id` from ((`gx_sys_role` `r` join `gx_sys_user` `u`) join `gx_sys_role_has_user` `ru`) where ((`r`.`role_id` = `ru`.`role_id`) and (`u`.`user_id` = `ru`.`user_id`)) ;

-- ----------------------------
-- View structure for v_room_device
-- ----------------------------
DROP VIEW IF EXISTS `v_room_device`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_room_device` AS SELECT
	concat_ws('_',`f`.`row_id`,`rid`.`device_id`) AS `v_key`,
	`f`.`row_id`,
	`f`.`row_name`,
	`f`.`p_floor_id`,
	`f`.`p_floor_name`,
	`f`.`floor_type`,
	`rid`.`device_id` ,
	`rid`.`device_name` ,
	`rid`.`settle_type_out` ,
	`rid`.`settle_type_name` ,
	`ds`.on_and_off
FROM
	(
		
		`floor_room` `f`
		JOIN `floor_room_in_device` `rid`
		JOIN `device_on_and_off` `ds`
	)
WHERE
	(
		`f`.`row_id` = `rid`.`room_id`
		AND
		`ds`.device_id=`rid`.device_id
	) ;

-- ----------------------------
-- View structure for v_room_device_copy
-- ----------------------------
DROP VIEW IF EXISTS `v_room_device_copy`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_room_device_copy` AS SELECT
	concat_ws('_',`f`.`row_id`,`rid`.`device_id`) AS `v_key`,
	`f`.`row_id`,
	`f`.`row_name`,
	`f`.`p_floor_id`,
	`f`.`p_floor_name`,
	`f`.`floor_type`,
`rid`.`room_id` ,
	`rid`.`device_id` ,
	`rid`.`device_name` ,
	`rid`.`settle_type_out` ,
	`rid`.`settle_type_name` ,
	`ds`.on_and_off
FROM
	(
		
		`floor_room` `f`
		JOIN `floor_room_in_device` `rid`
		JOIN `device_on_and_off` `ds`
	)
WHERE
	(
		`f`.`row_id` = `rid`.`room_id`
		AND
		`ds`.device_id=`rid`.device_id
	) ;

-- ----------------------------
-- View structure for v_room_device_every_day_energy
-- ----------------------------
DROP VIEW IF EXISTS `v_room_device_every_day_energy`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_room_device_every_day_energy` AS SELECT
	concat_ws('_',`f`.`row_id`,`rid`.`device_id`,`eedr`.time) AS `v_key`,
	`f`.`row_id`,
	`f`.`row_name`,
	`f`.`p_floor_id`,
	`f`.`p_floor_name`,
	`f`.`floor_type`,
	`rid`.`device_id` ,
	`rid`.`device_name` ,
	`rid`.`settle_type_out` ,
	`rid`.`settle_type_name` ,
	`ds`.on_and_off,
	`eedr`.total_energy_start,
	`eedr`.total_energy_end,
	`eedr`.balance,
	`eedr`.time,
	`eedr`.ext
FROM
	(
		
		`floor_room` `f`
		JOIN `floor_room_in_device` `rid`
		JOIN `device_on_and_off` `ds`
		JOIN `electric_every_day_record` `eedr`
	)
WHERE
	(
		`f`.`row_id` = `rid`.`room_id`
		AND
		`ds`.device_id=`rid`.device_id
		AND
		`eedr`.device_id=`rid`.device_id
	) ;

-- ----------------------------
-- View structure for v_room_device_month_energy
-- ----------------------------
DROP VIEW IF EXISTS `v_room_device_month_energy`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `v_room_device_month_energy` AS SELECT
	concat_ws('_',`f`.`row_id`,`rid`.`device_id`,`emr`.time) AS `v_key`,
	`f`.`row_id`,
	`f`.`row_name`,
	`f`.`p_floor_id`,
	`f`.`p_floor_name`,
	`f`.`floor_type`,
	`rid`.`device_id` ,
	`rid`.`device_name` ,
	`rid`.`settle_type_out` ,
	`rid`.`settle_type_name` ,
	`ds`.on_and_off,
	`emr`.month_energy,
	`emr`.total_energy_start,
	`emr`.total_energy_end,
	`emr`.balance,
	`emr`.time
FROM
	(
		
		`floor_room` `f`
		JOIN `floor_room_in_device` `rid`
		JOIN `device_on_and_off` `ds`
		JOIN `electric_month_record` `emr`
	)
WHERE
	(
		`f`.`row_id` = `rid`.`room_id`
		AND
		`ds`.device_id=`rid`.device_id
		AND
		`emr`.device_id=`rid`.device_id
	) ;

-- ----------------------------
-- View structure for v_tk_inst_act
-- ----------------------------
DROP VIEW IF EXISTS `v_tk_inst_act`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER  VIEW `v_tk_inst_act` AS SELECT
	t.row_id AS business_id,
	t.user_name,
	t.user_phone,
	t.user_id_card,
	t.ykt_number,
	t.bank_card,
	t.bank_name,
	t.bank_subbranch,
	t.id_card_front,
	t.id_card_reverse,
	t.bank_photo,
	t.is_confirm,
	t.refund_money,
	t.create_user_id,
	t.create_time,
	pi.process_id,
	pi.row_id AS instance_id,
	pi.instance_state,
	ai.row_id,
	ai.act_id,
	ai.act_name,
	ai.handle_user,
	ai.handle_user1,
	ai.act_back,
	ai.act_next,
	ai.active_state,
	ai.active_time,
	ai.finish_time,
	ai.step_state
FROM
	ykt_tk_apply t,
	proc_instance pi,
	proc_act_instance ai
WHERE
	t.row_id = pi.business_id
AND pi.row_id = ai.instance_id ;

-- ----------------------------
-- View structure for v_tk_pi
-- ----------------------------
DROP VIEW IF EXISTS `v_tk_pi`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER  VIEW `v_tk_pi` AS SELECT
	t.row_id,
	t.user_name,
	t.user_phone,
	t.user_id_card,
	t.ykt_number,
	t.bank_card,
	t.bank_name,
	t.bank_subbranch,
	t.id_card_front,
	t.id_card_reverse,
	t.bank_photo,
	t.is_confirm,
	t.refund_money,
	t.create_user_id,
	t.create_time,
	pi.process_id,
	pi.row_id AS instance_id,
	pi.instance_state,
	pi.active_state,
	pi.active_user_name,
	pi.create_time AS start_time,
	pi.end_time
FROM
	ykt_tk_apply t,
	proc_instance pi
WHERE
	t.row_id = pi.business_id ;

-- ----------------------------
-- View structure for v_user
-- ----------------------------
DROP VIEW IF EXISTS `v_user`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `v_user` AS SELECT
	concat(`o`.`row_id`, `u`.`user_id`) AS `v_user_key`,
	`o`.`org_name` AS `org_name`,
	`o`.`parent_org_id` AS `p_org_id`,
	`o`.`parent_org_name` AS `p_org_name`,
	`o`.`org_type` AS `org_type`,
	`o`.`row_id` AS `org_id`,
	`u`.`user_name` AS `user_name`,
	`u`.`user_en_name` AS `user_password`,
	`u`.`user_id` AS `user_id`,
	`u`.`user_type` AS `user_type`,
	`u`.`user_mobile_num` AS `user_mobile_num`,
	`u`.`data_status` AS `user_status`,
	`u`.`sys_color_id` AS `sys_color_id`,
	`uio`.`data_order` AS `data_order`,
uio.row_id as uio_row_id,
	u.row_id AS user_row_id
FROM
	(
		(
			`gx_sys_org` `o`
			JOIN `gx_sys_user` `u`
		)
		JOIN `gx_sys_user_in_org` `uio`
	)
WHERE
	(
		(
			`o`.`row_id` = `uio`.`org_id`
		)
		AND (
			`u`.`user_id` = `uio`.`user_id`
		)
	)
ORDER BY
	`uio`.`data_order` ;

-- ----------------------------
-- View structure for v_water_every_month
-- ----------------------------
DROP VIEW IF EXISTS `v_water_every_month`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`%` SQL SECURITY DEFINER  VIEW `v_water_every_month` AS SELECT
	concat_ws('_',`f`.`row_id`,`rid`.`device_id`) AS `v_key`,
	`f`.`row_id`,
	`f`.`row_name`,
	`f`.`p_floor_id`,
	`f`.`p_floor_name`,
	`f`.`floor_type`,
	`rid`.`status`,
	`rid`.`device_id` ,
	`rid`.`device_name`,
	`wmr`.total_water,
	`wmr`.time,
	`wmr`.ext,
	`wmr`.ext2,
	`wmr`.ext3,
	`wmr`.ext4
FROM
	(
		
		`water_floor_room` `f`
		JOIN `water_floor_room_in_device` `rid`
		JOIN `water_month_record` `wmr`
	)
WHERE
	(
		`f`.`row_id` = `rid`.`room_id`
		and
		`wmr`.`device_id` = `rid`.`device_id`
	) ;

-- ----------------------------
-- View structure for v_water_room_device
-- ----------------------------
DROP VIEW IF EXISTS `v_water_room_device`;
CREATE ALGORITHM=UNDEFINED DEFINER=`admin`@`%` SQL SECURITY DEFINER  VIEW `v_water_room_device` AS SELECT
	concat_ws('_',`f`.`row_id`,`rid`.`device_id`) AS `v_key`,
	`f`.`row_id`,
	`f`.`row_name`,
	`f`.`p_floor_id`,
	`f`.`p_floor_name`,
	`f`.`floor_type`,
	`rid`.`device_id` ,
	`rid`.`device_name`,
	`rid`.addr
FROM
	(
		
		`water_floor_room` `f`
		JOIN `water_floor_room_in_device` `rid`
	)
WHERE
	(
		`f`.`row_id` = `rid`.`room_id`
	) ;

-- ----------------------------
-- View structure for v_ykt_inst_act
-- ----------------------------
DROP VIEW IF EXISTS `v_ykt_inst_act`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER  VIEW `v_ykt_inst_act` AS SELECT
	o.row_id AS business_id,
	o.applicant_name,
	o.applicant_phone,
	o.identity_document,
	o.applicant_id_card,
	o.company_name,
	o.card_number,
	o.create_user_id,
	o.create_user_name,
	o.create_time,
	pi.process_id,
	pi.row_id AS instance_id,
	pi.instance_state,
	ai.row_id,
	ai.act_id,
	ai.act_name,
	ai.handle_user,
	ai.handle_user1,
	ai.act_back,
	ai.act_next,
	ai.active_state,
	ai.active_time,
	ai.finish_time,
	ai.step_state
FROM
	one_card_apply o,
	proc_instance pi,
	proc_act_instance ai
WHERE
	o.row_id = pi.business_id
AND pi.row_id = ai.instance_id ;

-- ----------------------------
-- View structure for v_ykt_procinst
-- ----------------------------
DROP VIEW IF EXISTS `v_ykt_procinst`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY INVOKER  VIEW `v_ykt_procinst` AS SELECT
	o.row_id,
	o.applicant_name,
	o.applicant_phone,
	o.identity_document,
	o.applicant_id_card,
	o.company_name,
	o.card_number,
	o.receive_place,
	o.create_user_id,
	o.create_user_name,
	o.create_time,
	pi.process_id,
	pi.row_id AS instance_id,
	pi.instance_state,
	pi.active_state,
	pi.active_user_name,
	pi.create_time AS start_time,
	pi.end_time
FROM
	one_card_apply o,
	proc_instance pi
WHERE
	o.row_id = pi.business_id ;

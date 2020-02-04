package com.gx.soft.common.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.SocketException;

/**
 * ftp文件上传/下载工具类
 * @author ShuaiBiLin
 * FTP账号：
 * ftp://10.250.143.158:17021/
 * 账号：11320100129473811NJZJWSSP
 * 密码：Zj09eI18
 * IP地址：10.250.143.158
 * 端口：17021
 */

public class FtpUtil {
	static Logger logger = Logger.getLogger(FtpUtil.class);
	protected FtpUtil(){
		
	}
	
	    /**
	     * 获取FTPClient对象
	     *
	     * @param ftpHost     FTP主机服务器
	     * @param ftpPassword FTP 登录密码
	     * @param ftpUserName FTP登录用户名
	     * @param ftpPort     FTP端口 默认为21
	     * @return
	     */
	    public static FTPClient getFTPClient(String ftpHost, String ftpUserName,
	                                         String ftpPassword, int ftpPort) {
	        FTPClient ftpClient = new FTPClient();
	        try {
	            ftpClient = new FTPClient();
	            ftpClient.connect(ftpHost, ftpPort);// 连接FTP服务器
	            ftpClient.login(ftpUserName, ftpPassword);// 登陆FTP服务器
	            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
	                System.out.println("未连接到FTP，用户名或密码错误。");
	                ftpClient.disconnect();
	            } else {
	                System.out.println("FTP连接成功。");
	            }
	        } catch (SocketException e) {
	            e.printStackTrace();
	            System.out.println("FTP的IP地址可能错误，请正确配置。");
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("FTP的端口错误,请正确配置。");
	        }
	        return ftpClient;
	    }

	    /**
	     * 从FTP服务器下载文件
	     * 
	     * @param ftpHost FTP IP地址
	     * @param ftpUserName FTP 用户名
	     * @param ftpPassword FTP用户名密码
	     * @param ftpPort FTP端口
	     * @param ftpPath FTP服务器中文件所在路径 格式： ftptest/aa
	     * @param localPath 下载到本地的位置 格式：H:/download
	     * @param fileName 文件名称
	     */
	    public static void downloadFtpFile(String ftpHost, String ftpUserName,String ftpPassword,
	    		int ftpPort, String ftpPath, String localPath,String fileName) {
	        FTPClient ftpClient = null;
	        try {
	            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
	            ftpClient.setControlEncoding("UTF-8"); // 中文支持
	            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
	            ftpClient.enterLocalPassiveMode();
	            ftpClient.changeWorkingDirectory(ftpPath);
	            File localFile = new File(localPath + File.separatorChar + fileName);
	            OutputStream os = new FileOutputStream(localFile);
	            ftpClient.retrieveFile(fileName, os);
	            os.close();
	            ftpClient.logout();
	        } catch (FileNotFoundException e) {
	            System.out.println("没有找到" + ftpPath + "文件");
	            e.printStackTrace();
	        } catch (SocketException e) {
	            System.out.println("连接FTP失败.");
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	            System.out.println("文件读取错误。");
	            e.printStackTrace();
	        }
	    }

	    /**
	     * 向FTP服务器上传文件
	     * 
	     * @param ftpHost FTP服务器hostname
	     * @param ftpUserName 账号
	     * @param ftpPassword 密码
	     * @param ftpPort 端口
	     * @param fileName ftp文件名称
	     * @param input 文件流
	     * @return 成功返回true，否则返回false
	     */
	    public static boolean uploadFile(String ftpHost, String ftpUserName,String ftpPassword,
	    		int ftpPort,String fileName,InputStream input, String INTERNAL_NO) {
	        boolean success = false;
	        FTPClient ftpClient = null;
	        try {
	            int reply;
	            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
	            reply = ftpClient.getReplyCode();
	            if (!FTPReply.isPositiveCompletion(reply)) {
	                ftpClient.disconnect();
	                return success;
	            }
	            ftpClient.setControlEncoding("UTF-8"); // 中文支持
	            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
	            ftpClient.enterLocalPassiveMode();
	            if(INTERNAL_NO != null && INTERNAL_NO.length() > 0){
	            	ftpClient.makeDirectory(INTERNAL_NO);
	            }
	            ftpClient.changeWorkingDirectory(INTERNAL_NO);
	            ftpClient.storeFile(fileName, input);
	            input.close();
	            ftpClient.logout();
	            success = true;
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (ftpClient.isConnected()) {
	                try {
	                    ftpClient.disconnect();
	                } catch (IOException ioe) {
	                }
	            }
	        }
	        return success;
	    }
}

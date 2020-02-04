package com.gx.soft.common.util;



import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import org.apache.log4j.Logger;


public class THostnameVerifier implements HostnameVerifier {
	
	Logger log = Logger.getLogger(THostnameVerifier.class);
	
	public boolean verify(String hostname, SSLSession session) {
		log.debug("Warning: URL Host: " + hostname + " vs. "   + session.getPeerHost());  
		return true;//��У�� ȫ����true
	}
}
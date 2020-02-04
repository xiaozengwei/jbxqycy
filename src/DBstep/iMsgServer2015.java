package DBstep;

import net.sf.json.JSONObject;
import org.apache.commons.fileupload.DefaultFileItemFactory;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 
 * @author ������
 *
 */
public class iMsgServer2015 {
	// 日志
	private static Logger logger = LoggerFactory
			.getLogger(iMsgServer2015.class);
    private Hashtable<String, String> saveFormParam = new Hashtable<String, String>();  //保存form表单数据
    //private Hashtable<String, String> sendFormParam = new Hashtable<String, String>();  //保存form表单数据
	private InputStream fileContentStream;
	private String fileSize ="0";
	private String fileName = "";
	private byte[] mFileBody = null;
	private boolean isLoadFile = false;
	private String sendType ="";
	
	private static final String MsgError = "404";//设置常量404，说明没有找到对应的文档
	
	
	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	/**
	 * @throws FileUploadException
	 * @throws IOException 
	 * @deprecated:后台类解析接口
	 * @time:2015-01-09
	 */
	public void Load(HttpServletRequest request) throws FileUploadException, IOException{
		 request.setCharacterEncoding("gb2312");
		 //DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		 //ServletFileUpload fileUpload = new ServletFileUpload(diskFileItemFactory);
		 DefaultFileItemFactory diskFileItemFactory = new DefaultFileItemFactory();
		DiskFileUpload fileUpload = new DiskFileUpload(diskFileItemFactory);
		List fileList =  fileUpload.parseRequest(request);
		 //List<FileItem> fileList =  fileUpload.parseRequest(request);
		 //Iterator iter = fileList.iterator();
		 if (fileList != null && fileList.size() > 0) {
			    for (int i=0; i<fileList.size(); i++) {
			        FileItem item = (FileItem)fileList.get(i);
			        if(item.isFormField()) {
			        	 processFormField(item);
			        }else{
			        	processUploadedFile(item);
			        }
			    }
			}
	/*	 while (iter.hasNext()) {
		 	 FileItem item = iter.next();
			 if (item.isFormField()) {
			    processFormField(item);
			 }else {
			    processUploadedFile(item);
			 }
		 }*/
	}
   
	/**
	 @deprecated：解析表达数据
	 * @param item:表单数据
	 * @throws UnsupportedEncodingException 
	 * @time:2015-01-09
	 */
	public void processFormField(FileItem item) throws UnsupportedEncodingException{
		String fieldName = item.getFieldName();
		String fieldValue = "";
		fieldValue = item.getString("utf-8");
		if(this.sendType.equalsIgnoreCase("JSON")){
			JSONObject json = JSONObject.fromObject(fieldValue);
			Iterator iter = json.keySet().iterator();   
			 while (iter.hasNext()) {   
			   fieldName = (String) iter.next();   
			   fieldValue = json.getString(fieldName); 
			   saveFormParam.put(fieldName, fieldValue);
			}
			 return;
		}
		saveFormParam.put(fieldName, fieldValue);
	}
	
	
	/**
	 * @deprecated：解析文档数据
	 * @param item:文档数据
	 * @throws IOException 
	 * @throws UnsupportedEncodingException
	 * @time:2015-01-09 
	 */	
	public void processUploadedFile(FileItem item) throws IOException{
		fileName = item.getName();
		System.out.println("正在保存的正文文件名:"+fileName);
		System.out.println("正在保存的文件长度："+item.getSize());
		if(fileName.indexOf("/")>=0){
			fileName = fileName.substring(fileName.lastIndexOf("/")+1);	
		}else if(fileName.indexOf("\\")>=0){
			fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
		}
	    fileContentStream =  item.getInputStream();
		fileSize = ""+item.getSize();
	}
	/**
	 * @deprecated：解析文档数据
	 * @param fieldName:参数名称
	 * @return：参数对于的值ڵ�ֵ
	 * @time:2015-01-09
	 */	
	public String GetMsgByName(String fieldName){
		return saveFormParam.get(fieldName);
	}

	/**
	 * 清除所有SetMsgByName所有内容
	 * @time:2015-01-09
	 */
	public void MsgTextClear(){
		saveFormParam.clear();
	}
	
	
	public byte[] MsgFileBody() throws IOException{
		 mFileBody = null;
		 isLoadFile = false;
		 ByteArrayOutputStream output = new ByteArrayOutputStream();
		 byte[] buffer = new byte[4096];
		 int n = 0;
		 while (-1 != (n = fileContentStream.read(buffer))) {
		        output.write(buffer, 0, n);
		 }
	    mFileBody = output.toByteArray();
		return mFileBody;
	}
	
	
	/** 
     * 把字节数组保存为一个文件 
     *  
     * @param
     * @param outputFile 
     * @return 
     */  
    public  boolean MsgFileSave(String outputFile,String outputFileAvd) {

    	 try {
    	File f = new File(outputFile);
    	FileOutputStream fos = null;
        BufferedInputStream bis = null;
        int BUFFER_SIZE = 1024;
        byte[] buf = new byte[BUFFER_SIZE];
        int size = 0;
			 if(!fileSize.equals("0")){
				 bis = new BufferedInputStream(fileContentStream);
				 fos = new FileOutputStream(f);
				 while ( (size = bis.read(buf)) != -1)
					 fos.write(buf, 0, size);
				 fos.close();
				 bis.close();
			 }
			 //如果有额外参数则读取并复制
	 	if(outputFileAvd!=null){
			File in = new File(outputFile);
			File out = new File(outputFileAvd);
			FileUtils.copyFile(in,out);
		}
        return true;
    	 } catch (Exception e) {
			 logger.info("文件保存失败"+outputFileAvd+"办理过程文件名称"+e.getMessage());
			 logger.info("文件保存失败"+outputFile+"正文文件名称"+e.getMessage());
 			e.printStackTrace();
 			return false;
 		}
    }  
//    public  boolean MsgFileSaveAdvice(String outputFile) {
//
//    	 try {
//    	File f1 = new File(outputFile);
//
//    	FileOutputStream fos1 = null;
//        BufferedInputStream bis1 = null;
//		System.out.println("MsgFileSaveAdvice fileSize:"+fileSize);
//        int BUFFER_SIZE = 1024;
//        byte[] buf1 = new byte[BUFFER_SIZE];
//        int size = 0;
//			 if(!fileSize.equals("0")){
//				 bis1 = new BufferedInputStream(fileContentStream);
//				 fos1 = new FileOutputStream(f1);
//				 while ( (size = bis1.read(buf1)) != -1)
//					 fos1.write(buf1, 0, size);
//				 fos1.close();
//				 bis1.close();
//			 }
//
//        return true;
//    	 } catch (Exception e) {
// 			e.printStackTrace();
// 			return false;
// 		}
//    }


    
    public boolean MsgFileLoad(String fileName) throws IOException{
    	File file = new File(fileName);
		System.out.println("读取服务器数据长度="+file.length());
		System.out.println("读取服务器正文名字="+file.getName());
    	if(file.exists()){
    	fileContentStream = new FileInputStream(new File(fileName));
    	MsgFileBody();
    	}else{
    		mFileBody = new byte[0];
    	}
    	isLoadFile = true;
    	return true;
    }
    
    
    /**
    * @deprecated:将文件的二进制数据设置到信息包中
     * @param response
     * @throws IOException
     */
    public void Send(HttpServletResponse response) throws IOException{
    	try{
    	//	System.out.println("in Send");
	    	if(isLoadFile){
	    		    if(mFileBody.length != 0){
			    		response.setCharacterEncoding("utf-8");
				   		response.setContentType("application/x-msdownload;charset=utf-8");
				   		response.setContentLength(mFileBody.length);
				   	    response.setHeader("Content-Disposition","attachment;filename=");
				   	    response.getOutputStream().write(mFileBody,0,mFileBody.length);
	    		    }else{
	    		    	response.setHeader("MsgError",iMsgServer2015.MsgError);
	    		    }
	    	}    	
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
    	}catch(Exception e){
    		//e.printStackTrace();
    	}
    } 	
}

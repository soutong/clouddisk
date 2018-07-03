package com.sxt.clouddisk.handler;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.sxt.clouddisk.exception.CustomException;
import com.sxt.clouddisk.model.FileInfos;
import com.sxt.clouddisk.model.UserInfos;
import com.sxt.clouddisk.service.FileInfosService;
import com.sxt.clouddisk.service.impl.FileInfosServiceImpl;
import com.sxt.clouddisk.utils.FileSizeUtils;

@Controller
@RequestMapping("fileInfos")
public class FileInfosHandler {
	private FileInfosService fs=new FileInfosServiceImpl();
	@RequestMapping("list")
	public String findAll(HttpServletRequest request,Model model){
		UserInfos user =(UserInfos)request.getSession().getAttribute("user");
		int userID = user.getUserID();
		List<FileInfos> list = fs.findByID(userID);
		model.addAttribute("fileList",list);
		return "list";
	}
	@RequestMapping("/upload")
	public String upload(MultipartFile[] upLoadFiles, HttpServletRequest request) throws CustomException{
		UserInfos userInfos=(UserInfos)request.getSession().getAttribute("user");
		String userName = userInfos.getUserName();
		int userID=userInfos.getUserID();
		File f=new File("E:/upload/"+userName);
		for(MultipartFile upLoadFile:upLoadFiles){
			String originalFilename = upLoadFile.getOriginalFilename();
			long size = upLoadFile.getSize();
			if(size==0){
				throw new CustomException("不能上传空文件");
			}
			FileSizeUtils fileSizeUtils = new FileSizeUtils();
			fileSizeUtils.getDirSize(f);
			if(userInfos.getUserType()==1){
			if(size>1*1024*1024){
				throw new CustomException("传输文件不能超过1M");
			}else if(size>(32*1024*1024-(int)fileSizeUtils.size)){
				throw new CustomException("剩余空间不足");
			}
			}else if(userInfos.getUserType()==2){
				if(size>2*1024*1024){
					throw new CustomException("传输文件不能超过2M");
				}else if(size>(128*1024*1024-(int)fileSizeUtils.size)){
					throw new CustomException("剩余空间不足");
				}
			}
			try {
				upLoadFile.transferTo(new File(f,originalFilename));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FileInfos fi = new FileInfos();
			fi.setFileName(originalFilename);
			fi.setFilePath("E:/upload/"+userName+"/"+originalFilename);
			fi.setFileSize((int)size);
			fi.setUserID(userID);
			fs.add(fi);
		}
		return "redirect:/fileInfos/list.action";
	}
	/*@RequestMapping("/download")
	public ResponseEntity<byte[]> downLoad(String fileName,HttpServletRequest request) throws Exception{
		UserInfos user = (UserInfos)request.getSession().getAttribute("user");
		String userName = user.getUserName();
		String s="E:/upload/"+userName+"/"+fileName;
		File f=new File(s);
		String fileName2=new String (fileName.getBytes("utf-8"),"iso-8859-1");
		HttpHeaders headers=new HttpHeaders();
		headers.setContentDispositionFormData("attachment", fileName2);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		ResponseEntity<byte[]> re=new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(f),headers,HttpStatus.CREATED);
		return re;
	}*/
	@RequestMapping("/delete")
	public String delete(int fileInfoID,String fileName,HttpServletRequest request){
		UserInfos user = (UserInfos)request.getSession().getAttribute("user");
		String userName = user.getUserName();
		String s="E:/upload/"+userName+"/"+fileName;
		File f=new File(s);
		f.delete();
		int count = fs.delete(fileInfoID);
			return "redirect:/fileInfos/list.action";
	}
	@RequestMapping(value="/download" ,method=RequestMethod.GET)
	public ResponseEntity<byte[]> downLoad(String fileLink) throws Exception{
		FileInfos fileInfo = fs.findByLink(fileLink);
		String filePath = fileInfo.getFilePath();
		String fileName = fileInfo.getFileName();
		String fileName2=new String (fileName.getBytes("utf-8"),"iso-8859-1");
		HttpHeaders headers=new HttpHeaders();
		headers.setContentDispositionFormData("attachment", fileName2);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		ResponseEntity<byte[]> re=new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(new File(filePath)), headers, HttpStatus.CREATED);
		return re;
	}
}

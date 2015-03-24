package com.gdufs.gd.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class UploadUtil {

	private String defaultPath = "D:/FILES/";

	public UploadUtil() {
	}

	public UploadUtil(String basePath) {
		this.defaultPath = basePath;
	}

	public String generateFileName() {
		String s = UUID.randomUUID().toString();
		return s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18)
				+ s.substring(19, 23) + s.substring(24);
	}

	/**
	 * 解析request 获取文件 依赖于common-io和common-upload 这两个包 支持多文件上传
	 * 
	 * 返回文件对应的存储位置
	 * 
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	public HashMap<String, String> uploadFiles(CommonsMultipartFile file,
			HttpServletRequest request) {
		HashMap<String, String> paths = new HashMap<String, String>();
		if (!file.isEmpty()) {
			// 定义解析器去解析request
			CommonsMultipartResolver mutilpartResolver = new CommonsMultipartResolver(
					request.getSession().getServletContext());
			if (mutilpartResolver.isMultipart(request)) {
				MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
				// 获取文件名
				Iterator<String> it = multiRequest.getFileNames();
				while (it.hasNext()) {
					// 获取MultipartFile类型文件
					MultipartFile fileDetail = multiRequest.getFile(it.next());
					// if (fileDetail != null) {
					// String fileName = "demoUpload"
					// + fileDetail.getOriginalFilename();
					// String path = "D:/" + fileName;
					// File localFile = new File(path);
					// // 将上传文件写入到指定文件出、核心！
					// try {
					// fileDetail.transferTo(localFile);
					// } catch (IllegalStateException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// } catch (IOException e) {
					// // TODO Auto-generated catch block
					// e.printStackTrace();
					// }
					// // 非常重要、有了这个想做什么处理都可以
					// // fileDetail.getInputStream();
					// }

					if (fileDetail != null) {
						String fileName = generateFileName()
								+ fileDetail.getOriginalFilename();
						String path = defaultPath + fileName;
						File localFile = new File(path);
						try {
							fileDetail.transferTo(localFile);
							paths.put(fileDetail.getOriginalFilename(), path);
						} catch (IllegalStateException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						// 将上传文件写入到指定文件出、核心！
						// 非常重要、有了这个想做什么处理都可以
						// fileDetail.getInputStream();
					}
				}
			}
		}
		return paths;
	}

	/**
	 * 单文件上传 返回文件对应的存储位置
	 * 
	 * @param file
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public String uploadAFile(CommonsMultipartFile file,
			HttpServletRequest request) throws IOException {
		String path = "";
		if (!file.isEmpty()) {
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(defaultPath
							+ file.getOriginalFilename()));
			InputStream in = file.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(in);
			int n = 0;
			byte[] b = new byte[1024];
			while ((n = bis.read(b)) != -1) {
				bos.write(b, 0, n);
			}
			bos.flush();
			bos.close();
			bis.close();
		}
		return path;
	}
}

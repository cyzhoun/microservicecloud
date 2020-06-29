package cn.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传的controller类
 * @author chongyu
 *
 */
@RestController // 相当于@Controller+@ResponseBody
public class FileUploadController {

	/**
	 * 文件上传的方法
	 * @return
	 * @throws IOException 
	 * @throws Exception 
	 */
	@RequestMapping("fileUploadController")
	public Map<String,String> FileUpload(MultipartFile filename) throws Exception{
		HashMap<String,String> responseMap = new HashMap<String,String>();
		
		// 文件上传
		System.out.println("文件 : " + filename.getOriginalFilename() + "正在上传");
		if (filename.getSize() > 0) {
			filename.transferTo(new File("C:/Users/chongyu/Desktop/" + filename.getOriginalFilename()));
			responseMap.put("message", "File upload success!");
		} else {
			responseMap.put("message", "File need >0");
		}
		System.out.println("文件 : " + filename.getOriginalFilename() + "上传成功");
		
		return responseMap;
	}
}


package com.bitacademy.mysite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bitacademy.mysite.service.FileUploadService;
import com.bitacademy.mysite.service.GalleryService;
import com.bitacademy.mysite.vo.GalleryVo;

@Controller
@RequestMapping("/gallery")
public class GalleryController {
	@Autowired
	private GalleryService galleryService;
	
	@Autowired
	private FileUploadService fileuploadService;
	
	@RequestMapping("")
	public String index() {
		return "gallery/index";
	}
	
	@RequestMapping(value = "/upload/", method = RequestMethod.POST)
	public String delete(@PathVariable("file") MultipartFile multipartFile,
			@RequestParam(value = "comments", required = true, defaultValue = "") String comments) {

		String url = fileuploadService.restore(multipartFile);
		GalleryVo vo = new GalleryVo();
		vo.setUrl(url);
		vo.setComments(comments);
		galleryService.saveImages(vo);
		
		return "redirect:/gallery";
	}
	
	@RequestMapping("/delete/{no}")
	public String delete(@PathVariable("no") Long no) {
		galleryService.removeImages(no);
		return "redirect:/gallery";
	}	
}

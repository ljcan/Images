import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.shinelon.service.ImageUploadService;
import cn.shinelon.service.ThumbImageService;


@Controller
public class ImageController {
	
	public ImageUploadService imageUploadService;
	public ThumbImageService thumbImageService;
	@RequestMapping("/image")
	public String upload(@RequestParam("image")CommonsMultipartFile image,
			HttpServletRequest req,ModelMap model) throws IOException{
		String uploadPath="/images";
		String realPath=req.getRealPath(uploadPath);
		String imageUrl=imageUploadService.upload(image, uploadPath, realPath);
		String thumbUrl=thumbImageService.thumb(image, uploadPath, realPath);
		model.addAttribute("oldimage", imageUrl);
		model.addAttribute("newimage",thumbUrl);
		return "/pictures.jsp";
	}
	@Autowired
	public void setImageUploadService(ImageUploadService imageUploadService) {
		this.imageUploadService = imageUploadService;
	}
	@Autowired
	public void setThumbImageService(ThumbImageService thumbImageService) {
		this.thumbImageService = thumbImageService;
	}
}

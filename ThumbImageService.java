import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Service("thumbImageService")
public class ThumbImageService {
	static int WIDTH=100;
	static int HEIGHT=100;
	public String thumb(CommonsMultipartFile file,String uploadPath,String realPath) throws IOException{
		String des=realPath+"/thum_"+file.getOriginalFilename();
		OutputStream os=null;
		os=new FileOutputStream(des);
		Image ima=ImageIO.read(file.getInputStream());
		int width=ima.getWidth(null);	//图片原宽
		int height=ima.getHeight(null);
		int rate=0;
		int rate1=width/WIDTH;
		int rate2=height/HEIGHT;
		if(rate1>rate2){
			rate=rate1;
		}else{
			rate=rate2;
		}
		int newWidth=width/rate;
		int newHeight=height/rate;
		BufferedImage bufferedImage=new BufferedImage(newWidth, newHeight, 
				BufferedImage.TYPE_INT_RGB);
		bufferedImage.getGraphics().drawImage(ima.getScaledInstance(newWidth,
				newHeight, ima.SCALE_SMOOTH),0,0,null);
		//image/jpg
		String imageType=file.getContentType().substring(file.getContentType().indexOf("/")+1);
		ImageIO.write(bufferedImage, imageType,os);
		if(os!=null){
			os.close();
		}
		return uploadPath+"/thum_"+file.getOriginalFilename();
	}
}

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Service("imageUploadService")
public class ImageUploadService {
	public String upload(CommonsMultipartFile file,String uploadPath,String realPath){
		InputStream is=null;
		OutputStream os=null;
		String path=realPath;
		try {
			is=file.getInputStream();
			os=new FileOutputStream(new File(path,file.getOriginalFilename()));
			IOUtils.copy(is, os);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return uploadPath+"/"+file.getOriginalFilename();
	}
}

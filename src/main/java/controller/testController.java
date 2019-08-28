package controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Controller
public class testController {
	
	@RequestMapping("sss")
	public  @ResponseBody String aaa(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest req )throws Exception {
		String oname=file.getOriginalFilename();
		String ex=oname.substring(oname.lastIndexOf("."),oname.length());
		String nname = UUID.randomUUID()+ex;
  
		String path=req.getSession().getServletContext().getRealPath("/");
		path=new File(path).getParentFile().getPath()+"/upload1";
		System.out.println(path);
		file.transferTo(new File(path,nname));
		return "/upload1/"+nname;
	}
	
	@RequestMapping("index")
	public void index(ModelMap m) {
		m.put("arr", new String[] {"/upload1/39000afe-4e44-4d51-82a8-44b9659f16e8.jpg",
				"/upload1/01b0b1d6-d76a-4a63-9f58-8f1cf5c95ce0.jpg"});
	}
}

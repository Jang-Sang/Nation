package controller.board;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.JsonObject;

import common.Paging;
import common.ViewPath;
import service.board.BoardService;
import vo.board.BoardVO;
import vo.boardfiles.BoardFilesVO;

@Configuration
@PropertySource("classpath:config/globals.properties")

@Controller
public class BoardController {

	private BoardService boardService;
	
	@Value("${globals.dir}")
	private String FILEPATH;
	
	@Autowired // 자동 주입
	private ServletContext application;
	
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigPlaceon() {
                  return new PropertySourcesPlaceholderConfigurer();
    }
   
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@RequestMapping("/board/list")
	public String list(Model model,Integer page,String type,String word) {
		
		//type이 빈 문자열이면 null값으로 바꿔치기 하자...
		//System.out.println(type);
		
		type = "".equals(type) ? null : type;
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("type", type);
		map.put("word", word);
		
		
		if(page == null) {
			page = 1;
		}
		
		int boardCount = boardService.getTotal(map);
		
		Paging paging = new Paging(page, boardCount);
		
		map.put("first", paging.getFirst());
		map.put("last", paging.getLast());
		
		List<BoardVO> list = boardService.selectList(map);
		
		
		model.addAttribute("list", list);
		model.addAttribute("paging", paging);
		
//		//현재 페이지
//		int nowPage = (start - 1) / 5 + 1;
//		//총 글의 개수
//		int total = boardService.getTotal();
//		int totalPage = total % 5 == 0 ? total / 5 : total / 5 + 1;
//		
//		model.addAttribute("start", start);
//		model.addAttribute("nowPage", nowPage);
//		model.addAttribute("total", total);
//		model.addAttribute("totalPage", totalPage);
//		model.addAttribute("list", list);
		
		return ViewPath.BOARD + "list.jsp";
	}
	
	@RequestMapping("/board/writeForm")
	public String writeForm() {
		return ViewPath.BOARD + "write.jsp";
	}
	
	@RequestMapping("/board/write")
	public String write(HttpServletRequest request,BoardVO vo) {
		
		int no = (Integer)request.getSession().getAttribute("login");
		
		vo.setNo(no);
		
//		String content = vo.getContent();
//		
//		vo.setContent(content.replaceAll("\r\n", "<br>"));
		
		//파일을 저장할 경로....
		String savePath = FILEPATH + "upload\\";
//		String savePath = application.getRealPath("/resources/upload/");
		
		
		MultipartFile photo = vo.getPhoto();
		
		String filename = null;
		
		if(!photo.isEmpty()) {
			
			//업로드된 실제파일명
			filename = photo.getOriginalFilename();
		
			//File 객체 생성
			File saveFile = new File(savePath,filename);
			
			if(!saveFile.exists()) { //경로에 파일이 없으면
				saveFile.mkdirs();
			}else { //있으면
				long time = System.currentTimeMillis();
				
				filename = String.format("%s%d%s", filename.substring(0, filename.lastIndexOf(".")),time,filename.substring(filename.lastIndexOf(".")));
			
				saveFile = new File(savePath,filename);
			}
			
			//업로드된 파일은 MultipartResolver라는 클래스가 지정한 임시저장소에 저장되어 있다...
			//파일이 일정시간이 지나면 사라지기때문에 내가 지정한 경로로 복사해준다...
			try {
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			vo.setFilename(filename);
		}
		
		int seq = boardService.getSeq();

		
		//답글인경우
		if(vo.getSeq() != 0) {
			BoardVO ref = boardService.selectOne(vo.getSeq());
			
			vo.setGroupno(ref.getGroupno());
			vo.setOrderno(ref.getOrderno() + 1);
			vo.setDepth(ref.getDepth() + 1);
		}else {
			vo.setGroupno(seq);
		}
		
		vo.setSeq(seq);
		
		String content = vo.getContent();
		content = content.replaceAll("getImg", "getImgLoad/" + seq);
		vo.setContent(content);
		
		try {
			summerCopy(vo.getFileList(), seq); //파일 위치 변경
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
		int check = boardService.insert(vo);
		
		
		boardService.fileInsert(seq, vo.getFileList());
		
		String msg = null;
		String url = null;
		if(check != 0) {
			msg = "글쓰기 성공!";
			url = "/myhome/board/list";
		}else {
			msg = "글쓰기 실패!";
			url = "/myhome/board/writeForm";
		}
		
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		
		return ViewPath.BOARD + "result.jsp";
	}
	
	
	@RequestMapping("/board/content/{seq}")
	public String content(Model model,@PathVariable("seq") int seq) {
		BoardVO vo = boardService.selectOne(seq);
		List<BoardFilesVO> list = boardService.fileSelectList(seq);
		
		System.out.println(list.size());
		
		model.addAttribute("vo", vo);
		model.addAttribute("list", list);
		
		return ViewPath.BOARD + "content.jsp";
	}
	
	@RequestMapping("/board/writeReply/{seq}")
	public String writeReply(Model model,@PathVariable("seq") int seq) {
		model.addAttribute("seq", seq);
		
		return ViewPath.BOARD + "write.jsp";
	}
	
	@RequestMapping("/board/download/{seq}")
	public void download(@PathVariable("seq")int seq, String fn,HttpServletResponse response) throws IOException{
        File f = new File(FILEPATH + "/upload/" + seq + "/", fn);
        // file 다운로드 설정
        response.setContentType("application/download");
        response.setContentLength((int)f.length());
        response.setHeader("Content-disposition", "attachment;filename=\"" + fn + "\"");
        // response 객체를 통해서 서버로부터 파일 다운로드
        OutputStream os = response.getOutputStream();
        // 파일 입력 객체 생성
        FileInputStream fis = new FileInputStream(f);
        FileCopyUtils.copy(fis, os);
        fis.close();
        os.close();

	}
	
	@RequestMapping("/summer_image")
	@ResponseBody
	public String uploadSummernoteImageFile(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request ) throws IOException {
	    JsonObject json = new JsonObject();

	    String fileRoot = FILEPATH + "/upload/copy/";
	    String originalFileName = multipartFile.getOriginalFilename();	//오리지날 파일명
	    String extension = originalFileName.substring(originalFileName.lastIndexOf(".")); //파일 확장자

	    String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
	    File targetFile = new File(fileRoot + savedFileName);	
	    System.out.println(targetFile);
	    try {
	        // 파일 저장
	        InputStream fileStream = multipartFile.getInputStream();
	        FileUtils.copyInputStreamToFile(fileStream, targetFile);	
	        
	        // 파일을 열기위하여 common/getImg 호출 / 파라미터로 savedFileName 보냄.
	        json.addProperty("url", "/myhome/board/common/getImg?savedFileName="+savedFileName);  
	        json.addProperty("responseCode", "success");
	   
	    } catch (IOException e) {
	        FileUtils.deleteQuietly(targetFile);	
	        json.addProperty("responseCode", "error");
	        e.printStackTrace();
	    }
	    String jsonvalue = json.toString();

	    return jsonvalue;
	}
	
	@RequestMapping(value="/board/common/getImg" , method=RequestMethod.GET)
	public void getImg(@RequestParam(value="savedFileName") String savedFileName, HttpServletResponse response) throws Exception{
	  String filePath;
	  String DIR = FILEPATH + "/upload/copy/";
	  filePath = DIR +savedFileName; 
	  getImage(filePath, response);
	}
	
	@RequestMapping(value="/board/common/getImgLoad/{seq}" , method=RequestMethod.GET)
	public void getImgCopy(@RequestParam(value="savedFileName") String savedFileName,@PathVariable("seq") int seq, HttpServletResponse response) throws Exception{
	  String filePath;
	  String DIR = FILEPATH + "/upload/" + seq + "/";
	  filePath = DIR +savedFileName; 
	  getImage(filePath, response);
	}
	
	private void getImage(String filePath, HttpServletResponse response) throws IOException {
		File file = new File(filePath);
		if(!file.isFile()){
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write("<script type='text/javascript'>alert('조회된 정보가 없습니다.'); self.close();</script>");
			out.flush();
			return;
		}
	
		
		FileInputStream fis = null;
		
		BufferedInputStream in = null;
		ByteArrayOutputStream bStream = null;
		try {
			fis = new FileInputStream(file);
			in = new BufferedInputStream(fis);
			bStream = new ByteArrayOutputStream();
			int imgByte;
			while ((imgByte = in.read()) != -1) {
				bStream.write(imgByte);
			}

			String type = "";
			String ext = FilenameUtils.getExtension(file.getName());
			System.out.println(ext);
			if (ext != null && !"".equals(ext)) {
				if ("jpg".equals(ext.toLowerCase())) {
					type = "image/jpeg";
				} else {
					type = "image/" + ext.toLowerCase();
				}

			} else {
				System.err.println("Image fileType is null.");
			}

			response.setHeader("Content-Type", type);
			response.setContentLength(bStream.size());

			bStream.writeTo(response.getOutputStream());

			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bStream != null) {
				try {
					bStream.close();
				} catch (Exception est) {
					est.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (Exception ei) {
					ei.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception efis) {
					efis.printStackTrace();
				}
			}
		}
	}
	
	public Map<String, Object> summerCopy(List<String> fileList ,int seq) throws Exception {

		Map<String, Object> result = new HashMap<String, Object>();
		//원본 파일경로
		for(int i=0;i<fileList.size();i++){
		    String oriFilePath = FILEPATH + "upload\\copy\\" + fileList.get(i);

		    //복사될 파일경로
		    String copyFilePath = FILEPATH + "upload\\" + seq + "\\"+fileList.get(i);
		    File copy = new File( FILEPATH + "upload\\" + seq + "\\");
		    System.out.println(oriFilePath);
		    System.out.println(copyFilePath);
		    
		    if(!copy.exists()) { //경로에 파일이 없으면
		    	copy.mkdirs();
		    }
		    
		    try {
		        FileInputStream fis = new FileInputStream(oriFilePath); //읽을파일
		        FileOutputStream fos = new FileOutputStream(copyFilePath); //복사할파일
		        int data = 0;
		        while((data=fis.read())!=-1) {
		         fos.write(data);
		        }
		        fis.close();
		        fos.close();
		       } catch (IOException e) {
		        e.printStackTrace();
		       }
		    
		    	File del = new File(oriFilePath);
		    	del.delete();
			}
		
			
	    result.put("SUCCESS", true);
	    return result;
	}
}


































package com.min.edu.ctrl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.min.edu.dto.BoardDTO;
import com.min.edu.dto.FileBoardDTO;
import com.min.edu.model.BoardFileImpl;
import com.min.edu.model.IBoardFile;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class FileController extends HttpServlet {

	private static final long serialVersionUID = 938871408338950278L;
	Logger logger = Logger.getLogger(this.getClass());
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
			
		IBoardFile dao= new BoardFileImpl();
		
		String command = req.getParameter("command");
		logger.info("doGet에서 요청받은 커맨드 값"+command);
		
		if(command.equalsIgnoreCase("boardList")) {
			List<BoardDTO> lists = dao.getAllList();
			req.setAttribute("lists", lists);
			req.getRequestDispatcher("/WEB-INF/views/boardList.jsp").forward(req, resp);
		}else if(command.equalsIgnoreCase("detail")) {
			String seq = req.getParameter("seq");
			logger.info("detail에서 전달 받은 값"+seq);
			List<BoardDTO> allDto = dao.getBoard(seq);
			req.setAttribute("dto", allDto.get(0));
			req.getRequestDispatcher("/WEB-INF/views/boardDetail.jsp").forward(req, resp);
		}else if(command.equalsIgnoreCase("boardWriteForm")) {
			req.getRequestDispatcher("/WEB-INF/views/WriteForm.jsp").forward(req, resp);
		}else if ( command. equalsIgnoreCase("download")) {
			String seq = req.getParameter("seq");
			logger.info("download에서 전달 받은 값"+seq);
			
			FileBoardDTO fdto = dao.getFile(seq);
			System.out.println(fdto);
			
			
			//상대경로
			ServletContext context = req.getServletContext();
			String path = context.getRealPath("/upload");
			String filepath = path+"/"+fdto.getStored_fname();
			System.out.println(filepath);
			//filepath에 저장되어 있는 파일을 IO로 읽어서(InputStream) 브라우저에 보내준다(OutputStream)
			
			FileInputStream in = null;
			ServletOutputStream out = null;

			try {
				File file = new File(filepath); //물리적인 주소에서 파일을 읽어옴
				System.out.println(file);
				
				byte[] b = new byte[(int)file.length()];//파일의 크기로 byte의 Array를 생성함
				System.out.println("읽어온 파일 byte : " + Arrays.toString(b));
				
				resp.reset();//브라우저로 응답 할 떄 해더에 있는 정보를 초기화 한다.
				
				//MIME
				//전달하는 파일의 특성에 맞춰 hearder정보를 변경해줌
				//어떤 타입인지 모를 경우 application/octect-stream <<타입에 대한 상관없이 8비트로 보내줌
				//만약에 타입을 알고있다면 제공해주는 타입을 사용하면 됨
				//EX) .word라면 application/msword
				resp.setContentType("application/octect-stream");
				
				//파일명 인코딩
				String encoding = new String (fdto.getOrigin_fname().getBytes("UTF-8"),"8859_1");
				//파일 다운로드 버튼을 눌렀을 때 서버에서 전송받은 데이터를 어떻게 처리 할 지 브라우저에 알려줘야함
				resp.setHeader("Content-Disposition", "attachment; filename="+encoding);
				
				in = new FileInputStream(file);
				out = resp.getOutputStream();
				
				int numRead=0;
				while((numRead =in.read(b,0,b.length))!=-1){
					out.write(b,0,numRead);
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				out.flush();
				out.close();
				in.close();
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		logger.info("doPost실행");
		//화면 (viewHTML의 form요소의 전송타입이 application/x-www-form-urlencode라면 text만들어 전송
//		String writer = req.getParameter("writer");
//		String title = req.getParameter("title");
//		String filename = req.getParameter("filename");
//		String content = req.getParameter("content");
//	
//		System.out.printf("%s %s %s %s \n", writer, title,filename,content);
		
		//화면(view-HTML)의 form요소에 전송이 tEXT와 data라면 Multipart/form-data로 선언해 줘야하고
		//server에서는 요청받은 request를 MulitpartRequset로 처리해줘야함

		/**
		 * 절대 경로(변하지않는 주소) 상대경로(변하는 주소) 
		 * 절대 경로 : local의 특정 위치 (window 기준 ex>c:\\upload\\)
		 * 상대경로 : was(tomcat)의 설치 위치( Run > Run Configuration > tomcat > dtwp~~~위치
		 * ※※ 미리보기 혹은 reflesh 없이 (비동기식) 미리보기 하기위해서 상대경로 작업해야함
		 */
		
		/**
		 * MultiPartRequest의 필요 값
		 * HttpServletRequest, saveDeirectory(저장경로>> 절대 / 상대), maxPostSize, Encoding, policy
		 */
		//절대경로 
		String saveDirectory = "C:\\eclipse_Web\\workspace_web\\WEB014_FileBoard\\src\\main\\webapp\\upload";
		
		//상대 경로(ContextRoot)
		ServletContext context = req.getServletContext();
		String saveDirectory2 = context.getRealPath("upload");
		String saveDirectory3 = req.getServletContext()+"upload";
		
		System.out.println("절대경로 : "+saveDirectory );
		System.out.println("상대 경로1 : " +saveDirectory2);
		System.out.println("상대 경로2 : " +saveDirectory3);
		
		int maxPostSize = 10*1024*1024;//10MB
		String encoding ="UTF-8";
		
		//MultipartRequest로 요청받은 데이터와 Text를 받아와서 객체로 만든다.
		MultipartRequest multi = new MultipartRequest(req, saveDirectory2, maxPostSize, encoding, new DefaultFileRenamePolicy());
		
		//1) 전달받은 Text 받기
		String writer = multi.getParameter("writer");
		String title = multi.getParameter("title");
		String content = multi.getParameter("content");
		String origin_fname = multi.getOriginalFileName("filename");
		System.out.printf("전달 받은 요청 값 : %s %s %s %s\n",writer,title,content,origin_fname);
		
		//2) 파일업로드 
		String strored_fname =null;
		int file_size=0;
		FileBoardDTO fDto=null;
		if(origin_fname != null) {
			//stored_fname : 파일이 서버에 저장될 떄 중복되지 않는다 이름을 만들어주고 = 전달할때는 기존의 이름과 맞춰준다.
			strored_fname = UUID.randomUUID().toString().replace("-", "")+ origin_fname.substring(0,origin_fname.lastIndexOf("."));
			System.out.println("저장 할 파일 명 " + strored_fname);
			
			file_size = (int)(multi.getFile("filename").length());
			
			fDto = new FileBoardDTO();
			fDto.setOrigin_fname(origin_fname);
			fDto.setStored_fname(strored_fname);
			fDto.setFile_size(file_size);
			fDto.setWriter(writer);
			
			System.out.println("최종 파일 저장 DTO 결과 " +fDto);
		}
		
		BoardDTO bDto = new BoardDTO();
		bDto.setId("writer");
		bDto.setTitle("title");
		bDto.setContent("content");
		
		System.out.println("최종 게시글 저장 DTo 결과 : \n"+bDto);
		
		//3)DAO 실행 
		IBoardFile dao = new BoardFileImpl();
		boolean isc = dao.insertBoard(bDto, fDto);
		
		File oldFile = new File(saveDirectory2+"/"+multi.getFilesystemName("filename"));
		File newFile = new File(saveDirectory2+"/"+strored_fname);
		oldFile.renameTo(newFile);
		
		if(isc) {
			resp.sendRedirect("./fileboard.do?command=boardList");
		}else {
			resp.getWriter().print("<script>alert('글입력실패');</script>");
		}
	}
}
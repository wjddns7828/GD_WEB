package com.min.edu.ctrl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.min.edu.dao.IUserDao;
import com.min.edu.dao.UserDaoImpl;
import com.min.edu.dto.UserDTO;

public class UserController extends HttpServlet {

	private static final long serialVersionUID = 8069945146676880444L;
	private Logger logger = Logger.getLogger(UserController.class);
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doGet 처리");
		doProcess(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.info("doPost 처리");
		doProcess(req, resp);
	}
	//모든 프로토콜을 처리하는 Process
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		IUserDao dao = new UserDaoImpl();	
		String cmd = request.getParameter("command");
		System.out.println("요청 받은 값 : " + cmd);
		
		if(cmd == null || cmd==""){
			response.sendRedirect("./error.jsp");
		}else if(cmd.equalsIgnoreCase("login")){
			String id = request.getParameter("id");
			String password = request.getParameter("password");

			System.out.printf("%s / %s \n",id,password);
			Map<String,Object> inmap = new HashMap<String,Object>();
			inmap.put("id",id);
			inmap.put("password",password);
			
			//TODO 001 MyBatis의 결과는 객체를 반환
			//결과가 없을 경우 null로 반환하여 로그인 실패했음을 script를 통해 알려줌
			UserDTO logindto = dao.getLogin(inmap);
			if(logindto != null){
				System.out.println("로그인 성공");
				HttpSession session = request.getSession();
				session.setAttribute("loginDTO",logindto);
				session.setMaxInactiveInterval(10*60);//세션유지 시간 기준은 //10분동안 활동이 없으면 세션은 자동 삭제
				if(logindto.getAuth().equals("AUTH")){
//					response.sendRedirect("./adminMain.jsp");	
					forward(request, response,"./WEB-INF/views/adminMain.jsp");
				}else if(logindto.getAuth().equalsIgnoreCase("user")){
//					response.sendRedirect("./userMain.jsp");
					forward(request, response,"./WEB-INF/views/userMain.jsp");
				}
				}else{
					
				PrintWriter out = response.getWriter();
				StringBuffer sb = new StringBuffer();
				sb.append("<script type='text/javascript'>");
				sb.append("alert('아이디 비밀번호를 확인하세요');");
				sb.append("location.href='./index.jsp';");
				sb.append("</script>");
				out.print(sb.toString());		
				}
	}else if(cmd.equalsIgnoreCase("logout")){
			HttpSession session = request.getSession();
			session.invalidate();
			forward(request, response,"./index.jsp");
		}else if(cmd.equalsIgnoreCase("getAlluserStatus")){
			List<UserDTO> lists = dao.getAllUserStatus();
			request.setAttribute("lists",lists);
			forward(request,response,"./WEB-INF/views/userListStatus.jsp");
		}else if(cmd.equalsIgnoreCase("getAlluser")){
			List<UserDTO> lists = dao.getAllUser();
			request.setAttribute("lists",lists);
			forward(request,response,"./WEB-INF/views/userList.jsp");
		}else if(cmd.equalsIgnoreCase("updateAuthForm")){
			String seq = request.getParameter("seq");
			System.out.println("전달받은 파라미터 : " + seq);
			UserDTO dto = dao.getUserInfo(seq);
			request.setAttribute("dto",dto);
			forward(request,response,"./WEB-INF/views/updateAuthForm.jsp");
		}else if(cmd.equalsIgnoreCase("userInfo")){
			HttpSession session = request.getSession();
			String seq = ((UserDTO) session.getAttribute("loginDTO")).getSeq();
			UserDTO dto = dao.getUserInfo(seq);
			request.setAttribute("dto", dto);
			forward(request,response,"./WEB-INF/views/userInfo.jsp");
		}else if(cmd.equalsIgnoreCase("modify")){
			HttpSession session = request.getSession();
			String seq = ((UserDTO) session.getAttribute("loginDTO")).getSeq();
			UserDTO dto = dao.getUserInfo(seq);
			request.setAttribute("dto", dto);
			forward(request,response,"./WEB-INF/views/updateForm.jsp");
		}else if(cmd.equalsIgnoreCase("updateUser")){
			HttpSession session = request.getSession();
			String seq = ((UserDTO) session.getAttribute("loginDTO")).getSeq();
			String address = request.getParameter("address");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			System.out.printf("%s %s %s %s \n" ,seq, address,phone,email);
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("seq", seq);
			map.put("address", address);
			map.put("phone", phone);
			map.put("email", email);
			int n = dao.updateUserInfo(map);
			if(n>0){
//				response.sendRedirect("./userController.jsp?command=userInfo");
				forward(request,response,"./userServelet.do?command=userInfo");
			}else{
				response.sendRedirect("./WEB-INF/views/error.jsp");
			}
		}else if(cmd.equalsIgnoreCase("delUser")){
			HttpSession session = request.getSession();
			String seq = ((UserDTO) session.getAttribute("loginDTO")).getSeq();
			int n = dao.delUser(seq);
			if(n>0){
//				response.sendRedirect("./userController.jsp?command=logout");
				forward(request,response,"./userServelet.do?command=logout");
			}else{
//				response.sendRedirect("./error.jsp");
				forward(request,response,"./WEB-INF/views/error.jsp");

			}
		}else if(cmd.equalsIgnoreCase("insertUser")){
			String id = request.getParameter("id");
			String pw = request.getParameter("password");
			String name = request.getParameter("name");
			String address= request.getParameter("address");
			String phone= request.getParameter("phone");
			String email = request.getParameter("email");
			
			System.out.printf("%s | %s | %s | %s | %s | %s",id, pw, name, address, phone,email);
			UserDTO dto = new UserDTO(id,pw,name,address,phone,email);
			int n = dao.insertUser(dto);
			if(n==1){
//				response.sendRedirect("./index.jsp");
				forward(request, response, "./index.jsp");
			}else{
//				response.sendRedirect("./registForm.jsp");
				forward(request, response, "./WEB-INF/views/registForm.jsp");
			}
		}else if(cmd.equalsIgnoreCase("idChk")){
			String id = request.getParameter("id");
			boolean isc = false;
			
			if(dao.dupulicateId(id)==1){
				isc=true;
			}
			forward(request, response, "./WEB-INF/views/idChk.jsp?isc="+isc);
		}else if(cmd.equalsIgnoreCase("registForm")) {
			forward(request, response, "./WEB-INF/views/registForm.jsp");
		}
			
	}//doprocess
	//값을 가지고 다음페이지로 이동하는 메소드 forward 객체
	private void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
//		request.getRequestDispatcher(url).forward(request, response);

	}
	
	
}

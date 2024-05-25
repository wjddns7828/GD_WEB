<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.min.edu.dto.UserDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.min.edu.dao.UserDaoImpl"%>
<%@page import="com.min.edu.dao.IUserDao"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
<%
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
			request.setAttribute("loginDTO", logindto);
			
			//흐름제어 redirect(값없이 페이지 넘김), forward(값을 가지고 페이지를 넘김)
			//response.sendRedirect("./adminMain.jsp");
			
			//RequestDispatcher dispatcher = request.getRequestDispatcher("이동페이지").forward(req,respose);
			//pageContext.forward("./adminMain.jsp");
			
			//TODO 003 session scope의 범위 연섭
			//request
			
			session.setAttribute("loginDTO",logindto);
			session.setMaxInactiveInterval(10*60);//세션유지 시간 기준은 //10분동안 활동이 없으면 세션은 자동 삭제
			if(logindto.getAuth().equals("AUTH")){
				response.sendRedirect("./adminMain.jsp");
			}else if(logindto.getAuth().equalsIgnoreCase("user")){
				response.sendRedirect("./userMain.jsp");
			}
			}else{
			%>
			<script type="text/javascript">
				alert("아이디 비밀번호를 확인하세요");
				location.href="./index.jsp";
			</script>
		<%
		}
	}else if(cmd.equalsIgnoreCase("logout")){
			session.invalidate();
			response.sendRedirect("./index.jsp");
		}else if(cmd.equalsIgnoreCase("getAlluserStatus")){
			List<UserDTO> lists = dao.getAllUserStatus();
			request.setAttribute("lists",lists);
			pageContext.forward("./userListStatus.jsp");
		}else if(cmd.equalsIgnoreCase("getAlluser")){
			List<UserDTO> lists = dao.getAllUser();
			request.setAttribute("lists",lists);
			pageContext.forward("./userList.jsp");
		}else if(cmd.equalsIgnoreCase("updateAuthForm")){
			String seq = request.getParameter("seq");
			System.out.println("전달받은 파라미터 : " + seq);
			UserDTO dto = dao.getUserInfo(seq);
			request.setAttribute("dto",dto);
			pageContext.forward("./updateAuthForm.jsp");
		}else if(cmd.equalsIgnoreCase("userInfo")){
			String seq = ((UserDTO) session.getAttribute("loginDTO")).getSeq();
			UserDTO dto = dao.getUserInfo(seq);
			request.setAttribute("dto", dto);
			pageContext.forward("./userInfo.jsp");
		}else if(cmd.equalsIgnoreCase("modify")){
			String seq = ((UserDTO) session.getAttribute("loginDTO")).getSeq();
			UserDTO dto = dao.getUserInfo(seq);
			request.setAttribute("dto", dto);
			pageContext.forward("./updateForm.jsp");
		}else if(cmd.equalsIgnoreCase("updateUser")){
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
				response.sendRedirect("./userController.jsp?command=userInfo");
			}else{
				response.sendRedirect("./error.jsp");
			}
		}else if(cmd.equalsIgnoreCase("delUser")){
			String seq = ((UserDTO) session.getAttribute("loginDTO")).getSeq();
			int n = dao.delUser(seq);
			if(n>0){
				response.sendRedirect("./userController.jsp?command=logout");
			}else{
				response.sendRedirect("./error.jsp");
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
				response.sendRedirect("./index.jsp");
			}else{
				response.sendRedirect("./registForm.jsp");
			}
		}else if(cmd.equalsIgnoreCase("idChk")){
			String id = request.getParameter("id");
			boolean isc = false;
			
			if(dao.dupulicateId(id)==1){
				isc=true;
			}
			response.sendRedirect("./idChk.jsp?isc="+isc);
		}
%>
</html>
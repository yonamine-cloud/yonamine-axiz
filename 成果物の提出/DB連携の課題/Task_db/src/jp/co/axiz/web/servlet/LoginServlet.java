package jp.co.axiz.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.web.dao.Role;
import jp.co.axiz.web.dao.UserInfo;
import jp.co.axiz.web.service.RoleService;
import jp.co.axiz.web.service.UserInfoService;
import jp.co.axiz.web.util.DbUtil;
import jp.co.axiz.web.util.Utility;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);

		HttpSession session = request.getSession(true);

		request.setCharacterEncoding("UTF-8");

		Connection con = DbUtil.getConnection();

		String loginId = request.getParameter("loginid");
		String pass = request.getParameter("pass");


		UserInfo userInfo = new UserInfo();
		UserInfoService UserInfoService = new UserInfoService();
		RoleService roleService = new RoleService();

		List<Role> list = new ArrayList<Role>();


		Integer name;


		String error0 = "";
		String error1 = "";
		String error2 = "";


		if(Utility.isNullOrEmpty(loginId))
			error1 = "IDは必須です。";
		if(Utility.isNullOrEmpty(pass))
			error1 = "パスワードは必須です。";

	    		userInfo = UserInfoService.authentication(loginId, pass);

	    		name = userInfo.getRoleId();




	       		list  = roleService.authentication();

	    		session.setAttribute("role", list);
	    		session.setAttribute("userInfo", userInfo);





		if(userInfo == null) {

			error0 = "IDまたはパスワードが間違っています。";
			session.setAttribute("error0", error0);
		    session.setAttribute("error1", error1);
		    session.setAttribute("error2", error2);

		    request.getRequestDispatcher("login.jsp").forward(request, response);

		}else{

			request.getRequestDispatcher("menu.jsp").forward(request, response);

		}


	}

}

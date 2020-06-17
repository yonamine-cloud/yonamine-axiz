package jp.co.axiz.web.servlet.insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.web.dao.UserInfo;
import jp.co.axiz.web.service.UserInfoService;

/**
 * Servlet implementation class InsertConfirmServlet
 */
@WebServlet("/InsertConfirmServlet")
public class InsertConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertConfirmServlet() {
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
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		String rePass= request.getParameter("rePass");
		UserInfo Insuser =  (UserInfo)session.getAttribute("InsUserInfo");
		UserInfoService userInfoService = new UserInfoService();

		System.out.println(Insuser.getPassword());

		String loginId =  Insuser.getLoginId();
		String userName =  Insuser.getUserName();
		String telephone =  Insuser.getTelephone();
		String password =  Insuser.getPassword();
		Integer role = Insuser.getRoleId();


		String error = "";

		if(rePass.equals(Insuser.getPassword())) {
		    userInfoService.authentication8(loginId,userName,telephone,password,role);



			request.getRequestDispatcher("insertResult.jsp").forward(request, response);
		}else {

			error = "前画面で入力したパスワードと一致しません。";
			session.setAttribute("rePasserror", error);
			request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
		}


	}

}

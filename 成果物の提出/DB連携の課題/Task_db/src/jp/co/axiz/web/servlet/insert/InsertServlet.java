package jp.co.axiz.web.servlet.insert;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.axiz.web.dao.UserInfo;
import jp.co.axiz.web.service.RoleService;
import jp.co.axiz.web.service.UserInfoService;
import jp.co.axiz.web.util.Utility;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
		String loginId = request.getParameter("loginid");
		String userName = request.getParameter("name");
		String telephone = request.getParameter("telephone");
		String roleStr = request.getParameter("role");
		String password = request.getParameter("pass");
		String roleName = "";

		System.out.println(roleStr);

		Integer role = Integer.parseInt(roleStr);

		String error1 = "";
		String error2 = "";
		String error3 = "";
		String error4 = "";
		String error5 = "";

		String lognId = "";

		int check = 0;

		UserInfoService UserInfoService = new UserInfoService();
		RoleService roleService = new RoleService();
		UserInfo CheckUserInfo = new UserInfo();

		if(Utility.isNullOrEmpty(loginId)){
			error1 = "ログインIDは必須です。";

			check = 1;
		}

		if(Utility.isNullOrEmpty(userName)){
			error2 = "ユーザー名は必須です。";

			check = 1;
		}

		if(Utility.isNullOrEmpty(telephone)){
			error3 = "電話番号は必須です。";

			check = 1;
		}

		if(Utility.isNullOrEmpty(password)){
			error4 = "パスワードは必須です。";

			check = 1;
		}

			CheckUserInfo = UserInfoService.authentication7(loginId);


			if(check == 0) {
				try{
					CheckUserInfo.getLoginId();
					error1 = "ログインIDが重複しています。";
					check = 1;
				}catch(NullPointerException e) {

				}

			}


		if(check == 1) {
			session.setAttribute("Inserror1", error1);
			session.setAttribute("Inserror2", error2);
			session.setAttribute("Inserror3", error3);
			session.setAttribute("Inserror4", error4);
			request.getRequestDispatcher("insert.jsp").forward(request, response);

		}else {
			roleName = roleService.authentication2(role);

			System.out.println(roleName);

			UserInfo UserInfo = new UserInfo(loginId,userName,telephone,password,role,roleName);



			session.setAttribute("InsUserInfo", UserInfo);
			request.getRequestDispatcher("insertConfirm.jsp").forward(request, response);
		}

	}

}

package jp.co.axiz.web.servlet.select;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class SelectServlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("userName");
		String tel = request.getParameter("tel");

		List<UserInfo> list = new ArrayList<UserInfo>();
		UserInfoService userInfoService = new UserInfoService();
		RoleService roleService = new RoleService();

		String error1 = "";

		if(Utility.isNullOrEmpty(name) && Utility.isNullOrEmpty(tel) ) {
			list = userInfoService.authentication2();
		}else if(Utility.isNullOrEmpty(name) == false && Utility.isNullOrEmpty(tel) == false ){
			list = userInfoService.authentication3(name,tel);
		}else if(Utility.isNullOrEmpty(tel) == false) {
			list = userInfoService.authentication4(tel);
		}else if(Utility.isNullOrEmpty(name) == false) {
			list = userInfoService.authentication5(name);
		}


		if(list.size() == 0) {
			error1 = "入力されたデータはありませんでした。";
			session.setAttribute("error", error1);

			request.getRequestDispatcher("select.jsp").forward(request, response);
		}else {



			session.setAttribute("list", list);

			request.getRequestDispatcher("selectResult.jsp").forward(request, response);
		}


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);



	}

}

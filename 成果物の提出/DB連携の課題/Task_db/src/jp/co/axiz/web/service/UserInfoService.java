package jp.co.axiz.web.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jp.co.axiz.web.dao.UserInfo;
import jp.co.axiz.web.dao.UserInfoDao;
import jp.co.axiz.web.util.DbUtil;

public class UserInfoService {

	 public UserInfo authentication(String id, String pass) {
	        try (Connection conn = DbUtil.getConnection()) {
	            UserInfoDao userInfoDao = new UserInfoDao(conn);
	            UserInfo UserInfo = userInfoDao.findByIdPass(id, pass);



	            return UserInfo;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

	 public List<UserInfo> authentication2() {
	        try (Connection conn = DbUtil.getConnection()) {
	            UserInfoDao userInfoDao = new UserInfoDao(conn);
	            List<UserInfo> list = new ArrayList<UserInfo>();
	            list = userInfoDao.findAll();



	            return list;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

	 public List<UserInfo> authentication3(String name,String tell) {
	        try (Connection conn = DbUtil.getConnection()) {
	            UserInfoDao userInfoDao = new UserInfoDao(conn);
	            List<UserInfo> list = new ArrayList<UserInfo>();
	            list = userInfoDao.findByTelName(name, tell);


	            return list;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

	 public List<UserInfo> authentication4(String tell) {
	        try (Connection conn = DbUtil.getConnection()) {
	            UserInfoDao userInfoDao = new UserInfoDao(conn);
	            List<UserInfo> list = new ArrayList<UserInfo>();
	            list = userInfoDao.findByTel(tell);


	            return list;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

	 public List<UserInfo> authentication5(String name) {
	        try (Connection conn = DbUtil.getConnection()) {
	            UserInfoDao userInfoDao = new UserInfoDao(conn);
	            List<UserInfo> list = new ArrayList<UserInfo>();
	            list = userInfoDao.findByName(name);


	            return list;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

	 public List<UserInfo> authentication6(Integer id) {
	        try (Connection conn = DbUtil.getConnection()) {
	            UserInfoDao userInfoDao = new UserInfoDao(conn);
	            List<UserInfo> list = new ArrayList<UserInfo>();
	            list = userInfoDao.findId(id);

	            return list;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

	 public UserInfo authentication7(String id) {
	        try (Connection conn = DbUtil.getConnection()) {
	            UserInfoDao userInfoDao = new UserInfoDao(conn);
	            UserInfo userInfo = new UserInfo();
	            userInfo = userInfoDao.findLogId(id);

	            return userInfo;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

	 public UserInfo authentication8(String login_id,String user_name,String telephone,String password,Integer role_id) {
	        try (Connection conn = DbUtil.getConnection()) {
	            UserInfoDao userInfoDao = new UserInfoDao(conn);
	            UserInfo userInfo = new UserInfo();
	            userInfo = userInfoDao.Register(login_id, user_name, telephone, password, role_id);

	            return userInfo;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return null;
	    }

}

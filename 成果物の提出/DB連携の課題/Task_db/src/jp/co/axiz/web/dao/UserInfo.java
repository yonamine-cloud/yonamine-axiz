package jp.co.axiz.web.dao;

public class UserInfo {

	private Integer userId;
	private String loginId;
	private String userName;
	private String telephone;
	private String password;
	private Integer roleId;
	private String roleName;


	public UserInfo() {

	}

	public UserInfo(Integer user_id,String login_id,String user_name,String telephone,String password,Integer role_id,String role_name) {
		this.userId = user_id;
		this.loginId = login_id;
		this.userName = user_name;
		this.telephone = telephone;
		this.password = password;
		this.roleId = role_id;
		this.roleName = role_name;
	}

	public UserInfo(String login_id,String user_name,String telephone,String password,Integer role_id, String role_name) {
		this.loginId = login_id;
		this.userName = user_name;
		this.telephone = telephone;
		this.password = password;
		this.roleId = role_id;
		this.roleName = role_name;
	}

	public String getLoginId() {
		return this.loginId;
	}

	public void setLoginId(String id) {
		this.loginId = id;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telphone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setRoleId(Integer id) {
		this.roleId = id;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleName(String name) {
		this.roleName = name;
	}

	public String getRoleName() {
		return this.roleName;
	}


}

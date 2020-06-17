package jp.co.axiz.web.dao;

public class Role {

	private Integer roleId;
	private String roleName;


	public Role() {

	}

	public Role(Integer id,String name) {
		this.roleId = id;
		this.roleName = name;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer id) {
		this.roleId = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String name) {
		this.roleName = name;
	}



}

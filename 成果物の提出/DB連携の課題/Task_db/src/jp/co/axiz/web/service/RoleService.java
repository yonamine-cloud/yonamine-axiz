package jp.co.axiz.web.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import jp.co.axiz.web.dao.Role;
import jp.co.axiz.web.dao.RoleDao;
import jp.co.axiz.web.util.DbUtil;

public class RoleService {

	public List<Role> authentication() {
        try (Connection conn = DbUtil.getConnection()) {
            RoleDao roleDao = new RoleDao(conn);
            List<Role> list = new ArrayList<Role>();
            list = roleDao.findAll();

            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

	public String authentication2(Integer id) {
        try (Connection conn = DbUtil.getConnection()) {
            RoleDao roleDao = new RoleDao(conn);
            String r = "";
            r = roleDao.findName(id);

            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}

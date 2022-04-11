package servletProject.service;

import servletProject.dao.AdminDao;
import servletProject.dao.impl.AdminDaoImpl;
import servletProject.entity.Admin;
import servletProject.utils.DbUtils;

import java.util.List;

/**
 * @author yqf
 * @create 2022-03-30-23:36
 */
public class AdminServiceImpl implements AdminService{
    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public Admin login(String username, String password) {
        Admin result = null;
        try{
            DbUtils.begin();
            Admin admin = adminDao.select(username);
            if(admin != null){
                if(password.equals(admin.getPassword())){
                    result = admin;
                }
            }
            DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollBack();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Admin> showAllAdmin() {
        List<Admin> result = null;
        try{
            DbUtils.begin();
            List<Admin> admins = adminDao.selectAll();
            if(admins != null){
                result = admins;
            }
            DbUtils.commit();
        }catch (Exception e){
            DbUtils.rollBack();
            e.printStackTrace();
        }
        return result;
    }
}

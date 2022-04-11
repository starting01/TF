package servletProject.service;

import servletProject.entity.Admin;

import java.util.List;

/**
 * @author yqf
 * @create 2022-03-30-23:34
 */
public interface AdminService {
    public Admin login(String username,String password);
    public List<Admin> showAllAdmin();
}

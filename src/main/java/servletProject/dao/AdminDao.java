package servletProject.dao;

import servletProject.entity.Admin;

import java.util.List;

/**
 * @author yqf
 * @create 2022-03-30-23:19
 */
public interface AdminDao {
    public int insert(Admin admin);
    public int delete(Admin admin);
    public int update(Admin admin);
    public Admin select(String username);
    public List<Admin> selectAll();
}

package servletProject.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import servletProject.dao.AdminDao;
import servletProject.entity.Admin;
import servletProject.utils.DbUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author yqf
 * @create 2022-03-30-23:22
 */
public class AdminDaoImpl implements AdminDao {
    private QueryRunner queryRunner = new QueryRunner();
    @Override
    public int insert(Admin admin) {
        return 0;
    }

    @Override
    public int delete(Admin admin) {
        return 0;
    }

    @Override
    public int update(Admin admin) {
        return 0;
    }

    @Override
    public Admin select(String username) {
        String sql = "select * from user where username = ?";
        try {
            Admin admin = queryRunner.query(DbUtils.getConnection(),sql,new BeanHandler<Admin>(Admin.class),username);
            return admin;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Admin> selectAll() {
        try {
            List<Admin> admin;
            admin = queryRunner.query(DbUtils.getConnection(),"select * from user",new BeanListHandler<Admin>(Admin.class));
            return admin;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

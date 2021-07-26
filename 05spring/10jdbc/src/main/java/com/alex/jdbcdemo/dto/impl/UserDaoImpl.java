package com.alex.jdbcdemo.dto.impl;

import com.alex.jdbcdemo.dto.UserDao;
import com.alex.jdbcdemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(User user) {
        String sql = "insert into t_user(id,username) values(?,?,?)";
        return this.jdbcTemplate.update(
                sql,
                user.getId(),
                user.getUsername()
        );
    }

    @Override
    public int delete(int id) {
        String sql = "delete from t_user where id = ?";
        return this.jdbcTemplate.update(sql, id);
    }

    @Override
    public int update(User user) {
        String sql = "update t_user set username = ? where id = ?";
        return this.jdbcTemplate.update(
                sql,
                user.getUsername(),
                user.getId()
        );
    }

    @Override
    public User getById(int id) {
        String sql = "select * from t_user where id = ?";
        return this.jdbcTemplate.queryForObject(sql, new RowMapper<User>() {

            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                return user;
            }

        }, id);
    }
}

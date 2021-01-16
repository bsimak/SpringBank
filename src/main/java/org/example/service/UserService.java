package org.example.service;

import org.example.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.UUID;

@Component
public class UserService {

    private final JdbcTemplate jdbcTemplate;
    private final String userId;
    private final String name;
    private final String pwd;

    public User findUser(String userId) {
        return jdbcTemplate.query("select user_id, name, pwd " +
                "from invoices", (resultSet, rowNum) -> {
            User user = new User();
            user.setUserId(resultSet.getString("user_id"));
            user.setName(resultSet.getString("name"));
            user.setPwd(resultSet.getString("pwd"));
            return new User(userId);
        });
    }

    @Transactional
    public User create(String id, String userId, String name, String pwd) {
        System.out.println("Is a database transaction open? = "
                + TransactionSynchronizationManager.isActualTransactionActive());
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("insert into invoices (id, user_id,name, pwd) values (?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,id);
            ps.setString(2, userId);
            ps.setString(3,name);
            ps.setString(4,pwd);
            return ps;
        }, keyHolder);

        String uuid;
        uuid = !keyHolder.getKeys().isEmpty() ?
                keyHolder.getKeys().values().iterator().next().toString() : null;
        User user = new User();
        user.setId(uuid);
        user.setUserId(userId);
        user.setName(name);
        user.setPwd(pwd);
        return User;
    }
}

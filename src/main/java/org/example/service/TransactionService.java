package org.example.service;

import org.example.model.Transaction;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.ZonedDateTime;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class TransactionService {

    private final JdbcTemplate jdbcTemplate;
    private final UserService userService;
    private final String reference;
    private final String name;
    private final Integer amount;


    private final List<Transaction> transactions = new CopyOnWriteArrayList<>(); // (1)

    public TransactionService(UserService userService,
                              JdbcTemplate jdbcTemplate) {
        this.userService = userService;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public List<Transaction> findAll() {
        System.out.println("find all transaction");
        return jdbcTemplate.query("select id, user_id,t_timestamp, amount, reference " +
                "from bank_transactions", (resultSet, rowNum) -> {
            Transaction transaction = new Transaction();
            transaction.setId(resultSet.getObject("id").toString());
            transaction.setTimestamp(resultSet.getTimestamp("t_timestamp"));
            transaction.setUserId(resultSet.getString("user_id"));
            transaction.setAmount(resultSet.getInt("amount"));
            transaction.setReference(resultSet.getString("reference"));
            return transactions;
        });
    }
        @Transactional
        public Transaction create (String userId, Integer amount, String reference) {
            System.out.println("Is a database transaction open? = "
                    + TransactionSynchronizationManager.isActualTransactionActive());
            KeyHolder keyHolder = new GeneratedKeyHolder();

            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement("insert into transactions (id, user_id,amount, reference) values (?,?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1,userId);
                ps.setInt(2,amount);
                ps.setString(3,reference);
                return ps;
            }, keyHolder);

            String uuid;
            uuid = !keyHolder.getKeys().isEmpty() ?
                    keyHolder.getKeys().values().iterator().next().toString() : null;
            Transaction transaction = new Transaction();
            transaction.setId(uuid);
            transaction.setUserId(userId);
            transaction.setAmount(amount);
            transaction.setReference(reference);
            return transaction;
        }
}

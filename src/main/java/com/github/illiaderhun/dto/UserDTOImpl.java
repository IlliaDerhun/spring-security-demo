package com.github.illiaderhun.dto;

import com.github.illiaderhun.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class UserDTOImpl implements UserDTO {

    @Autowired
    private DataSource securityDataSource;

    @Override
    public void saveUser(User user) {
        try {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setPassword("{bcrypt}" + encoder.encode(user.getPassword()));
            Connection connection = securityDataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(
                "INSERT INTO `spring_security_demo_plaintext`.`users` (`username`, `password`, `enabled`) VALUES (?, ?, ?);");
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getPassword());
            statement.setInt(3, 1);

            statement.executeUpdate();
            statement.clearParameters();

            statement = connection.prepareStatement(
                "INSERT INTO `spring_security_demo_plaintext`.`authorities` (`username`, `authority`) VALUES (?, 'ROLE_EMPLOYEE');");
            statement.setString(1, user.getFirstName());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

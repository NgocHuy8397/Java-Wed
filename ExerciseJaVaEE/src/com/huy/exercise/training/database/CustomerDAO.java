package com.huy.exercise.training.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.huy.exercise.training.model.Customer;
import com.huy.exercise.training.model.Gender;
import com.huy.exercise.training.model.MembershipLevel;

public class CustomerDAO {
    public void addCustomerViaStament() {
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;

        try {
            stmt = con.createStatement();
            int maxId = getMaxCustomerId(stmt);
            String sql = String.format("insert into customer(id, name) values (%s, 'Nguyen Van %s')", (maxId + 1),
                    System.currentTimeMillis() % 10);
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(stmt);
        }
    }

    public static void main(String[] args) {
//        CustomerDAO c = new CustomerDAO();
//        try {
////            c.addCustomertsTransactionalViaPreparedStatement();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        c.info();

    }

    public int getMaxCustomerId() throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            return getMaxCustomerId(stmt);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeQuietly(stmt);

        }
        return 0;
    }

    private int getMaxCustomerId(Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery("select max(id) as id from customer");
        if (rs.next()) {
            return rs.getInt("id");
        }

        return 0;
    }

    public List<Customer> info() {
        List<Customer> customer = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DatabaseConnection.getConnection().prepareStatement("select * from customer");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String phoneNumber = rs.getString("phone");
                String address = rs.getString("address");
                String email = rs.getString("email");
                int point = rs.getInt("point");
                String membershipLevel = rs.getString("membership_level");

//                System.out.println("id: " + id);
//                System.out.println("name: " + name);
//                System.out.println("gender: " + gender);
//                System.out.println("phoneNumber: " + phoneNumber);
//                System.out.println("address: " + address);
//                System.out.println("email: " + email);
//                System.out.println("point: " + point);
                System.out.println("membershipLevel: " + membershipLevel);

                Customer c = new Customer();
                c.setId(id);
                c.setName(name);
                c.setGender(Gender.valueOf(gender));
                c.setMembershipLevel(MembershipLevel.valueOf(membershipLevel));
                c.setPhoneNumber(phoneNumber);
                c.setAddress(address);
                c.setEmail(email);
                c.setPoint(point);
                customer.add(c);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeQuietly(preparedStatement);
        }

        return customer;
    }

    public void addCustomer(Customer c) {
        Connection connection = DatabaseConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {

            connection.setAutoCommit(false);

            int maxId = getMaxCustomerId();
            preparedStatement = connection.prepareStatement(
                    "insert into customer(id, name, gender, phone, address, email, membership_level, point) values (?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, ++maxId);
            preparedStatement.setString(2, c.getName());
            preparedStatement.setString(3, c.getGender().toString());
            preparedStatement.setString(4, c.getPhoneNumber());
            preparedStatement.setString(5, c.getAddress());
            preparedStatement.setString(6, c.getEmail());
            preparedStatement.setString(7, c.getMembershipLevel().toString());
            preparedStatement.setInt(8, c.getPoint());
            preparedStatement.executeUpdate();
            connection.commit();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeQuietly(preparedStatement);
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DatabaseConnection.getConnection()
                    .prepareStatement("delete from customer where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeQuietly(preparedStatement);
        }
    }

    public void editCustomer(Customer customer) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DatabaseConnection.getConnection()
                    .prepareStatement("update customer set name = ?,gender = ?, phone = ?, address = ?, email = ?,membership_level = ?, point = ? where id  = ?");
            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2,customer.getGender().toString());
            preparedStatement.setString(3,customer.getPhoneNumber());
            preparedStatement.setString(4,customer.getAddress());
            preparedStatement.setString(5,customer.getEmail());
            preparedStatement.setString(6, customer.getMembershipLevel().toString());
            preparedStatement.setInt(7,customer.getPoint());
            preparedStatement.setInt(8,customer.getId());
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeQuietly(preparedStatement);
        }
    }
    public List<Customer> searchCustomers(String name , String gender, String phone, String membershipLevel) {
        List<Customer> customers = new ArrayList<>(); 
        PreparedStatement preparedStatement = null;
        try {
            String sql = "select * from customer where";
            String whereSql = "";
            System.out.println("NAME" + name);
            if (name != null && !name.isEmpty()) {
                if(!whereSql.isEmpty()) whereSql += " and";
                whereSql += " name ilike ?";
            }
            if (gender != null && !gender.isEmpty()) {
                if (!whereSql.isEmpty()) whereSql += " and";
                whereSql += " gender = ?";
            }
            if (phone != null && !phone.isEmpty()) {
                if(!whereSql.isEmpty()) whereSql += " and";
                whereSql += " phone ilike ?";
            }
            if (membershipLevel != null && !membershipLevel.isEmpty()) {
                if(!whereSql.isEmpty()) whereSql += " and";
                whereSql += " membership_level ilike ?";
            }
            sql += whereSql;
            int index = 0;
            System.out.println("sql: " + sql);
            preparedStatement = DatabaseConnection.getConnection().prepareStatement(sql);
            if (name != null && !name.isEmpty()) {
                index ++;
                preparedStatement.setString(index, "%" + name + "%");
//                System.out.println("index" + index);
            }
            if (gender != null && !gender.isEmpty()) {
                index ++;
                //preparedStatement.setString(index, "%" + gender + "%");
                preparedStatement.setString(index, gender);
//                System.out.println("index" + index);
            }
            if (phone != null && !phone.isEmpty()) {
                index ++;
                preparedStatement.setString(index, "%" + phone + "%");
                System.out.println("index" + index);
            }
            if (membershipLevel != null && !membershipLevel.isEmpty()) {
                index ++;
                preparedStatement.setString(index, "%" + membershipLevel + "%");
                System.out.println("index" + index);
            }
            
            ResultSet  rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(Integer.parseInt(rs.getString("id")));
                c.setName(rs.getString("name"));
                c.setGender(Gender.valueOf(rs.getString("gender")));
                c.setPhoneNumber(rs.getString("phone"));
                c.setAddress(rs.getString("address"));
                c.setEmail(rs.getString("email"));
                c.setMembershipLevel(MembershipLevel.valueOf(rs.getString("membership_level")));
                c.setPoint(Integer.parseInt(rs.getString("point")));
                customers.add(c);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeQuietly(preparedStatement);
        }
        return customers;
    }

    private void closeQuietly(Statement statement) {
        if (statement != null)
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    public Customer getCustomerById(int customerId) {

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = DatabaseConnection.getConnection()
                    .prepareStatement("select * from customer where id = ?");
            preparedStatement.setInt(1, customerId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs == null || rs.next() == false) {
                return null;
            }

            int id = rs.getInt("id");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            String email = rs.getString("email");
            String address = rs.getString("address");
            String phoneNumber = rs.getString("phone");
            int point = rs.getInt("point");
            String membershipLevel = rs.getString("membership_level");

//            System.out.println("id: " + id);
//            System.out.println("name: " + name);
//            System.out.println("gender: " + gender);
//            System.out.println("phoneNumber: " + phoneNumber);
//            System.out.println("email: " + email);
//            System.out.println("address: " + address);
//            System.out.println("point: " + point);
//            System.out.println("membershipLevel: " + membershipLevel);
            Customer c = new Customer();
            c.setId(id);
            c.setName(name);
            c.setGender(Gender.valueOf(gender));;
            c.setMembershipLevel(MembershipLevel.valueOf(membershipLevel));
            c.setPhoneNumber(phoneNumber);
            c.setAddress(address);
            c.setEmail(email);
            c.setPoint(point);
            return c;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeQuietly(preparedStatement);

        }
    }
}

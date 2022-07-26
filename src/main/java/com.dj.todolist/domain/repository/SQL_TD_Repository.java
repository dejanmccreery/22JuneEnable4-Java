package com.dj.todolist.domain.repository;

import com.dj.todolist.domain.entity.ToDoItem;
import com.dj.todolist.utilities.JDBC_Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// does not have to be abstract -- shouts at me if I make it not abstract
public abstract class SQL_TD_Repository implements Repository<ToDoItem, Long> {
    private List<ToDoItem> listOfItems;
    private long idCounter;

    public SQL_TD_Repository() {

    }

    @Override
    public boolean save(ToDoItem item) {

        // WE NEVER EVER EVER CONCATENATE WHEN WRITING PROTECT STATEMENTS
        // WE USE QUESTION MARKS AS PLACEHOLDERS
        // these are called blind variables
        String sql = "INSERT INTO todo_item(name, dueDate) VALUES(?,?)";
        String[] columnNames = new String[] {"id"}; // this indicates the data we want returned


        try (Connection conn = JDBC_Utils.getConnection();
             // passing enum that returns generated keys
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ) {
        // a prepared statement pre-initialises the statement
            // sends it with data and the statement
            // the database knows how to bind the two and execute
        // a prepared statement has data inserted counting from 1
            // each blind variable in the sql code has an associated number
            // the first ? is 1
            ps.setString(1, item.getName());
            ps.setDate(2, Date.valueOf(item.getDueDate()));

            //executeUpdate is used for INSERT, UPDATE, DELETE sql statements
            //executeQuery for SELECT
            try {
                int modifiedCount = ps.executeUpdate();
                // with AUTO-INCREMENT we can auto-generate the Primary key
                if (modifiedCount > 0) {
                    // if modified count is greater than 0
                    // we know something was created
                    // so a result set will be returned containing any auto-generated IDs
                    ResultSet keys = ps.getGeneratedKeys();

                    if (keys.next()) {
                        item.setID(keys.getLong(1)); // we use
                        return true;
                    }
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; //if fails
        // he says make the return type a to do item -- this does make calling things easier
    }

    public List<ToDoItem> read(){
        List<ToDoItem> listOfItems = new ArrayList<>();

        // TRY-WITH-RESOURCES
        // rather than using a finally block to close resources, if they implement the AutoCloseable
            // interface, we can use a specialised try-catch

        try (Connection conn = JDBC_Utils.getConnection();
             Statement statement = conn.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM todo_item");

            // we start before the first row so we always call rs.next at least once.
            // it starts before the first one bc if there is nothing in the table
            // next will return false, and we will know the table is empty
            while (rs.next()) {
                // abstracted the code away to private method
                listOfItems.add(unwrap(rs));
            }

        } catch (SQLException e) {

        }
        return listOfItems;
    }

    @Override
    public void update(ToDoItem item){

    }



    public boolean deleteByID(long id){
        return false;
    }

    public boolean deleteByName(String name){
        return false;
    }

    public ToDoItem saveForTest(ToDoItem item) {

        // WE NEVER EVER EVER CONCATENATE WHEN WRITING PROTECT STATEMENTS
        // WE USE QUESTION MARKS AS PLACEHOLDERS
        // these are called blind variables
        String sql = "INSERT INTO todo_item(name, dueDate) VALUES(?,?)";
        String[] columnNames = new String[] {"id"}; // this indicates the data we want returned


        try (Connection conn = JDBC_Utils.getConnection();
             // passing enum that returns generated keys
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            // a prepared statement pre-initialises the statement
            // sends it with data and the statement
            // the database knows how to bind the two and execute
            // a prepared statement has data inserted counting from 1
            // each blind variable in the sql code has an associated number
            // the first ? is 1
            ps.setString(1, item.getName());
            ps.setDate(2, Date.valueOf(item.getDueDate()));

            //executeUpdate is used for INSERT, UPDATE, DELETE sql statements
            //executeQuery for SELECT
            try {
                int modifiedCount = ps.executeUpdate();
                // with AUTO-INCREMENT we can auto-generate the Primary key
                if (modifiedCount > 0) {
                    // if modified count is greater than 0
                    // we know something was created
                    // so a result set will be returned containing any auto-generated IDs
                    ResultSet keys = ps.getGeneratedKeys();

                    if (keys.next()) {
                        item.setID(keys.getLong(1)); // we use
                        return item;
                    }
                }

            } catch (SQLException e){
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // if fails
    }

    private ToDoItem unwrap(ResultSet rs) throws SQLException {
        long id = rs.getLong("id");
        String name = rs.getString("name");
        Date date = rs.getDate("dueDate");
        return new ToDoItem(id,name,date.toLocalDate());
    }

}



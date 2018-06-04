package com.edutilos.jdbc;

import com.edutilos.pojo.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 30/08/2016.
 */
public class PersonJDBCHelper {
  //properties
    private String url = "jdbc:mysql://localhost/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String driver = "com.mysql.jdbc.Driver";
    private String user = "root";
    private String password = "";

    //
    private Connection conn ;
    private Statement stmt ;
    private PreparedStatement pstmt ;
    private ResultSet rs ;


    public void savePerson(Person p) {
        try {
            String cmd = "insert into Person(name, age, wage, active) VALUES(?,?,?,?)";
            pstmt = conn.prepareStatement(cmd);
            pstmt.setString(1, p.getName());
            pstmt.setInt(2, p.getAge());
            pstmt.setDouble(3, p.getWage());
            pstmt.setBoolean(4, p.isActive());
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
             if(pstmt != null)
                 try {
                     pstmt.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
        }
    }


    public void updatePerson(long id , Person p) {
        try {
            String cmd = "update Person set name = ? , age = ? , wage =? , active = ? where id = ?";
            pstmt = conn.prepareStatement(cmd);
            pstmt.setString(1, p.getName());
            pstmt.setInt(2, p.getAge());
            pstmt.setDouble(3, p.getWage());
            pstmt.setBoolean(4, p.isActive());
            pstmt.setLong(5, id);
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if(pstmt != null)
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }


    public void deletePerson(long id) {
        try {
            String cmd = "delete from Person where id = ?";
            pstmt = conn.prepareStatement(cmd);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
             if(pstmt != null)
                 try {
                     pstmt.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
        }
    }


    public List<Person> findAll() {
        List<Person> l = new ArrayList<>();
        try {
          String cmd = "select * from Person";
            rs = stmt.executeQuery(cmd);
            while(rs.next()) {
                Person p = new Person();
                p.setId(rs.getLong(1));
                p.setName(rs.getString(2));
                p.setAge(rs.getInt(3));
                p.setWage(rs.getDouble(4));
                p.setActive(rs.getBoolean(5));
                l.add(p);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }  finally {
             if( rs != null)
                 try {
                     rs.close();
                 } catch (SQLException e) {
                     e.printStackTrace();
                 }
        }

        return l ;
    }

    public Person findById(long id){
         try {
             String cmd = "select * from Person where id = ?";
             pstmt = conn.prepareStatement(cmd);
             pstmt.setLong(1, id);
             rs = pstmt.executeQuery();
             rs.next();
             Person p = new Person();
             p.setId(rs.getLong(1));
             p.setName(rs.getString(2));
             p.setAge(rs.getInt(3));
             p.setWage(rs.getDouble(4));
             p.setActive(rs.getBoolean(5));
             return p;
         } catch(Exception ex) {
             ex.printStackTrace();
         }
        return null ;
    }

    public void dropTablePerson() {
          try {
              String cmd = "drop table if exists Person";
              stmt.executeUpdate(cmd);
          } catch(Exception ex) {
              ex.printStackTrace();
          }
    }

    public void createTablePerson() {
         try {
           String cmd = "create table if not exists Person (\n" +
                   " id bigint primary key auto_increment , \n" +
                   " name varchar(50) not null , \n" +
                   " age int not null , \n" +
                   " wage double not null , \n" +
                   " active boolean not null\n" +
                   ")";
             stmt.executeUpdate(cmd);
         } catch(Exception ex) {
             ex.printStackTrace();
         }
    }



    public void connect() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url , user, password);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
       if(rs!= null)
           try {
               rs.close();
           } catch (SQLException e) {
               e.printStackTrace();
           }

        if(pstmt != null)
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        if(stmt != null)
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        if(conn != null)
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
}

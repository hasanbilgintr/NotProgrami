/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import BLL.customers;
import BLL.mainclass;
import BLL.notes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author hasan
 */
public class tbl_customers {

    Connection connection=null;
    dbhelper dbhelper =null;
    Statement statement = null;
    ResultSet resultSet=null;
    String sorgu = "";
    ArrayList<customers> acustomers = null;
    Date tarih;
    PreparedStatement pstatement = null;
    String data = null;

    public ArrayList<customers> notesList() throws SQLException, ParseException {
        try {
            dbhelper=new dbhelper();
            connection = dbhelper.getConnection();
            statement = connection.createStatement();
            sorgu = "SELECT *FROM TBL_CUSTOMERS";
            try {
                resultSet = statement.executeQuery(sorgu);
                acustomers = new ArrayList<customers>();
                while (resultSet.next()) {
                    acustomers.add(new customers(
                            resultSet.getInt("CUSTOMER"),
                            resultSet.getString("CUSTOMERNAME")
                    ));
                };
            } catch (SQLException e) {
            }
        } catch (SQLException e) {
        } finally {
            statement.close();
            connection.close();
        }
        return acustomers;
    }

    public String Customerdata(int customer) throws SQLException {

        try {
              dbhelper=new dbhelper();
            connection = dbhelper.getConnection();
            statement = connection.createStatement();
            sorgu = "SELECT *FROM TBL_CUSTOMERS WHERE CUSTOMER=" + customer;

            resultSet = statement.executeQuery(sorgu);
            /*  acustomers = new ArrayList<customers>();*/
            
            if(resultSet.next()) {
                String data = resultSet.getString("CUSTOMERNAME");
                /*System.out.println(resultSet.getString("CUSTOMERNAME"));*/
                return data;
            }
        } catch (SQLException e) {
        } finally {
            statement.close();
            connection.close();
        }
         return data;
       
    }
}

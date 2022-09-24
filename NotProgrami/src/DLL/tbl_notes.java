package DLL;

import BLL.mainclass;
import BLL.notes;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

public class tbl_notes {

    Connection connection;
    dbhelper dbhelper = new dbhelper();
    Statement statement = null;
    ResultSet resultSet;
    String sorgu = "";
    ArrayList<notes> anotes = null;
    Date tarih;


    /*MYSQLDE GÜVENLİ MODU KAPAMAK İÇİN EDİT PREFENCESED (TERCİHLER) SQL EDİOR SEKMESİNDE EN ALTTA VAR SAFE UPDATES ... İŞARETİ KALDIR*/
 /*kod düzelt için alt sift +f */
    public ArrayList<notes> notesList(String id, int notetype, int companyid, String subject, String description, String createdate1, String createdate2, String requestdate1, String requestdate2, String deliverydate1, String deliverydate2, String plandate1, String plandate2, int ispicture, int iswait, int isdo, int status, int userid) throws SQLException, ParseException {
        try {
            connection = dbhelper.getConnection();
            statement = connection.createStatement();
            sorgu = sorgu = "SELECT *FROM TBL_NOTES  WHERE";
            if (notetype > 0) {
                sorgu = sorgu + " NOTETYPE=" + notetype;
            } else {
                sorgu = sorgu + " NOTETYPE lIKE '%'";
            }
            if (companyid > 0) {
                sorgu = sorgu + " AND COMPANYID=" + companyid;
            }

            if (mainclass.isEB(id)) {
                sorgu = sorgu + " AND ID LIKE '%" + id + "%'";
            }
            if (mainclass.isEB(subject)) {
                sorgu = sorgu + " AND SUBJECT LIKE '%" + subject + "%'";
            }
            if (mainclass.isEB(description)) {
                sorgu = sorgu + " AND DESCRIPTION LIKE '%" + description + "%'";
            }
            if (createdate1 != "") {
                sorgu = sorgu + " AND CREATEDATE>='" + createdate1 + ":00'";
            }
            if (createdate2 != "") {
                sorgu = sorgu + " AND CREATEDATE<='" + createdate2 + ":00'";
            }
            if (requestdate1 != "") {
                sorgu = sorgu + " AND REQUESTDATE>='" + requestdate1 + ":00'";
            }
            if (requestdate2 != "") {
                sorgu = sorgu + " AND REQUESTDATE<='" + requestdate2 + ":00'";
            }
            if (deliverydate1 != "") {
                sorgu = sorgu + " AND DELIVERYDATE>='" + requestdate1 + ":00'";
            }
            if (deliverydate2 != "") {
                sorgu = sorgu + " AND DELIVERYDATE<='" + requestdate2 + ":00'";
            }
            if (plandate1 != "") {
                sorgu = sorgu + " AND PLANDATE>='" + plandate1 + ":00'";
            }
            if (plandate2 != "") {
                sorgu = sorgu + " AND PLANDATE<='" + plandate2 + ":00'";
            }
            if (ispicture == 1) {
                sorgu = sorgu + " AND ISPICTURE=1";
            } else if (ispicture == 2) {
                sorgu = sorgu + " AND ISPICTURE=0";
            }
            if (iswait == 1) {
                sorgu = sorgu + " AND ISWAIT=1";
            } else if (iswait == 2) {
                sorgu = sorgu + " AND ISWAIT=0";
            }
            if (isdo == 1) {
                sorgu = sorgu + " AND ISDO=1";
            } else if (isdo == 2) {
                sorgu = sorgu + " AND ISDO=0";
            }
            if (status == 1) {
                sorgu = sorgu + " AND STATUS=1";
            } else if (status == 2) {
                sorgu = sorgu + " AND STATUS=0";
            }

            sorgu = sorgu + " AND USERID=" + userid;

            try {
                resultSet = statement.executeQuery(sorgu);

                anotes = new ArrayList<notes>();

                while (resultSet.next()) {

                    anotes.add(new notes(
                            resultSet.getInt("id"),
                            resultSet.getByte("notetype"),
                            resultSet.getInt("companyid"),
                            resultSet.getString("subject"),
                            resultSet.getString("description"),
                            resultSet.getDate("createdate"),
                            resultSet.getDate("requestdate"),
                            resultSet.getDate("deliverydate"),
                            resultSet.getDate("plandate"),
                            resultSet.getByte("ispicture"),
                            resultSet.getByte("iswait"),
                            resultSet.getByte("isdo"),
                            resultSet.getByte("status"),
                            resultSet.getInt("userid")));
                };
            } catch (SQLException e) {

            }

        } catch (SQLException e) {

        } finally {
            statement.close();
            connection.close();
        }

        return anotes;

    }

}

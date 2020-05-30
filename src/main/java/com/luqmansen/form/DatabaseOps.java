package com.luqmansen.form;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import org.mariadb.jdbc.Driver;

import javax.faces.context.FacesContext;

import com.luqmansen.form.StudentBean;

public class DatabaseOps {

    public static Statement stmtObj;
    public static Connection connObj;
    public static ResultSet resultSetObj;
    public static PreparedStatement pstmt;

    public static Connection getConnection(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            String db_url ="jdbc:mariadb://mariadb:3306/students",
                    db_userName = "root",
                    db_password = "root";
            connObj = DriverManager.getConnection(db_url,db_userName,db_password);
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        return connObj;
    }

    public static ArrayList getStudentsListFromDB() {
        ArrayList studentsList = new ArrayList();
        try {
            System.out.println("Fetching Student data");
            stmtObj = getConnection().createStatement();
            resultSetObj = stmtObj.executeQuery("select * from student_record;");
            while(resultSetObj.next()) {
                StudentBean stuObj = new StudentBean();
                stuObj.setFirstname(resultSetObj.getString("f_name"));
                stuObj.setLastname(resultSetObj.getString("l_name"));
                stuObj.setEmail(resultSetObj.getString("email"));
                studentsList.add(stuObj);
            }
            System.out.println("Total Records Fetched: " + studentsList.size());
            connObj.close();
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        return studentsList;
    }

    public static String saveStudentDetailsInDB(StudentBean newStudentObj) {
        int saveResult = 0;
        String navigationResult = "";
        try {
            pstmt = getConnection().prepareStatement("insert into student_record (f_name,l_name, email) values (?, ?, ?)");
            pstmt.setString(1, newStudentObj.getFirstname());
            pstmt.setString(2, newStudentObj.getLastname());
            pstmt.setString(3, newStudentObj.getEmail());
            saveResult = pstmt.executeUpdate();
            connObj.close();
        } catch(Exception sqlException) {
            sqlException.printStackTrace();
        }
        if(saveResult !=0) {
            navigationResult = "studentsList.xhtml?faces-redirect=true";
        } else {
            navigationResult = "failed.xhtml";
        }
        return navigationResult;
    }

//    public static String editStudentRecordInDB(int studentId) {
//        StudentBean editRecord = null;
//        System.out.println("editStudentRecordInDB() : Student Id: " + studentId);
//
//        /* Setting The Particular Student Details In Session */
//        Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//
//        try {
//            stmtObj = getConnection().createStatement();
//            resultSetObj = stmtObj.executeQuery("select * from student_record where student_id = "+studentId);
//            if(resultSetObj != null) {
//                resultSetObj.next();
//                editRecord = new StudentBean();
//                editRecord.setId(resultSetObj.getInt("student_id"));
//                editRecord.setName(resultSetObj.getString("student_name"));
//                editRecord.setEmail(resultSetObj.getString("student_email"));
//                editRecord.setGender(resultSetObj.getString("student_gender"));
//                editRecord.setAddress(resultSetObj.getString("student_address"));
//                editRecord.setPassword(resultSetObj.getString("student_password"));
//            }
//            sessionMapObj.put("editRecordObj", editRecord);
//            connObj.close();
//        } catch(Exception sqlException) {
//            sqlException.printStackTrace();
//        }
//        return "/editStudent.xhtml?faces-redirect=true";
//    }

//    public static String updateStudentDetailsInDB(StudentBean updateStudentObj) {
//        try {
//            pstmt = getConnection().prepareStatement("update student_record set student_name=?, student_email=?, student_password=?, student_gender=?, student_address=? where student_id=?");
//            pstmt.setString(1,updateStudentObj.getName());
//            pstmt.setString(2,updateStudentObj.getEmail());
//            pstmt.setString(3,updateStudentObj.getPassword());
//            pstmt.setString(4,updateStudentObj.getGender());
//            pstmt.setString(5,updateStudentObj.getAddress());
//            pstmt.setInt(6,updateStudentObj.getId());
//            pstmt.executeUpdate();
//            connObj.close();
//        } catch(Exception sqlException) {
//            sqlException.printStackTrace();
//        }
//        return "/studentsList.xhtml?faces-redirect=true";
//    }

//    public static String deleteStudentRecordInDB(int studentId){
//        System.out.println("deleteStudentRecordInDB() : Student Id: " + studentId);
//        try {
//            pstmt = getConnection().prepareStatement("delete from student_record where student_id = "+studentId);
//            pstmt.executeUpdate();
//            connObj.close();
//        } catch(Exception sqlException){
//            sqlException.printStackTrace();
//        }
//        return "/studentsList.xhtml?faces-redirect=true";
//    }
}
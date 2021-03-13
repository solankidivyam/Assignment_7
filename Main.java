//Divyam Solanki
//201951198

import java.sql.*;
import java.util.Scanner;
import java.io.*;
public class Main {
public static void main(String[] args) {
    //Creating a Scanner object
    Scanner sc = new Scanner(System.in);
    //Here we are connecting to Question_2 Database in MySQL in this Computer.

    try
    {  
        Class.forName("com.mysql.cj.jdbc.Driver");  
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/Question_2","root","Divyam@123");  

        while(true) {
            System.out.println("Enter any choice as per the given options");
            System.out.println("1. Insert into Branch");
            System.out.println("2. Insert into Course");
            System.out.println("3. Insert into Department");
            System.out.println("4. Insert into Student");
            System.out.println("5. Insert into ENROLLS");
            System.out.println();
            int k = sc.nextInt();
            switch(k) {
                case 1 : 
                    String BCode, BName, DNo;
                    System.out.println("Enter BCode : " );
                    BCode = sc.next();
                    System.out.println();
                    System.out.println("Enter BName : " );
                    BName = sc.next();
                    System.out.println();
                    System.out.println("Enter DNo : " );
                    DNo = sc.next();
                    System.out.println();
                    System.out.println(BCode + " :: " + BName + " :: " + DNo);
                    String query = "insert into Branch " + "values (?,?,?) ;";
                    PreparedStatement thisstmt = con.prepareStatement(query);
                    thisstmt.setString(1,BCode);
                    thisstmt.setString(2,BName);
                    thisstmt.setString(3,DNo);
                    thisstmt.executeUpdate();
                    System.out.println("The values are finally added!!..\n");
                    break;
                case 2 : 
                    
                    int Credits;
                    String CCode, CName, DNo1;    
                    System.out.println("Enter CCode : " );
                    CCode = sc.next();
                    System.out.println();

                    System.out.println("Enter CName : " );
                    CName = sc.next();
                    System.out.println();

                    System.out.println("Enter DNo : " );
                    DNo1 = sc.next();
                    System.out.println();

                    System.out.println("Enter Credits : " );
                    Credits = sc.nextInt();
                    System.out.println();

                    System.out.println(CCode + " :: " + CName + " :: " + DNo1 + " :: " + Credits);
                    String query1 = "insert into Course " + "values (?,?,?,?) ;";
                    PreparedStatement thisstmt1 = con.prepareStatement(query1);
                    thisstmt1.setString(1,CCode);
                    thisstmt1.setString(2,CName);
                    thisstmt1.setInt(3, Credits);
                    thisstmt1.setString(4,DNo1);
                    thisstmt1.executeUpdate();
                    System.out.println("The values are finally added!!..\n");
                    break;
                case 3 : 
                    String DNo2, DName;
                    System.out.println("Enter DNo : " );
                    DNo2 = sc.next();
                    System.out.println();

                    System.out.println("Enter DName : " );
                    DName = sc.next();
                    
                    System.out.println();
                    System.out.println(DNo2 + " :: " + DName);
                    String query2 = "insert into Department " + "values (?,?) ;";
                    PreparedStatement thisstmt2 = con.prepareStatement(query2);
                    thisstmt2.setString(1,DNo2);
                    thisstmt2.setString(2,DName);
                    thisstmt2.executeUpdate();
                    System.out.println("The values are finally added!!..\n");
                    break;
                case 4 : 
                    String BCode1, Name, Gender, DOB;
                    Long Roll_Number;
                    Date DOA;

                    System.out.println("Enter BCode : " );
                    BCode1 = sc.next();
                    System.out.println();

                    System.out.println("Enter Name : " );
                    Name = sc.next();
                    System.out.println();

                    System.out.println("Enter Roll Number : " );
                    Roll_Number = sc.nextLong();
                    System.out.println();

                    System.out.println("Enter Gender : " );
                    Gender = sc.next();
                    System.out.println();

                    System.out.println("Enter Date Of Birth in format YYYY-MM-DD : " );
                    DOB = sc.next();
                    System.out.println();

                    System.out.println("Enter the date of Joining : " );
                    Long date = System.currentTimeMillis();
                    DOA = new java.sql.Date(date);

                    System.out.println(BCode1 + " :: " + Name + " :: " + Roll_Number + " :: " + Gender + " :: " + DOB + " :: " + DOA);
                    String query3 = "insert into Student " + "values (?,?,?,?,?,?) ;";
                    PreparedStatement thisstmt3 = con.prepareStatement(query3);
                    thisstmt3.setLong(1,Roll_Number);
                    thisstmt3.setString(2, Name);
                    thisstmt3.setString(3, DOB);
                    thisstmt3.setString(4, Gender);
                    thisstmt3.setDate(5, DOA);
                    thisstmt3.setString(6, BCode1);
                    thisstmt3.executeUpdate();
                    System.out.println("The values are finally added!!..\n");
                    break;
                case 5 :
                    Long Roll_Number1;
                    String CCode1, Sess, Grade;    
                    System.out.println("Enter CCode : " );
                    CCode1 = sc.next();
                    System.out.println();

                    System.out.println("Enter Session : " );
                    Sess = sc.next();
                    System.out.println();

                    System.out.println("Enter Grade : " );
                    Grade = sc.next();
                    System.out.println();

                    System.out.println("Enter Roll Number : " );
                    Roll_Number1 = sc.nextLong();
                    System.out.println();

                    System.out.println(Roll_Number1 + " :: " + CCode1 + " :: " + Sess + " :: " + Grade);
                    PreparedStatement thisstmt4 = con.prepareStatement("Select * from Course where CCode = ?");
                    thisstmt4.setString(1, CCode1);
                    ResultSet res = thisstmt4.executeQuery();

                    if (res.next()) {
                        String query4 = "insert into Enrolls " +"values (?,?,?,?)";
                        PreparedStatement thisstmt5 = con.prepareStatement(query4);
                        thisstmt5.setLong(1, Roll_Number1);
                        thisstmt5.setString(2, CCode1);
                        thisstmt5.setString(3, Sess);
                        thisstmt5.setString(4, Grade);
                        thisstmt5.executeUpdate();
                        System.out.println("The values are finally added!!..\n");
                    }
                    else {
                        System.out.println("No such course that you have entered here");
                    }
                    break;

            }
        }

        // ResultSet rs=stmt.executeQuery("select * from Student");  
        // while(rs.next())  
        // System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
        // con.close();
    }

    catch(Exception e)
    {
        System.out.println(e);
    }

    }  

}
import java.sql.*;
import java.util.*;

public class Queries {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Question_2","root","Divyam@123");
            // Statement stmt = con.createStatement();

            while(true)
            {
                System.out.println("1. Query for part e in Question 1");
                System.out.println("2. Query for part f in Question 1");
                System.out.println("3. Query for part g in Question 1");
                System.out.println("4. Query for part h in Question 1");
                System.out.println();
                int k = sc.nextInt();
                switch (k) {
                    case 1 : 
                        Statement stmt1 = con.createStatement();
                        ResultSet res = stmt1.executeQuery("select * from Department where Department.DNo in(Select Branch.DNo from Branch group by Branch.DNo having Count(Branch.DNo) > 3);");
                        System.out.println("The Output of the query will be as below : ");
                        while(res.next())
                        System.out.println(res.getString(1) + " | " + res.getString(2) + " | ");
                        System.out.println();
                        break;
                    case 2 : 
                        Statement stmt2 = con.createStatement();
                        ResultSet res1 = stmt2.executeQuery("select * from Department where Department.DNo in(Select Course.DNo from Course group by Course.DNo having Count(Course.DNo) > 6);");
                        System.out.println("The Output of the query will be as below : ");
                        while(res1.next())
                        System.out.println(res1.getString(1) + " | " + res1.getString(2) + " | " );
                        System.out.println();
                        break;
                    case 3 : 
                        Statement stmt3 = con.createStatement();
                        ResultSet res2 = stmt3.executeQuery("select * from Course where Course.CCode in(Select Branch_Course.CCode from Branch_Course group by Branch_Course.CCode having Count(Branch_Course.CCode) > 3);");
                        System.out.println("The Output of the query will be as below : ");
                        while(res2.next())
                        System.out.println(res2.getString(1) + " | " + res2.getString(2) + " | " + res2.getString(3) + " | " + res2.getString(4) + " | ");
                        System.out.println();
                        break;
                    case 4 : 
                        Statement stmt4 = con.createStatement();
                        ResultSet res3 = stmt4.executeQuery("select * from student where student.Roll_Number in(Select Enrolls.Roll_Number from Enrolls where Enrolls.Grade = 'S' group by Enrolls.Roll_Number having Count(Enrolls.Grade) > 2);");
                        System.out.println("The Output of the query will be as below : ");
                        while(res3.next())
                        System.out.println(res3.getString(1) + " | " + res3.getString(2) + " | " + res3.getString(3) + " | " + res3.getString(4) + " | " + res3.getString(5) + " | " + res3.getString(6) + " | ");
                        System.out.println();
                        break;
                    default : 
                        System.out.println("No such input try again");
                        break;
                        
                }
                
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
}

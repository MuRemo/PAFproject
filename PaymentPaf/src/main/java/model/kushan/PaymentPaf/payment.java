package model.kushan.PaymentPaf;
import java.sql.*;

public class payment {
	//A common method to connect to the DB
		private Connection connect()
		 {
		 Connection con = null;
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			   con = DriverManager.getConnection("jdbc:mysql://localhost/testpaf","root","");
		 }
		 catch (Exception e)
		 {e.printStackTrace();}
		 return con;
		 } 
		
		public String insertPayment(int patientID, String date, String cardtype, String cardnumber,String expd,String pno,String amount)
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for inserting."; }
		 // create a prepared statement
		 String query = "insert into payment(`paymentid`,`patientid`,`date`,`cardtype`,`cardnumber`,`expirydate`,`pinnumber`,`amount`)"+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setInt(2, patientID);
		 preparedStmt.setString(3, date);
		 preparedStmt.setString(4, cardtype);
		 preparedStmt.setString(5, cardnumber);
		 preparedStmt.setString(6, expd);
		 preparedStmt.setString(7, pno);
		 preparedStmt.setDouble(8, Double.parseDouble(amount));
	
		 
		//execute the statement
		preparedStmt.execute();
		con.close();
		output = "Your payment is successfull";
		}
		catch (Exception e)
		{
		output = "Error while inserting the item.";
		System.err.println(e.getMessage());
		}
		return output;
		}
}

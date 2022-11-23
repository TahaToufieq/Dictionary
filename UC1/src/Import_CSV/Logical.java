package Import_CSV;

import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Logical {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	 static final String DB_URL = "jdbc:mysql://localhost/Dictionary";
	 static final String USER = "root";
	 static final String PASS = "";

	 public static void main(String[] args) {
	 Connection conn = null;
	 String filePath="C:\\Users\\EasyFix\\Downloads\\Masdar.csv";

     int batchSize=20;

	 try{
		 Class.forName("com.mysql.jdbc.Driver");
		 System.out.println("Connecting to database...");
		 conn = DriverManager.getConnection(DB_URL,USER,PASS);
		 
		 
		 
		 
		 String sql;
		 sql="insert into masdar_(ID,Mashkool,Sinf,Asal) values(?,?,?,?)";

		 PreparedStatement statement=conn.prepareStatement(sql);

         BufferedReader lineReader=new BufferedReader(new FileReader(filePath));

         String lineText=null;
         int count=0;

         lineReader.readLine();
         while ((lineText=lineReader.readLine())!=null){
             String[] data=lineText.split(",");

             String ID=data[0];
             String Mashkool=data[1];
             String Sinf=data[2];
             String Asal=data[3];
//             String Jins=data[4];
//             String Adad=data[5];
            

             statement.setInt(1,parseInt(ID));
             statement.setString(2,Mashkool);
             statement.setString(3,Sinf);
             statement.setString(4,Asal);
//             statement.setString(5,Jins);
//             statement.setString(6,Adad);
             

             
             statement.addBatch();
             if(count%batchSize==0){
                 statement.executeBatch();
             }
         }
         lineReader.close();
         statement.executeBatch();
         conn.commit();
         conn.close();

     }
	 
     catch (Exception exception){
         exception.printStackTrace();
     }

 }
}


//package Import_CSV;
//
//import java.sql.*;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//
//import static java.lang.Integer.parseInt;
//
//public class CSVConsume {
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//	static final String DB_URL = "jdbc:mysql://localhost/masdar_";
//    public static void main(String[] args) {
//    	
//        String jdbcUrl= DB_URL;
//        String username="root";
//        String password="";
//
//        String filePath="C:\\Users\\EasyFix\\Downloads\\masdar.csv";
//
//        int batchSize=20;
//
//        Connection connection=null;
//
//
//        try{
//            connection= DriverManager.getConnection(jdbcUrl,username,password);
//            connection.setAutoCommit(false);
//
//            String sql="insert into masdar_(ID,Mashkool,Sinf,Asal,Jins,Adad,Meaning) values(?,?,?,?,?,?,?)";
//
//            PreparedStatement statement=connection.prepareStatement(sql);
//
//            BufferedReader lineReader=new BufferedReader(new FileReader(filePath));
//
//            String lineText=null;
//            int count=0;
//
//            lineReader.readLine();
//            while ((lineText=lineReader.readLine())!=null){
//                String[] data=lineText.split(",");
//
//                String id=data[0];
//                String name=data[1];
//                String address=data[2];
//                String salary=data[3];
//
//                statement.setInt(1,parseInt(id));
//                statement.setString(2,name);
//                statement.setString(3,address);
//                statement.setInt(4,parseInt(salary));
//                statement.addBatch();
//                if(count%batchSize==0){
//                    statement.executeBatch();
//                }
//            }
//            lineReader.close();
//            statement.executeBatch();
//            connection.commit();
//            connection.close();
//            System.out.println("Data has been inserted successfully.");
//
//        }
//        catch (Exception exception){
//            exception.printStackTrace();
//        }
//
//    }
//}

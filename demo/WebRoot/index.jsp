
<span style="font-size:12px;"><span style="font-size:14px;">
<%@ page language="java" import="java.sql.*,java.io.*,java.util.*,java.sql.Connection,java.sql.DriverManager,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.SQLException"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<style type="text/css">
table {
	border: 2px #CCCCCC solid;
	width: 720px;
}

td,th {
	height: 30px;
	border: black 1px solid;
}
</style>
</head>
<body>
	<%
	    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://127.0.0.1;DatabaseName=courseplan;";
        /*String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/courseplan";*/
    
    
        Connection con = null;
        Statement stmt=null;
        ResultSet res = null;
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection("jdbc:sqlserver://localhost ; DatabaseName=courseplan ;user=sa ; password=123");
                String sql = "SELECT * FROM course " ;
		        stmt=con.createStatement();
		        res = stmt.executeQuery(sql);
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                  System.out.println("装载 JDBC/ODBC 驱动程序失败。");  
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("无法连接数据库"); 
                e.printStackTrace();
            }
           
		//驱动程序名 
		/*String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		//数据库用户名 
		String userName = "sa";
		//密码 
		String userPasswd = "123";
		//数据库名 
		String dbName = "courseplan";
		//表名 
		String tableName = "course";
		//联结字符串 
		String url = "jdbc:mysql://localhost:3306/" + dbName + "?user="
				+ userName + "&password=" + userPasswd;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection(url);
		Statement statement = connection.createStatement();*/
		
	%>
	<br>
	<br>
	<table align="center">
		<tr>
			<th>
				<%
					out.print("年级");
				%>
			</th>
			<th>
				<%
					out.print("专业");
				%>
			</th>
			<th>
				<%
					out.print("专业人数");
				%>
			</th>
			<th>
				<%
					out.print("课程名称");
				%>
			</th>
			<th>
				<%
					out.print("选修类型");
				%>
			</th>
			<th>
				<%
					out.print("学分");
				%>
			</th>
			<th>
				<%
					out.print("学时");
				%>
			</th>
			<th>
				<%
					out.print("实验学时");
				%>
			</th>
			<th>
				<%
					out.print("上机学时");
				%>
			</th>
			<th>
				<%
					out.print("起讫周序");
				%>
			</th>
			<th>
				<%
					out.print("任课老师");
				%>
			</th>
			<th>
				<%
					out.print("备注");
				%>
			</th>
		</tr>

		<%
			while (res.next()) {
		%>
		<tr>
			<td>
				<%
					out.print(res.getString(1));
				%>
			</td>
			<td>
				<%
					out.print(res.getString(2));
				%>
			</td>
			<td>
				<%
					out.print(res.getString(3));
				%>
			</td>
			<td>
				<%
					out.print(res.getString(4));
				%>
			</td>
			<td>
				<%
					out.print(res.getString(5));
				%>
			</td><td>
				<%
					out.print(res.getString(6));
				%>
			</td><td>
				<%
					out.print(res.getString(7));
				%>
			</td><td>
				<%
					out.print(res.getString(8));
				%>
			</td><td>
				<%
					out.print(res.getString(9));
				%>
			</td><td>
				<%
					out.print(res.getString(10));
				%>
			</td><td>
				<%
					out.print(res.getString(11));
				%>
			</td>
			<td>
				<%
					out.print(res.getString(12));
				%>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<div align="center">
		<br> <br> <br>
		<%
			out.print("数据查询成功，恭喜你");
		%>
	</div>
	<%
		res.close();
		stmt.close();
		con.close();
	%>
</body>
</html></span><span style="font-size:24px;color: rgb(255, 0, 0);">
</span></span>

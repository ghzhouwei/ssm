package zw.builder.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import zw.builder.vo.Column;

/**
 * @ClassName: DBUtils
 * @Description: 数据库工具类
 * @author 周威
 * @date 2020年6月4日 - 上午10:03:58
 */
public class DBUtils
{
	//连接参数
    private final static String driver = "com.mysql.jdbc.Driver";
    private String ip;
    private String port;
    private String userName;
    private String passWord;
    
    public DBUtils(String ip, String port, String userName, String passWord)
    {
    	this.ip = ip;
    	this.port = port;
    	this.userName = userName;
    	this.passWord = passWord;
    }
    
    //加载数据库驱动
    static
    {
    	try
		{
			Class.forName(driver);
		} 
    	catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
    }
    
    //获取数据库连接对象
    public Connection getConnection()
    {
    	Connection connection = null;
    	try
		{
			connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/mysql", userName, passWord);
		} 
    	catch (SQLException e)
		{
			e.printStackTrace();
		}
    	return connection;
    }
    
    private Connection getConnection(String dataBaseName)
    {
    	Connection connection = null;
    	try
		{
			connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + dataBaseName, userName, passWord);
		} 
    	catch (SQLException e)
		{
			e.printStackTrace();
		}
    	return connection;
    }
    
    //关闭数据库资源
    private void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet)
    {
		try
		{
			if(resultSet != null)
				resultSet.close();
			if(preparedStatement != null)
				preparedStatement.close();
			if(connection != null)
				connection.close();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
    }
    
    //获取所有数据库名称
    public List<String> getDataBasesName()
    {
    	List<String> list = new ArrayList<String>();
    	
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	
    	try
		{
    		String sql = "SHOW DATABASES";
        	connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				String dataBaseName = resultSet.getString(1);
				if(!"information_schema".equals(dataBaseName) && !"mysql".equals(dataBaseName) && !"performance_schema".equals(dataBaseName))
					list.add(dataBaseName);
			}
		} 
    	catch (SQLException e)
		{
			e.printStackTrace();
		}
    	finally
    	{
    		close(connection, preparedStatement, resultSet);
    	}
    	return list;
    }
    
    //获取数据表名称
    public List<String> getTablesName(String dataBaseName)
    {
    	List<String> list = new ArrayList<String>();
    	
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	
    	try
		{
    		String sql = "SHOW TABLES";
        	connection = getConnection(dataBaseName);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				String tableName = resultSet.getString(1);
				list.add(tableName);
			}
		} 
    	catch (SQLException e)
		{
			e.printStackTrace();
		}
    	finally
    	{
    		close(connection, preparedStatement, resultSet);
    	}
    	return list;
    }
    
    //获取字段名称和类型
    public List<Column> getColumns(String dataBaseName, String tableName)
    {
    	List<Column> list = new ArrayList<Column>();
    	
    	Connection connection = null;
    	PreparedStatement preparedStatement = null;
    	ResultSet resultSet = null;
    	
    	try
		{
    		String sql = "SELECT * FROM " + tableName;
        	connection = getConnection(dataBaseName);
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			int colunCount = resultSetMetaData.getColumnCount();
            for (int index = 1; index < colunCount; index++)
            {
                String columnType = Column.mysqlType_to_javaType(resultSetMetaData.getColumnTypeName(index));
                String columnName = Column.mysqlName_to_javaName(resultSetMetaData.getColumnName(index));
                Column column = new Column(columnType, columnName);
                list.add(column);
            }
		} 
    	catch (SQLException e)
		{
			e.printStackTrace();
		}
    	finally
    	{
    		close(connection, preparedStatement, resultSet);
    	}
    	return list;
    }
}

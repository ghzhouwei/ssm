package zw.builder.test;

import java.util.List;
import org.junit.Test;
import zw.builder.util.DBUtils;
import zw.builder.util.FileUtils;
import zw.builder.vo.Column;

/**
 * @ClassName: DBUtilsDemo
 * @Description: 数据库工具测试类
 * @author 周威
 * @date 2020年6月4日 - 上午10:40:05
 */
public class DBUtilsDemo
{
	@Test
	public void getDataBasesNameTest()
	{
		DBUtils dbUtils = new DBUtils("127.0.0.1", "3306", "root", "root");
		List<String> list = dbUtils.getDataBasesName();
		for (String string : list)
		{
			System.out.println(string);
		}
	}
	
	@Test
	public void getTablesNameTest()
	{
		DBUtils dbUtils = new DBUtils("127.0.0.1", "3306", "root", "root");
		List<String> list = dbUtils.getTablesName("test");
		for (String string : list)
		{
			System.out.println(string);
		}
	}
	
	@Test
	public void getColumnsTest()
	{
		DBUtils dbUtils = new DBUtils("127.0.0.1", "3306", "root", "root");
		List<Column> list = dbUtils.getColumns("test", "user");
		for (Column column : list)
		{
			System.out.println("类型：" + column.getColumnType() + "----------" + "名称：" + column.getColumnName());
		}
	}
	
	@Test
	public void POJOFileTest()
	{
		DBUtils dbUtils = new DBUtils("127.0.0.1", "3306", "root", "root");
		List<Column> list = dbUtils.getColumns("test", "user");
		FileUtils fileUtils = new FileUtils("com.base.vo");
		fileUtils.writePOJO("user", list);
	}
}

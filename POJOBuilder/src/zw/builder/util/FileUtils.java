package zw.builder.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import zw.builder.util.DateUtils;
import zw.builder.vo.Column;

/**
 * @ClassName: POJOFile
 * @Description: (类描述)
 * @author 周威
 * @date 2020年6月4日 - 上午11:30:11
 */
@SuppressWarnings("all")
public class FileUtils
{
	private String path = "src";
	private String packageName;
	private String packageNamePath = "";
	
	public FileUtils(String packageName)
	{
		this.packageName = packageName;
		String[] packageNames = packageName.split("\\.");
		for (String string : packageNames)
		{
			this.packageNamePath = this.packageNamePath + string + "//";
		}
		this.packageNamePath = this.packageNamePath.substring(0, this.packageNamePath.length()-2);
	}
	
	public void writePOJO(String tableName, List<Column> list)
	{
		File directory = new File(path, packageNamePath);
		if(!directory.exists())
			directory.mkdirs();
		File file = new File(directory, tableName.substring(0,1).toUpperCase() + tableName.substring(1,tableName.length()) + ".java");
		try
		{
			file.createNewFile();
			PrintWriter pw = new PrintWriter(file);
			
			//写包名
			pw.println("package "+ packageName +";");
			pw.println();
			
			//写类注释
			DateUtils dateUtils = new DateUtils();
			pw.println("/**");
			pw.println(" * @ClassName: " + tableName.substring(0,1).toUpperCase() + tableName.substring(1,tableName.length()));
			pw.println(" * @Description: " + tableName.substring(0,1).toUpperCase() + tableName.substring(1,tableName.length()) + "实体类");
			pw.println(" * @Author: 周威");
			pw.println(" * @Date: " + dateUtils.getDateTime());
			pw.println(" */");
			pw.flush();
			
			//写类头
			pw.println("public class " + tableName.substring(0,1).toUpperCase() + tableName.substring(1,tableName.length()));
			
			//写{+成员属性注释
			pw.println("{");
			pw.println("	//成员属性");
			pw.flush();
			
			//写成员属性
			for(Column column : list)
			{
				pw.println("	private " + column.getColumnType() + " " + column.getColumnName() + ";");
				pw.flush();
			}
			
			//写Getter和Setter方法注释
			pw.println();
			pw.println("	//Getter和Setter方法");
			pw.flush();
			
			//写Getter和Setter方法
			for(Column column : list)
	
			{
				//写Getter方法
				pw.println("	public " + column.getColumnType() + " get" + column.getColumnName().substring(0,1).toUpperCase() + column.getColumnName().substring(1,column.getColumnName().length()) + "()");
				pw.println("	{");
				pw.println("		return " + column.getColumnName() + ";");
				pw.println("	}");
				pw.println();
				pw.flush();
				
				//写Setter方法
				pw.println("	public void set" + column.getColumnName().substring(0,1).toUpperCase() + column.getColumnName().substring(1,column.getColumnName().length()) +"(" + column.getColumnType() + " " + column.getColumnName() + ")");
				pw.println("	{");
				pw.println("		this." + column.getColumnName() + " = " + column.getColumnName() +";");
				pw.println("	}");
				pw.println();
				pw.flush();
			}
			
			//写}
			pw.println("}");
			pw.flush();
			
			//关闭流资源
			pw.close();
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

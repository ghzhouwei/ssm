package zw.builder.vo;

/**
 * @ClassName: Column
 * @Description: 字段实体类
 * @author 周威
 * @date 2020年6月4日 - 上午10:58:47
 */
public class Column
{
	//字段类型和字段名称
	private String columnType;
	private String columnName;
	
	public Column(String columnType, String columnName)
	{
		this.columnType = columnType;
		this.columnName = columnName;
	}
	
	public static String mysqlName_to_javaName(String columnName)
	{
		String[] array = columnName.split("_");
		return array[array.length-1];
	}
	
	//mysql数据类型转化为java数据类型
	public static String mysqlType_to_javaType(String columnType)
	{
		if("TINYINT".equals(columnType))
			return "Byte";
		else if("SMALLINT".equals(columnType))
			return "Short";
		else if("INT".equals(columnType) || "INTEGER".equals(columnType))
			return "Integer";
		else if("BIGINT".equals(columnType))
			return "Long";
		if("BIT".equals(columnType))
			return "Boolean";
		else if("CHAR".equals(columnType))
			return "String";
		else if("VARCHAR".equals(columnType))
			return "String";
		else if("FLOAT".equals(columnType))
			return "Float";
		else if("DOUBLE".equals(columnType))
			return "Double";
		else if("DATE".equals(columnType) || "TIME".equals(columnType) || "DATATIME".equals(columnType))
			return "Date";
		else
			return "String";
	}
	
	//Getter和Setter方法
	public String getColumnType()
	{
		return columnType;
	}
	public void setColumnType(String columnType)
	{
		this.columnType = columnType;
	}
	public String getColumnName()
	{
		return columnName;
	}
	public void setColumnName(String columnName)
	{
		this.columnName = columnName;
	}
}

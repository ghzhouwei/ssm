package zw.builder.listener;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import zw.builder.util.DBUtils;
import zw.builder.window.DataBaseWindow;
import zw.builder.window.TablesWindow;

/**
 * @ClassName: CancelButtonListener
 * @Description: (类描述)
 * @author 周威
 * @date 2020年6月4日 - 下午2:50:34
 */
public class DataBaseButtonListener implements ActionListener
{
	private DataBaseWindow dataBaseWindow;
	private DBUtils dbUtils;
	private String dataBaseName;
	
	public DataBaseButtonListener(DataBaseWindow dataBaseWindow, DBUtils dbUtils, String dataBaseName)
	{
		this.dataBaseWindow = dataBaseWindow;
		this.dbUtils = dbUtils;
		this.dataBaseName = dataBaseName;
	}

	/**
	 * @Title: actionPerformed
	 * @Description: 单击数据库按钮
	 * @param e 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) 
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{		
		//关闭上一个窗口
		dataBaseWindow.setVisible(false);
		
		//获取屏幕大小
		Toolkit screen = Toolkit.getDefaultToolkit();
		int screen_width = screen.getScreenSize().width;
		int screen_hight = screen.getScreenSize().height;
		
		//定义窗口大小
		int window_width = 500;
		int window_height = 600;
		
		//定义窗口位置
		int window_x = (screen_width - window_width)/2;
		int window_y = (screen_hight - window_height)/2;
		
		//初始化窗口
		TablesWindow tablesWindow = new TablesWindow(window_x, window_y, window_width, window_height, dataBaseName, dbUtils);
		
		//显示窗口
		tablesWindow.showWindow();
	}

}

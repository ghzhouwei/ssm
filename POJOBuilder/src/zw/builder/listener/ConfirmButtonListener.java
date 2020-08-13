package zw.builder.listener;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

import zw.builder.util.DBUtils;
import zw.builder.window.ConnectionFrame;
import zw.builder.window.DataBaseWindow;

/**
 * @ClassName: CancelButtonListener
 * @Description: (类描述)
 * @author 周威
 * @date 2020年6月4日 - 下午2:50:34
 */
public class ConfirmButtonListener implements ActionListener
{
	
	private ConnectionFrame connectionFrame;
	
	public ConfirmButtonListener(ConnectionFrame connectionFrame)
	{
		this.connectionFrame = connectionFrame;
	}

	/**
	 * @Title: actionPerformed
	 * @Description: 单击确定按钮
	 * @param e 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) 
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		//获取连接信息
		String ip = connectionFrame.ipEdit.getText().trim();
		String port = connectionFrame.portEdit.getText().trim();
		String userName = connectionFrame.userNameEdit.getText().trim();
		String passWord = connectionFrame.passWordEdit.getText().trim();
		
		if(ip.equals("") || port.equals("") || userName.equals("") || passWord.equals(""))
		{
			JOptionPane.showMessageDialog(null, "请填写完整的连接信息！", "提示",JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			DBUtils dbUtils = new DBUtils(ip, port, userName, passWord);
			Connection connection = dbUtils.getConnection();
			if(connection == null)
			{
				JOptionPane.showMessageDialog(null, "连接失败，连接信息有误！", "提示",JOptionPane.ERROR_MESSAGE);
				connectionFrame.ipEdit.setText("");
				connectionFrame.portEdit.setText("");
				connectionFrame.userNameEdit.setText("");
				connectionFrame.passWordEdit.setText("");
			}
			else
			{
				//关闭上一个窗口
				connectionFrame.setVisible(false);
				
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
				DataBaseWindow dataBaseWindow = new DataBaseWindow(window_x, window_y, window_width, window_height, ip, port, userName, passWord);
				
				//显示窗口
				dataBaseWindow.showWindow();
			}
		}
	}

}

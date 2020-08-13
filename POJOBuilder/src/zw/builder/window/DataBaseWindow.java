package zw.builder.window;

import java.awt.Font;
import java.awt.Insets;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import zw.builder.listener.CancelButtonListener;
import zw.builder.listener.DataBaseButtonListener;
import zw.builder.util.DBUtils;

public class DataBaseWindow extends JFrame
{
	private static final long serialVersionUID = 1L;

	private int x;
	private int y;
	
	private int width;
	private int height;
	
	//数据库连接参数
	private String ip;
	private String port;
	private String userName;
	private String passWord;
	
	public DataBaseWindow(int x,int y,int width,int height, String ip, String port, String userName, String passWord)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		this.ip = ip;
		this.port = port;
		this.userName = userName;
		this.passWord = passWord;
	}
	
	public void showWindow()
	{
		this.setTitle("POJO生成器----周威");
		
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(null);
		
		//添加组件
		int begin_x = 100;
		int begin_y = 50;
		int space_y = 50;
		
		DBUtils dbUtils = new DBUtils(ip, port, userName, passWord);
		List<String> dataBasesName = dbUtils.getDataBasesName();
		for (int index = 0; index < dataBasesName.size(); index++)
		{
			JButton jButton = new JButton(dataBasesName.get(index));
			jButton.setBounds(begin_x,begin_y + space_y*index,300,35);
			jButton.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
			jButton.addActionListener(new DataBaseButtonListener(this, dbUtils, dataBasesName.get(index)));
			this.add(jButton);
		}
		
		//取消
		JButton cancelButton = new JButton("取消");
		cancelButton.setBounds(begin_x,begin_y + space_y*dataBasesName.size(),300,35);
		cancelButton.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
		cancelButton.addActionListener(new CancelButtonListener());
		this.add(cancelButton);
		
		this.setVisible(true);
		
		this.setLocation(x, y);
		
		Insets insets = this.getInsets();
		int window_width = width + insets.left + insets.right;
		int window_height = height + insets.top + insets.bottom;
		this.setSize(window_width, window_height);
	}
}

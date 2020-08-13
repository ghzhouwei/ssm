package zw.builder.window;

import java.awt.Font;
import java.awt.Insets;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import zw.builder.listener.CancelButtonListener;
import zw.builder.listener.CheckBoxListener;
import zw.builder.listener.CreateButtonListener;
import zw.builder.util.DBUtils;

public class TablesWindow extends JFrame
{
	private static final long serialVersionUID = 1L;

	private int x;
	private int y;
	
	private int width;
	private int height;
	
	//数据库
	private DBUtils dbUtils;
	private String dataBaseName;
	
	public TablesWindow(int x,int y,int width,int height, String dataBaseName, DBUtils dbUtils)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.dataBaseName = dataBaseName;
		this.dbUtils = dbUtils;
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
		
		List<String> tablesName = dbUtils.getTablesName(dataBaseName);
		CheckBoxListener checkBoxListener = new CheckBoxListener();
		for(int index = 0; index < tablesName.size(); index++)
		{
			JCheckBox jCheckBok = new JCheckBox(tablesName.get(index));
			jCheckBok.setBounds(begin_x,begin_y + space_y*index,300,35);
			jCheckBok.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
			jCheckBok.addItemListener(checkBoxListener);
			this.add(jCheckBok);
		}
		
		//生成
		JButton createButton = new JButton("生成");
		createButton.setBounds(begin_x,begin_y + space_y*(tablesName.size() + 0),300,35);
		createButton.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
		createButton.addActionListener(new CreateButtonListener(checkBoxListener, "com.base.vo", dbUtils, dataBaseName));
		this.add(createButton);
		
		//取消
		JButton cancelButton = new JButton("取消");
		cancelButton.setBounds(begin_x,begin_y + space_y*(tablesName.size() + 1),300,35);
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

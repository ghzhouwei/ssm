package zw.builder.window;

import java.awt.Font;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import zw.builder.listener.CancelButtonListener;
import zw.builder.listener.ConfirmButtonListener;

public class ConnectionFrame extends JFrame
{
	private static final long serialVersionUID = 1L;

	private int x;
	private int y;
	
	private int width;
	private int height;
	
	//文本编辑组件
	public JTextField ipEdit;
	public JTextField portEdit;
	public JTextField userNameEdit;
	public JTextField passWordEdit;
	
	public ConnectionFrame(int x,int y,int width,int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void showWindow()
	{
		this.setTitle("POJO生成器----周威");
		
		this.setResizable(false);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setLayout(null);
		
		//添加组件
		int begin_x = 70;
		int begin_y = 130;
		int space_x = 80;
		int space_y = 50;
		
		//IP地址
		JLabel ipText = new JLabel("主机:");
		ipText.setBounds(begin_x,begin_y + space_y*0,100,35);
		ipText.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
		this.add(ipText);
		
		ipEdit = new JTextField();
		ipEdit.setBounds(begin_x + space_x*1,begin_y + space_y*0,270,35);
		ipEdit.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
		this.add(ipEdit);
		
		//端口
		JLabel portText = new JLabel("端口:");
		portText.setBounds(begin_x,begin_y + space_y*1 ,100,35);
		portText.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
		this.add(portText);
		
		portEdit = new JTextField();
		portEdit.setBounds(begin_x + space_x*1,begin_y + space_y*1,270,35);
		portEdit.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
		this.add(portEdit);
		
		//账号
		JLabel userNameText = new JLabel("账号:");
		userNameText.setBounds(begin_x,begin_y + space_y*2,100,35);
		userNameText.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
		this.add(userNameText);
		
		userNameEdit = new JTextField();
		userNameEdit.setBounds(begin_x + space_x*1,begin_y + space_y*2,270,35);
		userNameEdit.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
		this.add(userNameEdit);
		
		//密码
		JLabel passWordText = new JLabel("密码:");
		passWordText.setBounds(begin_x,begin_y + space_y*3,100,35);
		passWordText.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
		this.add(passWordText);
		
		passWordEdit = new JPasswordField();
		passWordEdit.setBounds(begin_x + space_x*1,begin_y + space_y*3,270,35);
		passWordEdit.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
		this.add(passWordEdit);
		
		//确定
		JButton confirmButton = new JButton("确定");
		confirmButton.setBounds(begin_x + 70,begin_y + space_y*5,100,35);
		confirmButton.setFont(new Font (Font.DIALOG, Font.BOLD, 20));
		confirmButton.addActionListener(new ConfirmButtonListener(this));
		this.add(confirmButton);
		
		//取消
		JButton cancelButton = new JButton("取消");
		cancelButton.setBounds(begin_x + 200,begin_y + space_y*5,100,35);
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

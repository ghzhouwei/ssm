package zw.builder.window;

import java.awt.Toolkit;

/**
 * @ClassName: WindowMain
 * @Description: 主窗口
 * @author 周威
 * @date 2020年6月4日 - 下午1:55:21
 */
public class WindowMain
{	
	public static void main(String[] args)
	{
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
		ConnectionFrame connectionFrame = new ConnectionFrame(window_x, window_y, window_width, window_height);
		
		//显示窗口
		connectionFrame.showWindow();
	}
}

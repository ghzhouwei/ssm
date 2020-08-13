package zw.builder.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @ClassName: CancelButtonListener
 * @Description: (类描述)
 * @author 周威
 * @date 2020年6月4日 - 下午2:50:34
 */
public class CancelButtonListener implements ActionListener
{

	/**
	 * @Title: actionPerformed
	 * @Description: 单击取消按钮
	 * @param e 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) 
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		System.exit(0);
	}

}

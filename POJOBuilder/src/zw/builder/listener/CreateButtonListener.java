package zw.builder.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import zw.builder.util.DBUtils;
import zw.builder.util.FileUtils;

/**
 * @ClassName: CancelButtonListener
 * @Description: (类描述)
 * @author 周威
 * @date 2020年6月4日 - 下午2:50:34
 */
public class CreateButtonListener implements ActionListener
{
	private CheckBoxListener checkBoxListener;
	private String packageName;
	private DBUtils dbUtils;
	private String dataBaseName;
	
	public CreateButtonListener(CheckBoxListener checkBoxListener, String packageName,DBUtils dbUtils, String dataBaseName)
	{
		this.checkBoxListener = checkBoxListener;
		this.packageName = packageName;
		this.dbUtils = dbUtils;
		this.dataBaseName = dataBaseName;
	}

	/**
	 * @Title: actionPerformed
	 * @Description: 单击生成按钮
	 * @param e 
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent) 
	 */
	@Override
	public void actionPerformed(ActionEvent e)
	{
		int count = checkBoxListener.getTablesName().size();
		List<String> list = checkBoxListener.getTablesName();
		
		if(count != 0)
		{
			FileUtils fileUtils = new FileUtils(packageName);
			for(int index = 0; index < count; index++)
				fileUtils.writePOJO(list.get(index), dbUtils.getColumns(dataBaseName, list.get(index)));
			System.exit(0);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "请选择要导出的对应数据表", "提示",JOptionPane.ERROR_MESSAGE);  
		}
	}

}

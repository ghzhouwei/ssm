package zw.builder.listener;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;

/**
 * @ClassName: CheckBoxListener
 * @Description: (类描述)
 * @author 周威
 * @date 2020年6月4日 - 下午3:56:06
 */
public class CheckBoxListener implements ItemListener
{
	
	private List<String> tablesName = new ArrayList<String>();

	/**
	 * @Title: itemStateChanged
	 * @Description: (方法描述)
	 * @param e 
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent) 
	 */
	@Override
	public void itemStateChanged(ItemEvent e)
	{
		JCheckBox jCheckBox = (JCheckBox) e.getItem();
		if(jCheckBox.isSelected())
		{
			String tableName = jCheckBox.getText();
			tablesName.add(tableName);
		}
		else
		{
			String tableName = jCheckBox.getText();
			tablesName.remove(tableName);
		}
	}

	public List<String> getTablesName()
	{
		return tablesName;
	}

	public void setTablesName(List<String> tablesName)
	{
		this.tablesName = tablesName;
	}

}

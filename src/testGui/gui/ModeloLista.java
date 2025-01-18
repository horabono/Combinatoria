package testGui.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

@SuppressWarnings("serial")
public class ModeloLista extends DefaultListModel<String> {
	private List<Object> items = new ArrayList<>();
	
	public void add(Object item) {
		items.add(item);
		addElement(item.toString());
	}
	
	public Object getAt(int index) {
		return items.get(index);
	}
	
	public void removeAll() {
		items.clear();
		super.removeAllElements();
	}

}

package ch.hslu.appe.fs1303.gui.datasource;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;

import ch.hslu.appe.fs1301.business.shared.dto.DTOBestellung;
import ch.hslu.appe.fs1303.gui.utils.DateUtils;

public class OrderTableDescriptor extends AbstractTableDescriptor implements iTableDescriptor<DTOBestellung> {
	
	private List<DTOBestellung> fData;

	public void createColumns(Table table) {
		table.setRedraw(false);
		while ( table.getColumnCount() > 0 ) {
		    table.getColumns()[ 0 ].dispose();
		}
		
		createColumn(table, SWT.None, "ID", 30);
		createColumn(table, SWT.CENTER, "Bestelldatum", 150);
		createColumn(table, SWT.CENTER, "Soll Lieferdatum", 150);
		createColumn(table, SWT.CENTER, "Ist Lieferdatum", 150);
		createColumn(table, SWT.CENTER, "Anzahl Positionen", 150);
		
		table.setRedraw(true);
	}

	@Override
	public void createTableRows(Table table, List<DTOBestellung> data) {
		fData = data;
		table.removeAll();
		
		Collections.sort(data, new Comparator<DTOBestellung>() {

			@Override
			public int compare(DTOBestellung o1, DTOBestellung o2) {
				return o1.getBestelldatum().compareTo(o2.getBestelldatum());
			}
		});
		
		for (DTOBestellung bestellung : data) {
			createRow(table, SWT.None, new String[] { 
					String.valueOf(bestellung.getId()),
					DateUtils.getDateAsString(bestellung.getBestelldatum()),
					DateUtils.getDateAsString(bestellung.getLiefertermin_Soll()),
					DateUtils.getDateAsString(bestellung.getLiefertermin_Ist()),
					String.valueOf(bestellung.getBestellpositions().size())});
		}
	}

	@Override
	public DTOBestellung getItem(int index) {
		return fData.get(index);
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivesystem1;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;

/**
 *
 * @author Vallejos
 */
public class TableActionCellEditor1 extends DefaultCellEditor{

    private  TableActionEvent1 event;
    public TableActionCellEditor1(TableActionEvent1 event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        PanelAction1 action =new PanelAction1();
        action.initEvent((TableActionEvent1) event, row);
        return action;
    }

    
    
    
}
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EmployeeUI extends JFrame {

    JTable tblEmployee;
    
    EmployeeUI(){

        setTitle("EmployeeUI");
        setLocation(200,300);
        setSize(500, 500);

        Container con  = getContentPane();
        FlowLayout lay = new FlowLayout();
        con.setLayout(lay);

        Vector titles = new Vector();
        titles.add("Name");
        titles.add("DOB");
        titles.add("NIC");
        titles.add("Gender");
        titles.add("Designation");

        Vector data = new Vector();

        DefaultTableModel dataModel = new DefaultTableModel(data,titles);
        tblEmployee = new JTable();

        tblEmployee.setModel(dataModel);

        JScrollPane jspTable = new JScrollPane();
        jspTable.setPreferredSize(new Dimension(500, 200));
        jspTable.setViewportView(tblEmployee);

        con.add(jspTable);


        initialize();   
    }

    public void initialize(){
        loadView();
    }

    public void loadView(){
        List<Employee> empList = EmployeeController.get();
        filTable(empList);
    }

    public void filTable(List<Employee> employees){
         DefaultTableModel model = (DefaultTableModel) tblEmployee.getModel();

         for (Employee emp : employees) {
            Vector r = new Vector();
            r.add(emp.getName());
            r.add(emp.getDob().toString());
            r.add(emp.getNic());
            r.add(emp.getGender().getName());
            r.add(emp.getDesignation().getName());

            model.addRow(r);
         }
    }
}

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EmployeeUI extends JFrame {

    JTable tblEmployee;
    JComboBox<Object> cmdSearchGender;
    JTextField txtSearchName;
    Vector titles;

    EmployeeUI() {

        setTitle("EmployeeUI");
        setLocation(200, 300);
        setSize(500, 500);

        Container con = getContentPane();
        FlowLayout lay = new FlowLayout();
        con.setLayout(lay);

        JLabel lblSearchName = new JLabel("Name : ");
        txtSearchName = new JTextField(10);
        JLabel lblSearchGender = new JLabel("Gender : ");
        cmdSearchGender = new JComboBox();
        JButton btnSearch = new JButton("Search");
        JButton btnSearchClear = new JButton("Clear Search");

        con.add(lblSearchName);
        con.add(txtSearchName);
        con.add(lblSearchGender);
        con.add(cmdSearchGender);
        con.add(btnSearch);
        con.add(btnSearchClear);

        titles = new Vector();
        titles.add("Name");
        titles.add("DOB");
        titles.add("NIC");
        titles.add("Gender");
        titles.add("Designation");

        Vector data = new Vector();

        DefaultTableModel dataModel = new DefaultTableModel(data, titles);
        tblEmployee = new JTable();

        tblEmployee.setModel(dataModel);

        JScrollPane jspTable = new JScrollPane();
        jspTable.setPreferredSize(new Dimension(500, 200));
        jspTable.setViewportView(tblEmployee);

        con.add(jspTable);

        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSearchAp(e);
            }
        });

        btnSearchClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnSearchClearAp(e);
            }
        });

        initialize();
    }

    public void initialize() {
        loadView();
    }

    public void loadView() {
        List<Employee> empList = EmployeeController.get(null);
        filTable(empList);

        List<Gender> genList = GenderController.get();

        Vector<Object> genders = new Vector();
        genders.add("Select a Gender");

        for (Gender gen : genList) {
            genders.add(gen);
        }

        DefaultComboBoxModel<Object> gndModel = new DefaultComboBoxModel(genders);
        cmdSearchGender.setModel(gndModel);
    }

    public void filTable(List<Employee> employees) {

        Vector data = new Vector();

        for (Employee emp : employees) {
            Vector r = new Vector();
            r.add(emp.getName());
            r.add(emp.getDob().toString());
            r.add(emp.getNic());
            r.add(emp.getGender().getName());
            r.add(emp.getDesignation().getName());
            data.add(r);

        }

        DefaultTableModel dataModel = new DefaultTableModel(data, titles);
        tblEmployee.setModel(dataModel);
    }

    public void btnSearchAp(ActionEvent e) {

        String name = txtSearchName.getText();
        Object sitem = cmdSearchGender.getSelectedItem();
        Gender gender = null;

        if (!sitem.equals("Select a Gender")) {
            gender = (Gender) sitem;
        }

        Hashtable<String, Object> ht = new Hashtable();
        ht.put("name", name);

        if (gender != null) {
            ht.put("gender", gender);
        }

        List<Employee> employees = EmployeeController.get(ht);
        filTable(employees);

    }

    public void btnSearchClearAp(ActionEvent e) {

        int opt = JOptionPane.showConfirmDialog(null, "Are you sure to clear the search");

        if (opt != 1) {
            txtSearchName.setText(null);
            cmdSearchGender.setSelectedIndex(0);

            List<Employee> employees = EmployeeController.get(null);
            filTable(employees);
        }

    }

}

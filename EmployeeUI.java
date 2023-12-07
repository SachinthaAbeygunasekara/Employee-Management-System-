import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
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
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EmployeeUI extends JFrame {

    JTable tblEmployee;
    Vector titles;

    JTextField txtSearchName;

    JTextField txtName;
    JTextField txtNic;
    JTextField txtMobile;
    JTextField txtEmail;

    JComboBox<Object> cmdSearchGender;
    JComboBox<Object> cmdGender;
    JComboBox<Object> cmdDesignation;
    JComboBox<Object> cmdemployeeStatus;
    JComboBox<Object> cmdDobYear;
    JComboBox<Object> cmdDobMonth;
    JComboBox<Object> cmdDobDate;

    JButton btnAdd;
    JButton btnClear;
    JButton btnUpdate;
    JButton btnDelete;

    Color valid;
    Color invalid;
    Color initial;

    EmployeeUI() {

        valid = new Color(146, 245, 146);
        invalid = new Color(243, 117, 138);
        initial = Color.WHITE;

        setTitle("Harvest Super - Employee Details Manager");
        setLocation(300, 50);
        setSize(850, 450);

        Container con = getContentPane();
        // FlowLayout lay = new FlowLayout();
        con.setLayout(null);

        JLabel lblName = new JLabel("Name :");
        txtName = new JTextField(10);

        JLabel lblDob = new JLabel("Date of Birth :");
        cmdDobYear = new JComboBox();
        cmdDobMonth = new JComboBox();
        cmdDobDate = new JComboBox();

        JLabel lblGender = new JLabel("Gender :");
        cmdGender = new JComboBox();

        JLabel lblNic = new JLabel("Nic :");
        txtNic = new JTextField(10);

        JLabel lblMobile = new JLabel("Mobile :");
        txtMobile = new JTextField(10);

        JLabel lblEmail = new JLabel("Email :");
        txtEmail = new JTextField(10);

        JLabel lblDesignation = new JLabel("Designation :");
        cmdDesignation = new JComboBox();

        JLabel lblStatus = new JLabel("Status :");
        cmdemployeeStatus = new JComboBox();

        btnAdd = new JButton("Add");
        btnClear = new JButton("Clear");
        btnUpdate = new JButton("Update");
        btnDelete = new JButton("Delete");

        JLabel lblSearchName = new JLabel("Name : ");
        txtSearchName = new JTextField(10);
        JLabel lblSearchGender = new JLabel("Gender : ");
        cmdSearchGender = new JComboBox();
        JButton btnSearch = new JButton("Search");
        JButton btnSearchClear = new JButton("Clear");

        con.add(lblName);
        con.add(txtName);
        con.add(lblDob);
        con.add(cmdDobYear);
        con.add(cmdDobMonth);
        con.add(cmdDobDate);
        con.add(lblGender);
        con.add(cmdGender);
        con.add(lblNic);
        con.add(txtNic);
        con.add(lblMobile);
        con.add(txtMobile);
        con.add(lblEmail);
        con.add(txtEmail);
        con.add(lblDesignation);
        con.add(cmdDesignation);
        con.add(lblStatus);
        con.add(cmdemployeeStatus);

        lblName.setBounds(25, 5, 50, 50);
        txtName.setBounds(115, 20, 190, 25);
        lblDob.setBounds(25, 45, 80, 50);
        cmdDobYear.setBounds(115, 60, 55, 25);
        cmdDobMonth.setBounds(177, 60, 65, 25);
        cmdDobDate.setBounds(250, 60, 55, 25);
        lblGender.setBounds(25, 85, 50, 50);
        cmdGender.setBounds(115, 100, 190, 25);
        lblNic.setBounds(25, 125, 50, 50);
        txtNic.setBounds(115, 140, 190, 25);
        lblMobile.setBounds(25, 165, 50, 50);
        txtMobile.setBounds(115, 180, 190, 25);
        lblEmail.setBounds(25, 205, 50, 50);
        txtEmail.setBounds(115, 220, 190, 25);
        lblDesignation.setBounds(25, 245, 100, 50);
        cmdDesignation.setBounds(115, 260, 190, 25);
        lblStatus.setBounds(25, 285, 50, 50);
        cmdemployeeStatus.setBounds(115, 300, 190, 25);

        con.add(btnAdd);
        con.add(btnClear);
        con.add(btnUpdate);
        con.add(btnDelete);

        JSeparator verticalLine = new JSeparator(JSeparator.VERTICAL);
        verticalLine.setBounds(360, 15, 100, 380);
        con.add(verticalLine);

        btnAdd.setBounds(25, 350, 70, 25);
        btnClear.setBounds(105, 350, 70, 25);
        btnUpdate.setBounds(185, 350, 80, 25);
        btnDelete.setBounds(275, 350, 70, 25);

        con.add(lblSearchName);
        con.add(txtSearchName);
        con.add(lblSearchGender);
        con.add(cmdSearchGender);
        con.add(btnSearch);
        con.add(btnSearchClear);

        JSeparator horizontalLine = new JSeparator(JSeparator.HORIZONTAL);
        horizontalLine.setBounds(370, 100, 450, 380);
        con.add(horizontalLine);

        lblSearchName.setBounds(400, 5, 50, 50);
        txtSearchName.setBounds(450, 20, 130, 25);
        lblSearchGender.setBounds(590, 20, 130, 25);
        cmdSearchGender.setBounds(650, 20, 130, 25);
        btnSearch.setBounds(490, 60, 100, 25);
        btnSearchClear.setBounds(600, 60, 100, 25);

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
        jspTable.setBounds(380, 120, 430, 255);

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

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnAddAp(e);
            }
        });

        initialize();
    }

    public void initialize() {
        loadView();
        loadForm();
    }

    public void loadForm() {
        List<Gender> genList = GenderController.get();

        Vector<Object> genders = new Vector();
        genders.add("Select a Gender");

        for (Gender gen : genList) {
            genders.add(gen);
        }

        DefaultComboBoxModel<Object> gndModel = new DefaultComboBoxModel(genders);
        cmdGender.setModel(gndModel);

        List<Designation> desigList = DesignationController.get();
        
        Vector<Object> designations = new Vector();
        designations.add("Select a Designation");

        for (Designation desig : desigList) {
            designations.add(desig);
        }

        DefaultComboBoxModel<Object> desigModel = new DefaultComboBoxModel(designations);
        cmdDesignation.setModel(desigModel);

        List<EmployeeStatus> statusList = EmployeeStatusController.get();

        Vector<Object> status = new Vector();
        status.add("Select a Status");

        for (EmployeeStatus sts : statusList) {
            status.add(sts);
        }

        DefaultComboBoxModel<Object> statusModel = new DefaultComboBoxModel(status);
        cmdemployeeStatus.setModel(statusModel);

        Vector<Object> dobYear = new Vector();
        dobYear.add("Year");

        for (int i = 1980; i <= 2005; i++) {
            dobYear.add(i);
        }

        DefaultComboBoxModel<Object> dobYearModel = new DefaultComboBoxModel(dobYear);
        cmdDobYear.setModel(dobYearModel);

        Vector<Object> dobMonth = new Vector();
        dobMonth.add("Month");

        for (int i = 1; i <= 12; i++) {
            dobMonth.add(i);
        }

        cmdDobMonth.setModel(new DefaultComboBoxModel(dobMonth));

        Vector<Object> dobDate = new Vector();
        dobDate.add("Date");

        for (int i = 1; i <= 31; i++) {
            dobDate.add(i);
        }

        cmdDobDate.setModel(new DefaultComboBoxModel(dobDate));

        txtName.setText("");
        txtNic.setText("");
        txtMobile.setText("");
        txtEmail.setText("");

        enableButtons(true, false, false);
        setStyle(initial);

    }

    public void enableButtons(boolean add, boolean update, boolean delete) {

        btnAdd.setEnabled(add);
        btnUpdate.setEnabled(update);
        btnDelete.setEnabled(delete);
    }

    public void setStyle(Color color) {
        
        txtName.setBackground(color);
        cmdDobYear.setBackground(color);
        cmdDobMonth.setBackground(color);
        cmdDobDate.setBackground(color);
        cmdGender.setBackground(color);
        txtNic.setBackground(color);
        txtMobile.setBackground(color);
        txtEmail.setBackground(color);
        cmdDesignation.setBackground(color);
        cmdemployeeStatus.setBackground(color);
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

    public void btnAddAp(ActionEvent e) {

        Employee employee = new Employee();
        String error = "";

        String name = txtName.getText();

        if (name.matches("^[A-Z][a-z]+$")) {
            employee.setName(name);
            txtName.setBackground(valid);
        } else {
            txtName.setBackground(invalid);
            error = error + "\nName is not valid";
        }

        String year = "";
        String month = "";
        String date = "";

        int dobYear = cmdDobYear.getSelectedIndex();

        if (dobYear != 0) {
            cmdDobYear.setBackground(valid);
            year = cmdDobYear.getSelectedItem().toString();
        } else {
            cmdDobYear.setBackground(invalid);
        }

        int dobMonth = cmdDobMonth.getSelectedIndex();

        if (dobMonth != 0) {
            cmdDobMonth.setBackground(valid);
            month = cmdDobMonth.getSelectedItem().toString();
            if (month.length() == 1) {
                month = "0" + month;
            }
        } else {
            cmdDobMonth.setBackground(invalid);
        }

        int dobDate = cmdDobDate.getSelectedIndex();

        if (dobDate != 0) {
            cmdDobDate.setBackground(valid);
            date = cmdDobDate.getSelectedItem().toString();
            if (date.length() == 1) {
                date = "0" + date;
            }
        } else {
            cmdDobDate.setBackground(invalid);
        }

        if (dobYear != 0 && dobMonth != 0 && dobDate != 0) {
            String dobs = year + "-" + month + "-" + date;
            LocalDate dob = LocalDate.parse(dobs);
            employee.setDob(dob);
        } else {
            error = error + "\nSelect Birth Date";
        }

        int gender = cmdGender.getSelectedIndex();

        if (gender != 0) {
            employee.setGender((Gender) cmdGender.getSelectedItem());
            cmdGender.setBackground(valid);
        } else {
            cmdGender.setBackground(invalid);
            error = error + "\nGender is not selected";
        }

        String nic = txtNic.getText();

        if (nic.matches("^[0-9]{9}[V-v]$")) {
            employee.setNic(nic);
            txtNic.setBackground(valid);
        } else {
            txtNic.setBackground(invalid);
            error = error + "\nNic is not valid";
        }

        String mobile = txtMobile.getText();

        if (mobile.matches("^(?:\\+94|0)?(7\\d{8})$")) {
            employee.setMobile(mobile);
            txtMobile.setBackground(valid);
        } else {
            txtMobile.setBackground(invalid);
            error = error + "\nMobile is not valid";
        }

        String email = txtEmail.getText();

        if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            employee.setEmail(email);
            txtEmail.setBackground(valid);
        } else {
            txtEmail.setBackground(invalid);
            error = error + "\nEmail is not valid";
        }

        int designation = cmdDesignation.getSelectedIndex();

        if (designation != 0) {
            employee.setDesignation((Designation) cmdDesignation.getSelectedItem());
            cmdDesignation.setBackground(valid);
        } else {
            cmdDesignation.setBackground(invalid);
            error = error + "\nDesignation is not selected";
        }

        int status = cmdemployeeStatus.getSelectedIndex();

        if (status != 0) {
            employee.setEmployeeStatus((EmployeeStatus) cmdemployeeStatus.getSelectedItem());
            cmdemployeeStatus.setBackground(valid);
        } else {
            cmdemployeeStatus.setBackground(invalid);
            error = error + "\nStatus is not selected";
        }

        if (error.isEmpty()) {

            String cnfmsg = "Are you sure to save following Employee?\n";
            cnfmsg = cnfmsg + "\nName : " + employee.getName();
            cnfmsg = cnfmsg + "\nDob : " + employee.getDob().toString();
            cnfmsg = cnfmsg + "\nGender : " + employee.getGender().getName();
            cnfmsg = cnfmsg + "\nNic : " + employee.getNic();
            cnfmsg = cnfmsg + "\nMobile : " + employee.getMobile();
            cnfmsg = cnfmsg + "\nEmail : " + employee.getEmail();
            cnfmsg = cnfmsg + "\nDesignation : " + employee.getDesignation().getName();
            cnfmsg = cnfmsg + "\nStatus : " + employee.getEmployeeStatus().getName() + "\n\n";

            int conf = JOptionPane.showConfirmDialog(null, cnfmsg);
            if (conf == 0) {
                String st = EmployeeController.post(employee);
                if (st.equals("1")) {
                    loadView();
                    loadForm();
                    JOptionPane.showMessageDialog(null, "Successfully saved");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to saved as \n\n" + st);
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, error);
        }

    }

}

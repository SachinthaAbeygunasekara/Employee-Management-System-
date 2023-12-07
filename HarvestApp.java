import javax.swing.JFrame;

public class HarvestApp {
    public static void main(String[] args) {
        EmployeeUI empMgr = new EmployeeUI();
        empMgr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        empMgr.setVisible(true);
    }
}

package courseProject;

import javax.swing.SwingUtilities;

public class BankAccountGUIApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                BankAccountGUI gui = new BankAccountGUI();
                gui.setVisible(true);
            }
        });
    }
}

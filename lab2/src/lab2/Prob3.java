package lab2;

import javax.swing.JOptionPane;

class Prob3 {
    public static int getInt(String mess) {
        int val;
        while (true) { // itereaza in bucla pana cand se primeste un int valid
            String s = JOptionPane.showInputDialog(null, mess);
            try {
                val = Integer.parseInt(s);
                break; // iese din bucla cu un intreg valid >>>>>>>>>>>>>>>>>>>>>>
            } catch (NumberFormatException nx) {
                JOptionPane.showMessageDialog(null, "Introduceti un intreg valid");
            }
        }
        return val;
    }//end getInt

    public static float getFloat(String mess) {
        float val;
        while (true) { // itereaza in bucla pana cand se primeste un int valid
            String s = JOptionPane.showInputDialog(null, mess);
            try {
                val = Float.parseFloat(s);
                break; // iese din bucla cu un intreg valid >>>>>>>>>>>>>>>>>>>>>>
            } catch (NumberFormatException nx) {
                JOptionPane.showMessageDialog(null, "Introduceti un float valid");
            }
        }
        return val;
    }//end getInt

    public static double getDouble(String mess) {
        double val;
        while (true) { // itereaza in bucla pana cand se primeste un int valid
            String s = JOptionPane.showInputDialog(null, mess);
            try {
                val = Double.parseDouble(s);
                break; // iese din bucla cu un intreg valid >>>>>>>>>>>>>>>>>>>>>>
            } catch (NumberFormatException nx) {
                JOptionPane.showMessageDialog(null, "Introduceti un double valid");
            }
        }
        return val;
    }//end getInt

    public static boolean getBool(String mess) {
        boolean val;
        while (true) { // itereaza in bucla pana cand se primeste un int valid
            String s = JOptionPane.showInputDialog(null, mess);
            try {
                val = Boolean.parseBoolean(s);
                break; // iese din bucla cu un intreg valid >>>>>>>>>>>>>>>>>>>>>>
            } catch (NumberFormatException nx) {
                JOptionPane.showMessageDialog(null, "Introduceti un bool valid");
            }
        }
        return val;
    }//end getInt

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String str = null;
        System.out.println("Numarul intreg este " + Prob3.getInt(str));
        System.out.println("\nNumarul float este " + Prob3.getFloat(str));
        System.out.println("\nNumarul double este " + Prob3.getDouble(str));
        System.out.println("\nValoarea bool este " + Prob3.getBool(str));
    }
}


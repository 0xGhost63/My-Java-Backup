import javax.swing.JOptionPane;
public class GUI_Input_Output 
{
    public static void main(String[] args) 
    {
        JOptionPane.showMessageDialog(null,"Hello World");
        String name = JOptionPane.showInputDialog("Enter your name :)");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age !"));
        double height = Double.parseDouble(JOptionPane.showInputDialog("Enter your height"));
        String data=String.format("Hi %s you are %d years old and %.2f cm tall",name,age,height);
        JOptionPane.showMessageDialog(null,data);
    }
}
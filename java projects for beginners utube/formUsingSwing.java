import javax.swing.*;

public class formUsingSwing {
    public static void main(String[] args) {
        System.out.println("testing.....");
        MyWindow w=new MyWindow();
    }

    public static class MyWindow extends JFrame {
        public MyWindow(){
            System.out.println("This is the constructor");
            super.setTitle("MyForm");
            super.setSize(400,400);
            super.setLocation(100,100);
            super.setVisible(true);


        }
    }
}

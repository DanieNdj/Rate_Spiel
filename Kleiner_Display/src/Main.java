import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class Main {

    static int myNumber = new Random().nextInt(100) + 1 ;
    static int count = 0;
    static JLabel text = new JLabel("Gebe eine Zahl zwishen 1 und 100 ein");

    static JTextField textField = new JTextField();

    public static void main(String[] args){
       //System.out.println("The number ist " + myNumber);
        //nextRound();

        openUI();
    }

    public static void openUI(){
        JFrame frame = new JFrame("Rate die Zahl");
        frame.setSize(550,350);
        frame.setLocation(100,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultLookAndFeelDecorated(true);


        text.setBounds(150, 50,300,30);


        textField.setBounds(100,120,350,30);

        JButton button = new JButton("Raten");
        button.setBounds(150,200,200,50);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String textFromTextfield = textField.getText();
                    int number = Integer.parseInt(textFromTextfield);
                    System.out.println(number);
                    guess(number);
                } catch (Exception error){
                    text.setText("Geben Sie bitte eine richtige Zahl");
                }
                textField.setText("");
            }
        });

        frame.add(text);
        frame.add(textField);
        frame.add(button);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void nextRound(){
        count++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie bitte eine Zahl ein : ");
        int number = scanner.nextInt();
        guess (number);

    }
    public static void guess(int number){
        if(number == myNumber){
            System.out.println("Richtig geraten!");
            System.out.println("Number of tries: " + (count +1));

            text.setText("Richtig geraten mit " + (count + 1) + " Versuche");
        }else{
            count++;
            if(number < myNumber){
                //System.out.println("Deine Zahl ist zu klein\n");
                text.setText("Falsch geraten die Zahl ist zu klein");

            } else {
                //System.out.println("Deine Zahl ist zu groß\n");
                text.setText("Falsch geraten die Zahl ist zu groß");
            }
            textField.setText("");
            //nextRound();
        }

    }

}

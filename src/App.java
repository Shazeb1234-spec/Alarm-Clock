import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Set Alarm Time (HH:mm:ss)");
        String input = scanner.nextLine();

        // It helps to tell which time format the user was typing
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime alarmtime;

        // Just in case if the user types an invalid time format
        try {

            alarmtime = LocalTime.parse(input, formatter);

        } catch (Exception e) {

            System.out.println("Invalid Time Format");
            scanner.close();
            return;

        }

        System.out.println("Alarm Set For " + alarmtime);

        // If The condition is true then it will go forever which what line 34 says
        while (true) {

            // The time will be stored in the now variable 
            LocalTime now =  LocalTime.now();
            
            // The "!" is telling that we are checking something else and the if statement is saying that if the time local time is not before the alarm time we set then it wwill ring
            if (!now.isBefore(alarmtime)) {

                System.out.println("Your Alarm is ringing");
                break;
            }

            try {
                //Code will check the time after evry one second and thred.sleep means that the computer will sleep every one second
                Thread.sleep(1000);

                //Whenever Someone interrupts the program it will carry on from wherever is possible
            } catch (InterruptedException e) {
                
                System.out.println("Someone has interrupted the program...");
                Thread.currentThread().interrupt();
                scanner.close();
            }

        }


    }
}

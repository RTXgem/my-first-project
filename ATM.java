//made by Singculan :D
 
//This is a STM simulator where you can withdraw cash and deposit B)
 
import java.util.Scanner;
public class ATM {
    public static void main(String[] args) {
        
        LaunchATM launchatm = new LaunchATM();
        
        launchatm.greet();
        
    }
}
 
 
 
class LaunchATM{
    
    WasCreated wascreated = new WasCreated();
    Scanner scan = new Scanner(System.in);
    UserInfo userinfo = new UserInfo();
    
    void greet(){
        String secret = "8";
        System.out.println();
        System.out.print("\n============================\nHello player kindly follow the instructions below\nPress enter to proceed: ");
        
        secret = scan.nextLine();
        
        if (secret.equals("8")){
         System.out.println();
         wascreated.created();
        } else {
        signin();
        }
    }
    
    void signin(){
        
        System.out.println("============================");
        System.out.print("Ceate new user: ");
        userinfo.name = scan.nextLine();
        System.out.println("============================");
        System.out.print("Create new password: ");
        userinfo.pass = scan.nextLine();
        System.out.println();
        System.out.println();
        mainatm();
        
    }
    
    
    void mainatm(){
        
        int choice1;
        boolean mainatmrun = true;
        
        while (mainatmrun){
        System.out.printf("Hello %s!\n", userinfo.name);
    System.out.println("How can I help you today?");
    System.out.println();
    System.out.println("[1] Withdraw");
    System.out.println("[2] Deposit");
    System.out.println();
    System.out.print("Choice here: ");
    choice1 = scan.nextInt();
    scan.nextLine();
    
    
    String passattempt;
 
    if (choice1 == 1){
        
        boolean runpassattempt = true;
     
        while (runpassattempt){
            System.out.println();
        System.out.print("Enter password to withdraw: ");
        passattempt = scan.nextLine();
        System.out.println();
        
     if (passattempt.equals(userinfo.pass)){
            runpassattempt = false;
            mainatmrun = false;
            atmwithdraw();
        } else {
            System.out.println("Wrong password! Try again");
            System.out.println();
            
        }//if
        }//while
       
    } else if (choice1 == 2){
       
       String depositpassattempt;
       boolean depositpasscheck = true;
       
       while (depositpasscheck){
        System.out.println();
        System.out.print("Enter password to deposit: ");
      depositpassattempt = scan.nextLine();
      System.out.println("============================");
        
        if (depositpassattempt.equals(userinfo.pass)){
            depositpasscheck = false;
            deposit();
            mainatmrun = false;
        } else {
            System.out.println("Wrong password! Try again");
            System.out.println();
        }//if
       }//while deposit pass check
        
    }else{
        System.out.println();
        System.out.println("Invalid choice!");
        System.out.println("============================");
        System.out.println();
    }//if
    }
    }
    
    
    void atmwithdraw(){
        
        while(true){
        double towithdraw;
        System.out.println();
        System.out.println("Enter the amount you want to withdraw below");
        System.out.println();
        System.out.print("Amount: ");
        towithdraw = scan.nextDouble();
        scan.nextLine();
        System.out.println("============================");
        System.out.println();
        
 
        if (towithdraw <= userinfo.digitalcash){
            
               userinfo.digitalcash -= towithdraw;
            System.out.printf("Withdrawal succesful!\n"); 
System.out.println("============================");
            System.out.println();
        System.out.printf("You've withdrawed: %.2f", towithdraw);
        System.out.println();
        System.out.printf("Balance left: %.2f", userinfo.digitalcash);
        
        int choice1;
            System.out.println();
            System.out.println();
            System.out.println("[1] Try again?");
            System.out.println("[2] Go back to main lobby");
            System.out.print("Enter choice here: ");
            choice1 = scan.nextInt();
            scan.nextLine();
            System.out.println("============================");
            
            if (choice1 == 1){
                
            } else if (choice1 == 2){
                System.out.println();
                System.out.println();
                mainatm();
                return;
            } else {
                
                System.out.println("Invalid choice XD");
                System.out.print("Press enter to try again: ");
                scan.nextLine();
                mainatm();
                return;
            }//if try again
            
        } else {
            
            int choice1;
            System.out.println("Insufficient balance! :(");
            System.out.printf("\nYour current balance: %.2f", userinfo.digitalcash);
            System.out.println();
            System.out.println();
            System.out.println("[1] Try again?");
            System.out.println("[2] Go back to main lobby");
            System.out.print("Enter choice here: ");
            choice1 = scan.nextInt();
            scan.nextLine();
            System.out.println("============================");
            
            if (choice1 == 1){
           
            } else if (choice1 == 2){
                System.out.println();
                System.out.println();
                mainatm();
            } else {
                System.out.println("Invalid choice XD");
                System.out.println("*Sending you back to ATM*");
                System.out.println();
                System.out.println();
                mainatm();
                return;
        
            }//if try again
            
        }//if to withdraw
        }//while to withdraw
    }//atmwithdraw
    
    
    
    
    void deposit(){
        
        while(true){
        double todeposit;
        System.out.println();
        System.out.println("Enter amount to deposit");
        System.out.print("Amount here: ");
;        todeposit = scan.nextDouble();
        
        if (todeposit <= userinfo.cash){
           
           userinfo.digitalcash += todeposit;
           userinfo.cash -= todeposit;
        System.out.println();
        System.out.printf("You have deposited: %.2f\n", todeposit);
        System.out.printf("Your cash in hand is: %.2f\n", userinfo.cash);
     System.out.printf("Your new balance in ATM: %.2f\n", userinfo.digitalcash);
        System.out.println("============================");
        
        int choice1;
        
        System.out.println();
            System.out.println();
            System.out.println("[1] Try again?");
            System.out.println("[2] Go back to main lobby");
            System.out.print("Enter choice here: ");
            choice1 = scan.nextInt();
            scan.nextLine();
            System.out.println("============================");
            
            if (choice1 == 1){
            
            } else if (choice1 == 2){
                System.out.println();
                System.out.println();
                mainatm();
                return;
            } else {
                System.out.println("Invalid choice");
            }//if
    } else {
        System.out.println("Insuficient balance :(");
   //===============================
   int choice1;
        System.out.printf("\nYour cash is: %.2f", userinfo.cash);
            System.out.println();
            System.out.println();
            System.out.println("[1] Try again?");
            System.out.println("[2] Go back to main lobby");
            System.out.print("Enter choice here: ");
            choice1 = scan.nextInt();
            scan.nextLine();
            System.out.println("============================");
            
            if (choice1 == 1){
           
            } else if (choice1 == 2){
                System.out.println();
                System.out.println();
                mainatm();
            } else {
                System.out.println("Invalid choice XD");
                System.out.println("*Sending you back to ATM*");
                System.out.println();
                System.out.println();
                mainatm();
                return;
      //==============================
        
    }//if
    }//deposit
    }
    }
}//launchATM class
 
class WasCreated{
    Scanner scan = new Scanner(System.in);
    
    String madeby = "Duasty";
    String projectended = "June25(2026)";
    String projectstarted = "June24(2026)";
    
    void created(){
        System.out.println(madeby + ": ??");
        scan.nextLine();
        System.out.println(madeby + ": I guess you properly read my code :D");
        scan.nextLine();
        System.out.println("This was created by: "+ projectstarted);
        scan.nextLine();
        System.out.println("And ended at: " + projectended);
        scan.nextLine();
        System.out.println("Thank you for visiting my project :D");
        
    }
}
 
 
class UserInfo{
    double cash = 500;
    double digitalcash = 1000;
    String name;
    String pass;
    
}
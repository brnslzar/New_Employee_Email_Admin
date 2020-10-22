import java.util.Scanner;

public class Email{
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";


    // Constructor to receive the first name and las name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        System.out.println("New Employee: " + this.firstName + " " + this.lastName);
        // Call a method asking for the department - return the department
        this.department = setDepartment();
        System.out.println("Department: "+ this.department);

        //Call a method that returns a random passcode
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: "+ this.password);

        //Combine Elements to generate Email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + "." + department + companySuffix ;
        System.out.println("Your email is: "+ email);

    }

    //Ask for The department
    private String setDepartment(){
        System.out.print("DEPARTMENT CODES\n1 for Sales\n2 for Developent \n3 for Accounting\n0 for none\n");
        Scanner in = new Scanner(System.in);
        int depChoice =in.nextInt();
        if(depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "dev"; }
        else if (depChoice == 3) { return "acct"; }
        else {return ""; }

    }

    // generate random password
    private String randomPassword(int length){
        String passwordSet = "ABCD123!@#";
        char[] password = new char[length];
        for (int i=0; i<length; i++){
           int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String (password);

    }
    //Set the mailbox Capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    //Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    //Change the password
    public void changePassword(String password){
        this.password = password;
    }
    
    public int getMailboxCapacity(){return mailboxCapacity; }

    public String getAlternateEmail(){return alternateEmail; }

    public String getPassword(){return password; }

    public String showInfo(){
        return "Display Name: " + firstName + " "+ lastName + "Company Email: " + email + "Mail Capacity: " + mailboxCapacity + "mb";
    }
}
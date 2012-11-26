
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class register implements Serializable {
    // City names from

    User customer;
    public UserDatabase UserDatabase;
    ArrayList<User> allCustomers;
    User firstCustomer;
    String dir;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public register() {
        allCustomers = new ArrayList<User>();
        // UserDatabase = new UserDatabase();
        ReadDatabase();
    }

    public User getFirstCustomer() {
        return firstCustomer;
    }

    public void setFirstCustomer(User firstCustomer) {
        this.firstCustomer = firstCustomer;
    }

    public List<User> getAllCustomers() {
        return allCustomers;
    }

    public void setAllCustomers(ArrayList<User> allCustomers) {
        this.allCustomers = allCustomers;
    }

    public UserDatabase getUserDatabase() {
        return UserDatabase;
    }

    public void setUserDatabase(UserDatabase UserDatabase) {
        this.UserDatabase = UserDatabase;
    }
    String username, password;
    Date dateofbirth;

    // http://www.usatoday.com/weather/resources/climate/wusaclim.htm
    public String addUser() {
        ReadDatabase();
        System.out.println("haha");
        customer = new User(username, password,dateofbirth);
        System.out.println("haha1");

        UserDatabase.addCustomer(customer);
        System.out.println("haha2");

        WriteDatabase();
        System.out.println("haha3");

        // UserDatabase.ReadDatabase();
        allCustomers = UserDatabase.getArrayListCustomer();
        System.out.println("haha4");

        // firstCustomer = allCustomers.get(0);
        return "UserAdded";

    }

    public void WriteDatabase() {
        try {
            System.out.println(System.getProperty("user.dir"));
            dir = System.getProperty("user.dir");
            System.out.println("t1");
      //      ObjectOutputStream outputListCustomer = new ObjectOutputStream(
       //             new FileOutputStream("C:/Users/Myrmidon/workspace/Namproctin_JSF/src/UserDatabase.dat"));

              //jelastic
             ObjectOutputStream outputListCustomer = new ObjectOutputStream(
                    new FileOutputStream("UserDatabase.dat"));

            outputListCustomer.writeObject(UserDatabase);
            outputListCustomer.close();
            System.out.println("t2");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("t3");
        }
    }

    public void ReadDatabase() {

        try {
         //   ObjectInputStream inputListCustomer = new ObjectInputStream(
           //         new FileInputStream("C:/Users/Myrmidon/workspace/Namproctin_JSF/src/UserDatabase.dat"));


                  //jelastic
             ObjectInputStream inputListCustomer = new ObjectInputStream(
                    new FileInputStream("UserDatabase.dat"));

            UserDatabase = ((UserDatabase) inputListCustomer.readObject());
            inputListCustomer.close();
        } catch (EOFException e) {
            UserDatabase = new UserDatabase();
            System.out.println("new");
        } catch (Exception ex) {
                 System.out.println("something wrong , database reset!");
            UserDatabase = new UserDatabase();
            WriteDatabase();
            System.out.println(ex);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

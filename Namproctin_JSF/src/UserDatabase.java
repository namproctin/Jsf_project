
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

public class UserDatabase implements Serializable {

    /**
     *
     */
    /**
     *
     */
    public ArrayList<User> listCustomer;
    public String testString;

    public void printAll() {
        System.out.println("print all username and password");
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.println(listCustomer.get(i).username);
            System.out.println(listCustomer.get(i).password);

        }
    }

    public User getUser(String username, String password) {

        //      System.out.println(listCustomer.get(0).username);
        //      System.out.println(listCustomer.get(0).password);
        System.out.println("get user from username and password");
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.println(listCustomer.get(i).username);
            System.out.println(listCustomer.get(i).password);
            if ((listCustomer.get(i).username.equals(username)) && (listCustomer.get(i).password.equals(password))) {
                return listCustomer.get(i);

            }
        }
        return null;

    }

    public String getTestString() {
        return testString;
    }

    public void setTestString(String testString) {
        this.testString = testString;
    }

    public UserDatabase() {
        testString = "myTest";
        listCustomer = new ArrayList<User>();
    }
    // TODO Auto-generated constructor stub

    //	listCustomer=Arrays.asList(myarray);
    //User c = new User("test1", "test1");
    //addCustomer(c);
    //WriteDatabase();
    /**
     * @param args
     */
    public ArrayList<User> getArrayListCustomer() {
        return listCustomer;
    }

    public void setListCustomer(ArrayList<User> listCustomer) {
        this.listCustomer = listCustomer;
    }

    public void addCustomer(User c) {

        listCustomer.add(c);

    }
}

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements Serializable {

    /**
     * @param args
     */
    public String username, password;
    Date dateofbirth;
    ArrayList<Article> arraylistArticle;

    public void addArticle(Article a) {
            System.out.println(a.articleContent);
            System.out.println(a.articleTitle);
            System.out.println(a.articleDate);
        arraylistArticle.add(a);
        
    }

    public Date getDateofbirth() {

        return dateofbirth;
    }

    public void setDateofbbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public User(String username, String password, Date dateofbirth) {
        this.username = username;
        this.password = password;
        this.dateofbirth = dateofbirth;
        arraylistArticle= new ArrayList<Article>();
        // TODO Auto-generated constructor stub
    }

    public ArrayList<Article> getArraylistArticle() {
        return arraylistArticle;
    }

    public void setArraylistArticle(ArrayList<Article> arraylistArticle) {
        this.arraylistArticle = arraylistArticle;
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


import javax.faces.bean.ManagedBean;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Myrmidon
 */
@ManagedBean
@SessionScoped
public class UserSession {

    /** Creates a new instance of UserSession */
    Boolean isLogin;
    ArrayList<Article> userAllArticle;

    public ArrayList<Article> getUserAllArticle() {
        if (isLogin) {
            return userDatabase.getUser(username, password).getArraylistArticle();
        } else {

            return null;
        }



    }

    public void setUserAllArticle(ArrayList<Article> userAllArticle) {
        this.userAllArticle = userAllArticle;
    }

    public Boolean getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Boolean isLogin) {
        this.isLogin = isLogin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    String username, password;

    public UserSession() {
        errorLogin = "";
        isLogin = false;

    }
    UserDatabase userDatabase;

    public String doLogin() {
        ReadDatabase();
        System.out.println("read database success");
        System.out.println("print all");
        userDatabase.printAll();

        if (userDatabase.getUser(username, password) != null) {
            isLogin = true;
            errorLogin = "";
            System.out.println("loggeg in");
        } else {
            isLogin = false;
            errorLogin = "Wrong username and password combination";
            return "HomePage";
        }
        return "AllArticle";
    }
    String errorLogin;

    public void deleteArticle() {

        FacesContext f = FacesContext.getCurrentInstance();
        String date = f.getExternalContext().getRequestParameterMap().get("date");
        userAllArticle = getUserAllArticle();
        for (int i = 0; i < userAllArticle.size(); i++) {
            if (userAllArticle.get(i).articleDate.toString().equals(date)) {
                System.out.println("found article to delete");
                userAllArticle.remove(i);
                System.out.println("article deleted");
                break;


            }
        }

        System.out.println("");
        WriteDatabase();
        //    String date = FacesContext.getExternalContext().getRequestParameterMap().get("date");

        //...
    }
    String updateArticleTitle, updateArticleContent;
    String  updateDate;

    public String getUpdateDate() {
        FacesContext f = FacesContext.getCurrentInstance();
        String s= f.getExternalContext().getRequestParameterMap().get("articledate");
        System.out.println("Da nhan duoc date " + s);
        return s;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateArticleContent() {


        FacesContext f = FacesContext.getCurrentInstance();
        return f.getExternalContext().getRequestParameterMap().get("articlecontent");
    }

    public void setUpdateArticleContent(String updateArticleContent) {
        this.updateArticleContent = updateArticleContent;
    }

    public String getUpdateArticleTitle() {

        FacesContext f = FacesContext.getCurrentInstance();
        return f.getExternalContext().getRequestParameterMap().get("articletitle");
    }

    public void setUpdateArticleTitle(String updateArticleTitle) {
        this.updateArticleTitle = updateArticleTitle;
    }

    public String getErrorLogin() {
        return errorLogin;
    }

    public void setErrorLogin(String errorLogin) {
        this.errorLogin = errorLogin;
    }

    public String doLogout() {
        isLogin = false;
        errorLogin = "";
        System.out.println("loggeg out");
        return "HomePage";
    }

    public void ReadDatabase() {

        try {
       //     ObjectInputStream inputListCustomer = new ObjectInputStream(
        //            new FileInputStream("C:/Users/Myrmidon/workspace/Namproctin_JSF/src/UserDatabase.dat"));

                //jelastic
             ObjectInputStream inputListCustomer = new ObjectInputStream(
                    new FileInputStream("UserDatabase.dat"));


            userDatabase = ((UserDatabase) inputListCustomer.readObject());

            userDatabase.printAll();
            inputListCustomer.close();
        } catch (EOFException e) {
            userDatabase = new UserDatabase();
            System.out.println("new database");
        } catch (Exception ex) {
            System.out.println("something wrong , database reset!");
            userDatabase = new UserDatabase();
            WriteDatabase();
            System.out.println(ex);
        }

    }
String userDirectory;

    public String getUserDirectory() {
        return System.getProperty("user.dir");
    }

    public void setUserDirectory(String userDirectory) {
        this.userDirectory = userDirectory;
    }

    public void WriteDatabase() {
        try {
            System.out.println(System.getProperty("user.dir"));

       //    ObjectOutputStream outputListCustomer = new ObjectOutputStream(
       //             new FileOutputStream("C:/Users/Myrmidon/workspace/Namproctin_JSF/src/UserDatabase.dat"));

            //jelastic
             ObjectOutputStream outputListCustomer = new ObjectOutputStream(
                    new FileOutputStream("UserDatabase.dat"));


            outputListCustomer.writeObject(userDatabase);
            outputListCustomer.close();
            System.out.println("write database success");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("write database failed");
        }
    }

    public String navigatetoNewPost() {
        return "NewPost";
    }

    public String doAddArticle() {
        userDatabase.getUser(username, password).addArticle(new Article(new Date(), articleTitle, artileContent));
        System.out.println("article added");
        System.out.println(articleTitle + artileContent);

        WriteDatabase();
        return "AllArticle";

    }

    public String doUpdateArticle() {

       // ReadDatabase();

        System.out.println("tttttttttttt");
        // why without these two line => null ?
        FacesContext f = FacesContext.getCurrentInstance();
        updateDate= f.getExternalContext().getRequestParameterMap().get("articledate");

        System.out.println(updateDate);

     
        userAllArticle=getUserAllArticle();
        System.out.println("update Date la:"+ updateDate);
        System.out.println("update title la:"+updateArticleTitle);
        System.out.println("update content la:"+updateArticleContent);
        System.out.println("ListDate:");
        for (int i = 0; i < userAllArticle.size(); i++) {
            System.out.println(userAllArticle.get(i).articleDate);
            
            if (userAllArticle.get(i).articleDate.toString().equals(updateDate)) {
                System.out.println("found matched");
                userAllArticle.remove(i);
                break;
            }
        }

        userDatabase.getUser(username, password).addArticle(new Article(new Date(), updateArticleTitle, updateArticleContent));
        System.out.println("article updated");
        WriteDatabase();
        return "AllArticle";
//        userDatabase.getUser(username, password).addArticle(new Article(new Date(), articleTitle, artileContent));
//        System.out.println("article added");
//        System.out.println(articleTitle + artileContent);
//
//        WriteDatabase();
//        return "AllArticle";
//
//



    }
    String articleTitle, artileContent;

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArtileContent() {
        return artileContent;
    }

    public void setArtileContent(String artileContent) {
        this.artileContent = artileContent;
    }
}


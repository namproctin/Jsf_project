
import java.io.Serializable;
import java.util.Date;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Myrmidon
 */
public class Article implements Serializable {

    Date articleDate;
    String articleTitle;
    String articleContent;

    public Article(Date articleDate, String title, String articlecontent) {

        this.articleContent = articlecontent;
        this.articleDate = articleDate;
        this.articleTitle = title;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }
}

package coreservlets;

import java.util.Date;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class TrainingRegistration {
  private Date date;
  
  public Date getDate() {
    return(date);
  }

  public void setDate(Date date) {
    this.date = date;
  }

  /** Returns a String representing the date, in a form similar to
   * "Tuesday, November 1, 2011". For use in results page.
   */
  public String getDay() {
    return(DateUtils.formatDate(date));
  }
  
  public String register() {
    return("show-date");
  }
  public String doRegister()
  {
	  return("Register");
	  
  }
}

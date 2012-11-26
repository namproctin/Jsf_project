

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class DateBean {
  protected Date startDate, endDate;
  
  public Date getStartDate() {
    return(startDate);
  }
  
  /** Returns a String representing the starting date, in a form similar to
   * "Tuesday, November 1, 2011". For use in results page.
   */
  public String getStartDay() {
    return(formatDate(startDate));
  }
  
  /** Given a Date, returns a String "Day, Month Number, Year", 
   *  e.g. "Wednesday, November 2, 2011". For results page.
   */
  private String formatDate(Date date) {
    if (date == null) {
      return("");
    } else {
      return(String.format("%tA, %tB %te, %tY", 
                           date, date, date, date));
    }
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return(endDate);
  }
  
  /** Returns a String representing the ending date, in a form similar to
   * "Wednesday, November 2, 2011". For use in results page.
   */
  public String getEndDay() {
    return(formatDate(endDate));
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  
  public String register() {
    FacesContext context = FacesContext.getCurrentInstance();
    if (!startDate.before(endDate)) {
      endDate = null;
      FacesMessage errorMessage = 
        new FacesMessage("End date must be after start date");
      context.addMessage(null, errorMessage);
      return(null);
    } else {
      return("show-dates");
    }
  }
}

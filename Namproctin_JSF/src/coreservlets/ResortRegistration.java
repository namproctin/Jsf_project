package coreservlets;

import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class ResortRegistration {
  private Date startDate, endDate;
  private String roomNum;

  public Date getStartDate() {
    return(startDate);
  }
  
  /** Returns a String representing the starting date, in a form similar to
   * "Tuesday, November 1, 2011". For use in results page.
   */
  public String getStartDay() {
    return(DateUtils.formatDate(startDate));
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
    return(DateUtils.formatDate(endDate));
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  
  public String getRoomNum() {
    return(roomNum);
  }

  public void setRoomNum(String roomNum) {
    this.roomNum = roomNum;
  }
  
  @SuppressWarnings("deprecation")
  public String register() {
    FacesContext context = FacesContext.getCurrentInstance();
    Date testDate = (Date)startDate.clone();
    testDate.setDate(testDate.getDate() + 2);
    if (!testDate.before(endDate)) {
      endDate = null;
      FacesMessage errorMessage = 
        new FacesMessage("3-day minimum stay required");
      context.addMessage(null, errorMessage);
      return(null);
    } else {
      return("show-dates");
    }
  }
}

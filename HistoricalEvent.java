/**
* HistoricalEvent.java - Represent any historical event with a description and date
*/

public class HistoricalEvent {
  /*******CONSTANTS**********/
  public static final String DEFAULT_DESCRIPTION = "Historical event description default.";
  public static final Date DEFAULT_EVENT_DAY = new Date();
  
  /*****INSTANCE VARIABLES*****/
  private String description;
  private Date eventDay;

  /*****CONSTRUCTORS*****/
  /**
  *Full constructor sets object to parameter values if valid, otherwise
  *outputs error message and exits program.
  *
  *@param description original "historical" description
  @param eventDay Date of historical event
  */
  public HistoricalEvent(String description, Date eventDay) {
    if(!this.setAll(description, eventDay)) {
      System.out.println("ERROR: bad data given to full constructor.");
      System.exit(0);
    }
  }

  /**
  *Default constructor sets HistoricalEvent object to default values
  */
  public HistoricalEvent() {
    this(DEFAULT_DESCRIPTION, DEFAULT_EVENT_DAY);
  }

  /**
  *Copy constructor creates a deep copy of original HistoricalEvent object,
  *if object null outputs error message and exits program.
  *
  *@param original HistoricalEvent object to deep copy
  */
  public HistoricalEvent(HistoricalEvent original) {
    if(original != null) {
      this.setAll(original.description, original.eventDay);
    } else {
      System.out.println("ERROR: null data given to copy constructor.");
      System.exit(0);
    }
  }

  /*****SETTERS / MUTATORS *******/
  /**
  *Sets description instance variable (no error checking)
  *
  *@param description historical event description
  *@return true if set, false if parameter is null
  */
  public boolean setDescription(String description) {
    if(description != null) {
      this.description = description;
      return true;
    } else {
      return false;
    }
  }

  /**
  *Sets event Date instance variable (no error checking, except for null)
  *and deep copies object to ensure encapsulation
  *
  *@param eventDay Date object representing day of historical event;
  *should not be changed in any way
  *@return true if set, false if parameter is null
  */
  public boolean setEventDay(Date eventDay) {
    if(eventDay != null) {
      this.eventDay = new Date(eventDay); //deep copy
      return true;
    } else {
      return false;
    }
  }

  /**
  *Sets all instance variables (no error checking, except null)
  *and deep copies object to ensure encapsulation
  *
  * @param description historical event description
  @param eventDay Date object representing day of historical event,
  *should not be changed in any way
  *
  *@return true if set, false if parameter is null 
  */

  public boolean setAll(String description, Date eventDay) {
    return this.setDescription(description) && this.setEventDay(eventDay); 
  }

  /*****GETTERS / ACCESSOR METHODS *******/
  /**
  *Acces value of description instance variable
  *
  *@return description of historical event
  */
  public String getDescription() {
    return this.description;
  }

  /**
  *Access value of eventDay instance variable (deep copy to preserve encapsulation)
  *
  *@return date of historical event
  */
  public Date getEventDay() {
    return new Date(this.eventDay); //deep copy
  }
  
  /********OTHER REQUIRED METHODS*********/
  @Override
  public String toString() {
    return "On " + this.eventDay + ": " + this.description;
  }

  @Override
  public boolean equals(Object other) {
    if(other == null) {
      return false;
    } else if(!(other instanceof HistoricalEvent)) {
      return false;
    } else {
      HistoricalEvent otherEvent = (HistoricalEvent) other;
      return this.description.equals(otherEvent.description) &&
        this.eventDay.equals(otherEvent.eventDay);
    }
  }
  
}
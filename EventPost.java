import java.util.*;

enum EventType {
	NEWMESSAGE, NEWFILE, LIKE, UNLIKE
}

/**
 * Parent Class For All Event Posts extending Post
 *
 * @author Nikhita Kataria
 * @version 1.0
 */
public class EventPost extends Post {
	private String eventType;

        /**
         * Constructor for objects of class EventPost
         *
         * @param author Username for the EventPost
         * @param e Event Type 
         */
	public EventPost(String author, EventType e) {
		super(author);
		switch(e) {
			case LIKE: eventType = "like";
			 	   break;
			case UNLIKE: eventType = "unlike";
			 	   break;
			case NEWMESSAGE: eventType = "new message";
			 	   break;
			case NEWFILE: eventType = "new file";
			 	   break;
		}
	}

        /**
         * Constructor for objects of class EventPost
         *
         * @param author Username for the EventPost
         * @param event User defined event type
         */
	public EventPost(String author, String event) {
		super(author);
		eventType = event;
	}

        /**
         * Method for setting event for the EventPost
         *
         * @param event Event for the EventPost
         */
	public void setEventType(String event) {
		if (event != null) {
			eventType = event;
		} else {
			throw new NullPointerException();
		}
	}

        /**
         * Method for getting event for the EventPost
         *
         * @return Event for the EventPost
         */
	public String getEventType() {
		return eventType;
	}

	public EventPost cloneEventPost() {
		EventPost obj = new EventPost(getUsername(), getEventType());
		return obj;
	}
}

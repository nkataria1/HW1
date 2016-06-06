import java.util.*;

/**
 * Class to handle all MessagePosts
 *
 * @author Nikhita Kataria
 * @version 1.0
 */
public class MessagePost extends CommentedPost {
	private String message;

        /**
         * Constructor for objects of class MessagePost
         *
         * @param username Username for the MessagePost
         * @param text Message for the Post
         */
	public MessagePost (String username, String text) {
		super(username);
		if (text != null) {
			message = text;
		} else {
			System.out.println("Message is empty");
			throw new NullPointerException();
		}
	}

        /**
         * Method for setting message for the MessagePost
         *
         * @param text Message for the Post
         */
	public void setMessage(String text) {
		if (text != null) {
			message = text;
		} else {
			System.out.println("Message is empty");
			throw new NullPointerException();
		}
	}

        /**
         * Method for getting message for the MessagePost
         *
         * @return Message for the Post
         */
	public String getMessage() {
		return message;
	}

        /**
         * Method for displaying metadata for the MessagePost
         *
         */
	public void display() {
		System.out.print("User " + getUsername() + " Posted Message ");
		getTimelapsed();
		System.out.println(message);
		displayLikesComments();
	}

	/** 
	 * Abstract method implemented by MessagePost
	 * @return CommentedPost Instance
	 */
	public CommentedPost cloneCommentedPost() {
		return cloneMessagePost(); 
	}

        /**
         * Method for cloning MessagePost
	 * @return Instance of MessagePost
         */
        public MessagePost cloneMessagePost() {
                MessagePost obj = new MessagePost(getUsername(), message);
		obj.setLikes(getLikes());
		ArrayList<String> commentList = getComments();
                for(String c : commentList) {
                       obj.addComment(new String(c));
                }
                return obj;
        }

        /**
         * Method for comparing PhotoPost instances
         */
        public Boolean equalsMessagePost(MessagePost obj) {
                if(obj.message.equals(message) && obj.getUsername().equals(getUsername())) {
                        return true;
                } else {
                        return false;
                }
        }
}


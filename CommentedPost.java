import java.util.*;

/**
 * Abstract Class For All CommentedPosts.
 * Inherited by MessagePost and PhotoPost
 *
 * @author Nikhita Kataria
 * @version 1.0
 */
public abstract class CommentedPost extends Post {
	private int likes;
	private ArrayList<String> comments;

	/**
	 * Constructor for objects of class CommentedPost
	 *
	 * @param name Username for the CommentedPost
	 */
	public CommentedPost (String name) {
		super(name);
		likes = 0;
		comments = new ArrayList<String>();
	}

	/**
	 * Method for getting likes for the CommentedPost
	 *
	 * @return Likes for the CommentedPost
	 */
	public int getLikes() {
		return likes;
	}

	/**
	 * Method for setting likes for the CommentedPost
	 *
	 * @param numLikes Likes for the CommentedPost
	 */
	public void setLikes(int numLikes) {
		likes = numLikes;;
	}

	/**
	 * Method for liking a Commentedpost
	 */
	public void like() {
		likes++;
	}

	/**
	 * Method for unliking a CommentedPost
	 */
	public void unlike() {
		likes--;
	}

	/**
	 * Method for adding comments for the CommentedPost
	 *
	 * @param text Comment for the CommentedPost
	 */
	public void addComment(String text) {
		if (text != null) {
			comments.add(text);
		} else {
			System.out.println("Comment is empty");
			throw new NullPointerException();
		}
	}

	/**
	 * Method for displaying comments for the CommentedPost
	 * @return String ArrayList of Comments
	 */
	public ArrayList<String> getComments() {
		return comments;
	}

	/**
	 * Method for displaying likes and comments for the CommentedPost
	 *
	 */
	public void displayLikesComments() {
		System.out.println("Comments:");
		for(String c : comments) {
			if (!c.isEmpty());
			System.out.println(c.toString());
		}
		System.out.println("Likes: "+ likes);
	}

	/**
	 * Method for displaying Post specific metadata by the classes extending CommentedPost
	 *
	 */
	abstract void display();

        /**
         * Abstract method implemented by PhotoPost
         * @return CommentedPost Instance
         */
        abstract CommentedPost cloneCommentedPost();
}

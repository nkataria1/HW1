import java.util.*;

/**
 * Parent Class For CommentedPost and EventPost
 *
 * @author Nikhita Kataria
 * @version 1.0
 */
public class Post {
	private String username;
	private long timestamp;
	private ArrayList<CommentedPost> commentedPosts;
	private ArrayList<EventPost> eventPosts;
	private static int num_event_posts = 0;
	private static int num_commented_posts = 0;

	/**
     	 * Constructor for objects of class Post 
     	 */
	public Post () {
		commentedPosts = new ArrayList<CommentedPost>();
		eventPosts = new ArrayList<EventPost>();
	}

	/**
     	 * Constructor for objects of class Post with user name
	 *
	 * @param name Username for the post
     	 */
	public Post (String name) {
		if (name != null) {
			username = name;
			timestamp = System.currentTimeMillis();
		} else {
			throw new NullPointerException();
		}
		commentedPosts = new ArrayList<CommentedPost>();
		eventPosts = new ArrayList<EventPost>();
	}

	/**
     	 * Method for adding instance of CommentedPost in Post
	 *
	 * @param post Instance of CommentedPost
     	 */
	public void addCommentedPost(CommentedPost post) {
		commentedPosts.add(post);
		num_commented_posts++;
	}

	/**
     	 * Method for adding instance of EventPost in Post
	 *
	 * @param post Instance of EventPost
     	 */
	public void addEventPost(EventPost post) {
		eventPosts.add(post);
		num_event_posts++;
	}

	/**
     	 * Method for setting username for the Post 
	 *
	 * @param name Username for the post
     	 */
	public void setUsername(String name) {
		if (name != null) {
			username = name;
		} else {
			throw new NullPointerException();
		}
	}

	/**
     	 * Method for setting timestamp for the Post 
	 *
	 * @param userTimestamp Time stamp for the post
     	 */
	public void setTimestamp(long userTimestamp) {
		timestamp = userTimestamp;
	}

	/**
     	 * Method for getting username for the Post 
	 *
	 * @return Username for the post
     	 */
	public String getUsername() {
		if (username != null) {
			return username;
		} else {
			return null;
		}
	}

	/**
     	 * Method for getting timestamp for the Post 
	 *
	 * @return Time stamp for the post
     	 */
	public long getTimestamp() {
		return timestamp;
	}

	/**
     	 * Method for getting time lapsed since the post was added
     	 */
	public void getTimelapsed() {
		long current = System.currentTimeMillis();
		long lapsedSec = (current - timestamp)/1000;
		int lapsedMin = (int) lapsedSec/60;
		int lapsedHours = (int)lapsedMin/60;
		if (lapsedHours >= 24) {
			System.out.println(lapsedHours/24+" Days ago");
		} else {
			if (lapsedHours > 0)
				System.out.print(lapsedHours + " hours ");
			if (lapsedMin > 0)
				System.out.print((lapsedMin-lapsedHours*60) + " minutes ");
			if (lapsedSec >= 0)
				System.out.print((lapsedSec-lapsedMin*60) + " seconds");
			System.out.println(" ago");
		}
	}

	/**
     	 * Method for disaplying all CommentedPosts
	 *
     	 */
	public void displayCommentedPosts() {
		System.out.println("Number of Commented Posts " + num_commented_posts);
		for (CommentedPost c : commentedPosts) {
			c.display();
		}
	}

	/**
     	 * Method for disaplying all EventPosts
	 *
     	 */
	public void displayEventPosts() {
		System.out.println("Number of Event Posts " + num_event_posts);
		for (EventPost e : eventPosts) {
			System.out.println("User " + e.getUsername() + " added " + e.getEventType());
		}
	}

	public Post clonePost() {
		Post obj = new Post(username);
		obj.timestamp = timestamp;
		/* Clone Event and Commented Post */
		for (CommentedPost c : commentedPosts) {
			obj.commentedPosts.add(c.cloneCommentedPost());
		}
		for (EventPost e : eventPosts) {
			obj.eventPosts.add(e.cloneEventPost());
		}
		obj.num_event_posts = num_event_posts;
		obj.num_commented_posts = num_commented_posts;
		return obj;
	}
}

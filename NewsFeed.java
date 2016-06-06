import java.lang.*;
import java.util.*;

/**
 * Client Class to test PhotoPost, MessagePost and EventPost
 * 
 * @author Nikhita Kataria
 * @version 1.0
 */
public class NewsFeed {
	/**
	 * Main method to trigger test client for Posts
	 * @param args Collection of args
	 */
	public static void main(String []args) {
		/* Add some photo posts */
		Post p = new Post();

		System.out.println("------------------------");
		System.out.println("Adding 3 New Photo Posts");
		System.out.println("------------------------");

		PhotoPost pp1;
		pp1 = new PhotoPost("user1", "test1.jpg");
		p.addCommentedPost(pp1);
		pp1.addCaption("First Photo Post");
		System.out.println(pp1.getUsername() + " Added file " + pp1.getFileName() + " with caption "+ pp1.getCaption());

		pp1 = new PhotoPost("user2", "test2.jpg");
		p.addCommentedPost(pp1);
		pp1.addCaption("Second Photo Post");
		System.out.println(pp1.getUsername() + " Added file " + pp1.getFileName() + " with caption "+ pp1.getCaption());

		pp1 = new PhotoPost("user3", "test3.jpg");
		p.addCommentedPost(pp1);
		pp1.addCaption("Third Photo Post");
		System.out.println(pp1.getUsername() + " Added File " + pp1.getFileName() + " with caption "+ pp1.getCaption());

		System.out.println("-----------------------------");
		System.out.println("Done Adding 3 New Photo Posts");
		System.out.println("-----------------------------");

		System.out.println("-----------------------------");
		System.out.println("Adding 3 New Message Posts");
		System.out.println("-----------------------------");

		MessagePost mp1;
		mp1 = new MessagePost("user1", "Have a good day");
		p.addCommentedPost(mp1);
		mp1.like();
		mp1.addComment("Good day !!");
		mp1.addComment("Have a Good day !!");
		System.out.println(mp1.getUsername() + " Added Post " + mp1.getMessage());

		mp1 = new MessagePost("user2", "Have a good day");
		p.addCommentedPost(mp1);
		mp1.like();
		mp1.addComment("Good day !!");
		mp1.addComment("Have a Good day !!");
		System.out.println(mp1.getUsername() + " Added Post " + mp1.getMessage());

		mp1 = new MessagePost("user3", "Have a good day");
		p.addCommentedPost(mp1);
		mp1.like();
		mp1.addComment("Good day !!");
		mp1.addComment("Have a Good day !!");
		System.out.println(mp1.getUsername() + " Added Post " + mp1.getMessage());

		System.out.println("-----------------------------");
		System.out.println("Done Adding 3 New Message Posts");
		System.out.println("-----------------------------");

		System.out.println("-----------------------------");
		System.out.println("Adding 5 New Events");
		System.out.println("-----------------------------");

		EventPost e1;
		e1 = new EventPost("user 3", EventType.NEWMESSAGE);
		p.addEventPost(e1);
		System.out.println(e1.getUsername() + " Added Event " + e1.getEventType());

		e1 = new EventPost("user 4", EventType.NEWFILE);
		p.addEventPost(e1);
		System.out.println(e1.getUsername() + " Added Event " + e1.getEventType());

		e1 = new EventPost("user 5", EventType.LIKE);
		p.addEventPost(e1);
		System.out.println(e1.getUsername() + " Added Event " + e1.getEventType());

		e1 = new EventPost("user 6", EventType.UNLIKE);
		p.addEventPost(e1);
		System.out.println(e1.getUsername() + " Added Event " + e1.getEventType());

		e1 = new EventPost("user 7", "custom event");
		p.addEventPost(e1);
		System.out.println(e1.getUsername() + " Added Event " + e1.getEventType());

		System.out.println("-----------------------------");
		System.out.println("Done adding 5 New Events");
		System.out.println("-----------------------------");

		System.out.println("Displaying all posts After 5 seconds");
		try { Thread.sleep(5000); } catch (InterruptedException e) { e.printStackTrace(); }
		p.displayCommentedPosts();
		p.displayEventPosts();

		System.out.println("Displaying all posts After 1 minute 4 seconds");
		try { Thread.sleep(64000); } catch (InterruptedException e) { e.printStackTrace(); }
		p.displayCommentedPosts();
		p.displayEventPosts();
	}
}

import java.util.*;

/**
 * Class to handle all PhotoPosts
 *
 * @author Nikhita Kataria
 * @version 1.0
 */
public class PhotoPost extends CommentedPost {
	private String filename;
	private String caption;

        /**
         * Constructor for objects of class PhotoPost
         *
         * @param author Username for the PhotoPost
         * @param fileName File name for the photo
         */
	public PhotoPost (String author, String fileName) {
		super(author);
		if (fileName != null) {
			filename = fileName;
		} else {
			// If file name is null throw an exception
			System.out.println("Message is empty");
			throw new NullPointerException();
		}
	}

        /**
         * Method for setting filename for the PhotoPost
         *
         * @param fileName Filename for the PhotoPost
         */
	public void setFileName (String fileName) {
		if (fileName != null) {
			filename = fileName;
		} else {
			// If file name is null throw an exception
			System.out.println("Message is empty");
			throw new NullPointerException();
		}
	}

        /**
         * Method for getting filename for the PhotoPost
         *
         * @return Filename for the PhotoPost
         */
	public String getFileName () {
		return filename;
	}

        /**
         * Method for setting caption for the PhotoPost
         *
         * @param fileCaption Caption for the PhotoPost
         */
	public void addCaption(String fileCaption) {
		caption = fileCaption;
	}

        /**
         * Method for getting caption for the PhotoPost
         *
         * @return Caption for the PhotoPost
         */
	public String getCaption () {
		return caption;
	}

        /**
         * Method for displaying metadata for the PhotoPost
         */
	public void display() {
		// Display metadata for PhotoPost
		System.out.print("User " + getUsername() + " posted file " + filename + " with caption " + caption + " ");
		getTimelapsed();
		displayLikesComments();
	}

        /**
         * Abstract method implemented by PhotoPost
         * @return CommentedPost Instance
         */
        public CommentedPost cloneCommentedPost() {
                return clonePhotoPost();
        }

        /**
         * Method for cloning PhotoPost
         * @return Instance of PhotoPost
         */
	public PhotoPost clonePhotoPost() {
		PhotoPost obj = new PhotoPost(getUsername(), filename);
		obj.filename = new String(filename);
		obj.caption = new String(caption);
		obj.setLikes(getLikes());
		// Clone all the comments
		ArrayList<String> commentList = getComments();
                for(String c : commentList) {
                       obj.addComment(new String(c));
                }
		return obj;
	}

        /**
         * Method for comparing PhotoPost instances
         */
	public Boolean equalsPhotoPost(PhotoPost obj) {
		if(obj.filename.equals(filename) && obj.caption.equals(caption) && obj.getUsername().equals(getUsername())) {
			return true;
		} else {
			return false;
		}
	}
}

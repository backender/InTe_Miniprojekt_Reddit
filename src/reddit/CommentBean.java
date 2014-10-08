package reddit;

import java.util.Date;

public class CommentBean {

	private PostBean post;
	private UserBean user;
	private String text;
	private int upvotes;
	private int downvotes;
	private Date createdAt;
	public PostBean getPost() {
		return post;
	}
	public void setPost(PostBean post) {
		this.post = post;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getUpvotes() {
		return upvotes;
	}
	public void setUpvotes(int upvotes) {
		this.upvotes = upvotes;
	}
	public int getDownvotes() {
		return downvotes;
	}
	public void setDownvotes(int downvotes) {
		this.downvotes = downvotes;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
}

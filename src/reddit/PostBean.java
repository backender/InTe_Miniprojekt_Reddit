package reddit;

import java.util.Date;
import java.util.Hashtable;
import java.util.List;

public class PostBean {
	public Hashtable<String, PostBean>  posts = new Hashtable<String, PostBean>();
	
	private UserBean user;
	private String title;
	private String url;
	private int votes;
	private Date createdAt;
	
	public String post(){
		this.posts.put(getTitle(), this);
		return getTitle() + " posted!";
	}
	
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int upvote() {
		return votes++;
	}
	public int downvote() {
		return votes--;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public List<CommentBean> getComments() {
		return comments;
	}
	public void setComments(List<CommentBean> comments) {
		this.comments = comments;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	private List<CommentBean> comments;
}

package reddit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.context.FacesContext;

public class CommentBean {

//	private PostBean post;
	private UserBean user;
	private String text;
	private int upVotes = 0;
	private int downVotes = 0;
	private Date createdAt = new Date();
	
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
	public int getUpVotes(){
		return upVotes;
	}
	public int getDownVotes(){
		return downVotes;
	}
	public void upvote() {
		upVotes++;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
			.redirect("index.xhtml");
		} catch (IOException e) {}
	}
	public void downvote() {
		downVotes++;
		try {
			FacesContext.getCurrentInstance().getExternalContext()
			.redirect("index.xhtml");
		} catch (IOException e) {}
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
}

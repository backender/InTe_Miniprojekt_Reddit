package reddit;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

public class CommentBean {

//	private PostBean post;
	private UserBean user;
	private String text;
	private int upVotes = 0;
	private int downVotes = 0;
	private Date createdAt = new Date();
	
	public class CommentComparator implements Comparator<CommentBean> {
		@Override
	    public int compare(CommentBean o1, CommentBean o2) {
			if(o1.getUpVotes()-o1.getDownVotes() < o2.getUpVotes()-o2.getDownVotes()){
				return 1;
			} else if (o1.getUpVotes()-o1.getDownVotes() > o2.getUpVotes()-o2.getDownVotes()) {
				return -1;
			} else {
				return 0;
			}
	    }
	}
	
	public void sortComments(List<CommentBean> comments){
		Collections.sort(comments, new CommentComparator());
	}
	
	public UserBean getUser() {
		return user;
	}
	public String getUserString(){
		return user.getUsername();
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
	public void upvote(PostBean post) {
		upVotes++;
		sortComments(post.getComments());
		try {
			FacesContext.getCurrentInstance().getExternalContext()
			.redirect("index.xhtml");
		} catch (IOException e) {}
	}
	public void downvote(PostBean post) {
		downVotes++;
		sortComments(post.getComments());
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
	public String getCreatedAgo() throws ParseException{
		return new Timer().getTimeDiff(createdAt);
	}
	
}

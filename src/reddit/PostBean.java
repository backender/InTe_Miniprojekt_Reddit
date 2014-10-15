package reddit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;

public class PostBean {	
	private UserBean user;
	private String title;
	private String url;
	private int upVotes = 0;
	private int downVotes = 0;
	private Date createdAt = new Date();
	private int comments = 0;
	private FacesContext context = FacesContext.getCurrentInstance();
	
	
	public String post(){
		ArrayList<PostBean> postList = context.getApplication().evaluateExpressionGet(context, "#{postListBean}", ArrayList.class);
		postList.add(this);
		System.out.println(getTitle() + " posted!");
		for(int i = 0; i < postList.size(); i++){
			System.out.println(postList.get(i).getTitle());
		}
		return "index.xhtml";
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
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}
	
	public void addComment(){
		comments++;
	}
	
}

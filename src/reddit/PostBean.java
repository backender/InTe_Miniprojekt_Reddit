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
	private FacesContext context = FacesContext.getCurrentInstance();
	private List<CommentBean> comments = new ArrayList<CommentBean>();
	ArrayList<PostBean> postList = context.getApplication().evaluateExpressionGet(context, "#{postListBean}", ArrayList.class);

	public String post(){
		postList.add(this);
		System.out.println(getTitle() + " posted!");
		for(int i = 0; i < postList.size(); i++){
			System.out.println(postList.get(i).getTitle());
		}
		return "index.xhtml";
	}
	
	public void comment(CommentBean c){
		System.out.println(c);
		System.out.println(c.getText());
		//c.setUser();
		comments.add(c);
		
		/*System.out.println(getText() + " posted!");
		for(int i = 0; i < commentList.size(); i++){
			System.out.println(commentList.get(i).getText());
		}*/
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

	public List<CommentBean> getComments() {
		return comments;
	}

	public void setComments(List<CommentBean> comments) {
		this.comments = comments;
	}

	public boolean addComment(CommentBean comment){
		return comments.add(comment);
	}
	
	public int getCountComments(){
		return comments.size();
	}
	
}

package reddit;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.print.attribute.standard.DateTimeAtCompleted;


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

	public class PostComparator implements Comparator<PostBean> {
		@Override
	    public int compare(PostBean o1, PostBean o2) {
			if(o1.getUpVotes()-o1.getDownVotes() < o2.getUpVotes()-o2.getDownVotes()){
				return 1;
			} else if (o1.getUpVotes()-o1.getDownVotes() > o2.getUpVotes()-o2.getDownVotes()) {
				return -1;
			} else {
				return 0;
			}
	    }
	}
	
	public String post(){
		UserBean user = context.getApplication().evaluateExpressionGet(context, "#{userBean}", UserBean.class);
		setUser(user);
		postList.add(this);
		System.out.println(getTitle() + " posted!");
		for(int i = 0; i < postList.size(); i++){
			System.out.println(postList.get(i).getTitle());
		}
		return "index.xhtml";
	}
	
	public void sortPosts(){
		Collections.sort(postList, new PostComparator());
	}
	
	public void comment(CommentBean c){
		System.out.println(c);
		System.out.println(c.getText());
		//TODO: set user for comment
		//UserBean user = context.getApplication().evaluateExpressionGet(context, "#{userBean}", UserBean.class);
		//newUser.setUsername(user.getUsername());
		//c.setUser(newUser);
		comments.add(c);
		
		/*System.out.println(getText() + " posted!");
		for(int i = 0; i < commentList.size(); i++){
			System.out.println(commentList.get(i).getText());
		}*/
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
	public int getVotes(){
		return upVotes-downVotes;
	}
	public void upvote() {
		upVotes++;
		sortPosts();
	}
	public void downvote() {
		downVotes++;
		sortPosts();
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

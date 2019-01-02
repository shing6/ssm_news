package com.weihaicheng.po;

public class Comment {
    private Integer commentId;
    private String commentText;
    private Integer assit;
    private Integer userId;
    private Integer itemID;
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public Integer getAssit() {
		return assit;
	}
	public void setAssit(Integer assit) {
		this.assit = assit;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getItemID() {
		return itemID;
	}
	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}
    
}

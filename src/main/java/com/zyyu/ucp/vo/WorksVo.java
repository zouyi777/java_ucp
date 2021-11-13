package com.zyyu.ucp.vo;


public class WorksVo extends BaseVo{

	private Long worksId;
	private String content;
	private String quote;
	private Long userId;
	private Long commentId;

	public Long getWorksId() {
		return worksId;
	}

	public void setWorksId(Long worksId) {
		this.worksId = worksId;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

}

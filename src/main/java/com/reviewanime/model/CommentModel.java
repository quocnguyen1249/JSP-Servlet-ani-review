package com.reviewanime.model;

public class CommentModel extends AbstractModel<CommentModel>{
	private String content;
	private Long userId;
	private Long animeId;
	private String userFullName;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getAnimeId() {
		return animeId;
	}
	public void setAnimeId(Long animeId) {
		this.animeId = animeId;
	}
	public String getUserFullName() {
		return userFullName;
	}
	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}
}

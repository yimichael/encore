package com.encore.model;

public class BookDTO {
	private String title;
	private String author;
	private String publisher;
	public BookDTO() {
		System.out.println("BookDTO 기본 생성자");
	}
	
	public BookDTO(String title, String author, String publisher) {
		super();
		this.title = title;
		this.author = author;
		this.publisher = publisher;
	}

	public String getTitle() {
		System.out.println("getTitle:"+title);
		return title;
	}

	public void setTitle(String title) {
		System.out.println("setTitle:"+title);
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "BookDTO [title=" + title + ", author=" + author + ", publisher=" + publisher + ", getTitle()="
				+ getTitle() + ", getAuthor()=" + getAuthor() + ", getPublisher()=" + getPublisher() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
}

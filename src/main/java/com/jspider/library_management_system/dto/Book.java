package com.jspider.library_management_system.dto;

import java.util.Objects;

public class Book {

	    private int id;
	    private String title;
	    private String author;
	    private String isbn;
	    private String category;
	    private int totalCopies;
	    private int availableCopies;
		
	    public Book() {}

		public Book(int id, String title, String author, String isbn, String category, int totalCopies,
				int availableCopies) {
	
			this.id = id;
			this.title = title;
			this.author = author;
			this.isbn = isbn;
			this.category = category;
			this.totalCopies = totalCopies;
			this.availableCopies = availableCopies;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public int getTotalCopies() {
			return totalCopies;
		}

		public void setTotalCopies(int totalCopies) {
			this.totalCopies = totalCopies;
		}

		public int getAvailableCopies() {
			return availableCopies;
		}

		public void setAvailableCopies(int availableCopies) {
			this.availableCopies = availableCopies;
		}
	    
		@Override
		public String toString() {
			return "Book [Id=" + id + " , Title=" + title + " , Author=" + author + " , ISBN=" + isbn + " , Category=" + category
					+ " , Total_Copies=" + totalCopies + " , Available_Copies=" + availableCopies + "]";
		}
	    
		@Override
		public int hashCode() {
			return Objects.hash(id,title,author,category,isbn,totalCopies,availableCopies);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			return Objects.equals(title, other.title) && id==other.id && Objects.equals(category, other.category)
					&& Objects.equals(author, other.author) && totalCopies==other.totalCopies && availableCopies==other.availableCopies
					&& Objects.equals(isbn, other.isbn);
		}
		
		
}

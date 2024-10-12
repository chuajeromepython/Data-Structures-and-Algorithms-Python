package Library;

import java.util.HashMap;
import java.util.ArrayList;

class Book {
	String title;
	String author;
	int page;
	HashMap<String, String> finished = new HashMap<String, String>();
	HashMap<String, Integer> unfinished = new HashMap<String, Integer>();
	ArrayList<String> allBooks = new ArrayList<String>();
	
	Book(String t, String a){
		this.title = t;
		this.author = a;
	}
	Book(String t, int p){
		this.title = t;
		this.page = p;
	}
	void addToLibrary(){
		if (author != null){
			finished.put(this.title, this.author);
		} else {
			unfinished.put(this.title, this.page);
		}
		allBooks.add(this.title);
	}
}
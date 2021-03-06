package ch11;

public interface BookService {
	
	// 북 객체를 저장하는 기능
	void addBook(Book book);
	
	// 북 객체를 수정하는 기능
	void updateBook(String title, Book book);
	
	// 북 객체 삭제 기능
	void deleteBook(String title);
	
	// 책 한권의 정보를 출력하는 기능
	void selectedByTitleBook(String title);
	
	// Array에 저장되어있는 책 정보를 전부 출력
	void showAllBook();

}

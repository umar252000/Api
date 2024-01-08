package com.restapi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;

import org.springframework.stereotype.Component;

import entity.Book;

@Component
public class BookService {

  private static List<Book> list=new ArrayList<>();
     
  static {
	  list.add(new Book(1,"leo","umar"));
	  list.add(new Book(2,"leoleo","irfan"));
	  list.add(new Book(3,"leoleo","amjhad"));
  }
  
  	public List<Book> findAll()
  	{
  		return list;
  	}
  	
  	public Book findbyId(int id)
  	{
  		Book book=null;
  		Iterator<Book> iterator = list.iterator();
  		while(iterator.hasNext())
  		{
  			 book=iterator.next();
  			if(id==book.getId())
  			{
  				System.out.println(book);
  			}
  			
  			
  		}
  		
  			return book;
  	}
  	
  	public Book Delete(int id)
  	{
  		Book book=null;
  		Iterator<Book> iterator = list.iterator();
  		while(iterator.hasNext())
  		{
  			 book=iterator.next();
  			if(id==book.getId())
  			{
  				iterator.remove();
  			}
  		}
  		return book;
  	}
  	
  	public Book insert(Book book)
  	{
  		 list.add(book);
  		 return book;
  	}
  	
  	
  	
  	public void update(Book book,int id)
  	{
  		Book book1=null;
  		ListIterator<Book> iterator = list.listIterator();
  		while(iterator.hasNext())
  		{
  			book1=iterator.next();
  			if(book1.getId()==id)
  			{
  				iterator.set(book);
  			}
  			
  		}
  		
  	}
  	
}

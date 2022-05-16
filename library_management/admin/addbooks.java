package admin;
public class addbooks 
{
    Object category_name;
    String book_title;
    String book_author;
    int rating;
    int bookquantity;
    int totalquantity;
    int quantity;

 public addbooks(Object category_name,String book_title,String book_author,int rating,int bookquantity,int totalquantity,int quantity)
{
    this.category_name =  category_name;
    this.book_title = book_title;
    this.book_author = book_author;
    this.rating=rating;
    this.bookquantity= bookquantity;
    this.totalquantity=totalquantity;
    this.quantity=quantity;
}
public Object getcategoryName()
{
    return category_name;
}
public String getbookTitle()
{
    return book_title;
}
public String getbookAuthor()
{
    return book_author;
}
public int getrating()
{
    return rating;
}
public int getbookquantity()
{
    return bookquantity;
}
public int gettotalquantity()
{
    return totalquantity;
}
public int getquantity()
{
    return quantity;
}
public String toString()
{ 
return "catergory: "+category_name+" "+ "Title: "+book_title+" "+"Author: "+book_author+" "+"initial quantity: "+bookquantity
+" "+"totalquantity: "+totalquantity+" "+"quantity: "+quantity;
}    
}
    
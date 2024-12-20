package com.book.web;

import com.book.domain.Book;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class BookController {
    // 注入BookService
    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    // 查询图书
    @RequestMapping("/querybook.html")
    public ModelAndView queryBookDo(HttpServletRequest request,String searchWord){
        // 判断是否存在匹配的图书
        boolean exist=bookService.matchBook(searchWord);
        if (exist){
            // 查询匹配的图书
            ArrayList<Book> books = bookService.queryBook(searchWord);
            ModelAndView modelAndView = new ModelAndView("admin_books");
            modelAndView.addObject("books",books);
            return modelAndView;
        }
        else{
            // 如果没有匹配的图书，返回错误信息
            return new ModelAndView("admin_books","error","没有匹配的图书");
        }
    }
    // 读者查询图书
    @RequestMapping("/reader_querybook.html")
    public ModelAndView readerQueryBook(){
       return new ModelAndView("reader_book_query");

    }
    // 读者查询图书处理
    @RequestMapping("/reader_querybook_do.html")
    public String readerQueryBookDo(HttpServletRequest request,String searchWord,RedirectAttributes redirectAttributes){
        // 判断是否存在匹配的图书
        boolean exist=bookService.matchBook(searchWord);
        if (exist){
            // 查询匹配的图书
            ArrayList<Book> books = bookService.queryBook(searchWord);
            // 将查询结果添加到重定向属性中
            redirectAttributes.addFlashAttribute("books", books);
            return "redirect:/reader_querybook.html";
        }
        else{
            // 如果没有匹配的图书，返回错误信息
            redirectAttributes.addFlashAttribute("error", "没有匹配的图书！");
            return "redirect:/reader_querybook.html";
        }

    }

    // 查询所有图书
    @RequestMapping("/allbooks.html")
    public ModelAndView allBook(){
        ArrayList<Book> books=bookService.getAllBooks();
        ModelAndView modelAndView=new ModelAndView("admin_books");
        modelAndView.addObject("books",books);
        return modelAndView;
    }
    // 删除图书
    @RequestMapping("/deletebook.html")
    public String deleteBook(HttpServletRequest request,RedirectAttributes redirectAttributes){
        // 获取图书ID
        long bookId=Integer.parseInt(request.getParameter("bookId"));
        // 删除图书
        int res=bookService.deleteBook(bookId);

        if (res==1){
            // 删除成功，返回成功信息
            redirectAttributes.addFlashAttribute("succ", "图书删除成功！");
            return "redirect:/allbooks.html";
        }else {
            // 删除失败，返回错误信息
            redirectAttributes.addFlashAttribute("error", "图书删除失败！");
            return "redirect:/allbooks.html";
        }
    }

    // 添加图书
    @RequestMapping("/book_add.html")
    public ModelAndView addBook(HttpServletRequest request){

            return new ModelAndView("admin_book_add");

    }

    // 添加图书处理
    @RequestMapping("/book_add_do.html")
    public String addBookDo(BookAddCommand bookAddCommand,RedirectAttributes redirectAttributes){
        // 创建图书对象
        Book book=new Book();
        book.setBookId(0);
        book.setPrice(bookAddCommand.getPrice());
        book.setState(bookAddCommand.getState());
        book.setPublish(bookAddCommand.getPublish());
        book.setPubdate(bookAddCommand.getPubdate());
        book.setName(bookAddCommand.getName());
        book.setIsbn(bookAddCommand.getIsbn());
        book.setClassId(bookAddCommand.getClassId());
        book.setAuthor(bookAddCommand.getAuthor());
        book.setIntroduction(bookAddCommand.getIntroduction());
        book.setPressmark(bookAddCommand.getPressmark());
        book.setLanguage(bookAddCommand.getLanguage());


        // 添加图书
        boolean succ=bookService.addBook(book);
        // 获取所有图书
        ArrayList<Book> books=bookService.getAllBooks();
        if (succ){
            // 添加成功，返回成功信息
            redirectAttributes.addFlashAttribute("succ", "图书添加成功！");
            return "redirect:/allbooks.html";
        }
        else {
            // 添加失败，返回错误信息
            redirectAttributes.addFlashAttribute("succ", "图书添加失败！");
            return "redirect:/allbooks.html";
        }
    }

    // 编辑图书
    @RequestMapping("/updatebook.html")
    public ModelAndView bookEdit(HttpServletRequest request){
        // 获取图书ID
        long bookId=Integer.parseInt(request.getParameter("bookId"));
        // 获取图书详情
        Book book=bookService.getBook(bookId);
        ModelAndView modelAndView=new ModelAndView("admin_book_edit");
        modelAndView.addObject("detail",book);
        return modelAndView;
    }

    // 编辑图书处理
    @RequestMapping("/book_edit_do.html")
    public String bookEditDo(HttpServletRequest request,BookAddCommand bookAddCommand,RedirectAttributes redirectAttributes){
        // 获取图书ID
        long bookId=Integer.parseInt( request.getParameter("id"));
        // 创建图书对象
        Book book=new Book();
        book.setBookId(bookId);
        book.setPrice(bookAddCommand.getPrice());
        book.setState(bookAddCommand.getState());
        book.setPublish(bookAddCommand.getPublish());
        book.setPubdate(bookAddCommand.getPubdate());
        book.setName(bookAddCommand.getName());
        book.setIsbn(bookAddCommand.getIsbn());
        book.setClassId(bookAddCommand.getClassId());
        book.setAuthor(bookAddCommand.getAuthor());
        book.setIntroduction(bookAddCommand.getIntroduction());
        book.setPressmark(bookAddCommand.getPressmark());
        book.setLanguage(bookAddCommand.getLanguage());


        // 编辑图书
        boolean succ=bookService.editBook(book);
        if (succ){
            // 编辑成功，返回成功信息
            redirectAttributes.addFlashAttribute("succ", "图书修改成功！");
            return "redirect:/allbooks.html";
        }
        else {
            // 编辑失败，返回错误信息
            redirectAttributes.addFlashAttribute("error", "图书修改失败！");
            return "redirect:/allbooks.html";
        }
    }


    // 图书详情
    @RequestMapping("/bookdetail.html")
    public ModelAndView bookDetail(HttpServletRequest request){
        // 获取图书ID
        long bookId=Integer.parseInt(request.getParameter("bookId"));
        // 获取图书详情
        Book book=bookService.getBook(bookId);
        ModelAndView modelAndView=new ModelAndView("admin_book_detail");
        modelAndView.addObject("detail",book);
        return modelAndView;
    }



    // 读者图书详情
    @RequestMapping("/readerbookdetail.html")
    public ModelAndView readerBookDetail(HttpServletRequest request){
        // 获取图书ID
        long bookId=Integer.parseInt(request.getParameter("bookId"));
        // 获取图书详情
        Book book=bookService.getBook(bookId);
        ModelAndView modelAndView=new ModelAndView("reader_book_detail");
        modelAndView.addObject("detail",book);
        return modelAndView;
    }



}

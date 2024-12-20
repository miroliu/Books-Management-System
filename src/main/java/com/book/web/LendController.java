package com.book.web;

import com.book.domain.Book;
import com.book.domain.ReaderCard;
import com.book.service.BookService;
import com.book.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LendController {

    // 注入LendService
    private LendService lendService;
    @Autowired
    public void setLendService(LendService lendService) {
        this.lendService = lendService;
    }
    // 注入BookService
    private BookService bookService;
    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    // 处理借书请求
    @RequestMapping("/lendbook.html")
    public ModelAndView bookLend(HttpServletRequest request){
        // 获取请求中的bookId
        long bookId=Integer.parseInt(request.getParameter("bookId"));
        // 根据bookId获取Book对象
        Book book=bookService.getBook(bookId);
       // 返回ModelAndView对象，视图名为admin_book_lend，并将book对象添加到ModelAndView中
       ModelAndView modelAndView=new ModelAndView("admin_book_lend");
       modelAndView.addObject("book",book);
       return modelAndView;
    }

    // 处理借书操作
    @RequestMapping("/lendbookdo.html")
    public String bookLendDo(HttpServletRequest request,RedirectAttributes redirectAttributes,int readerId){
        // 获取请求中的bookId
        long bookId=Integer.parseInt(request.getParameter("id"));
        // 调用bookLend方法进行借书操作
        boolean lendsucc=lendService.bookLend(bookId,readerId);
        // 如果借书成功，重定向到allbooks.html，并添加succ属性
        if (lendsucc){
            redirectAttributes.addFlashAttribute("succ", "图书借阅成功！");
            return "redirect:/allbooks.html";
        }else {
            // 如果借书失败，重定向到allbooks.html，并添加succ属性
            redirectAttributes.addFlashAttribute("succ", "图书借阅成功！");
            return "redirect:/allbooks.html";
        }


    }

    // 处理还书请求
    @RequestMapping("/returnbook.html")
    public String bookReturn(HttpServletRequest request,RedirectAttributes redirectAttributes){
        // 获取请求中的bookId
        long bookId=Integer.parseInt(request.getParameter("bookId"));
        // 调用bookReturn方法进行还书操作
        boolean retSucc=lendService.bookReturn(bookId);
        // 如果还书成功，重定向到allbooks.html，并添加succ属性
        if (retSucc){
            redirectAttributes.addFlashAttribute("succ", "图书归还成功！");
            return "redirect:/allbooks.html";
        }
        // 如果还书失败，重定向到allbooks.html，并添加error属性
        else {
            redirectAttributes.addFlashAttribute("error", "图书归还失败！");
            return "redirect:/allbooks.html";
        }
    }


    // 处理借书列表请求
    @RequestMapping("/lendlist.html")
    public ModelAndView lendList(){

        // 返回ModelAndView对象，视图名为admin_lend_list，并将lendList方法返回的列表添加到ModelAndView中
        ModelAndView modelAndView=new ModelAndView("admin_lend_list");
        modelAndView.addObject("list",lendService.lendList());
        return modelAndView;
    }
    // 处理我的借书列表请求
    @RequestMapping("/mylend.html")
    public ModelAndView myLend(HttpServletRequest request){
        // 从session中获取ReaderCard对象
        ReaderCard readerCard=(ReaderCard) request.getSession().getAttribute("readercard");
        // 返回ModelAndView对象，视图名为reader_lend_list，并将myLendList方法返回的列表添加到ModelAndView中
        ModelAndView modelAndView=new ModelAndView("reader_lend_list");
        modelAndView.addObject("list",lendService.myLendList(readerCard.getReaderId()));
        return modelAndView;
    }




}

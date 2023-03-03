package com.kuang.controller;

import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
import java.util.List;

/**
 * @Author LYL
 * @create 2021/7/13 20:04
 */
@Controller
@RequestMapping("/book")
public class BookController {
    //controller 调用 service 层
    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    //查询全部的书籍。并且返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model){
        List<Books> books = bookService.queryAllBook();
        model.addAttribute("list",books);
        return "allBook";
    }
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books){
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";//重定向我们的@RequestMapping("/allBook")请求，请求复用
    }


    @RequestMapping("/toUpdate")
    //跳转到修改页面
    public String updatePaper(int id, Model model){
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBooks",books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String upDateBook(Books books,Model model){
        System.out.println(books);
        bookService.updateBook(books);
        Books books1 = bookService.queryBookById(books.getBookId());
        model.addAttribute("books",books1);
        return "redirect:/book/allBook";
    }
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        System.out.println(id);
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

}

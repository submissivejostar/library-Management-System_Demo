package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.utils.R;
import com.itheima.domain.Book;
import com.itheima.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private IBookService bookService;
    @GetMapping
    public R getAll()  {return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book){
//        R r = new R();
//        boolean flag = bookService.save(book);
//        r.setFlag(flag);
        return new R(bookService.save(book));

    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.delete(id));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
       return new R(true,bookService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize){
        return new R(true,bookService.getPage(currentPage,pageSize));
    }
}

package com.xiaofang.service;

import com.xiaofang.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    //没有bookDao2名称的bean报错,同时指定@Qualifier和@Primary,@Qualifier的优先级高
    //@Qualifier("bookDao2")
    // @Autowired//(required = false) //默认必须有这个bean
    //@Resource
    //@Inject
    BookDao bookDao;

    //只有一个构造器时,可以省略
    //@Autowired
    public BookService(@Autowired BookDao bookDao) {
        this.bookDao = bookDao;
    }

    //@Autowired
    public void setBookDao(/**@Autowired 错误不能注入*/BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public String toString() {
        return "BookService{" +
                "bookDao=" + bookDao.getLabel() +
                '}';
    }
}

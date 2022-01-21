package com.xiaofang.dao;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {

    private String label = "label1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}

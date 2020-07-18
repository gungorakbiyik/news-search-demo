package com.gun.newssearch.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class News {

    private long id;
    private String url;
    private String name;
    private String title;
    private String description;
    private String content;
    private String type;
    private String lang;
    private List<String> tags;
    private List<String> categories;

    // crawl_date olarak json'da geliyor
    private Date crawlDate;

    private Date modifiedDate;
    private Date publishedDate;


}

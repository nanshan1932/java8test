package com.wsai.coolblog.dao;

import com.wsai.coolblog.model.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangsai
 * @data 2019/5/10
 */
public interface ArticleMapper {
    List<Article> findByAuthorAndCreateTime(@Param("author") String author, @Param("addTime") String addTime);
}

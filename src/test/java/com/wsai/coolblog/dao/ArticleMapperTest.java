package com.wsai.coolblog.dao;

import com.wsai.coolblog.model.Article;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author wangsai
 * @data 2019/5/10
 */
public class ArticleMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testMyBatis() throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleMapper articleMapper = session.getMapper(ArticleMapper.class);
            List<Article> articles = articleMapper.findByAuthorAndCreateTime("zhangsan", "2019-05-10");
        } finally {
            session.commit();
            session.close();
        }
    }
}
package com.xuecheng.manage_cms;

import com.xuecheng.framework.domain.cms.CmsPage;
import com.xuecheng.manage_cms.dao.CmsPageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

/**
 * test测试类
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    CmsPageRepository cmsPageRepository;

    //查询
    @Test
    public void testFindAll (){
        /*List<CmsPage> list = cmsPageRepository.findAll();

        System.out.println(list);*/
        int page = 1;
        int size = 10;
        Pageable pageable = PageRequest.of(page,size);
        Page<CmsPage> list = cmsPageRepository.findAll(pageable);
        System.out.println(list);
    }

    @Test
    public void testFindAllByExample(){
        int page =0;
        int pageSize=10;
        Pageable pageable = PageRequest.of(page,pageSize);

        //条件匹配器
        ExampleMatcher exampleMatcher = ExampleMatcher.matching();
        //模糊查询
        //exampleMatcher = exampleMatcher.withMatcher("pageAliase",ExampleMatcher.GenericPropertyMatchers.contains());
        exampleMatcher = exampleMatcher.withMatcher("pageAliase",ExampleMatcher.GenericPropertyMatchers.startsWith());
        //cmspage对象作为条件本身
        CmsPage cmsPage = new CmsPage();
        //精确查询
        cmsPage.setPageAliase("轮播");

        //设置条件
        Example<CmsPage> example =Example.of(cmsPage,exampleMatcher);

        Page<CmsPage> list = cmsPageRepository.findAll(example,pageable);
        System.out.println(list.getContent());
    }

    //修改
    @Test
    public void testUpate(){

        Optional<CmsPage> optional = cmsPageRepository.findById("5abefd525b05aa293098fca6");
        if (optional.isPresent()){
            CmsPage cmsPage = optional.get();
            cmsPage.setPageAliase("bbb");
            CmsPage save = cmsPageRepository.save(cmsPage);
            System.out.println(save);
        }
    }

    @Test
    public void testFindPageName(){
        CmsPage cms = cmsPageRepository.findByPageName("index2.html");
        System.out.println(cms);


    }


}

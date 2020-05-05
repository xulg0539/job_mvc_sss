package com.lagou.edu.controller;

import com.lagou.edu.pojo.Resume;
import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class ResumeController {

    /**
     * Spring容器和SpringMVC容器是有层次的（父子容器）
     * Spring容器：service对象+dao对象
     * SpringMVC容器：controller对象，，，，可以引用到Spring容器中的对象
     */


    @Autowired
    private ResumeService resumeService;

    @RequestMapping("/list")
    public ModelAndView  queryAll() throws Exception {
        System.out.println("controller调用service查询了");
        ModelAndView mv=new ModelAndView();
        List<Resume> datas=resumeService.queryAll();
        System.out.println("查询到数据："+datas.size());
        mv.addObject("datas",datas);
        mv.setViewName("list");
        return mv;
    }


    @RequestMapping("/delById")
    public ModelAndView  delById(String  id) throws Exception {
        System.out.println("controller调用service删除了");
        ModelAndView mv=new ModelAndView();
        resumeService.delById(Long.parseLong(id));
        System.out.println("成功删除数据");
        List<Resume> datas=resumeService.queryAll();
        System.out.println("查询到数据："+datas.size());
        mv.addObject("datas",datas);
        mv.setViewName("list");
        return mv;
    }

    @RequestMapping("/opt")
    public ModelAndView  opt(String  id) throws Exception {
        ModelAndView mv=new ModelAndView();
        Resume item=null;
        if (id==null)
        {
            item=new Resume();
        }
        else {
           item=resumeService.findById(Long.parseLong(id));
           if (item==null)
            {
                item=new Resume();
            }
        }
        mv.addObject("item",item);
        mv.setViewName("edit");
        return mv;
    }



    @RequestMapping("/opts")
    public ModelAndView  opts(Resume resume) throws Exception {
        ModelAndView mv=new ModelAndView();
        resumeService.save(resume);
        List<Resume> datas=resumeService.queryAll();
        System.out.println("查询到数据："+datas.size());
        mv.addObject("datas",datas);
        mv.setViewName("list");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(String username, String password, HttpSession session) throws Exception {
        System.out.println("controller调用service查询了");
        ModelAndView mv=new ModelAndView();
        if("admin".equals(username)&&"admin".equals(password))
        {
            session.setAttribute("username","username");
            List<Resume> datas= resumeService.queryAll();
            mv.addObject("datas",datas);
            mv.setViewName("list");
        }
        else {
            mv.setViewName("index");
        }
        return mv;

    }

}

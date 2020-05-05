package com.lagou.edu.service.impl;

import com.lagou.edu.dao.ResumeDao;
import com.lagou.edu.pojo.Resume;
import com.lagou.edu.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    @Override
    public List<Resume> queryAll() throws Exception {
        System.out.println("sercice层调用dao查询了");
        return resumeDao.findAll();
    }

    @Override
    public void delById(Long id) throws Exception {
        System.out.println("service 调用dao 删除了");
        resumeDao.deleteById(id);
    }

    @Override
    public Resume findById(Long id) throws Exception {
        System.out.println("service 调用dao 根据id查询指定数据了");
         Optional<Resume>  oresume=resumeDao.findById(id);
         return oresume.get();
    }

    @Override
    public Resume save(Resume resume) throws Exception {
        return resumeDao.save(resume);
    }
}

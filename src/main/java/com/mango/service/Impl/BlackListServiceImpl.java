package com.mango.service.Impl;

import com.mango.constant.WebConstant;
import com.mango.dao.BlackListDao;
import com.mango.pojo.BlackList;
import com.mango.pojo.Student;
import com.mango.service.BlackListService;
import com.mango.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 这里主要是用来操作dao层数据的
 * 你看下面的代码 blackListDao.addStudentBlackList
 * 这就是用来操作dao层行为的，处理逻辑用的，这里声明逻辑
 */
@Service
public class BlackListServiceImpl implements BlackListService {

    @Autowired
    BlackListDao blackListDao;



    @Override
    public void addStudentBlackList(BlackList blackList) {
        blackListDao.addStudentBlackList(blackList);
    }

    @Override
    public List<Student> getAllBlackedStudent() {
        return blackListDao.getAllBlackedStudent();
    }

    @Override
    public void deleteStudentBlackList(String s_id) {
        blackListDao.deleteStudentBlackList(s_id);
    }

    @Override
    public BlackList getBlackedStudentById(String s_id) {
        return blackListDao.getBlackedStudentById(s_id);
    }
}

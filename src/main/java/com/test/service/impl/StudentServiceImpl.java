package com.test.service.impl;

import com.test.entity.Student;
import com.test.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 学生
 *
 * @author huangfu
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public Student findOneStudent(Integer id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Student(1,"张三","计算机网络",new Date());
    }
}

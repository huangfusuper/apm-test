package com.test.service;

import com.test.entity.Student;

/**
 * @author huangfu
 */
public interface StudentService {

    /**
     * 查找单个学生
     * @param id 主键
     * @return 学生
     */
    Student findOneStudent(Integer id);
}

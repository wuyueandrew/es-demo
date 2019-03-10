package com.cn.test.service;

import com.cn.test.bean.User;

public interface UserService {

    void add(User user);

    void remove(String userId);

    void edit(User user);

    User query(String userId);

}

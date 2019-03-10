package com.cn.test.service.impl;

import com.cn.test.bean.User;
import com.cn.test.service.UserService;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Delete;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import io.searchbox.core.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private JestClient jestClient;

    @Override
    public void add(User user) {
        Index index = new Index.Builder(user).index("test").type("user").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {

        }
    }

    @Override
    public void remove(String userId) {
        try {
            jestClient.execute(new Delete.Builder(userId)
                    .index("test")
                    .type("user")
                    .build());
        } catch (IOException e) {

        }

    }

    @Override
    public void edit(User user) {
        try {
            jestClient.execute(new Update.Builder(user).index("test").type("user").id(user.getId()).build());
        } catch (IOException e) {

        }
    }

    @Override
    public User query(String userId) {
        User user = null;
        Get get = new Get.Builder("test", userId).type("user").build();
        try {
            JestResult result = jestClient.execute(get);
            user = result.getSourceAsObject(User.class);
        } catch (IOException e) {

        }
        return user;
    }

}

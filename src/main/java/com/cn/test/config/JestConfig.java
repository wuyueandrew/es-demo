package com.cn.test.config;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JestConfig {

    @Bean
    @Scope("singleton")
    public JestClient client() {
        JestClientFactory factory = new JestClientFactory();
        factory.setHttpClientConfig(new HttpClientConfig
                .Builder("")
                .defaultCredentials("elastic", "")
                .multiThreaded(true)
                .connTimeout(100000) //连接超时
                .readTimeout(100000) //由于是基于http，所以超时时间必不可少，不然经常会遇到socket异常：read time out
                .build());

        JestClient client = factory.getObject();
        return client;
    }

}

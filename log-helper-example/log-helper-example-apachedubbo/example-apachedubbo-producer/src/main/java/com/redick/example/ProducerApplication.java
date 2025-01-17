/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.redick.example;

import com.redick.starter.annotation.LogHelperEnable;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

/**
 * @author Redick01
 *  2022/3/28 13:42
 */
@SpringBootApplication
@LogHelperEnable
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@RestController
@EnableDubbo(scanBasePackages = "com.redick.example.producer")
@PropertySource("classpath:/spring/dubbo-provider.properties")
public class ProducerApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ProducerApplication.class, args);
        new CountDownLatch(1).await();
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}

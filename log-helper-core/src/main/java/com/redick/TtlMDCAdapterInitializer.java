package com.redick;

import org.slf4j.TtlMDCAdapter;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.lang.NonNull;

/**
 * @author Redick01
 * @date 2021/6/30 3:37 下午
 */
public class TtlMDCAdapterInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    @SuppressWarnings("all")
    public void initialize(@NonNull ConfigurableApplicationContext configurableApplicationContext) {
        // 加载自定义的MDCAdapter
        TtlMDCAdapter.getInstance();
    }
}
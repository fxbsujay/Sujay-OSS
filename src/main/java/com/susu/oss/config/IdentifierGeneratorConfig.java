package com.susu.oss.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.susu.oss.common.utils.SnowFlakeUtils;
import org.springframework.stereotype.Component;

/**
 * Id生成策略
 */
@Component
public class IdentifierGeneratorConfig implements IdentifierGenerator {

    @Override
    public Number nextId(Object entity) {
        SnowFlakeUtils idUtils = new SnowFlakeUtils(1,1);
        return idUtils.nextId();
    }
}

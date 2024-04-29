package com.bootweb;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class SpringbootwebApplicationTests {

    @Autowired
    JdbcTemplate  jdbcTemplate ;

    @Autowired
    DataSource dataSource;
    @Test
    void contextLoads() {
        long cs = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM  BSMSTGD_HP02 ",long.class);
        log.info("记录总数{},数据源类型{}",cs,dataSource.getClass());

    }

}

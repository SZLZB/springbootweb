package com.bootweb.Server;

import com.bootweb.mapper.BsmxxMapper;
import com.bootweb.pojo.Bsmxx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classname: BsmxxServer
 * Package: com.bootweb.Server
 * Description:
 *
 * @Author: Simon
 * Create: 2024-04-02 - 16:07
 * Version: v1.0
 */
@Service
public class BsmxxServer {
    @Autowired
    BsmxxMapper bsmxxMapper;

    public Bsmxx GetBsmxx(){

        return bsmxxMapper.bsmxxe();
    }
}

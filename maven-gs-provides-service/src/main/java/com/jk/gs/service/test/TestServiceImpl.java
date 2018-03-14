package com.jk.gs.service.test;

import com.jk.gs.mapper.test.TestMapper;
import com.jk.gs.model.user.TreeBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper testMapper;
    public int getCount() {
        return testMapper.getCount();
    }

    public List<TreeBean> getZtree(Integer cid) {

        return testMapper.getZtree(cid);
    }
}

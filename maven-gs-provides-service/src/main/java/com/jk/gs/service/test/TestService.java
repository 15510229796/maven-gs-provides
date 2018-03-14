package com.jk.gs.service.test;

import com.jk.gs.model.user.TreeBean;

import java.util.List;

public interface TestService {
    public int getCount();

    List<TreeBean> getZtree(Integer cid);
}

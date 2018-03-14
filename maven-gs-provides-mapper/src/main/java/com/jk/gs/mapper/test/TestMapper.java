package com.jk.gs.mapper.test;

import com.jk.gs.model.user.TreeBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {
    int getCount();

    List<TreeBean> getZtree(Integer cid);
}

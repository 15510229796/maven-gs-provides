package com.jk.gs.mapper.login;

import com.jk.gs.model.user.Clientele;
import com.jk.gs.model.user.Log;
import com.jk.gs.model.user.UserBean;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginMapper {

    void addLog(Log log);

    Clientele login(String clienteleNumber);
}

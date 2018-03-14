package com.jk.gs.service.login;

import com.jk.gs.mapper.login.LoginMapper;
import com.jk.gs.model.user.Clientele;
import com.jk.gs.model.user.Log;
import com.jk.gs.model.user.UserBean;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    public Clientele login(String clienteleNumber) {
        return loginMapper.login(clienteleNumber);
    }

    public void addLog(Log log) {
        loginMapper.addLog(log);
    }
}

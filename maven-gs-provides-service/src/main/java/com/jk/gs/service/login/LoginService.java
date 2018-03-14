package com.jk.gs.service.login;

import com.jk.gs.model.user.Clientele;
import com.jk.gs.model.user.Log;
import com.jk.gs.model.user.UserBean;

public interface LoginService {
    Clientele login(String clienteleNumber);
    void addLog(Log log);
}

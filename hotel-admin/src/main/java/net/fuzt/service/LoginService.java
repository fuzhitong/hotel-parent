package net.fuzt.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import net.fuzt.pojo.OneMenu;

public interface LoginService {

    boolean login(String username, String pwd, HttpSession session) throws Exception;
    
    List<OneMenu> getSQAuthority();
    
}

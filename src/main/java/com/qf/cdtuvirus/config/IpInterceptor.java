package com.qf.cdtuvirus.config;

import com.qf.cdtuvirus.entity.Visit;
import com.qf.cdtuvirus.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class IpInterceptor implements HandlerInterceptor {
    @Autowired
    private VisitService visitService;
    //spring 接管拦截器


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*
         *1.拦截请求（只要访问当前网站就拦截**/
        String requestURI = request.getRequestURI();
        String ip=null;
        if (requestURI.contains("index")){
            String remoteAddr = request.getRemoteAddr();
            if (remoteAddr.equals("0:0:0:0:0:0:0:1")){
                ip="127.0.0.1";
            }else {
                ip=remoteAddr;
            }
            Visit visit = visitService.queryByIp(ip);
            if (visit==null){
                Visit vis = new Visit();
                vis.setCount(1);
                vis.setIp(ip);
                visitService.insert(vis);
            }else {
                visit.setCount(visit.getCount()+1);
                visitService.update(visit);
            }
        }
        return true;
    }
}

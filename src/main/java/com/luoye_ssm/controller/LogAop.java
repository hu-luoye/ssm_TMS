package com.luoye_ssm.controller;

import com.luoye_ssm.domain.SysLog;
import com.luoye_ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    ISysLogService sysLogService;

  /*  @Autowired
    private HttpServletRequest request;*/

    private Date visitTime; //开始访问时间
    private Class clazz;    //访问的类
    private Method method;  //访问的方法

    /*
     * 前置通知 主要是获取最快开始时间，执行的类是哪一个，执行的是哪一个方法
     * @param joinPoint
     **/

    @Before("execution(* com.luoye_ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        System.out.println("hello");
        visitTime = new Date(); //当前时间就是开始访问的时间
        clazz = joinPoint.getClass();   //获取要访问的类
        String methodName = joinPoint.getSignature().getName(); //获取访问的方法的名称
        Object[] args = joinPoint.getArgs();    //获取访问的方法的参数

        //获取具体方法的method对象
        if (args==null || args.length==0) {
            method = clazz.getMethod(methodName);   //获取无参数的方法
        }else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            clazz.getMethod(methodName,classArgs);
        }
    }

    /*
     * 后置通知
     * @param joinPoint
     */

    @After("execution(* com.luoye_ssm.controller.*.*(..))")
    public void diAfter(JoinPoint joinPoint) throws Exception {
        System.out.println("hello after");
        long time = new Date().getTime() - visitTime.getTime(); //获取访问的时长

        String url = "";
        //获取URL
        if (clazz!=null && method!=null && clazz!=LogAop.class) {
            //获取  @RequestMapping("/findAll")
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String[] classValue = classAnnotation.value();

                //获取方法上的@RequestMapping("/findAll")
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();
                    url = classValue[0] + methodValue[0];

                    //获取访问的ip地址
               //     String ip = request.getRemoteAddr();

                    //获取当前操作的对象
                    SecurityContext context = SecurityContextHolder.getContext();   //获取上下文的登录用户
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    //将日志对象封装到sysLog对象里面
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                  //  sysLog.setIp(ip);
                    sysLog.setMethon("[类目] " + clazz.getName() + "[方法名] " + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);

                    //调用service完成存入数据库
                    sysLogService.save(sysLog);
                }
            }
        }

    }
}

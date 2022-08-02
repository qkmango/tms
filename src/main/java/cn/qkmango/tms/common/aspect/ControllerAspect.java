package cn.qkmango.tms.common.aspect;

import cn.qkmango.tms.common.exception.ParamVerifyException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;

/**
 * @className: ControllerAspect
 * @Description: 控制器方法参数校验切面
 * @author: qkmango
 * @date: 2021-07-20 21:04
 * @version: 1.0
 */
@Aspect
@Component
public class ControllerAspect {
   // @Around("execution(* cn.qkmango.tms.query.*.controller.*Controller.*(..) || cn.qkmango.tms.email.controller )")
    @Around("execution(* cn.qkmango.tms.query.*.controller.*Controller.*(..) )")
    public Object controllerParamValidAspect(ProceedingJoinPoint jp) throws Throwable {
        Object[] args = jp.getArgs();
        ArrayList<BindingResult> bindingResultList = null;

        for (Object arg : args) {
            if (arg instanceof BindingResult) {
                BindingResult result = (BindingResult) arg;
                if (result.hasErrors()) {
                    if (bindingResultList == null) {
                        bindingResultList = new ArrayList<>(args.length);
                    }
                    bindingResultList.add(result);
                }
            }
        }

        if (bindingResultList != null) {
            throw new ParamVerifyException(bindingResultList);
        }

        return jp.proceed();
    }
}

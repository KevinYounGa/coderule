package coderule1.intercept;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by fangiming on 2017/9/19.
 */
@Component
@Aspect
public class WriteLogger {
    private final Logger logger = Logger.getLogger(getClass());

    @AfterThrowing("execution(* coderule1.controller.CodeRuleController.doUserToPrintAop())")
    public void hasException(){
        logger.error("");
    }

}

package coderule1.ruleClass;

import coderule1.Object.LittleRuleObj;
import coderule1.constant.LittleRuleType;
import coderule1.dal.service.ServiceDao;
import coderule1.exception.NoRuleTypeException;
import coderule1.ruleClass.littleRule.fix.FixRule;
import coderule1.ruleClass.littleRule.flow.flowRule;
import coderule1.ruleClass.littleRule.time.TimeRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by fangiming on 2017/9/19.
 */
@Component
public class LittleRuleFactory {

    @Autowired
    public ServiceDao ruleDao;

    public RuleClassBase getRule(LittleRuleObj obj){
        if(obj.ruleClass.equals(LittleRuleType.Time_Base)){
            return new TimeRule(obj);
        }else if(obj.ruleClass.equals(LittleRuleType.Fix_Rule)){
            return new FixRule(obj);
        }else if(obj.ruleClass.equals(LittleRuleType.Flow_Rule)){
            return new flowRule(obj,ruleDao);
        }else{
            throw new NoRuleTypeException("ruleClass="+obj.ruleClass);
        }
    }
}

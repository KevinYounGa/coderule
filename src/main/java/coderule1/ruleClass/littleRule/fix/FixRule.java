package coderule1.ruleClass.littleRule.fix;

import coderule1.Object.LittleRuleObj;
import coderule1.ruleClass.RuleClassBase;

/**
 * Created by fangiming on 2017/9/19.
 */
public class FixRule extends RuleClassBase{

    public FixRule(String ruleName, String conditionalValue) {
        super(ruleName, conditionalValue);
    }

    public FixRule(LittleRuleObj obj){
        this.conditionalValue=obj.value;
    }

    @Override
    public String getCode(String value) {
        if(value==null||value==""){
            return conditionalValue;
        }
        return value;
    }
}

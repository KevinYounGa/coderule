package coderule1.ruleClass;

import org.apache.log4j.Logger;

/**
 * Created by fangiming on 2017/9/19.
 */
public abstract class RuleClassBase {

    public RuleClassBase() {
    }

    public RuleClassBase(String ruleName, String conditionalValue) {
        this.ruleName = ruleName;
        this.conditionalValue = conditionalValue;
    }

    public Logger logger=Logger.getLogger(getClass());

    public String ruleName;

    public String conditionalValue;

    public abstract String getCode(String value);

}

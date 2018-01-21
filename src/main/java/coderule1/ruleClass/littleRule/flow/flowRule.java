package coderule1.ruleClass.littleRule.flow;

import coderule1.Object.LittleRuleObj;
import coderule1.dal.service.ServiceDao;
import coderule1.ruleClass.RuleClassBase;

/**
 * Created by fangiming on 2017/9/19.
 */
public class flowRule extends RuleClassBase{

    private ServiceDao ruleDao;

    private Integer primaryKey;

    public flowRule(String ruleName, String conditionalValue, ServiceDao ruleDao,int primaryKey) {
        super(ruleName, conditionalValue);
        this.ruleDao = ruleDao;
        this.primaryKey=primaryKey;
    }

    public flowRule(LittleRuleObj obj, ServiceDao ruleDao){
        this.conditionalValue=obj.value;
        this.primaryKey=obj.id;
        this.ruleDao=ruleDao;
    }

    @Override
    public String getCode(String value) {
        return ruleDao.getNextFlow(primaryKey,null);
    }

    public ServiceDao getRuleDao() {
        return ruleDao;
    }

    public void setRuleDao(ServiceDao ruleDao) {
        this.ruleDao = ruleDao;
    }
}

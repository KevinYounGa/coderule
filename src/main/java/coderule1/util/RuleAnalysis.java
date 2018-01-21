package coderule1.util;

import coderule1.Object.LittleRuleObj;
import coderule1.dal.util.RuleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fangiming on 2017/9/20.
 */
@Component
public class RuleAnalysis {

    @Autowired
    private RuleDao ruleDao;

    public String getRuleExplain(String ruleStr){
        if(ruleStr==null||ruleStr.equals(""))
            return "";
        StringBuffer result=new StringBuffer();
        String[] rules=ruleStr.split(",");
        List<LittleRuleObj> ruleObj=explainStrToObj(rules);
        Map<String,String> idToExlpain=getIdToExplain(StringUtil.idsToIn(ruleStrToList(ruleObj)).toString());
        for(LittleRuleObj obj : ruleObj){
            String name=idToExlpain.get(obj.id);
            result.append(name+"("+obj.value+")");
        }
        return result.toString();
    }


    public List<LittleRuleObj> explainStrToObj(final String[] rules){
        List<LittleRuleObj> ruleObj=new ArrayList<LittleRuleObj>();
        for(int i=0;i<rules.length;i++){
            ruleObj.add(new LittleRuleObj(rules[i]));
        }
        return ruleObj;
    }

    private List<String> ruleStrToList(final  List<LittleRuleObj> ruleObj){
        List<String> result=new ArrayList<String>();
       for(LittleRuleObj obj : ruleObj){
           result.add(obj.id+"");
       }
        return result;
    }

    private Map<String,String> getIdToExplain(String ids){
        List<Map<String,String>> tmp= ruleDao.getIdToExplain(ids);
        Map<String,String> idToExplain=new HashMap<String, String>();
        for(Map<String,String> map : tmp){
            idToExplain.put(map.get("littleRuleId"),map.get("LittleRuleName"));
        }
        return idToExplain;
    }

}

package coderule1.dal.service;

import coderule1.Object.LittleRuleObj;
import coderule1.Object.SeqLengthSpacer;
import coderule1.dal.dao.CodeLittleruleMapper;
import coderule1.dal.dao.CodeTargetMapper;
import coderule1.ruleClass.LittleRuleFactory;
import coderule1.ruleClass.RuleClassBase;
import coderule1.util.NumUtil;
import coderule1.util.RuleAnalysis;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by fangiming on 2017/9/19.
 */
@Component
public class ServiceDao {

    @Autowired
    private CodeLittleruleMapper little;

    @Autowired
    private CodeTargetMapper target;

    @Autowired
    private RuleAnalysis analysis;

    @Autowired
    private LittleRuleFactory littleRuleFactory;

    public synchronized String getNextFlow(int key,String value){
        Map<String,Object> seq_spacer=little.getSeqByPrimaryKey(key);
        SeqLengthSpacer seqLengthSpacer=new SeqLengthSpacer(seq_spacer);
        if(value==null||value.equals("")){
            int nextSeq=NumUtil.rollBackNum(seqLengthSpacer.seq,seqLengthSpacer.length);
            little.updateSeqByPrimaryKey(nextSeq,key);
            return NumUtil.formateNum(nextSeq,seqLengthSpacer.length,seqLengthSpacer.spacer);
        }
        return NumUtil.formateNum(Integer.parseInt(value),seqLengthSpacer.length,seqLengthSpacer.spacer);
    }

    public String getCodeValue(JSONObject targetInfo){
        String ruleLink=target.getRuleByKeyWorld(targetInfo.getString("targetCode"));
        if(ruleLink!=null&&!ruleLink.equals("")){
            String[] rule =ruleLink.split(",");
            List<LittleRuleObj> littleRule=analysis.explainStrToObj(rule);
            return calculCode(littleRule,targetInfo);
        }
        return "";
    }

    private String calculCode(List<LittleRuleObj> rules,JSONObject targetInfo){
       String result="";
        for(LittleRuleObj rule : rules){
            RuleClassBase base=littleRuleFactory.getRule(rule);
            result+=base.getCode(targetInfo.getString(rule.param));
        }
        return result;
    }



}

package coderule1.dal.util;

import coderule1.dal.dao.CodeLittleruleMapper;
import coderule1.dal.model.CodeLittlerule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by fangiming on 2017/9/20.
 */
@Component
public class RuleDao {

    @Autowired
    private CodeLittleruleMapper littleRule;

    public List<Map<String,String>> getIdToExplain(String sqlIn){
        return littleRule.getIdWithExplain(sqlIn);
    }

    public List<CodeLittlerule> getLittleCodeByType(String type){
        return littleRule.getLittleRuleByClass(type);
    }

    public int saveRuleLittle(CodeLittlerule obj){
        return littleRule.insert(obj);
    }

    public int deleteRuleLittle(int id){
        return littleRule.deleteByPrimaryKey(id);
    }
}

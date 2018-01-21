package coderule1.util.target;

import coderule1.dal.model.CodeTarget;
import coderule1.dal.util.TargetDao;
import coderule1.util.RuleAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by fangiming on 2017/9/20.
 */
@Component
public class TargetUtil {

    @Autowired
    private TargetDao targetDao;
    @Autowired
    private RuleAnalysis analysis;

    public List<CodeTarget>  getAllTarget(){
        List<CodeTarget> targets=targetDao.getAllTarget();
        for(CodeTarget t : targets){
            t.setTargetrule(analysis.getRuleExplain(t.getTargetrule()));
        }
        return targets;
    }
}

package coderule1.dal.util;

import coderule1.dal.dao.CodeTargetMapper;
import coderule1.dal.model.CodeTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by fangiming on 2017/9/20.
 */
@Component
public class TargetDao {

    @Autowired
    private CodeTargetMapper targetDao;

    public List<CodeTarget> getAllTarget(){
        List<CodeTarget> targets=targetDao.selectAllTarget();
        return targets;
    }

    public int saveTarget(CodeTarget target){
        target.setCreatetime(new Date());
        return targetDao.saveOrUpdate(target);
    }

    public int deleteTarget(int targetId){
        return targetDao.deleteByPrimaryKey(targetId);
    }

    public String getRule(String targetCode){
        return targetDao.getRuleByKeyWorld(targetCode);
    }
}

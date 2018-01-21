package coderule1.Object;

/**
 * Created by fangiming on 2017/9/19.
 */
public class LittleRuleObj {

    public final String originalVal;

    public final Integer id;          //主键

    public final String ruleClass;    //对象类型

    public final String value;        //特征值

    public  String param;

    public LittleRuleObj(String rule) {
        this.originalVal=rule;
        String[] strs=originalVal.split("\\^");
        this.id=Integer.parseInt(strs[0]);
        this.ruleClass=strs[1];
        this.value=strs[2];
        if(strs.length==4)
            this.param=strs[3];
    }
}

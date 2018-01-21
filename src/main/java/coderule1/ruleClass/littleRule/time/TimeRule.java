package coderule1.ruleClass.littleRule.time;

import coderule1.Object.LittleRuleObj;
import coderule1.ruleClass.RuleClassBase;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by fangiming on 2017/9/19.
 */
public class TimeRule extends RuleClassBase{


    public TimeRule(String ruleName, String conditionalValue) {
        super(ruleName, conditionalValue);
    }

    public TimeRule(LittleRuleObj obj) {
        this.conditionalValue=obj.value;
    }

    @Override
    public String getCode(String value) {
        if(!conditionalValue.equalsIgnoreCase("hex")){
            SimpleDateFormat sdf = new SimpleDateFormat(conditionalValue);
            if(value==null||value==""){
                return sdf.format(new Date());
            }
            SimpleDateFormat sdf2 =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                Date date = sdf2.parse(value);
                return sdf.format(date);
            }catch(Exception e){
                logger.error("时间类型转化异常：value="+value);
                e.printStackTrace();
            }
            return "";
        }else{
            if(value==null||value==""){
                long timeHex=new Date().getTime();
                return Long.toHexString(timeHex).toUpperCase();
            }
            SimpleDateFormat sdf2 =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                Date date = sdf2.parse(value);
                return Long.toHexString(date.getTime()).toUpperCase();
            }catch(Exception e){
                logger.error("时间类型转化异常：value="+value);
                e.printStackTrace();
            }
            return "";
        }
    }
}

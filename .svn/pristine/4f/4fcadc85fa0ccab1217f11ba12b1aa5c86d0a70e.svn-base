package coderule1.util;

/**
 * Created by fangiming on 2017/9/13.
 */
public class NumUtil {

    public static String formateNum(Integer num,int length,String spacer){
        if(num==null)
            num=0;
        String target=num.toString();
        while (target.length() < length) {
            target = spacer + target;
        }
        return target.substring(target.length()-length,target.length());
    }


    public static int rollBackNum(Integer num,int length){
        int checkNum=num+1;
        int nextLength= String.valueOf(checkNum).length();
        if(nextLength>length){
            return 0;
        }
        return checkNum;
    }
}

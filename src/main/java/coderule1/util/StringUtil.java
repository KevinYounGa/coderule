package coderule1.util;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by fangiming on 2017/9/20.
 */
public class StringUtil {

    /**
     * 作用：将集合转化为如下形式 <1,2,3> --> ('1','2','3')
     *                          <<1,2,3><4,5,6>> --> (1,2,3),(4,5,6)
     * @param values
     * @return
     */
    public static StringBuffer idsToIn(Collection<? extends Object> values){
        StringBuffer sb;
        Iterator<Object> it = (Iterator<Object>) values.iterator();
        if(it.next() instanceof Collection ){
            sb=valuesToColumn(values,false);
            return sb.deleteCharAt(0).deleteCharAt(sb.length()-1);
        }
        return valuesToColumn(values,false);
    }

    private static StringBuffer valuesToColumn(Collection<? extends  Object> values,boolean isBatch){
        StringBuffer sb=new StringBuffer();
        Iterator<Object> it = (Iterator<Object>)values.iterator();
        while (it.hasNext()){
            Object o = it.next();
            if(o instanceof Collection){
                StringBuffer tmpSb=valuesToColumn((Collection)o,true);
                sb.append(tmpSb);
            }else if (o instanceof Number){
                sb.append(" ").append(o).append(" ").append(",");
            }else if(o instanceof String){
                sb.append(" '").append(o).append("' ").append(",");
            }else{
                return sb.append("");
            }
        }
        return isBatch ? sb.deleteCharAt(sb.length() - 1).insert(0, "(").append(")").append(",") : sb.deleteCharAt(sb.length()-1).insert(0, "(").append(")");
    }

}

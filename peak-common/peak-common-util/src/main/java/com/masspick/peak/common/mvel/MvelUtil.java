package com.masspick.peak.common.mvel;


import org.mvel2.MVEL;
import org.mvel2.compiler.ExecutableAccessor;

import java.util.List;
import java.util.Map;


/**
 * Created by admin on 2018/9/18 0018.
 */
public class MvelUtil {


    /**
     * @param t
     * @param data
     * @param <T>
     * @return t
     */
    public <T extends Expression> T match(List<T> t, Map<String, Object> data) {
        try {
            for (T t1 : t) {
                ExecutableAccessor compiled = (ExecutableAccessor) MVEL.compileExpression(t1.getExpression());
                boolean b = (boolean) MVEL.executeExpression(compiled, data);
                if (b) {
                    return t1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

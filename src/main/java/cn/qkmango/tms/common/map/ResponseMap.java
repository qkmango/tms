package cn.qkmango.tms.common.map;

import java.util.HashMap;
import java.util.Map;

public class ResponseMap extends HashMap<String, Object> {
    public ResponseMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public ResponseMap(int initialCapacity) {
        super(initialCapacity);
    }

    public ResponseMap() {
    }

    public ResponseMap(Map<? extends String, ?> m) {
        super(m);
    }

    public void setSuccess(boolean flag) {
        this.put("success",flag);
    }

    public void setMessage(String message) {
        this.put("message",message);
    }

    public void setData(Object data) {
        this.put("data",data);
    }

}

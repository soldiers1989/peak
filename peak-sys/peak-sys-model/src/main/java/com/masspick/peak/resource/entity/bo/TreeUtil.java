package com.masspick.peak.resource.entity.bo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/7/31 0031.
 */
public class TreeUtil {

    /**
     * map
     */
    private static Map<String, Object> map = new LinkedHashMap<String, Object>();

    /**
     * nodeList
     */
    private List<Node> nodeList;

    /**
     * list
     */
    private List<Object> list = new ArrayList<Object>();


    /**
     *
     * @param id id
     * @return List
     */
    public List<Object> child(String id) {
        List<Object> lists = new ArrayList<Object>();
        for (Node node : nodeList) {
            Map<String, Object> childArray = new LinkedHashMap<String, Object>();
            if (node.getParentId().equals(id)) {
                childArray.put("value", node.getId());
                childArray.put("text", node.getName());
                //childArray.put("pid", node.getParentId());
                childArray.put("checked", node.getDisable() == 0 ? false : true);
                childArray.put("children", child(node.getId()));
                lists.add(childArray);
            }
        }
        return lists;
    }

    /**
     * Gets nodeList
     *
     * @return value of nodeList
     */
    public List<Node> getNodeList() {
        return nodeList;
    }

    /**
     * @param nodeList nodeList
     */
    public void setNodeList(List<Node> nodeList) {
        this.nodeList = nodeList;
    }
}

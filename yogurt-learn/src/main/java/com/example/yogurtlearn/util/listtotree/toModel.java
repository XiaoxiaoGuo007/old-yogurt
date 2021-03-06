//package com.example.yogurtlearn.util.listtotree;
//
//import com.sun.javafx.collections.MappingChange;
//import org.apache.logging.log4j.util.PropertySource;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class toModel {
//
//    private static void forEach(MappingChange.Map<String, List<TreeMenuNode>> collect, TreeMenuNode treeMenuNode) {
//        List<TreeMenuNode> treeMenuNodes = collect.(treeMenuNode.getId());
//        if(collect.get(treeMenuNode.getId())!=null){
//            //排序
//            treeMenuNodes.sort((u1, u2) -> u1.getSort().compareTo(u2.getSort()));
//            treeMenuNodes.stream().sorted(PropertySource.Comparator.comparing(TreeMenuNode::getSort)).collect(Collectors.toList());
//            treeMenuNode.setChildren(treeMenuNodes);
//            treeMenuNode.getChildren().forEach(t->{
//                forEach(collect,t);
//            });
//        }
//    }
//
//    public static void main(String[] args) {
//        List<ZhField> zhFields = new ArrayList<>();
//        List<TreeMenuNode> treeNodeList = new ArrayList<>();
//        //转换数据,这个是前端需要的格式。
//        zhFields.forEach(t->{
//            TreeMenuNode treeMenuNode = new TreeMenuNode();
//            treeMenuNode.setId(t.getId());
//            treeMenuNode.setParentId(t.getParentId());
//            treeMenuNode.setName(t.getName());
//            treeMenuNode.setSort(t.getSort());
//            treeNodeList.add(treeMenuNode);
//        });
//        //分组
//        Map<String, List<TreeMenuNode>> collect = treeNodeList.stream().collect(Collectors.groupingBy(TreeMenuNode::getParentId));
//        //树形结构 肯定有一个根部，我的这个根部的就是parentId.euqal("0"),而且只有一个就get（"0"）
//        TreeMenuNode treeMenuNode = collect.get("0").get(0);
//        //拼接数据
//        forEach(collect, treeMenuNode);
//    }
//}

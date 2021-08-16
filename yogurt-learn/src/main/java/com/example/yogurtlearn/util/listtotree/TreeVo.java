package com.example.yogurtlearn.util.listtotree;

import java.util.List;
import java.util.Objects;

/**
 * @description:
 * @author: old_yogurt
 * @date 2021/8/10 15:03
 */
public class TreeVo {
    private Integer id;
    private String name;
    private List<TreeVo> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TreeVo> getList() {
        return list;
    }

    public void setList(List<TreeVo> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "TreeVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeVo treeVo = (TreeVo) o;
        return id.equals(treeVo.id) && name.equals(treeVo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

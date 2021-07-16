package com.example.yogurtlearn.databasedemo.entity;
import java.time.LocalDate;

public class ModuleInfo {

    /** 模块id. 主键，自增. */
 
    private Integer id;

    /** 模块名. */
    private String moduleName;

    private LocalDate createTime;

    private LocalDate updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    public LocalDate getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDate updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ModuleInfo{" +
                "id=" + id +
                ", moduleName='" + moduleName + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
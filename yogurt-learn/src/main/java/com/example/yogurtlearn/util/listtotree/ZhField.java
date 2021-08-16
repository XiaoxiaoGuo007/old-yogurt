package com.example.yogurtlearn.util.listtotree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZhField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 上级领域id
     */
    @Column(name = "parent_id")
    private String parentId;

    /**
     * 领域名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

}
package com.example.yogurtlearn.util.listtotree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeMenuNode implements Serializable {
	private String id;
	private String parentId;
	private String name;
	private Integer sort;
	private List<TreeMenuNode> children;
	private Boolean isAble;

	/**20180929zhw添加 树的额外属性(至少含有父节点ID:"parentId")**/
	private Map<String,Object> attributes;

	public static void main(String[] args) {
		BigDecimal bigDecimal = new BigDecimal("15.6006240249609999999999999");
		System.out.println(bigDecimal);
	}
}
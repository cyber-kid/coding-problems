package com.home.data_structures.tree;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TreeNode {
    private Integer data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Integer data) {
        this.data = data;
    }
}

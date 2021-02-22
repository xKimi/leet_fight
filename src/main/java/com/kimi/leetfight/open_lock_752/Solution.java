package com.kimi.leetfight.open_lock_752;

import java.util.*;

/**
 * Created on 2021/2/23.
 * Copyright xKimi.inc
 *
 * @author Kimi
 */
public class Solution {

    public String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    public String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }

    void BFS(String target) {
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                System.out.println(cur);

                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    String down = minusOne(cur, j);
                    q.offer(up);
                    q.offer(down);
                }
            }
        }
        return;
    }

    int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        // 从起点开始启动广度优先搜索
        int step = 0;
        q.offer("0000");
        visited.add("0000");

        while (!q.isEmpty()) {
            int sz = q.size();
            /* 将当前队列中的所有节点向周围扩散 */
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();

                /* 判断是否到达终点 */
                if (deads.contains(cur)) {
                    continue;
                }
                if (Objects.equals(cur, target)) {
                    return step;
                }

                /* 将一个节点的未遍历相邻节点加入队列 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            /* 增加步数 */
            step++;
        }
        //如果穷举完都没找到目标密码，返回-1
        return -1;
    }
}

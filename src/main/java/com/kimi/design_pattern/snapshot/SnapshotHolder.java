package com.kimi.design_pattern.snapshot;

import java.util.Stack;

/**
 * @author Kimi
 * @date 2021/6/17 22:03
 */
public class SnapshotHolder {

    private Stack<Snapshot> snapshots = new Stack<>();

    public Snapshot popSnapshot() {
        return snapshots.pop();
    }

    public void pushSnapshot(Snapshot snapshot) {
        snapshots.push(snapshot);
    }
}

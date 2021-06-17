package com.kimi.design_pattern.snapshot;

import java.util.Scanner;

/**
 * @author Kimi
 * @date 2021/6/17 22:04
 */
public class TestSnapshot {

    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (":list".equals(input)) {
                System.out.println(inputText.getText());
            } else if (":undo".equals(input)) {
                Snapshot snapshot = snapshotHolder.popSnapshot();
                inputText.restoreSnapshot(snapshot);
            } else {
                snapshotHolder.pushSnapshot(inputText.createSnapshot());
                inputText.append(input);
            }
        }
    }
}

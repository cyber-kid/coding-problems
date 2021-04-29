package com.home.binarylinkedlist;

import java.io.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}


class Result {

    /*
     * Complete the 'getNumber' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts INTEGER_SINGLY_LINKED_LIST binary as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static long getNumber(SinglyLinkedListNode binary) {
        long result = 0;

        while (binary != null) {
            result = (result * 2) + binary.data;

            binary = binary.next;
        }

        return result;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        SinglyLinkedList binary = new SinglyLinkedList();

        int binaryCount = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, binaryCount).forEach(i -> {
            try {
                int binaryItem = Integer.parseInt(bufferedReader.readLine().trim());

                binary.insertNode(binaryItem);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.getNumber(binary.head);

        System.out.println(String.valueOf(result));

        bufferedReader.close();
    }
}

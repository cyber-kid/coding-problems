package com.home.linked_list.design_browser_history;

import java.util.Objects;

public class BrowserHistory {
    private HistoryNode currentPage;
    public BrowserHistory(String homepage) {
        currentPage = new HistoryNode(homepage);
    }

    public void visit(String url) {
        HistoryNode next = new HistoryNode(url);

        next.setPrev(currentPage);
        currentPage.setNext(next);
        currentPage = next;
    }

    public String back(int steps) {
        for (int i = 0; i < steps; i++) {
            if (Objects.isNull(currentPage.getPrev())) {
                break;
            }

            currentPage = currentPage.getPrev();
        }

        return currentPage.getUrl();
    }

    public String forward(int steps) {
        for (int i = 0; i < steps; i++) {
            if (Objects.isNull(currentPage.getNext())) {
                return currentPage.getUrl();
            }

            currentPage = currentPage.getNext();
        }

        return currentPage.getUrl();
    }

    static class HistoryNode {
        private final String url;
        private HistoryNode prev;
        private HistoryNode next;

        public HistoryNode(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public HistoryNode getPrev() {
            return prev;
        }

        public void setPrev(HistoryNode prev) {
            this.prev = prev;
        }

        public HistoryNode getNext() {
            return next;
        }

        public void setNext(HistoryNode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");

        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"

        System.out.println(browserHistory.back(1)); // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1)); // You are in "facebook.com", move back to "google.com" return "google.com"

        System.out.println(browserHistory.forward(1)); // You are in "google.com", move forward to "facebook.com" return "facebook.com"

        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"

        System.out.println(browserHistory.forward(2)); // You are in "linkedin.com", you cannot move forward any steps.

        System.out.println(browserHistory.back(2)); // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(browserHistory.back(7)); // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}

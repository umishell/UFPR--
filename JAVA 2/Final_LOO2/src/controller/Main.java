package controller;

import view.Frame;

public class Main {

    private void init(Frame frame) {
        frame.initView();
    }

    public static void main(String[] args) {

        Main main = new Main();
        main.init(new Frame());

    }
}

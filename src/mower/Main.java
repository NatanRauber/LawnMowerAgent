package mower;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        RandomMower rMower = new RandomMower(10, 15);
        rMower.print();
        rMower.cut();
    }
}
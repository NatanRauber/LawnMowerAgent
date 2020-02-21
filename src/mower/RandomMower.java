package mower;

import java.io.IOException;
import java.util.Random;

public class RandomMower extends Mower {

    RandomMower(int size, int ant) {
        float a = size;
        float b = ant;
        float c = (b / ((a - 2) * (a - 2)));
        if (c > 0.30) {
            System.out.printf("Muitos formigueiros\n");
            System.out.printf("Numero maximo: 30,0 %%\n");
            System.out.printf("Numero atual: %.1f %%\n", (c * 100));
            System.exit(0);
        } else {
            this.size = size;
            totalGrass = (((size - 2) * (size - 2)) - ant);
            lawn = new String[size][size];
            newLawn(size, ant);
        }
    }

    public void cut() throws IOException, InterruptedException {

        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size; i2++) {
                if (lawn[i][i2] == "w") {
                    lawn[i][i2] = "C";
                    alreadyCut++;
                    print();
                    _cut();
                    return;
                }
            }
        }
    }

    private void _cut() throws IOException, InterruptedException {

        int x;
        Random rand = new Random();

        do {
            for (int i = 1; i < size - 1; i++) {
                for (int i2 = 1; i2 < size - 1; i2++) {
                    if (lawn[i][i2] == "C") {
                        if (diagonal == true) {
                            x = rand.nextInt(8);
                            if (lawn[i][i2 + 1] == "w") {
                                right();
                            } else if (lawn[i][i2 - 1] == "w") {
                                left();
                            } else if (lawn[i - 1][i2] == "w") {
                                up();
                            } else if (lawn[i + 1][i2] == "w") {
                                down();
                            } else if (lawn[i - 1][i2 + 1] == "w") {
                                rightUp();
                            } else if (lawn[i + 1][i2 + 1] == "w") {
                                rightDown();
                            } else if (lawn[i + 1][i2 - 1] == "w") {
                                leftDown();
                            } else if (lawn[i - 1][i2 - 1] == "w") {
                                leftUp();
                            } else if (x == 0) {
                                right();
                            } else if (x == 1) {
                                left();
                            } else if (x == 2) {
                                up();
                            } else if (x == 3) {
                                down();
                            } else if (x == 4) {
                                rightUp();
                            } else if (x == 5) {
                                rightDown();
                            } else if (x == 6) {
                                leftUp();
                            } else if (x == 7) {
                                leftDown();
                            }
                        }
                        if (diagonal == false) {
                            x = rand.nextInt(4);
                            if (lawn[i][i2 + 1] == "w") {
                                right();
                            } else if (lawn[i][i2 - 1] == "w") {
                                left();
                            } else if (lawn[i - 1][i2] == "w") {
                                up();
                            } else if (lawn[i + 1][i2] == "w") {
                                down();
                            } else if ((lawn[i - 1][i2 + 1] == "w") && (up())) {
                                right();
                            } else if ((lawn[i - 1][i2 + 1] == "w") && (right())) {
                                up();
                            } else if ((lawn[i + 1][i2 + 1] == "w") && (down())) {
                                right();
                            } else if ((lawn[i + 1][i2 + 1] == "w") && (right())) {
                                down();
                            } else if ((lawn[i + 1][i2 - 1] == "w") && (down())) {
                                left();
                            } else if ((lawn[i + 1][i2 - 1] == "w") && (left())) {
                                down();
                            } else if ((lawn[i - 1][i2 - 1] == "w") && (up())) {
                                left();
                            } else if ((lawn[i - 1][i2 - 1] == "w") && (left())) {
                                up();
                            } else if (x == 0) {
                                right();
                            } else if (x == 1) {
                                left();
                            } else if (x == 2) {
                                up();
                            } else if (x == 3) {
                                down();
                            }
                        }
                    }
                }
            }
        } while (alreadyCut < totalGrass);
    }
}
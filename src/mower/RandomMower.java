package mower;

import java.io.IOException;
import java.util.Random;

public class RandomMower extends Mower {

    RandomMower(int size, int ant) {
        float a = size;
        float b = ant;
        float c = (b / ((a - 2) * (a - 2)));

        if (c > 0.30) {
            System.out.printf("Too many ants\n");
            System.out.printf("Maximum: 30,0 %%\n");
            System.out.printf("Currently: %.1f %%\n", (c * 100));
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
                    if (alreadyCut >= totalGrass)
                        return;
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
                                right();
                                right();
                            } else if (x == 1) {
                                left();
                                left();
                                left();
                            } else if (x == 2) {
                                up();
                                up();
                                up();
                            } else if (x == 3) {
                                down();
                                down();
                                down();
                            } else if (x == 4) {
                                rightUp();
                                rightUp();
                                rightUp();
                            } else if (x == 5) {
                                rightDown();
                                rightDown();
                                rightDown();
                            } else if (x == 6) {
                                leftUp();
                                leftUp();
                                leftUp();
                            } else if (x == 7) {
                                leftDown();
                                leftDown();
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
                                right();
                                right();
                            } else if (x == 1) {
                                left();
                                left();
                                left();
                            } else if (x == 2) {
                                up();
                                up();
                                up();
                            } else if (x == 3) {
                                down();
                                down();
                                down();
                            }
                        }
                    }
                }
            }
        } while (alreadyCut < totalGrass);
    }
}
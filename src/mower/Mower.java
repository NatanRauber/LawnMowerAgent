package mower;

import java.util.Random;
import java.io.IOException;

public class Mower {

    boolean diagonal = true;
    protected String lawn[][];
    protected int size, totalGrass, alreadyCut = 0;
    protected String direcao = "right";

    public void print() throws IOException, InterruptedException {
        clear();
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size; i2++) {
                System.out.printf("%s ", lawn[i][i2]);
            }
            System.out.printf("\n");
        }
    }

    public void newLawn(int size, int ant) {

        int a, b, i = 0;
        Random rand = new Random();

        for (i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size; i2++) {
                lawn[i][i2] = ".";
            }
        }

        for (i = 1; i < size - 1; i++) {
            for (int i2 = 1; i2 < size - 1; i2++) {
                lawn[i][i2] = "w";
            }
        }

        i = 0;
        while (i < ant) {
            a = rand.nextInt(size);
            b = rand.nextInt(size);

            if ((a > 0) && (a < size - 1) && (b > 0) && (b < size - 1)) {
                if (lawn[a][b] != "@") {
                    lawn[a][b] = "@";
                    i++;
                }
            }
        }

        for (i = 1; i < size - 1; i++) {
            for (int i2 = 1; i2 < size - 1; i2++) {
                if ((lawn[i][i2] == "w") && (lawn[i][i2 + 1] != "w") && (lawn[i][i2 - 1] != "w")
                        && (lawn[i + 1][i2] != "w") && (lawn[i - 1][i2] != "w")) {
                    newLawn(size, ant);
                }
            }
        }
    }

    public boolean right() throws IOException, InterruptedException {
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size; i2++) {
                if (lawn[i][i2] == "C") {
                    if ((lawn[i][i2 + 1] == "w") || (lawn[i][i2 + 1] == "_")) {
                        if (lawn[i][i2 + 1] == "w")
                            alreadyCut++;
                        lawn[i][i2 + 1] = "C";
                        lawn[i][i2] = "_";
                        print();
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean left() throws IOException, InterruptedException {
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size; i2++) {
                if (lawn[i][i2] == "C") {
                    if ((lawn[i][i2 - 1] == "w") || (lawn[i][i2 - 1] == "_")) {
                        if (lawn[i][i2 - 1] == "w")
                            alreadyCut++;
                        lawn[i][i2 - 1] = "C";
                        lawn[i][i2] = "_";
                        print();
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean up() throws IOException, InterruptedException {
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size; i2++) {
                if (lawn[i][i2] == "C") {
                    if ((lawn[i - 1][i2] == "w") || (lawn[i - 1][i2] == "_")) {
                        if (lawn[i - 1][i2] == "w")
                            alreadyCut++;
                        lawn[i - 1][i2] = "C";
                        lawn[i][i2] = "_";
                        print();
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean down() throws IOException, InterruptedException {
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size; i2++) {
                if (lawn[i][i2] == "C") {
                    if ((lawn[i + 1][i2] == "w") || (lawn[i + 1][i2] == "_")) {
                        if (lawn[i + 1][i2] == "w")
                            alreadyCut++;
                        lawn[i + 1][i2] = "C";
                        lawn[i][i2] = "_";
                        print();
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean rightUp() throws IOException, InterruptedException {
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size; i2++) {
                if (lawn[i][i2] == "C") {
                    if ((lawn[i - 1][i2 + 1] == "w") || (lawn[i - 1][i2 + 1] == "_")) {
                        if (lawn[i - 1][i2 + 1] == "w")
                            alreadyCut++;
                        lawn[i - 1][i2 + 1] = "C";
                        lawn[i][i2] = "_";
                        print();
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean rightDown() throws IOException, InterruptedException {
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size; i2++) {
                if (lawn[i][i2] == "C") {
                    if ((lawn[i + 1][i2 + 1] == "w") || (lawn[i + 1][i2 + 1] == "_")) {
                        if (lawn[i + 1][i2 + 1] == "w")
                            alreadyCut++;
                        lawn[i + 1][i2 + 1] = "C";
                        lawn[i][i2] = "_";
                        print();
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean leftUp() throws IOException, InterruptedException {
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size; i2++) {
                if (lawn[i][i2] == "C") {
                    if ((lawn[i - 1][i2 - 1] == "w") || (lawn[i - 1][i2 - 1] == "_")) {
                        if (lawn[i - 1][i2 - 1] == "w")
                            alreadyCut++;
                        lawn[i - 1][i2 - 1] = "C";
                        lawn[i][i2] = "_";
                        print();
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean leftDown() throws IOException, InterruptedException {
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size; i2++) {
                if (lawn[i][i2] == "C") {
                    if ((lawn[i + 1][i2 - 1] == "w") || (lawn[i + 1][i2 - 1] == "_")) {
                        if (lawn[i + 1][i2 - 1] == "w")
                            alreadyCut++;
                        lawn[i + 1][i2 - 1] = "C";
                        lawn[i][i2] = "_";
                        print();
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public static void clear() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}
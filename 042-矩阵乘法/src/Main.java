import java.util.Scanner;

/**
 * Author: 王俊超
 * Date: 2015-12-24 20:37
 * Declaration: All Rights Reserved !!!
 */
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();

            int[][] a = new int[x][y];
            int[][] b = new int[y][z];


            int a1 = x * y;
            for (int i = 0; i < a1; i++) {
                a[i / y][i % y] = scanner.nextInt();
            }

            int b1 = y * z;
            for (int i = 0; i < b1; i++) {
                b[i / z][i % z] = scanner.nextInt();
            }

            System.out.println(matrixMultiply(a, b));
        }

        scanner.close();
    }

    private static String matrixMultiply(int[][] a, int[][] b) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                int result = 0;
                for (int k = 0; k < a[0].length; k++) {
                    result += a[i][k] * b[k][j];
                }

                builder.append(result).append(' ');
            }
            builder.setCharAt(builder.length() - 1, '\n');
        }

        return builder.substring(0, builder.length() - 1);
    }
}

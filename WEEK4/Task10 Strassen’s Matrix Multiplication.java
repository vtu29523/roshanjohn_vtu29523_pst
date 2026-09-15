import java.util.*;

public class Solution {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {

        int m = matrix.size();
        int n = matrix.get(0).size();

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            List<Integer> elements = new ArrayList<>();

            int top = layer;
            int left = layer;
            int bottom = m - layer - 1;
            int right = n - layer - 1;

            // Top row: left -> right
            for (int j = left; j <= right; j++) {
                elements.add(matrix.get(top).get(j));
            }

            // Right column: top+1 -> bottom
            for (int i = top + 1; i <= bottom; i++) {
                elements.add(matrix.get(i).get(right));
            }

            // Bottom row: right-1 -> left
            for (int j = right - 1; j >= left; j--) {
                elements.add(matrix.get(bottom).get(j));
            }

            // Left column: bottom-1 -> top+1
            for (int i = bottom - 1; i > top; i--) {
                elements.add(matrix.get(i).get(left));
            }

            // Effective rotations
            int len = elements.size();
            int shift = r % len;

            // Anti-clockwise rotation
            List<Integer> rotated = new ArrayList<>();

            for (int i = shift; i < len; i++) {
                rotated.add(elements.get(i));
            }

            for (int i = 0; i < shift; i++) {
                rotated.add(elements.get(i));
            }

            int index = 0;

            // Put back: Top row
            for (int j = left; j <= right; j++) {
                matrix.get(top).set(j, rotated.get(index++));
            }

            // Put back: Right column
            for (int i = top + 1; i <= bottom; i++) {
                matrix.get(i).set(right, rotated.get(index++));
            }

            // Put back: Bottom row
            for (int j = right - 1; j >= left; j--) {
                matrix.get(bottom).set(j, rotated.get(index++));
            }

            // Put back: Left column
            for (int i = bottom - 1; i > top; i--) {
                matrix.get(i).set(left, rotated.get(index++));
            }
        }

        // Print matrix
        for (List<Integer> row : matrix) {
            for (int j = 0; j < row.size(); j++) {
                System.out.print(row.get(j));

                if (j < row.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();Week4 Task9 Strassen’s Matrix Multiplication.java

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(sc.nextInt());
            }

            matrix.add(row);
        }

        matrixRotation(matrix, r);

        sc.close();
    }
}

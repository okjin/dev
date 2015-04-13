import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by lne on 14.03.15.
 */
public class SudokuAlgorithm {
    public static final int SIZE = 9;

    public int[][] loadSudoku(String file) {
        int[][] a = new int[SIZE][SIZE];
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String l;
            for (int i = 0; i < SIZE; i++) {
                l = bufferedReader.readLine();
                String[] tokens = l.split("\\s");
                for (int j = 0; j < SIZE; j++) {
                    int v = 0;
                    if (!tokens[j].equals("x"))
                        v = Integer.parseInt(tokens[j]);
                    a[i][j] = v;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }

    public boolean existsInRow(int[][] a, int x, int y) {
        int v = a[y][x];

        for (int j = 0; j < SIZE; j++) {
            if (a[y][j] == v && x != j && a[y][j] != 0) return true;
        }

        return false;
    }

    public boolean existsInCol(int[][] a, int x, int y) {
        int v = a[y][x];

        for (int i = 0; i < SIZE; i++) {
            if (a[i][x] == v && y != i && a[i][x] != 0) return true;
        }

        return false;
    }

    public boolean existsInBlock(int[][] a, int x, int y) {
        int v = a[y][x];
        int blockX = x / 3;
        int blockY = y / 3;

        for (int i = blockY * 3; i < blockY * 3 + 3; i++) {
            for (int j = blockX * 3; j < blockX * 3 + 3; j++) {
                if ((i == y && j == x) || a[i][j] == 0) continue;
                if (v == a[i][j]) return true;
            }
        }

        return false;
    }

    public boolean isValid(int[][] a) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (existsInBlock(a, j, i)) return false;
                if (existsInRow(a, j, i))   return false;
                if (existsInCol(a, j, i))   return false;
            }
        }
        return true;
    }

    public static void printSudoku(int[][] a) {
        for (int i = 0; i < SIZE; i++) {
            if (i != 0 && i % 3 == 0) System.out.println();
            for (int j = 0; j < SIZE; j++) {
                if (j != 0 && j % 3 == 0) System.out.print("  ");
                if (a[i][j] > 0)
                    System.out.printf("%2d ", a[i][j]);
                else
                    System.out.print(" ? ");
            }
            System.out.println();
        }
    }

    public int[][] copyArray(int[][] a) {
        int[][] b = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                b[i][j] = a[i][j];
            }
        }
        return b;
    }

    public boolean isSolved(int[][] a) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (a[i][j] == 0) return false;
            }
        }
        return true;
    }

    public ArrayList<Integer> possibleValuesAt(int[][] a, int x, int y) {
        int[][] b = copyArray(a);

        ArrayList<Integer> values = new ArrayList<Integer>();
        for (int v = 1; v <= 9; v++) {
            b[y][x] = v;
            if (isValid(b)) values.add(new Integer(v));
        }

        return values;
    }

    public static void main(String[] args) {
        SudokuAlgorithm algorithm = new SudokuAlgorithm();
        int[][] sudoku = algorithm.loadSudoku("sudoku.txt");
        long start = System.nanoTime();
        System.out.printf("Needed %f milliseconds to solve sudoku\n", start / 1000000.0);
        sudoku = algorithm.solveSudoku(sudoku);
        long end = System.nanoTime() - start;
        System.out.printf("Needed %f milliseconds to solve sudoku\n", end / 1000000.0);
        SudokuAlgorithm.printSudoku(sudoku);
    }

    private class SudokuCell implements Comparable<Object> {
        int x, y;
        ArrayList<Integer> possibleValues;

        @Override
        public int compareTo(Object o) {
            if (!(o instanceof SudokuCell))
                throw new RuntimeException("Types not comparable");
            return possibleValues.size() - ((SudokuCell) o).possibleValues.size();
        }
    }

    public int[][] solveSudoku(int[][] a) {
        // Return if sudoku is not valid
        if (!isValid(a)) return null;

        // Return if sudoku is solved
        if (isSolved(a)) return a;

        // Look for next cell with the least values
        ArrayList<SudokuCell> possibleCells = new ArrayList<SudokuCell>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (a[i][j] == 0) {
                    SudokuCell cell = new SudokuCell();
                    cell.possibleValues = possibleValuesAt(a, j, i);
                    cell.x = j;
                    cell.y = i;
                    possibleCells.add(cell);
                }
            }
        }

        // Return if there are no possible cells any more
        if (possibleCells.isEmpty()) return null;

        // Sort the cells
        for (int n = possibleCells.size(); n > 1; n--) {
            for (int i = 0; i < n - 1; i++) {
                if (possibleCells.get(i).compareTo(possibleCells.get(i + 1)) > 0) {
                    SudokuCell tmp = possibleCells.get(i);
                    possibleCells.set(i, possibleCells.get(i + 1));
                    possibleCells.set(i + 1, tmp);
                }
            }
        }


        // Create array copy and start this function again
        for (int i = 0; i < possibleCells.size(); i++) {
            SudokuCell cell = possibleCells.get(i);
            for (Integer v : cell.possibleValues) {
                int[][] b = copyArray(a);
                b[cell.y][cell.x] = v;
                int[][] solution = solveSudoku(b);

                if (solution != null) return solution;
            }
        }
        return null;
    }
}

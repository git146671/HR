package QueenAttack;

public class Main {
    public static void main(String[] args) {
        int[][] obstacles = {{5, 5}, {4, 2}, {2, 3}};
        System.out.println(queensAttack(5, 3, 4, 3, obstacles));
    }

    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int result = 0;
        int up, upRight, right, downRight, down, downLeft, left, upLeft;
        up = upRight = right = downRight = down = downLeft = left = upLeft = -1;
        for (int i = 0; i < obstacles.length; i++) {
            int x = obstacles [i][0];
            int y = obstacles [i][1];
            if (x == r_q && y < c_q && up < c_q - y - 1) up = c_q - y - 1;                          // up
            if (x == r_q && y > c_q && down < y - c_q - 1) down = y - c_q - 1;                      // down
            if (y == c_q && x > r_q && right < x - r_q - 1) right = x - r_q - 1;                    // right
            if (y == c_q && x < r_q && left < r_q - x - 1) left = r_q - x - 1;                      // left
            if (Math.abs(r_q - x) == Math.abs(c_q - y)) {                                           // диагонали
                if (r_q < x && c_q > y && upRight < x - r_q - 1) upRight = x - r_q - 1;             // upRight
                if (r_q < x && c_q < y && downRight < x - r_q - 1) downRight = x - r_q - 1;         // downRight
                if (r_q > x && c_q < y && downLeft < r_q - x - 1) downLeft = r_q - x - 1;           // downLeft
                if (r_q > x && c_q > y && upLeft < r_q - x - 1) upLeft = r_q - x - 1;               // upLeft
            }
        }
        result = up != -1 ? result + up : result + c_q - 1;
        result = down != -1 ? result + down : result + n - c_q;
        result = right != -1 ? result + right : result + n - r_q;
        result = left != -1 ? result + left : result + r_q - 1;
        if (upRight != -1) result += upRight;
            else result += Math.min(r_q - 1, n - c_q);
        if (downRight != -1) result += downRight;
            else result += Math.min(n - r_q, n - c_q);
        if (downLeft != -1) result += downLeft;
            else result += Math.min(n - r_q, c_q - 1);
        if (upLeft != -1) result += upLeft;
            else result += Math.min(r_q - 1, c_q - 1);
        return result;
    }
}

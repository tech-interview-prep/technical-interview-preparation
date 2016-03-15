package leetcode_online_judge;

public class Point {
    int x;
    int y;
    Point() {
        x = 0;
        y = 0;
    }
    
    Point(int a, int b) {
        x = a;
        y = b;
    }

    public static Point[] getPoints() {
        return new Point[]{
                new Point(0, 0),
                new Point(1, 1),
                new Point(1, 2),
                new Point(2, 1),
                new Point(2, 2)
        };
    }
}

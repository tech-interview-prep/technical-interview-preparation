package leetcode_online_judge.Java;

import java.util.HashMap;
import java.util.Map;

import utils.Point;
import utils.Utils;

/**
 * https://leetcode.com/problems/palindrome-number/
 * @author bkoteshwarreddy
 */
public class _149MaxPointsOnALine {
    /*
    Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
     */
    public static int maxPoints(Point[] points) {
        Map<Double, Integer> slopeCount = new HashMap<Double, Integer>();
        int max = -1;

        for (int i = 0; i < points.length; i++) {
            slopeCount.clear();
            int count, numSamePts = 0, roundMax = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    numSamePts++;
                } else {
                    double slope = points[j].x == points[i].x ? Double.NEGATIVE_INFINITY : (points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                    slope = slope == 0.0 ? 0.0 : slope; // (-0.0 and 0.0);

                    if (!slopeCount.containsKey(slope)) {
                        count = 1;
                    } else {
                        count = slopeCount.get(slope) + 1;
                    }
                    slopeCount.put(slope, count);
                    roundMax = Math.max(roundMax, count);
                }
            }
            max = Math.max(max, roundMax + numSamePts);
        }

        return max + 1;
    }

    private static void test() {
        Utils.printTestln(maxPoints(Point.getPoints()), 3);
        Utils.printTestln(maxPoints(new Point[] {new Point(), new Point(1, 1), new Point()}), 3);
        Utils.printTestln(maxPoints(new Point[] {new Point(1, 1), new Point(1, 1), new Point(1, 1)}), 3);
        Utils.printTestln(maxPoints(new Point[] {new Point(2, 3), new Point(3, 3), new Point(-5, 3)}), 3);
        Utils.printTestln(maxPoints(new Point[] {new Point(84, 250), new Point(0, 0), new Point(1, 0), new Point(0, -70),
                              new Point(0, -70), new Point(1, -1), new Point(21, 10), new Point(42, 90), new Point(-42, -230)
        }), 6);
    }

    public static void main(String[] args) {
        test();
    }
}

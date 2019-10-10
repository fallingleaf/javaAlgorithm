package array;
import java.util.*;


// Robot can move, turn left or right and clean
// Use backtrack: turn 180 back, move back and turn 180 again to have same
// position, move to other direction by turn left or right
public class RobotRoomCleaner {
    int[][] dirs = new int[][] {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    void cleanRoom(Robot robot) {
        HashSet<String> visited = new HashSet<>();
        helper(robot, 0, 0, 0, visited);
    }

    void helper(Robot robot, int x, int y, int dir, HashSet<String> visited) {
        robot.clean();

        visited.add(x + "-" + y);

        for (int i = 0; i < 4; ++i) {
            int newX = x + dirs[i][0], newY = y + dirs[i][1];

            if (!visited.count(newX + "-" + newY) && robot.move()) {
                helper(robot, newX, newY, cur, visited);
                // Turn 180 back
                robot.turnRight();
                robot.turnRight();
                // Move back
                robot.move();
                // Turn 180 back same previous direction
                robot.turnLeft();
                robot.turnLeft();
            }
            // Turn to another direction
            robot.turnRight();
        }
    }
}

import org.junit.Assert;
import org.junit.Test;
/*
*
*
 */
public class PacManShould {

    @Test
    public void ensure_pacman_moves_right_and_looks_right() {
        PacMan pacman = new PacMan(0,0, Direction.LEFT);

        pacman.moveRight(Cell.EMPTY);

        Assert.assertEquals(new PacMan(1,0, Direction.RIGHT), pacman);
    }

    @Test
    public void ensure_pacman_moves_left_and_looks_left() {
        PacMan pacman = new PacMan(0, 0, Direction.RIGHT);

        pacman.moveLeft(Cell.EMPTY);

        Assert.assertEquals(new PacMan(-1, 0, Direction.LEFT), pacman);
    }

    @Test
    public void ensure_pacman_moves_up_and_looks_up(){
        PacMan pacman = new PacMan(0,0, Direction.RIGHT);

        pacman.moveUp(Cell.EMPTY);

        Assert.assertEquals(new PacMan(0,1, Direction.UP), pacman);
    }

    @Test
    public void ensure_pacman_moves_down_and_looks_down() {
        PacMan pacman = new PacMan(0, 0, Direction.DOWN);

        pacman.moveDown(Cell.EMPTY);

        Assert.assertEquals(new PacMan(0, -1, Direction.DOWN), pacman);
    }

    @Test
    public void ensure_pacman_does_not_move_through_walls_when_moving_right(){
        PacMan pacman = new PacMan(0,0, Direction.RIGHT);

        pacman.moveRight(Cell.WALL);

        Assert.assertEquals(new PacMan(0,0, Direction.RIGHT), pacman);
    }

    @Test
    public void ensure_pacman_does_not_move_through_walls_when_moving_left(){
        PacMan pacman = new PacMan(0,0, Direction.LEFT);

        pacman.moveLeft(Cell.WALL);

        Assert.assertEquals(new PacMan(0,0, Direction.LEFT), pacman);
    }

    @Test
    public void ensure_pacman_does_not_move_through_walls_when_moving_up(){
        PacMan pacman = new PacMan(0,0, Direction.UP);

        pacman.moveUp(Cell.WALL);

        Assert.assertEquals(new PacMan(0,0, Direction.UP), pacman);
    }

    @Test
    public void ensure_pacman_does_not_move_through_walls_when_moving_down(){
        PacMan pacman = new PacMan(0,0, Direction.DOWN);

        pacman.moveDown(Cell.WALL);

        Assert.assertEquals(new PacMan(0,0, Direction.DOWN), pacman);
    }

}

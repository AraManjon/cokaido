import org.junit.Assert;
import org.junit.Test;

public class YatzyShould {

    @Test
    public void ensure_yatzy_play_scores_50_points(){
        Yatzy yatzy = new Yatzy(new int[]{1, 1, 1, 1, 1}, "yatzy");

//        Assert.assertEquals(new Score(50), yatzy.calculateScore());
        Assert.assertTrue(new Score(50).equals(yatzy.calculateScore()));
    }

    @Test
    public void ensure_erroneous_yatzy_play_scores_0_points(){
        Yatzy yatzy = new Yatzy(new int[]{1, 1, 1, 1, 2}, "yatzy");

        Assert.assertTrue(new Score(0).equals(yatzy.calculateScore()));
    }
}

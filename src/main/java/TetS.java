import com.googlecode.lanterna.TextColor;

public class TetS extends Tetromino {
    private final TextColor color = TextColor.ANSI.WHITE;
    private TetSConfiguration configuration;


    public TetS(Positions anchor, TetSConfiguration configuration) {
        super.anchor = anchor;
        this.configuration = configuration;

        if (configuration == TetSConfiguration.UP) {

        } else if (configuration == TetSConfiguration.DOWN) {

        } else if (configuration == TetSConfiguration.LEFT) {

        } else if (configuration == TetSConfiguration.RIGHT) {

        }
    }


}

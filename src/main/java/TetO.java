import com.googlecode.lanterna.TextColor;

public class TetO extends Tetromino {
    private final TextColor color = TextColor.ANSI.YELLOW;
    private TetOConfiguration configuration;


    public TetO(Positions anchor, TetOConfiguration configuration) {
        super.anchor = anchor;
        this.configuration = configuration;

        if (configuration == TetOConfiguration.UP) {
            setsShapeUP(this.anchor);
        }
    }

    public void setsShapeUP(Positions anchor) {

    }

}
import com.googlecode.lanterna.TextColor;

public class TetL extends Tetromino{
    private final TextColor color = TextColor.ANSI.MAGENTA;
    private TetLConfiguration configuration;


    public TetL(Positions anchor, TetLConfiguration configuration) {
        super.anchor = anchor;
        this.configuration = configuration;

        if (configuration == TetLConfiguration.UP) {

        } else if (configuration == TetLConfiguration.DOWN) {

        } else if (configuration == TetLConfiguration.LEFT) {

        } else if (configuration == TetLConfiguration.RIGHT) {

        }
    }

}



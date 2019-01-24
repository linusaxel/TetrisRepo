import com.googlecode.lanterna.TextColor;

public class TetI extends Tetromino{

    private final TextColor color = TextColor.ANSI.RED;
    private TetIConfiguration configuration;


    public TetI(Positions anchor, TetIConfiguration configuration) {
        super.anchor = anchor;
        this.configuration = configuration;

        if (configuration == TetIConfiguration.VERTICAL) {

        }
        else if (configuration == TetIConfiguration.HORIZONTAL) {

        }
    }


}

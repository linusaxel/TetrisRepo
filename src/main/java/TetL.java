import com.googlecode.lanterna.TextColor;

public class TetL extends Tetromino{
    private final TextColor color = TextColor.ANSI.MAGENTA;
    private TetLConfiguration configuration;


    public TetL(Positions anchor, TetLConfiguration configuration) {
        super.anchor = anchor;
        this.configuration = configuration;

        if (configuration == TetLConfiguration.UP) {
            setsShapeUP(this.anchor);
        } else if (configuration == TetLConfiguration.DOWN) {
            setsShapeDOWN(this.anchor);
        } else if (configuration == TetLConfiguration.LEFT) {
            setsShapeLEFT(this.anchor);
        } else if (configuration == TetLConfiguration.RIGHT) {
            setsShapeRIGHT(this.anchor);
        }
    }

    public void setsShapeDOWN(Positions anchor) {

    }

    public void setsShapeLEFT(Positions anchor) {

    }

    public void setsShapeUP(Positions anchor) {

    }

    public void setsShapeRIGHT(Positions anchor) {

    }

}



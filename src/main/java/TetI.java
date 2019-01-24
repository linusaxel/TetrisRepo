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

    public void setsShapeVERTICAL(Positions anchor) {
        Positions positionOne = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        Positions positionTwo = new Positions(this.anchor.getX() + 1, this.anchor.getY());
        Positions positionThree = new Positions(this.anchor.getX(), this.anchor.getY() + 1);

        Positions[] positionsVERTICAL = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsVERTICAL;
    }

    public void setsShapeHORIZONTAL(Positions anchor) {
        Positions positionOne = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        Positions positionTwo = new Positions(this.anchor.getX() + 1, this.anchor.getY());
        Positions positionThree = new Positions(this.anchor.getX(), this.anchor.getY() + 1);

        Positions[] positionsHORIZONTAL = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsHORIZONTAL;
    }

}

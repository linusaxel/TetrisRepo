import com.googlecode.lanterna.TextColor;

public class TetI extends Tetromino{

    private final TextColor color = TextColor.ANSI.RED;
    private TetIConfiguration configuration;


    public TetI(Positions anchor, TetIConfiguration configuration) {
        super.anchor = anchor;
        this.configuration = configuration;

        if (configuration == TetIConfiguration.VERTICAL) {
            setsShapeVERTICAL(this.anchor);
        }
        else if (configuration == TetIConfiguration.HORIZONTAL) {
            setsShapeHORIZONTAL(this.anchor);
        }
    }

    public void setsShapeVERTICAL(Positions anchor) {
        Positions positionOne = new Positions(this.anchor.getX(), this.anchor.getY() - 2);
        Positions positionTwo = new Positions(this.anchor.getX(), this.anchor.getY() - 1);
        Positions positionThree = new Positions(this.anchor.getX(), this.anchor.getY() + 1);

        Positions[] positionsVERTCAL = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsVERTCAL;
    }

    public void setsShapeHORIZONTAL(Positions anchor) {
        Positions positionOne = new Positions(this.anchor.getX() - 2, this.anchor.getY());
        Positions positionTwo = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        Positions positionThree = new Positions(this.anchor.getX() + 1, this.anchor.getY());

        Positions[] positionsHORIZONTAL = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsHORIZONTAL;
    }
    public Positions[] getPositions() {
        return positions;
    }

    public void setPositions(Positions[] positions) {
        this.positions = positions;
    }


}

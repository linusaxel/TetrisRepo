import com.googlecode.lanterna.TextColor;

public class TetS extends Tetromino {
    private TetSConfiguration configuration;

    public TetS(Positions anchor, TetSConfiguration configuration, TextColor color) {
        super(anchor, color);
        this.configuration = configuration;

        if (configuration == TetSConfiguration.VERTICAL) {
            setsShapeVERTICAL(this.anchor);
        } else if (configuration == TetSConfiguration.HORIZONTAL) {
            setsShapeHORIZONTAL(this.anchor);
        }
    }

    public void setsShapeHORIZONTAL(Positions anchor) {
        Positions positionOne = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        Positions positionTwo = new Positions(this.anchor.getX(), this.anchor.getY() + 1);
        Positions positionThree = new Positions(this.anchor.getX() + 1, this.anchor.getY() + 1);

        Positions[] positionsHORIZONTAL = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsHORIZONTAL;
    }

    public void setsShapeVERTICAL(Positions anchor) {
        Positions positionOne = new Positions(this.anchor.getX(), this.anchor.getY() - 1);
        Positions positionTwo = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        Positions positionThree = new Positions(this.anchor.getX() - 1, this.anchor.getY() + 1);

        Positions[] positionsVERTCAL = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsVERTCAL;
    }

    public Positions[] getPositions() {
        return positions;
    }

    public void setPositions(Positions[] positions) {
        this.positions = positions;
    }
}

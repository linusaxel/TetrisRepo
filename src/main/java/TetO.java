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
        Positions positionOne = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        Positions positionTwo = new Positions(this.anchor.getX(), this.anchor.getY() - 1);
        Positions positionThree = new Positions(this.anchor.getX() - 1, this.anchor.getY() - 1);

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
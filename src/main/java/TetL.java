import com.googlecode.lanterna.TextColor;

public class TetL extends Tetromino{
    private TetLConfiguration configuration;

    public TetL(Positions anchor, TetLConfiguration configuration, TextColor color) {
        super(anchor, color);
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
        Positions positionOne = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        Positions positionTwo = new Positions(this.anchor.getX(), this.anchor.getY() + 1);
        Positions positionThree = new Positions(this.anchor.getX(), this.anchor.getY() + 2);

        Positions[] positionsDOWN = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsDOWN;
    }

    public void setsShapeLEFT(Positions anchor) {
        Positions positionOne = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        Positions positionTwo = new Positions(this.anchor.getX() - 2, this.anchor.getY());
        Positions positionThree = new Positions(this.anchor.getX(), this.anchor.getY() - 1);

        Positions[] positionsLEFT = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsLEFT;
    }

    public void setsShapeUP(Positions anchor) {
        Positions positionOne = new Positions(this.anchor.getX(), this.anchor.getY() - 2);
        Positions positionTwo = new Positions(this.anchor.getX(), this.anchor.getY() - 1);
        Positions positionThree = new Positions(this.anchor.getX() + 1, this.anchor.getY());

        Positions[] positionsUP = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsUP;
    }

    public void setsShapeRIGHT(Positions anchor) {
        Positions positionOne = new Positions(this.anchor.getX(), this.anchor.getY() + 1);
        Positions positionTwo = new Positions(this.anchor.getX() + 1, this.anchor.getY());
        Positions positionThree = new Positions(this.anchor.getX() + 2, this.anchor.getY());

        Positions[] positionsRIGHT = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsRIGHT;
    }

    public Positions[] getPositions() {
        return positions;
    }

    public void setPositions(Positions[] positions) {
        this.positions = positions;
    }
}



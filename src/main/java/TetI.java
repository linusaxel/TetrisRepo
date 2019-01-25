import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class TetI extends Tetromino{

    private TetIConfiguration configuration;
    private Positions positionOne;
    private Positions positionTwo;
    private Positions positionThree;


    public TetI(Positions anchor, TetIConfiguration configuration, TextColor color) {
        super(anchor, color);
        this.configuration = configuration;

        if (configuration == TetIConfiguration.VERTICAL) {
            setsShapeVERTICAL(this.anchor);
        }
        else if (configuration == TetIConfiguration.HORIZONTAL) {
            setsShapeHORIZONTAL(this.anchor);
        }
    }

    public void setsShapeVERTICAL(Positions anchor) {
        positionOne = new Positions(this.anchor.getX(), this.anchor.getY() - 2);
        positionTwo = new Positions(this.anchor.getX(), this.anchor.getY() - 1);
        positionThree = new Positions(this.anchor.getX(), this.anchor.getY() + 1);

        Positions[] positionsVERTCAL = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionsVERTCAL;
    }

    public void setsShapeHORIZONTAL(Positions anchor) {
        positionOne = new Positions(this.anchor.getX() - 2, this.anchor.getY());
        positionTwo = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        positionThree = new Positions(this.anchor.getX() + 1, this.anchor.getY());

        Positions[] positionsHORIZONTAL = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionsHORIZONTAL;
    }

    public Positions[] getPositions() {
        return positions;
    }

    public void setPositions(Positions[] positions) {
        this.positions = positions;
    }

    public Positions getAnchor() {
        return anchor;
    }

    public void setAnchor(Positions anchor) {
        this.anchor = anchor;
    }

    public void eraseFromTerminal(Terminal terminal, Positions[] positions) throws IOException {
        for (Positions position : positions) {
            terminal.setCursorPosition(position.getX(), position.getY());
            terminal.putCharacter(' ');
        }
    }

    public Positions getPositionOne() {
        return positionOne;
    }

    public Positions getPositionTwo() {
        return positionTwo;
    }

    public Positions getPositionThree() {
        return positionThree;
    }

    public TetIConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(TetIConfiguration configuration) {
        this.configuration = configuration;
    }
}

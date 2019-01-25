import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class TetS extends Tetromino {
    private TetSConfiguration configuration;
    private Positions positionOne;
    private Positions positionTwo;
    private Positions positionThree;



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
        positionOne = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        positionTwo = new Positions(this.anchor.getX(), this.anchor.getY() + 1);
        positionThree = new Positions(this.anchor.getX() + 1, this.anchor.getY() + 1);

        Positions[] positionsHORIZONTAL = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionsHORIZONTAL;
    }

    public void setsShapeVERTICAL(Positions anchor) {
        positionOne = new Positions(this.anchor.getX(), this.anchor.getY() - 1);
        positionTwo = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        positionThree = new Positions(this.anchor.getX() - 1, this.anchor.getY() + 1);

        Positions[] positionsVERTCAL = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionsVERTCAL;
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

    public TetSConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(TetSConfiguration configuration) {
        this.configuration = configuration;
    }
}

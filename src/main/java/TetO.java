import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class TetO extends Tetromino {
    private TetOConfiguration configuration;
    private Positions positionOne;
    private Positions positionTwo;
    private Positions positionThree;


    public TetO(Positions anchor, TetOConfiguration configuration, TextColor color) {
        super(anchor, color);
        this.configuration = configuration;

        if (configuration == TetOConfiguration.UP) {
            setsShapeUP(this.anchor);
        }
    }

    public void setsShapeUP(Positions anchor) {
        positionOne = new Positions(this.anchor.getX() + 1, this.anchor.getY());
        positionTwo = new Positions(this.anchor.getX(), this.anchor.getY() + 1);
        positionThree = new Positions(this.anchor.getX() + 1, this.anchor.getY() + 1);

        Positions[] positionsUP = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionsUP;
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

    public TetOConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(TetOConfiguration configuration) {
        this.configuration = configuration;
    }
}
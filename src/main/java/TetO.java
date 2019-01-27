import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class TetO extends Tetromino {
    private TetOConfiguration configuration;
    private Position positionOne;
    private Position positionTwo;
    private Position positionThree;


    public TetO(Position anchor, TetOConfiguration configuration, TextColor color) {
        super(anchor, color);
        this.configuration = configuration;

        if (configuration == TetOConfiguration.UP) {
            setsShapeUP(this.anchor);
        }
    }

    public void setsShapeUP(Position anchor) {
        positionOne = new Position(this.anchor.getX() + 1, this.anchor.getY());
        positionTwo = new Position(this.anchor.getX(), this.anchor.getY() + 1);
        positionThree = new Position(this.anchor.getX() + 1, this.anchor.getY() + 1);

        Position[] positionUP = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionUP;
    }

    public Position[] getPositions() {
        return positions;
    }

    public void setPositions(Position[] positions) {
        this.positions = positions;
    }

    public Position getAnchor() {
        return anchor;
    }

    public void setAnchor(Position anchor) {
        this.anchor = anchor;
    }


    public void eraseFromTerminal(Terminal terminal, Position[] positions) throws IOException {
        for (Position position : positions) {
            terminal.setCursorPosition(position.getX(), position.getY());
            terminal.putCharacter(' ');
        }
    }

    public Position getPositionOne() {
        return positionOne;
    }

    public Position getPositionTwo() {
        return positionTwo;
    }

    public Position getPositionThree() {
        return positionThree;
    }

    public TetOConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(TetOConfiguration configuration) {
        this.configuration = configuration;
    }
}
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class TetS extends Tetromino {
    private TetSConfiguration configuration;
    private TetSConfiguration futureConfiguration;
    private int configurationCount = 1;
    private Position positionOne;
    private Position positionTwo;
    private Position positionThree;


    public TetS(Position anchor, TetSConfiguration configuration, TextColor color) {
        super(anchor, color);
        this.configuration = configuration;

        if (configuration == TetSConfiguration.VERTICAL) {
            setsShapeVERTICAL(this.anchor);
        } else if (configuration == TetSConfiguration.HORIZONTAL) {
            setsShapeHORIZONTAL(this.anchor);
        }
    }

    public void setsShapeHORIZONTAL(Position anchor) {
        positionOne = new Position(this.anchor.getX() - 1, this.anchor.getY());
        positionTwo = new Position(this.anchor.getX(), this.anchor.getY() + 1);
        positionThree = new Position(this.anchor.getX() + 1, this.anchor.getY() + 1);

        Position[] positionHORIZONTAL = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionHORIZONTAL;
    }

    public void setsShapeVERTICAL(Position anchor) {
        positionOne = new Position(this.anchor.getX(), this.anchor.getY() - 1);
        positionTwo = new Position(this.anchor.getX() - 1, this.anchor.getY());
        positionThree = new Position(this.anchor.getX() - 1, this.anchor.getY() + 1);

        Position[] positionVERTCAL = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionVERTCAL;
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

    public TetSConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(TetSConfiguration configuration) {
        this.configuration = configuration;
    }

    public TetSConfiguration getFutureConfiguration() {
        return futureConfiguration;
    }

    public void setFutureConfiguration(TetSConfiguration futureConfiguration) {
        this.futureConfiguration = futureConfiguration;
    }

    public void rotate(Terminal terminal) throws Exception{
        eraseFromTerminal(terminal, this.positions);

        if (configurationCount == 1) {
            setsShapeVERTICAL(this.anchor);
            setConfiguration(TetSConfiguration.VERTICAL);
            setFutureConfiguration(TetSConfiguration.HORIZONTAL);
            configurationCount++;
        }
        else if (configurationCount == 2) {
            setsShapeHORIZONTAL(this.anchor);
            setConfiguration(TetSConfiguration.HORIZONTAL);
            setFutureConfiguration(TetSConfiguration.VERTICAL);
            configurationCount = 1;
        }

        printToTerminal(terminal, this.positions);
        terminal.flush();
    }
}

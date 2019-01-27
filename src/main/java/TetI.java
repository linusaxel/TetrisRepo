import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class TetI extends Tetromino{

    private TetIConfiguration configuration;
    private TetIConfiguration futureConfiguration;
    private Position positionOne;
    private int configurationCount = 1;
    private Position positionTwo;
    private Position positionThree;


    public TetI(Position anchor, TetIConfiguration configuration, TextColor color) {
        super(anchor, color);
        this.configuration = configuration;

        if (configuration == TetIConfiguration.VERTICAL) {
            setsShapeVERTICAL(this.anchor);
        }
        else if (configuration == TetIConfiguration.HORIZONTAL) {
            setsShapeHORIZONTAL(this.anchor);
        }
    }

    public void setsShapeVERTICAL(Position anchor) {
        positionOne = new Position(this.anchor.getX(), this.anchor.getY() - 2);
        positionTwo = new Position(this.anchor.getX(), this.anchor.getY() - 1);
        positionThree = new Position(this.anchor.getX(), this.anchor.getY() + 1);

        Position[] positionVERTCAL = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionVERTCAL;
    }

    public void setsShapeHORIZONTAL(Position anchor) {
        positionOne = new Position(this.anchor.getX() - 2, this.anchor.getY());
        positionTwo = new Position(this.anchor.getX() - 1, this.anchor.getY());
        positionThree = new Position(this.anchor.getX() + 1, this.anchor.getY());

        Position[] positionHORIZONTAL = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionHORIZONTAL;
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

    public TetIConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(TetIConfiguration configuration) {
        this.configuration = configuration;
    }

    public TetIConfiguration getFutureConfiguration() {
        return futureConfiguration;
    }

    public void setFutureConfiguration(TetIConfiguration futureConfiguration) {
        this.futureConfiguration = futureConfiguration;
    }

    public void rotate (Terminal terminal) throws Exception{
        eraseFromTerminal(terminal, this.positions);

        if (configurationCount == 1){
            setsShapeHORIZONTAL(this.anchor);
            setConfiguration(TetIConfiguration.HORIZONTAL);
            setFutureConfiguration(TetIConfiguration.VERTICAL);
            configurationCount++;
        } else if (configurationCount == 2) {
            setsShapeVERTICAL(this.anchor);
            setConfiguration(TetIConfiguration.VERTICAL);
            setFutureConfiguration(TetIConfiguration.HORIZONTAL);
            configurationCount = 1;
        }

        printToTerminal(terminal, this.positions);
        terminal.flush();
    }
}

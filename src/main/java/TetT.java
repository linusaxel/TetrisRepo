import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class TetT extends Tetromino{
    private TetTConfiguration configuration;
    private TetTConfiguration futureConfiguration;
    private int configurationCount = 1;
    private Position positionOne;
    private Position positionTwo;
    private Position positionThree;

    public TetT(Position anchor, TetTConfiguration configuration, TextColor color) {
        super(anchor, color);
        this.configuration = configuration;

        if (configuration == TetTConfiguration.UP) {
            setsShapeUP(this.anchor);
        } else if (configuration == TetTConfiguration.RIGHT) {
            setsShapeRIGHT(this.anchor);
        }
        else if (configuration == TetTConfiguration.DOWN) {
            setsShapeDOWN(this.anchor);
        }
        else if (configuration == TetTConfiguration.LEFT) {
            setsShapeLEFT(this.anchor);
        }
    }

    public void setsShapeDOWN(Position anchor) {
        positionOne = new Position(this.anchor.getX() - 1, this.anchor.getY());
        positionTwo = new Position(this.anchor.getX() + 1, this.anchor.getY());
        positionThree = new Position(this.anchor.getX(), this.anchor.getY() + 1);
        Position[] positionDOWN = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionDOWN;
    }

    public TetTConfiguration getFutureConfiguration() {
        return futureConfiguration;
    }

    public void setFutureConfiguration(TetTConfiguration futureConfiguration) {
        this.futureConfiguration = futureConfiguration;
    }

    public void setsShapeLEFT(Position anchor) {
        positionOne = new Position(this.anchor.getX(), this.anchor.getY() - 1);
        positionTwo = new Position(this.anchor.getX() - 1, this.anchor.getY());
        positionThree = new Position(this.anchor.getX(), this.anchor.getY() + 1);
        Position[] positionLEFT = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionLEFT;
    }

    public void setsShapeUP(Position anchor) {
        positionOne = new Position(this.anchor.getX() + 1, this.anchor.getY());
        positionTwo = new Position(this.anchor.getX(), this.anchor.getY() - 1);
        positionThree = new Position(this.anchor.getX() - 1, this.anchor.getY());
        Position[] positionUP = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionUP;
    }

    public void setsShapeRIGHT(Position anchor) {
        positionOne = new Position(this.anchor.getX(), this.anchor.getY() + 1);
        positionTwo = new Position(this.anchor.getX() + 1, this.anchor.getY());
        positionThree = new Position(this.anchor.getX(), this.anchor.getY() - 1);
        Position[] positionRIGHT = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionRIGHT;
    }

    public Position getAnchor() {
        return anchor;
    }

    public void setAnchor(Position anchor) {
        this.anchor = anchor;
    }

    public Position[] getPositions() {
        return positions;
    }

    public void setPositions(Position[] positions) {
        this.positions = positions;
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

    public TetTConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(TetTConfiguration configuration) {
        this.configuration = configuration;
    }

    public void rotate (Terminal terminal) throws Exception{
        eraseFromTerminal(terminal, this.positions);

        if (configurationCount == 1){
            setsShapeLEFT(this.anchor);
            setConfiguration(TetTConfiguration.LEFT);
            setFutureConfiguration(TetTConfiguration.UP);
            configurationCount++;
        } else if (configurationCount == 2) {
            setsShapeUP(this.anchor);
            setConfiguration(TetTConfiguration.UP);
            setFutureConfiguration(TetTConfiguration.RIGHT);
            configurationCount++;
        } else if (configurationCount == 3) {
            setsShapeRIGHT(this.anchor);
            setConfiguration(TetTConfiguration.RIGHT);
            setFutureConfiguration(TetTConfiguration.DOWN);
            configurationCount++;
        } else if (configurationCount == 4) {
            setsShapeDOWN(this.anchor);
            setConfiguration(TetTConfiguration.DOWN);
            setFutureConfiguration(TetTConfiguration.LEFT);
            configurationCount = 1;
        }

        printToTerminal(terminal, this.positions);
        terminal.flush();
    }


}

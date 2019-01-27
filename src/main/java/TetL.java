import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class TetL extends Tetromino{
    private TetLConfiguration configuration;
    private TetLConfiguration futureConfiguration;

    public TetLConfiguration getFutureConfiguration() {
        return futureConfiguration;
    }

    public void setFutureConfiguration(TetLConfiguration futureConfiguration) {
        this.futureConfiguration = futureConfiguration;
    }

    private int configurationCount = 1;
    private Position positionOne;
    private Position positionTwo;
    private Position positionThree;


    public TetL(Position anchor, TetLConfiguration configuration, TextColor color) {
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

    public void setsShapeDOWN(Position anchor) {
        positionOne = new Position(this.anchor.getX() - 1, this.anchor.getY());
        positionTwo = new Position(this.anchor.getX(), this.anchor.getY() + 1);
        positionThree = new Position(this.anchor.getX(), this.anchor.getY() + 2);

        Position[] positionDOWN = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionDOWN;
    }

    public void setsShapeLEFT(Position anchor) {
        positionOne = new Position(this.anchor.getX() - 1, this.anchor.getY());
        positionTwo = new Position(this.anchor.getX() - 2, this.anchor.getY());
        positionThree = new Position(this.anchor.getX(), this.anchor.getY() - 1);

        Position[] positionLEFT = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionLEFT;
    }

    public void setsShapeUP(Position anchor) {
        positionOne = new Position(this.anchor.getX(), this.anchor.getY() - 2);
        positionTwo = new Position(this.anchor.getX(), this.anchor.getY() - 1);
        positionThree = new Position(this.anchor.getX() + 1, this.anchor.getY());

        Position[] positionUP = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionUP;
    }

    public void setsShapeRIGHT(Position anchor) {
        positionOne = new Position(this.anchor.getX(), this.anchor.getY() + 1);
        positionTwo = new Position(this.anchor.getX() + 1, this.anchor.getY());
        positionThree = new Position(this.anchor.getX() + 2, this.anchor.getY());

        Position[] positionRIGHT = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionRIGHT;
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

    public TetLConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(TetLConfiguration configuration) {
        this.configuration = configuration;
    }

    public void rotate (Terminal terminal) throws Exception{
        eraseFromTerminal(terminal, this.positions);

        if (configurationCount == 1){
            setsShapeDOWN(this.anchor);
            setConfiguration(TetLConfiguration.DOWN);
            setFutureConfiguration(TetLConfiguration.LEFT);
            configurationCount++;
        } else if (configurationCount == 2) {
            setsShapeLEFT(this.anchor);
            setConfiguration(TetLConfiguration.LEFT);
            setFutureConfiguration(TetLConfiguration.UP);
            configurationCount++;
        } else if (configurationCount == 3) {
            setsShapeUP(this.anchor);
            setConfiguration(TetLConfiguration.UP);
            setFutureConfiguration(TetLConfiguration.RIGHT);
            configurationCount++;
        } else if (configurationCount == 4) {
            setsShapeRIGHT(this.anchor);
            setConfiguration(TetLConfiguration.RIGHT);
            setFutureConfiguration(TetLConfiguration.DOWN);
            configurationCount = 1;
        }

        printToTerminal(terminal, this.positions);
        terminal.flush();
    }
}



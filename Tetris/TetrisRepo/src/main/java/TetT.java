import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import javax.swing.*;
import java.io.IOException;

public class TetT extends Tetromino{
    private TetTConfiguration configuration;
    private Positions positionOne;
    private Positions positionTwo;
    private Positions positionThree;


    public TetT(Positions anchor, TetTConfiguration configuration, TextColor color) {
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

    public void setsShapeDOWN(Positions anchor) {
        positionOne = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        positionTwo = new Positions(this.anchor.getX() + 1, this.anchor.getY());
        positionThree = new Positions(this.anchor.getX(), this.anchor.getY() + 1);
        Positions[] positionsDOWN = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionsDOWN;
    }

    public void setsShapeLEFT(Positions anchor) {
        positionOne = new Positions(this.anchor.getX(), this.anchor.getY() - 1);
        positionTwo = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        positionThree = new Positions(this.anchor.getX(), this.anchor.getY() + 1);
        Positions[] positionsLEFT = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionsLEFT;
    }

    public void setsShapeUP(Positions anchor) {
        positionOne = new Positions(this.anchor.getX() + 1, this.anchor.getY());
        positionTwo = new Positions(this.anchor.getX(), this.anchor.getY() - 1);
        positionThree = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        Positions[] positionsUP = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionsUP;
    }

    public void setsShapeRIGHT(Positions anchor) {
        positionOne = new Positions(this.anchor.getX(), this.anchor.getY() + 1);
        positionTwo = new Positions(this.anchor.getX() + 1, this.anchor.getY());
        positionThree = new Positions(this.anchor.getX(), this.anchor.getY() - 1);
        Positions[] positionsRIGHT = {anchor, positionOne, positionTwo, positionThree};
        super.positions = positionsRIGHT;
    }

    public Positions getAnchor() {
        return anchor;
    }

    public void setAnchor(Positions anchor) {
        this.anchor = anchor;
    }

    public Positions[] getPositions() {
        return positions;
    }

    public void setPositions(Positions[] positions) {
        this.positions = positions;
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

    public TetTConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(TetTConfiguration configuration) {
        this.configuration = configuration;
    }


}

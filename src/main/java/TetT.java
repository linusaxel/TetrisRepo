import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import javax.swing.*;
import java.io.IOException;

public class TetT extends Tetromino{
    private TetTConfiguration configuration;

    public TetT(Positions anchor, TetTConfiguration configuration, TextColor color) throws Exception {
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
        Positions positionOne = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        Positions positionTwo = new Positions(this.anchor.getX() + 1, this.anchor.getY());
        Positions positionThree = new Positions(this.anchor.getX(), this.anchor.getY() + 1);

        Positions[] positionsDOWN = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsDOWN;
    }

    public void setsShapeLEFT(Positions anchor) {
        Positions positionOne = new Positions(this.anchor.getX(), this.anchor.getY() - 1);
        Positions positionTwo = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        Positions positionThree = new Positions(this.anchor.getX(), this.anchor.getY() + 1);

        Positions[] positionsLEFT = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsLEFT;
    }

    public void setsShapeUP(Positions anchor) {
        Positions positionOne = new Positions(this.anchor.getX() + 1, this.anchor.getY());
        Positions positionTwo = new Positions(this.anchor.getX(), this.anchor.getY() - 1);
        Positions positionThree = new Positions(this.anchor.getX() - 1, this.anchor.getY());

        Positions[] positionsUP = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsUP;
    }

    public void setsShapeRIGHT(Positions anchor) {
        Positions positionOne = new Positions(this.anchor.getX(), this.anchor.getY() + 1);
        Positions positionTwo = new Positions(this.anchor.getX() + 1, this.anchor.getY());
        Positions positionThree = new Positions(this.anchor.getX(), this.anchor.getY() - 1);

        Positions[] positionsRIGHT = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsRIGHT;
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

}

import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;

import javax.swing.*;
import java.io.IOException;

public class TetT {


    private char block = '\u2588';
    private Positions anchor;
    private Positions[] positions;

    public TetT (Positions anchor, Terminal terminal, KeyStroke keyStroke) throws Exception{
        this.anchor = anchor;

        TetTConfiguration configuration = TetTConfiguration.DOWN;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) {
            if (configuration == TetTConfiguration.UP) {
                configuration = TetTConfiguration.RIGHT;
            }
            else if (configuration == TetTConfiguration.RIGHT) {
                configuration = TetTConfiguration.DOWN;
            }
            else if (configuration == TetTConfiguration.DOWN) {
                configuration = TetTConfiguration.LEFT;
            }
            else if (configuration == TetTConfiguration.LEFT) {
                configuration = TetTConfiguration.UP;
            }
        }

        switch (configuration) {
            case UP:

                break;
            case DOWN:
                setsShapeDOWN(this.anchor);
                break;
            case LEFT:
                setsShapeLEFT(this.anchor);
                break;
            case RIGHT:

                break;
        }

    }

    public void setsShapeDOWN(Positions anchor) {
        Positions positionOne = new Positions(this.anchor.getX()-1, this.anchor.getY());
        Positions positionTwo = new Positions(this.anchor.getX() +1, this.anchor.getY());
        Positions positionThree = new Positions(this.anchor.getX(), this.anchor.getY()+1);

        Positions[] positionsUP = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsUP;
    }

    public void setsShapeLEFT(Positions anchor) {
        Positions positionOne = new Positions(this.anchor.getX(), this.anchor.getY() - 1);
        Positions positionTwo = new Positions(this.anchor.getX() - 1, this.anchor.getY());
        Positions positionThree = new Positions(this.anchor.getX(), this.anchor.getY()+ 1);

        Positions[] positionsUP = {anchor, positionOne, positionTwo, positionThree};
        this.positions = positionsUP;
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

    public void printToTerminal (Terminal terminal, Positions[] positions) throws IOException {

        for (Positions position : positions) {
            terminal.setCursorPosition(position.getX(), position.getY());
            terminal.putCharacter(this.block);
        }

    }
    public void eraseFromTerminal (Terminal terminal, Positions[] positions) throws IOException {
        for (Positions position : positions) {
            terminal.setCursorPosition(position.getX(), position.getY());
            terminal.putCharacter(' ');
        }
    }
}

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;
import org.w3c.dom.Text;

import java.io.IOException;

public abstract class Tetromino {

    protected Positions anchor;
    protected Positions[] positions;
    protected char block = '\u2588';
    protected TextColor color;

    public Tetromino(Positions anchor, TextColor color) {
        this.anchor = anchor;
        this.color = color;
    }


    public void eraseFromTerminal(Terminal terminal, Positions[] positions) throws IOException {

    }

    public Positions[] getPositions() {
        return positions;
    }

    public void setPositions(Positions[] positions) {
        this.positions = positions;
    }

    public void setAnchor(int x, int y) {
        Positions anchor = new Positions(x, y);
        this.anchor = anchor;
    }

    public void printToTerminal(Terminal terminal, Positions[] positions) throws IOException {
        for (Positions position : positions) {
            terminal.setCursorPosition(position.getX(), position.getY());
            terminal.setForegroundColor(this.color);
            terminal.putCharacter(this.block);
        }
    }

    public Positions getAnchor() {
        return anchor;
    }

    public void goDown (Positions[] positions) {
        for (Positions position : positions) {
            position.setY(position.getY() + 1);
        }
    }

    public void goRight (Positions[] positions) {
        for (Positions position : positions) {
            position.setX(position.getX() + 1);
        }
    }

    public void goLeft (Positions[] positions) {
        for (Positions position : positions) {
            position.setX(position.getX() - 1);
        }
    }




}

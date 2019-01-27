import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public abstract class Tetromino {

    protected Position anchor;
    protected Position[] positions;
    protected char block = '\u2588';
    protected TextColor color;

    public Tetromino(Position anchor, TextColor color) {
        this.anchor = anchor;
        this.color = color;
    }


    public void eraseFromTerminal(Terminal terminal, Position[] positions) throws IOException {
        for (Position position : positions) {
            terminal.setCursorPosition(position.getX(), position.getY());
            terminal.putCharacter(' ');
        }
    }

    public Position[] getPositions() {
        return positions;
    }

    public void setPositions(Position[] positions) {
        this.positions = positions;
    }

    public void setAnchor(int x, int y) {
        Position anchor = new Position(x, y);
        this.anchor = anchor;
    }

    public void printToTerminal(Terminal terminal, Position[] positions) throws IOException {
        for (Position position : positions) {
            terminal.setCursorPosition(position.getX(), position.getY());
            terminal.setForegroundColor(this.color);
            terminal.putCharacter(this.block);
        }
    }

    public Position getAnchor() {
        return anchor;
    }

    public void goDown (Position[] positions, Terminal terminal) throws Exception{
        eraseFromTerminal(terminal, this.positions);
        for (Position position : positions) {
            position.setY(position.getY() + 1);
        }
        printToTerminal(terminal, this.positions);
        terminal.flush();
    }

    public void goRight (Position[] positions, Terminal terminal) throws Exception{
        eraseFromTerminal(terminal, this.positions);
        for (Position position : positions) {
            position.setX(position.getX() + 1);
        }
        printToTerminal(terminal, this.positions);
        terminal.flush();
    }

    public void goLeft (Position[] positions, Terminal terminal) throws Exception {
        eraseFromTerminal(terminal, this.positions);
        for (Position position : positions) {
            position.setX(position.getX() - 1);
        }
        printToTerminal(terminal, this.positions);
        terminal.flush();
    }




}

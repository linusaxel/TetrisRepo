import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public abstract class Tetromino {

    protected Positions anchor;
    protected Positions[] positions;
    protected char block = '\u2588';

    public void printToTerminal(Terminal terminal, Positions[] positions) throws IOException {
        for (Positions position : positions) {
            terminal.setCursorPosition(position.getX(), position.getY());
            terminal.putCharacter(this.block);
        }
    }

    public void eraseFromTerminal(Terminal terminal, Positions[] positions) throws IOException {
        for (Positions position : positions) {
            terminal.setCursorPosition(position.getX(), position.getY());
            terminal.putCharacter(' ');
        }
    }

}

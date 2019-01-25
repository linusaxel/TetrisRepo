import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

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

    public void setAnchor(Positions anchor){
        this.anchor = anchor;
    }

    public void printToTerminal(Terminal terminal, Positions[] positions) throws IOException {
        for (Positions position : positions) {
            terminal.setCursorPosition(position.getX(), position.getY());
            terminal.setForegroundColor(this.color);
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

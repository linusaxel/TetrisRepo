import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;

public class TetrisConsole {


    private Terminal terminal;
    private Screen screen;
    private TextGraphics tg;

    public TetrisConsole() throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        this.terminal = terminalFactory.createTerminal();
        this.screen = new TerminalScreen(this.terminal);
        this.tg = this.screen.newTextGraphics();
        this.terminal.enterPrivateMode();
        this.screen.startScreen();
    }

    public void paintFigure(int row, int col, Figure fig) throws IOException {
        tg.setForegroundColor(fig.color);
        //tg.setBackgroundColor(TextColor.ANSI.WHITE);
        String symb = "\u20de";
        if (fig.shape == Shape.L_TETROMINO) {
            tg.putString(col, row, symb);
            tg.putString(col + 1, row, symb);
            tg.putString(col + 2, row, symb);
            tg.putString(col, row + 1, symb);
        } else if (fig.shape == Shape.O_TETROMINO) {
            tg.putString(col, row, symb);
            tg.putString(col, row + 1, symb);
            tg.putString(col + 1, row, symb);
            tg.putString(col + 1, row + 1, symb);
        } else if (fig.shape == Shape.I_TETROMINO) {
            tg.putString(col, row, symb);
            tg.putString(col, row + 1, symb);
            tg.putString(col, row + 2, symb);
            tg.putString(col, row + 3, symb);
        } else if (fig.shape == Shape.S_TETRAOMINO) {
            tg.putString(col, row, symb);
            tg.putString(col + 1, row, symb);
            tg.putString(col + 1, row + 1, symb);
            tg.putString(col + 2, row + 1, symb);
        } else if (fig.shape == Shape.T_TETROMINO) {
            tg.putString(col, row, symb);
            tg.putString(col - 1, row + 1, symb);
            tg.putString(col, row + 1, symb);
            tg.putString(col + 1, row + 1, symb);
        }
        screen.refresh();
    }

    public KeyStroke pollInput() throws IOException {
        return terminal.pollInput();
    }

    public void exit() throws IOException {
        screen.stopScreen();
    }


}

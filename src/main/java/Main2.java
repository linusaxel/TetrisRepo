import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws IOException, InterruptedException {
        //Setting up terminal
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);

        //Takes input as keystroke
        KeyStroke keyStroke = terminal.pollInput();

        int x = 3;
        int y = 3;

        //While no input from user, keep doing this loop
        keyStroke = null;
        int counter = 0;
        do {
            Thread.sleep(5); // might throw InterruptedException
            keyStroke = terminal.pollInput();
            counter++;
            if (counter % 50 == 0) {
                TetT tetT = new TetT(new Positions(x, y), terminal);
                tetT.printToTerminal(terminal, tetT.getPositions());
                terminal.flush(); // required one
                tetT.eraseFromTerminal(terminal, tetT.getPositions());
                y++;
            }
        } while (keyStroke == null);

        switch (keyStroke.getKeyType()) {
            case ArrowUp:

                break;
            case ArrowDown:

                break;
            case ArrowLeft:

                break;
            case ArrowRight:

                break;
        }


    }
}

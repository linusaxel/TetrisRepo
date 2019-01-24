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
            for (counter == 100) {
                TetT tetT = new TetT(new Positions(x, y), terminal);
                tetT.printToTerminal(terminal, tetT.getPositions());
                terminal.flush(); // required one
                Thread.sleep(500);
                terminal.flush();
                tetT.eraseFromTerminal(terminal, tetT.getPositions());
                terminal.flush();
                y++;
                terminal.flush();
            }
        } while (keyStroke == null);


        //Positions anchor = new Positions(3, 3);






//        TetT tetT2 = new TetT(new Positions(3, 7), terminal);


        terminal.flush();

    }
}

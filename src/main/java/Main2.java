import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import static com.googlecode.lanterna.input.KeyType.*;
import java.io.IOException;
import java.security.Key;

public class Main2 {

    public static void main(String[] args) throws Exception, IOException, InterruptedException {
        //Setting up terminal
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);
        int x = 3;
        int y = 3;
        while(true) {
            //Creates keystroke object, declares it as null
            KeyStroke keyStroke = null;

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
            //While no input from user, shape keeps going down
            //goDown(terminal, keyStroke = terminal.pollInput());

            switch (keyStroke.getKeyType()) {
                case ArrowUp:

                    break;
                case ArrowDown:

                    break;
                case ArrowLeft:
                    x--;
                    break;
                case ArrowRight:
                    x++;
                    break;
            }
        }
    }

    public static void goDown(Terminal terminal, KeyStroke keyStroke) throws IOException, InterruptedException {
        int x = 3;
        int y = 3;
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
    }
}

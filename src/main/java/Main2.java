import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Main2 {

    public static void main(String[] args) throws NullPointerException, Exception, IOException, InterruptedException {
        runTetris();
    }

    private static void runTetris () throws Exception, IOException, InterruptedException {

        //Setting up terminal, hides cursor
        Terminal terminal = setUpTerminal();

        //Set initial position for first shape
        Positions initialPosition = new Positions(3, 3);

        //Never-ending loop for movement of shapes
        while (true) {

            //Creates keystroke object, declares it as null
            KeyStroke keyStroke;

            int counter = 0;

            do {
                Thread.sleep(5);
                keyStroke = terminal.pollInput();
                counter++;
                terminal.flush();

                if (counter % 50 == 0) {
                    TetT tetT = new TetT(initialPosition,TetTConfiguration.DOWN);
                    tetT.setsShapeDOWN(tetT.getAnchor());
                    terminal.flush();
                    tetT.printToTerminal(terminal, tetT.getPositions());
                    terminal.flush();
                    tetT.eraseFromTerminal(terminal, tetT.getPositions());
                    terminal.flush();
                    initialPosition.setY(initialPosition.getY()+1);
                }

            } while (keyStroke == null);



            //While no input from user, shape keeps going down
            //goDown(terminal, keyStroke = terminal.pollInput());



            switch (keyStroke.getKeyType()) {
                case ArrowUp:
//                    TetT tetT = new TetT(new Positions(x, y), TetTConfiguration.LEFT);
                    break;
                case ArrowDown:
                    initialPosition.setY(initialPosition.getY()+1);
                    break;
                case ArrowLeft:
                    initialPosition.setX(initialPosition.getX()-1);
                    break;
                case ArrowRight:
                    initialPosition.setX(initialPosition.getX()+1);
                    break;
            }


        }


    }

    public static Terminal setUpTerminal() throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);
        return terminal;
    }

//    public static void goDown(Terminal terminal, KeyStroke keyStroke) throws Exception, InterruptedException {
//        int x = 3;
//        int y = 3;
//        int counter = 0;
//        do {
//            Thread.sleep(5); // might throw InterruptedException
//            keyStroke = terminal.pollInput();
//            counter++;
//            if (counter % 50 == 0) {
//                TetT tetT = new TetT(new Positions(x, y), keyStroke);
//                tetT.printToTerminal(terminal, tetT.getPositions());
//                terminal.flush(); // required one
//                tetT.eraseFromTerminal(terminal, tetT.getPositions());
//                y++;
//            }
//        } while (keyStroke == null);
//    }
}


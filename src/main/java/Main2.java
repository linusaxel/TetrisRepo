import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;

public class Main2 {

    public static void main(String[] args) throws NullPointerException, Exception, IOException, InterruptedException {
        runTetris();
    }

    private static void runTetris () throws Exception, IOException, InterruptedException {

        //Setting up terminal, hides cursor
        Terminal terminal = setUpTerminal();

        //Set initial position for first shape
        Positions currentPosition = new Positions(10, 1);

        //Emmas stuff
        Walls.createWalls(terminal);
        int configurationCountT = 1;
        int configurationCountS = 1;
        int configurationCountI = 1;
        int configurationCountL = 1;

        TetTConfiguration configT = TetTConfiguration.DOWN;
        TetSConfiguration configS = TetSConfiguration.HORIZONTAL;

        TetT tetT = new TetT(currentPosition, configT);
        TetS tetS = new TetS(currentPosition, configS);
        //Never-ending loop for movement of shapes
        while (true) {

            //Creates keystroke object, declares it as null
            KeyStroke keyStroke;

            int counter = 0;

            do {
                if (counter % 40 == 0) {
//                    tetT = new TetT(currentPosition,configT);
//                    terminal.flush();
//                    tetT.printToTerminal(terminal, tetT.getPositions());
//                    terminal.flush();
//                    tetT.eraseFromTerminal(terminal, tetT.getPositions());
                    tetS = new TetS(currentPosition,configS);
                    terminal.flush();
                    tetS.printToTerminal(terminal, tetS.getPositions());
                    terminal.flush();
                    tetS.eraseFromTerminal(terminal, tetS.getPositions());

                    currentPosition.setY(currentPosition.getY()+1);
                }

                Thread.sleep(10);
                keyStroke = terminal.pollInput();
                counter++;


            } while (keyStroke == null);



            //While no input from user, shape keeps going down
            //goDown(terminal, keyStroke = terminal.pollInput());



            switch (keyStroke.getKeyType()) {
                case ArrowUp:

//================================================================================================TetS
                    if (configurationCountS == 1) {
                        tetS.setsShapeLEFT(currentPosition);
                        configS = TetSConfiguration.VERTICAL;
                        configurationCountT++;
                    }
                    else if (configurationCountS == 2) {
                        tetS.setsShapeUP(currentPosition);
                        configS = TetSConfiguration.HORIZONTAL;
                        configurationCountT = 1;
                    }

                    //TetT tetT = new TetT(currentPosition, TetTConfiguration.LEFT);
//================================================================================================TetT
                    if (configurationCountT == 1) {
                        tetS.setsShapeLEFT(currentPosition);
                        configT = TetTConfiguration.LEFT;
                        configurationCountT++;
                    }
                    else if (configurationCountT == 2) {
                        tetS.setsShapeUP(currentPosition);
                        configT = TetTConfiguration.UP;
                        configurationCountT++;
                    }
                    else if (configurationCountT == 3) {
                        tetS.setsShapeRIGHT(currentPosition);
                        configT = TetTConfiguration.RIGHT;
                        configurationCountT++;
                    }
                    else if (configurationCountT == 4) {
                        tetS.setsShapeDOWN(currentPosition);
                        configT = TetTConfiguration.DOWN;
                        configurationCountT = 1;
                    }

                    break;
                case ArrowDown:
                    currentPosition.setY(currentPosition.getY()+1);
                    break;
                case ArrowLeft:
                    currentPosition.setX(currentPosition.getX()-1);
                    break;
                case ArrowRight:
                    currentPosition.setX(currentPosition.getX()+1);
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

//    public void checkIfEmpty(Terminal terminal, ArrayList<Positions> wall, Tetronimo) {
//        if ()
//    }

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


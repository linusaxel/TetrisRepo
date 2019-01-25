import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;

public class Main3 {

    public static void main(String[] args) throws NullPointerException, Exception, IOException, InterruptedException {
        runTetris();
    }

    private static void runTetris () throws Exception, IOException, InterruptedException {

        //Setting up terminal, hides cursor
        Terminal terminal = setUpTerminal();

        //Set initial position for first shape
        Positions currentPosition = new Positions(10, 1);

        //Emmas stuff
        //ArrayList<Positions> walls = Walls.getWallPositions();
        Walls.createWalls(terminal);
        int configurationCount = 1;

        TetTConfiguration config = TetTConfiguration.DOWN;
        TetT tetT = new TetT(currentPosition, config);
        //Never-ending loop for movement of shapes
        while (true) {

            //Creates keystroke object, declares it as null
            KeyStroke keyStroke;

            int counter = 0;
            boolean hitWall = false;

            do {
                if (counter % 40 == 0) {
                    tetT = new TetT(currentPosition,config);
                    terminal.flush();
                    tetT.printToTerminal(terminal, tetT.getPositions());
                    terminal.flush();
                    tetT.eraseFromTerminal(terminal, tetT.getPositions());
/*
                    for (Positions position : walls) {
                        if (position.getY() == currentPosition.getY() + 1 && position.getX() == currentPosition.getX()) {

                            ArrayList<Positions> fixedShapes = new ArrayList<>();

                            fixedShapes.add(tetT.getPositions()[0]);
                            fixedShapes.add(tetT.getPositions()[1]);
                            fixedShapes.add(tetT.getPositions()[2]);
                            fixedShapes.add(tetT.getPositions()[3]);
                            printFixedShapes(terminal, fixedShapes);

                            hitWall = true;
                            break;

                        }
                    }
*/


                    currentPosition.setY(currentPosition.getY()+1);
                }

                Thread.sleep(10);
                keyStroke = terminal.pollInput();
                counter++;


            } while (keyStroke == null || !hitWall);



            //While no input from user, shape keeps going down
            //goDown(terminal, keyStroke = terminal.pollInput());




            switch (keyStroke.getKeyType()) {
                case ArrowUp:
                    //TetT tetT = new TetT(currentPosition, TetTConfiguration.LEFT);


                    if (configurationCount == 1) {
                        tetT.setsShapeLEFT(currentPosition);
                        config = TetTConfiguration.LEFT;
                        configurationCount++;
                    }
                    else if (configurationCount == 2) {
                        tetT.setsShapeUP(currentPosition);
                        config = TetTConfiguration.UP;
                        configurationCount++;
                    }
                    else if (configurationCount == 3) {
                        tetT.setsShapeRIGHT(currentPosition);
                        config = TetTConfiguration.RIGHT;
                        configurationCount++;
                    }
                    else if (configurationCount == 4) {
                        tetT.setsShapeDOWN(currentPosition);
                        config = TetTConfiguration.DOWN;
                        configurationCount = 1;
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


    public static void printFixedShapes (Terminal terminal, ArrayList<Positions> fixedShapes) throws Exception{

        for (Positions position : fixedShapes) {
            terminal.setCursorPosition(position.getX(), position.getY());
            terminal.putCharacter('\u2588');
        }

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


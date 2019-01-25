import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main2 {

    static Positions[] line1 = new Positions[19];
    static Positions[] line2 = new Positions[19];
    static Positions[] line3 = new Positions[19];
    static Positions[] line4 = new Positions[19];
    static Positions[] line5 = new Positions[19];
    static Positions[] line6 = new Positions[19];
    static Positions[] line7 = new Positions[19];
    static Positions[] line8 = new Positions[19];
    static Positions[] line9 = new Positions[19];
    static Positions[] line10 = new Positions[19];
    static Positions[] line11 = new Positions[19];
    static Positions[] line12 = new Positions[19];
    static Positions[] line13 = new Positions[19];
    static Positions[] line14 = new Positions[19];
    static Positions[] line15 = new Positions[19];
    static Positions[] line16 = new Positions[19];
    static Positions[] line17 = new Positions[19];
    static Positions[] line18 = new Positions[19];
    static Positions[] line19 = new Positions[19];
    static final char block = '\u2588';


    static Positions[][] allLines = {line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11, line12, line13, line14, line15, line16, line17, line18, line19};

    public static void main(String[] args) throws NullPointerException, Exception, IOException, InterruptedException {
        //Setting up terminal, hides cursor
        Terminal terminal = setUpTerminal();

        do {
            //Calling main game method
            runTetris(terminal);
//            checkIfGameOver(terminal);
        } while (true);

//        System.out.println("GAME OVER");
//        System.exit(0);
    }

    private static void runTetris(Terminal terminal) throws Exception, IOException, InterruptedException {

        //Prints walls AND stores positions of walls in an ArrayList of positions
        ArrayList<Positions> walls = Walls.createWalls(terminal);


        while (true) {
            Positions currentPosition = new Positions(10, 1);
            //Creates a random tetromino (S, O, T, I or L type)
            Tetromino tetromino = createNewTetromino(currentPosition);



            //Counter used to change configuration (orientation) of shapes
            int configurationCount = 1;

            boolean tetKeepsMoving = true;

            while (tetKeepsMoving) {

                //Creates keystroke object, declares it as null
                KeyStroke keyStroke;

                int counter = 0;

                do {
                    //Downwards movement of shapes
                    if (counter % 30 == 0) {
                        terminal.flush();
                        tetromino.printToTerminal(terminal, tetromino.getPositions());
                        terminal.flush();

                        tetromino.eraseFromTerminal(terminal, tetromino.getPositions());
                        if (checkIfTetHitsBottom(tetromino.getPositions(), walls)) {
                            storeTetPositions(tetromino.getPositions(), allLines);
//                            printLines(terminal, allLines);

                            tetKeepsMoving = false;
                        } else {
                            tetromino.goDown(tetromino.getPositions());
                        }
                    }

                    Thread.sleep(10);
                    keyStroke = terminal.pollInput();
                    counter++;
//                    if (tetKeepsMoving = false) {
//                        break;
//                    }
                } while (keyStroke == null);

                switch (keyStroke.getKeyType()) {
                    case ArrowUp:
                        if (tetromino instanceof TetT) {
                            TetT tetT = (TetT) tetromino;
                            if (configurationCount == 1){
                                tetT.setsShapeLEFT(currentPosition);
                                tetT.setConfiguration(TetTConfiguration.LEFT);
                                configurationCount++;
                            } else if (configurationCount == 2) {
                                tetT.setsShapeUP(currentPosition);
                                tetT.setConfiguration(TetTConfiguration.UP);
                                configurationCount++;
                            } else if (configurationCount == 3) {
                                tetT.setsShapeRIGHT(currentPosition);
                                tetT.setConfiguration(TetTConfiguration.RIGHT);
                                configurationCount++;
                            } else if (configurationCount == 4) {
                                tetT.setsShapeDOWN(currentPosition);
                                tetT.setConfiguration(TetTConfiguration.DOWN);
                                configurationCount = 1;
                            }
                        } else if (tetromino instanceof TetS) {
                            TetS tetS = (TetS) tetromino;
                            if (configurationCount == 1){
                                tetS.setsShapeVERTICAL(currentPosition);
                                tetS.setConfiguration(TetSConfiguration.VERTICAL);
                                configurationCount++;
                            } else if (configurationCount == 2) {
                                tetS.setsShapeHORIZONTAL(currentPosition);
                                tetS.setConfiguration(TetSConfiguration.HORIZONTAL);
                                configurationCount = 1;
                            }
                        } else if (tetromino instanceof TetL) {
                            TetL tetL = (TetL) tetromino;
                            if (configurationCount == 1){
                                tetL.setsShapeDOWN(currentPosition);
                                tetL.setConfiguration(TetLConfiguration.DOWN);
                                configurationCount++;
                            } else if (configurationCount == 2) {
                                tetL.setsShapeLEFT(currentPosition);
                                tetL.setConfiguration(TetLConfiguration.LEFT);
                                configurationCount++;
                            } else if (configurationCount == 3) {
                                tetL.setsShapeUP(currentPosition);
                                tetL.setConfiguration(TetLConfiguration.UP);
                                configurationCount++;
                            } else if (configurationCount == 4) {
                                tetL.setsShapeRIGHT(currentPosition);
                                tetL.setConfiguration(TetLConfiguration.RIGHT);
                                configurationCount = 1;
                            }
                        } else if (tetromino instanceof TetI) {
                            TetI tetI = (TetI) tetromino;
                            if (configurationCount == 1){
                                tetI.setsShapeHORIZONTAL(currentPosition);
                                tetI.setConfiguration(TetIConfiguration.HORIZONTAL);
                                configurationCount++;
                            } else if (configurationCount == 2) {
                                tetI.setsShapeVERTICAL(currentPosition);
                                tetI.setConfiguration(TetIConfiguration.VERTICAL);
                                configurationCount = 1;
                            }
                        }
                        break;
                    case ArrowDown:
                        tetromino.eraseFromTerminal(terminal, tetromino.getPositions());

                        if (checkIfTetHitsBottom(tetromino.getPositions(), walls)) {
                            storeTetPositions(tetromino.getPositions(), allLines);
                            tetKeepsMoving = false;
                        } else {
                            tetromino.goDown(tetromino.getPositions());
                        }
                        break;
                    case ArrowLeft:
                        if (!checkIfTetHitsLeftWall(tetromino.getPositions(), walls)) {
                            tetromino.goLeft(tetromino.getPositions());
                        }
                        break;
                    case ArrowRight:
                        if (!checkIfTetHitsRightWall(tetromino.getPositions(), walls)) {
                            tetromino.goRight(tetromino.getPositions());
                        }
                        break;
                }
            }
        }

    }

    private static Tetromino createNewTetromino(Positions currentPosition) throws Exception {
        int randomTetronimo = new Random().nextInt(5);

        if (randomTetronimo == 0) {
            return new TetT(currentPosition, TetTConfiguration.DOWN, TextColor.ANSI.GREEN);
        } else if (randomTetronimo == 1) {
            return new TetS(currentPosition, TetSConfiguration.HORIZONTAL, TextColor.ANSI.WHITE);
        } else if (randomTetronimo == 2) {
            return new TetO(currentPosition, TetOConfiguration.UP, TextColor.ANSI.YELLOW);
        } else if (randomTetronimo == 3) {
            return new TetL(currentPosition, TetLConfiguration.RIGHT, TextColor.ANSI.MAGENTA);
        } else {
            return new TetI(currentPosition, TetIConfiguration.HORIZONTAL, TextColor.ANSI.RED);
        }
    }

    public static Terminal setUpTerminal() throws IOException {
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        terminal.setCursorVisible(false);
        return terminal;
    }

    public static boolean checkIfTetHitsLeftWall(Positions[] tetPositions, ArrayList<Positions> wall) {
        for (Positions position : tetPositions) {
            for (Positions wallPositions : wall) {
                if ((position.getY() == wallPositions.getY() && position.getX() - 1 == wallPositions.getX()))
                    return true;
            }
        }
        return false;
    }

    public static boolean checkIfTetHitsRightWall(Positions[] tetPositions, ArrayList<Positions> wall) {
        for (Positions position : tetPositions) {
            for (Positions wallPositions : wall) {
                if ((position.getY() == wallPositions.getY() && position.getX() + 1 == wallPositions.getX()))
                    return true;
            }
        }
        return false;
    }

    public static boolean checkIfTetHitsBottom(Positions[] tetPositions, ArrayList<Positions> wall) {
        for (Positions position : tetPositions) {
            for (Positions wallPositions : wall) {
                if ((position.getY() + 1 == wallPositions.getY() && position.getX() == wallPositions.getX()))
                    return true;
            }
        }
        return false;
    }

    public static void storeTetPositions(Positions[] tetPositions, Positions[][] allLines) {
        for (Positions position : tetPositions) {
            for (int i = 19; i > 0; i--) {
                if (position.getY() == i) {
                    allLines[i - 1][i - 1] = position;

                }
            }
        }
    }

    public static void printLines(Terminal terminal, Positions[][] allLines) throws Exception {
        for (Positions[] line : allLines) {
            for (Positions position : line) {
                terminal.setCursorPosition(position.getY(), position.getX());
                terminal.putCharacter(block);
            }
        }
    }
}



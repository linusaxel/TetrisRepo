import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    static Position[] line1 = new Position[19];
    static Position[] line2 = new Position[19];
    static Position[] line3 = new Position[19];
    static Position[] line4 = new Position[19];
    static Position[] line5 = new Position[19];
    static Position[] line6 = new Position[19];
    static Position[] line7 = new Position[19];
    static Position[] line8 = new Position[19];
    static Position[] line9 = new Position[19];
    static Position[] line10 = new Position[19];
    static Position[] line11 = new Position[19];
    static Position[] line12 = new Position[19];
    static Position[] line13 = new Position[19];
    static Position[] line14 = new Position[19];
    static Position[] line15 = new Position[19];
    static Position[] line16 = new Position[19];
    static Position[] line17 = new Position[19];
    static Position[] line18 = new Position[19];
    static Position[] line19 = new Position[19];
    static Position[][] allLines = {line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11, line12, line13, line14, line15, line16, line17, line18, line19};

    static final char block = '\u2588';

    public static void main(String[] args) throws Exception {

        MP3Player m = new MP3Player();
//        m.play("Tetris+Official+Theme+song.mp3", true);

        Terminal terminal = setUpTerminal();

        do {
            runTetris(terminal);
        } while (true);


    }

    private static void runTetris(Terminal terminal) throws Exception, IOException, InterruptedException {

        ArrayList<Position> walls = Walls.createWalls(terminal);
        KeyStroke keyStroke;

        while (true) {
            Tetromino tetromino = createNewTetromino();
            boolean tetKeepsMoving = true;

            int counter = 0;
            while (tetKeepsMoving) {

                //Moves down gradually
                do {
                    if (counter % 50 == 0) {
                        terminal.flush();
                        tetromino.printToTerminal(terminal, tetromino.getPositions());
                        terminal.flush();
                        tetromino.eraseFromTerminal(terminal, tetromino.getPositions());
                        if (ifTetHitsBottom(tetromino.getPositions(), walls)) {
                            storeTetPositions(tetromino.getPositions(), allLines);
                            tetKeepsMoving = false;
                        } else {
                            tetromino.goDown(tetromino.getPositions(), terminal);
                        }
                    }
                    counter++;
                    Thread.sleep(10);
                    keyStroke = terminal.pollInput();
                } while (keyStroke == null);

                switch (keyStroke.getKeyType()) {
                    case ArrowUp:
                        rotateTetrominoClockwise(tetromino, terminal, walls);
                        break;
                    case ArrowDown:
                        tetromino.eraseFromTerminal(terminal, tetromino.getPositions());
                        if (ifTetHitsBottom(tetromino.getPositions(), walls)) {
                            storeTetPositions(tetromino.getPositions(), allLines);
                            tetKeepsMoving = false;
                        } else {
                            tetromino.goDown(tetromino.getPositions(), terminal);
                        }
                        break;
                    case ArrowLeft:
                        if (!ifTetHitsLeftWall(tetromino.getPositions(), walls)) {
                            tetromino.goLeft(tetromino.getPositions(), terminal);
                        }
                        break;
                    case ArrowRight:
                        if (!ifTetHitsRightWall(tetromino.getPositions(), walls)) {
                            tetromino.goRight(tetromino.getPositions(), terminal);
                        }
                        break;
                }
            }
        }
    }

    private static void rotateTetrominoClockwise(Tetromino tetromino, Terminal terminal, ArrayList<Position> walls) throws Exception {
        if (tetromino instanceof TetT) {
            TetT tetT = (TetT) tetromino;
            if (!ifRotationHitsWall(tetT, walls)) {
                tetT.rotate(terminal);
            }
        } else if (tetromino instanceof TetS) {
            TetS tetS = (TetS) tetromino;
            if (!ifRotationHitsWall(tetS, walls)) {
                tetS.rotate(terminal);
            }
        } else if (tetromino instanceof TetL) {
            TetL tetL = (TetL) tetromino;
            if (!ifRotationHitsWall(tetL, walls)) {
                tetL.rotate(terminal);
            }
        } else if (tetromino instanceof TetI) {
            TetI tetI = (TetI) tetromino;
            if (!ifRotationHitsWall(tetI, walls)) {
                tetI.rotate(terminal);
            }
        }
    }

    private static Tetromino createNewTetromino() throws Exception {

        Position currentPosition = new Position(10, 1);

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

    public static boolean ifTetHitsLeftWall(Position[] tetPositions, ArrayList<Position> wall) {
        for (Position position : tetPositions) {
            for (Position wallPosition : wall) {
                if ((position.getY() == wallPosition.getY() && position.getX() - 1 == wallPosition.getX()))
                    return true;
            }
        }
        return false;
    }

    public static boolean ifTetHitsRightWall(Position[] tetPositions, ArrayList<Position> wall) {
        for (Position position : tetPositions) {
            for (Position wallPosition : wall) {
                if ((position.getY() == wallPosition.getY() && position.getX() + 1 == wallPosition.getX()))
                    return true;
            }
        }
        return false;
    }

    public static boolean ifTetHitsBottom(Position[] tetPositions, ArrayList<Position> wall) {
        for (Position position : tetPositions) {
            for (Position wallPosition : wall) {
                if ((position.getY() + 1 == wallPosition.getY() && position.getX() == wallPosition.getX()))
                    return true;
            }
        }
        return false;
    }

    public static boolean ifRotationHitsWall(Tetromino tetromino, ArrayList<Position> wall) {
        if (tetromino instanceof TetT) {
            if (tetromino.getAnchor().getX() == 1 && ((TetT) tetromino).getConfiguration().equals(TetTConfiguration.RIGHT)) {
                return true;
            }
            else if (tetromino.getAnchor().getX() == 19 && ((TetT) tetromino).getConfiguration().equals(TetTConfiguration.LEFT)) {
                return true;
            }
            return false;
        }
        else if (tetromino instanceof TetS) {
            if (tetromino.getAnchor().getX() == 19 && ((TetS) tetromino).getConfiguration().equals(TetSConfiguration.VERTICAL)) {
                return true;
            }
            return false;
        }
        else if (tetromino instanceof TetL) {
            if (tetromino.getAnchor().getX() == 1 && ((TetL) tetromino).getConfiguration().equals(TetLConfiguration.RIGHT)) {
                return true;
            }
            else if ((tetromino.getAnchor().getX() == 1 || tetromino.getAnchor().getX() == 2) && ((TetL) tetromino).getConfiguration().equals(TetLConfiguration.DOWN)) {
                return true;
            }
            else if (tetromino.getAnchor().getX() == 19 && ((TetL) tetromino).getConfiguration().equals(TetLConfiguration.LEFT)) {
                return true;
            }
            else if ((tetromino.getAnchor().getX() == 18 || tetromino.getAnchor().getX() == 19) && ((TetL) tetromino).getConfiguration().equals(TetLConfiguration.UP)) {
                return true;
            }
            return false;
        }
        else if (tetromino instanceof TetI) {
            if ((tetromino.getAnchor().getX() == 1 || tetromino.getAnchor().getX() == 2) && ((TetI) tetromino).getConfiguration().equals(TetIConfiguration.VERTICAL)) {
                return true;
            }
            else if (tetromino.getAnchor().getX() == 19 && ((TetI) tetromino).getConfiguration().equals(TetIConfiguration.VERTICAL)) {
                return true;
            }
            return false;
        }
        return true;
    }

    public static void storeTetPositions(Position[] tetPositions, Position[][] allLines) {
        for (Position position : tetPositions) {
            for (int i = 19; i > 0; i--) {
                if (position.getY() == i) {
                    allLines[i - 1][i - 1] = position;
                }
            }
        }
    }

    public static void printLines(Terminal terminal, Position[][] allLines) throws Exception {
        for (Position[] line : allLines) {
            for (Position position : line) {
                terminal.setCursorPosition(position.getY(), position.getX());
                terminal.putCharacter(block);
            }
        }
    }
}



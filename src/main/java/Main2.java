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

        MP3Player m = new MP3Player();
        m.play("Tetris Official Theme song.mp3", true);


        //Set initial position for first shape
        Positions currentPosition = new Positions(10, 1);

        //Emmas stuff
        Walls.createWalls(terminal);
        int configurationCountS = 1;
        int configurationCountI = 1;
        int configurationCountL = 1;
        int configurationCountT = 1;

        TetSConfiguration configS = TetSConfiguration.HORIZONTAL;
        TetOConfiguration configO = TetOConfiguration.UP;
        TetLConfiguration configL = TetLConfiguration.RIGHT;
        TetIConfiguration configI = TetIConfiguration.HORIZONTAL;
        TetTConfiguration configT = TetTConfiguration.UP;



        TetT tetT = new TetT(currentPosition, configT);
        TetS tetS = new TetS(currentPosition, configS);
        TetO tetO = new TetO(currentPosition, configO);
        TetL tetL = new TetL(currentPosition, configL);
        TetI tetI = new TetI(currentPosition, configI);


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

//                    tetS = new TetS(currentPosition,configS);
//                    terminal.flush();
//                    tetS.printToTerminal(terminal, tetS.getPositions());
//                    terminal.flush();
//                    tetS.eraseFromTerminal(terminal, tetS.getPositions());

                    tetO = new TetO(currentPosition,configO);
                    terminal.flush();
                    tetO.printToTerminal(terminal, tetO.getPositions());
                    terminal.flush();
                    tetO.eraseFromTerminal(terminal, tetO.getPositions());

//                    tetL = new TetL(currentPosition,configL);
//                    terminal.flush();
//                    tetL.printToTerminal(terminal, tetL.getPositions());
//                    terminal.flush();
//                    tetL.eraseFromTerminal(terminal, tetL.getPositions());

//                    tetI = new TetI(currentPosition,configI);
//                    terminal.flush();
//                    tetI.printToTerminal(terminal, tetI.getPositions());
//                    terminal.flush();
//                    tetI.eraseFromTerminal(terminal, tetI.getPositions());

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

//================================================================================================TetO

//================================================================================================TetL
                    if (configurationCountL == 1) {
                        tetT.setsShapeLEFT(currentPosition);
                        configL = TetLConfiguration.DOWN;
                        configurationCountL++;
                    }
                    else if (configurationCountL == 2) {
                        tetT.setsShapeUP(currentPosition);
                        configL = TetLConfiguration.LEFT;
                        configurationCountL++;
                    }
                    else if (configurationCountL == 3) {
                        tetT.setsShapeRIGHT(currentPosition);
                        configL = TetLConfiguration.UP;
                        configurationCountL++;
                    }
                    else if (configurationCountL == 4) {
                        tetT.setsShapeDOWN(currentPosition);
                        configL = TetLConfiguration.RIGHT;
                        configurationCountL = 1;
                    }


//================================================================================================TetI
                    if (configurationCountI == 1) {
                        tetI.setsShapeVERTICAL(currentPosition);
                        configI = TetIConfiguration.VERTICAL;
                        configurationCountI++;
                    }
                    else if (configurationCountI == 2) {
                        tetI.setsShapeHORIZONTAL(currentPosition);
                        configI = TetIConfiguration.HORIZONTAL;
                        configurationCountI = 1;
                    }


//================================================================================================TetS
                    if (configurationCountS == 1) {
                        tetS.setsShapeVERTICAL(currentPosition);
                        configS = TetSConfiguration.VERTICAL;
                        configurationCountS++;
                    }
                    else if (configurationCountS == 2) {
                        tetS.setsShapeHORIZONTAL(currentPosition);
                        configS = TetSConfiguration.HORIZONTAL;
                        configurationCountS = 1;
                    }

                    //TetT tetT = new TetT(currentPosition, TetTConfiguration.LEFT);
//================================================================================================TetT
                    if (configurationCountT == 1) {
                        tetT.setsShapeLEFT(currentPosition);
                        configT = TetTConfiguration.LEFT;
                        configurationCountT++;
                    }
                    else if (configurationCountT == 2) {
                        tetT.setsShapeUP(currentPosition);
                        configT = TetTConfiguration.UP;
                        configurationCountT++;
                    }
                    else if (configurationCountT == 3) {
                        tetT.setsShapeRIGHT(currentPosition);
                        configT = TetTConfiguration.RIGHT;
                        configurationCountT++;
                    }
                    else if (configurationCountT == 4) {
                        tetT.setsShapeDOWN(currentPosition);
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


//import com.googlecode.lanterna.TextColor;
//import com.googlecode.lanterna.input.KeyStroke;
//import com.googlecode.lanterna.terminal.Terminal;
//
//import javax.swing.text.Position;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        runTetris();
//    }
//
//    private static void runTetris() throws Exception {
//        TetrisConsole con = new TetrisConsole();
//
//        Figure figL = new Figure(Shape.L_TETROMINO, TextColor.ANSI.MAGENTA);
//        Figure figO = new Figure(Shape.O_TETROMINO, TextColor.ANSI.YELLOW);
//        Figure figS = new Figure(Shape.S_TETRAOMINO, TextColor.ANSI.WHITE);
//        Figure figT = new Figure(Shape.T_TETROMINO, TextColor.ANSI.GREEN);
//        Figure figI = new Figure(Shape.I_TETROMINO, TextColor.ANSI.RED);
//
//
//        KeyStroke keyStroke;
//
//        do {
//            con.paintFigure(10, 15, figL);
//            con.paintFigure(20, 25, figO);
//            con.paintFigure(15, 20, figS);
//            con.paintFigure(26, 30, figT);
//            con.paintFigure(5, 5, figI);
//
//            Thread.sleep(1000);
//
//            keyStroke = con.pollInput();
//        } while (keyStroke == null);
//        con.exit();
//
//        Walls walls = new Walls();
//        walls.createWalls();
//    }
//}
//


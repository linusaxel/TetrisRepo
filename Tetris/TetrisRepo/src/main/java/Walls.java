import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Walls {

    public static ArrayList<Positions> createWalls(Terminal terminal) throws Exception {

        //instantiating block char
        final char block = '\u2588';

        ArrayList<Positions> walls = new ArrayList<>();
        int x = 0;
        int y = 0;
        //Position position = new Position(x, y);

        //for wall upper left to right horizontally
        for (int i = 0; i < 20; i++) {
            terminal.setCursorPosition(x, y);
            terminal.putCharacter(block);
            x++;
            walls.add(new Positions(x, y));
//            walls.add(position);

        }
//for wall bottom right to left horizontally
        x = 20;
        y = 20;
        for (int i = 0; i < 21; i++) {
            terminal.setCursorPosition(x, y);
            terminal.putCharacter(block);
            x--;
            walls.add(new Positions(x, y));
        }
//for wall top to bottom y axis on the right side vertically
        x = 20;
        y = 0;
        for (int i = 0; i < 21; i++) {
            terminal.setCursorPosition(x, y);
            terminal.putCharacter(block);
            y++;
            walls.add(new Positions(x, y));
            //walls.add(position);

        }
//for wall bottom to top x axis on the left side vertically
        x = 0;
        y = 20;
        for (int i = 0; i < 21; i++) {
            terminal.setCursorPosition(x, y);
            terminal.putCharacter(block);
            y--;
            walls.add(new Positions(x, y));
        }

//Next figure board
        //instantiating block char
        //final char block2 = '\u2588';

        ArrayList<Positions> walls2 = new ArrayList<>();
        int s = 21;
        int t = 0;
        //Position position2 = new Position(s, t);

        //for wall upper left to right horizontally
        for (int i = 21; i < 36; i++) {
            terminal.setCursorPosition(s, t);
            terminal.putCharacter(block);
            s++;
            walls2.add(new Positions(s, t));
            //walls.add(position);
        }

        //for wall bottom right to left horizontally
        s = 36;
        t = 10;
        for (int i = 20; i < 36; i++) {
            terminal.setCursorPosition(s, t);
            terminal.putCharacter(block);
            s--;
            walls2.add(new Positions(s, t));
        }
//for wall top to bottom y axis on the right side vertically
        s = 36;
        t = 0;
        for (int i = 0; i < 10; i++) {
            terminal.setCursorPosition(s, t);
            terminal.putCharacter(block);
            t++;
            walls2.add(new Positions(s, t));
            //walls.add(position);

        }
//for wall bottom to top x axis on the left side vertically
        s = 0;
        t = 10;
        for (int i = 0; i < 10; i++) {
            terminal.setCursorPosition(s, t);
            terminal.putCharacter(block);
            t--;
            walls2.add(new Positions(s, t));

            String message = "Next Shape: ";
            for (int j = 0; j < message.length(); j++) {
                terminal.setCursorPosition(j + 22, 2);
                terminal.putCharacter(message.charAt(j));
           /* s= 22;
            t= 2;
            System.out.println("Next figure: ");
*/
            }
            //Score board
            //final char block3 = '\u2588';

            ArrayList<Positions> walls3 = new ArrayList<>();
            int c = 36;
            int v = 0;
            //Position position3 = new Position(c, v);


//for wall bottom right to left horizontally
            c = 36;
            v = 20;
            for (i = 20; i < 36; i++) {
                terminal.setCursorPosition(c, v);
                terminal.putCharacter(block);
                c--;
                walls3.add(new Positions(c, v));
            }
//for wall top to bottom y axis on the right side vertically
            c = 36;
            v = 10;
            for (i = 10; i < 21; i++) {
                terminal.setCursorPosition(c, v);
                terminal.putCharacter(block);
                v++;
                walls3.add(new Positions(c, v));
                //walls.add(position);

            }
//for wall bottom to top x axis on the left side vertically
            c = 0;
            v = 20;
            for (i = 10; i < 21; i++) {
                terminal.setCursorPosition(c, v);
                terminal.putCharacter(block);
                v--;
                walls3.add(new Positions(c, v));

                message = "Score: ";
                for (int j = 0; j < message.length(); j++) {
                    terminal.setCursorPosition(j + 22, 12);
                    terminal.putCharacter(message.charAt(j));

                }
            }
        }
        return walls;
    }

}


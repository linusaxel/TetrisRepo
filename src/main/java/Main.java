import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.text.Position;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {

        Walls walls = new Walls();
        walls.createWalls();
    }
}

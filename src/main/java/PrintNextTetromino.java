import com.googlecode.lanterna.terminal.Terminal;

public class PrintNextTetromino {
    private char block = '\u2588';


    public void printNextTetromino(Terminal terminal, Tetromino tetromino) throws Exception {
        if (tetromino instanceof TetS) {
            terminal.setCursorPosition(25, 5);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(26, 5);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(26, 6);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(27, 6);
            terminal.putCharacter(block);
            terminal.flush();
        } else if (tetromino instanceof TetL) {
            terminal.setCursorPosition(25, 5);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(26, 5);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(27, 5);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(25, 6);
            terminal.putCharacter(block);
            terminal.flush();
        } else if (tetromino instanceof TetI) {
            terminal.setCursorPosition(25, 5);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(26, 5);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(27, 5);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(28, 5);
            terminal.putCharacter(block);
            terminal.flush();
        } else if (tetromino instanceof TetT) {
            terminal.setCursorPosition(25, 5);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(26, 5);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(27, 5);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(26, 6);
            terminal.putCharacter(block);
            terminal.flush();
        } else if (tetromino instanceof TetO) {
            terminal.setCursorPosition(25, 5);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(26, 5);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(25, 6);
            terminal.putCharacter(block);
            terminal.flush();

            terminal.setCursorPosition(26, 6);
            terminal.putCharacter(block);
            terminal.flush();
        }
    }


    public void RemoveNextShapes(Terminal terminal, Tetromino tetromino) throws Exception {
        if (tetromino instanceof TetS) {
            terminal.setCursorPosition(25, 5);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(26, 5);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(26, 6);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(27, 6);
            terminal.putCharacter(' ');
            terminal.flush();
        } else if (tetromino instanceof TetL) {
            terminal.setCursorPosition(25, 5);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(26, 5);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(27, 5);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(25, 6);
            terminal.putCharacter(' ');
            terminal.flush();
        } else if (tetromino instanceof TetI) {
            terminal.setCursorPosition(25, 5);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(26, 5);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(27, 5);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(28, 5);
            terminal.putCharacter(' ');
            terminal.flush();
        } else if (tetromino instanceof TetT) {
            terminal.setCursorPosition(25, 5);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(26, 5);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(27, 5);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(26, 6);
            terminal.putCharacter(' ');
            terminal.flush();
        } else if (tetromino instanceof TetO) {
            terminal.setCursorPosition(25, 5);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(26, 5);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(25, 6);
            terminal.putCharacter(' ');
            terminal.flush();

            terminal.setCursorPosition(26, 6);
            terminal.putCharacter(' ');
            terminal.flush();
        }
    }
}

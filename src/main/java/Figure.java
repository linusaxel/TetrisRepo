import com.googlecode.lanterna.TextColor;

public class Figure {
    public Shape shape;
    public TextColor color;

    public Figure(Shape shape, TextColor color) {
        this.color = color;
        this.shape = shape;
    }
}


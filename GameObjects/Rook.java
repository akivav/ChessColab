package GameObjects;

import java.awt.*;
import java.util.List;

public class Rook extends piece {

    public Rook(Color color) {
        super(Type.ROOK, color);
    }

    @Override
    List<Point> getAllMoves(Point position) {
        return null;
    }

    @Override
    void makeAMove(Point position) {

    }
}
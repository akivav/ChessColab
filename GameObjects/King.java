package GameObjects;

import java.awt.*;
import java.util.List;

public class King extends piece {

    public King(Color color){
        super(Type.KING, color);
    }

    @Override
    List<Point> getAllMoves(Point position) {
        return null;
    }

    @Override
    void makeAMove(Point position) {

    }
}

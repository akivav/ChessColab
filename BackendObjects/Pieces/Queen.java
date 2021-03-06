package BackendObjects.Pieces;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import BackendObjects.BackendBoard;
import BackendObjects.BackendBoard.Type;

public class Queen extends Piece {

    public Queen(Color color) {
        super(Type.QUEEN, color);
    }

    @Override
    public void makeAMove(Point position) {
        this.position.x = position.x;
        this.position.y = position.y;
    }

    @Override
    public List<Point> getAllMoves(BackendBoard board) {
        Point origin = new Point();
        origin.x = this.position.x;
        origin.y = this.position.y;

        List<Point> moves = new ArrayList<>();


        Point destination = new Point(origin);

        /////////////////////////////// Slant ////////////////////////////////////

        while (isInBounds(destination.y-1) && isInBounds(destination.x-1)){
            destination.y--;
            destination.x--;
            if(hasEnemy(destination,board)){
                moves.add(new Point(destination));
                break;
            }
            if(!hasPlayerPiece(destination, origin, board)){
                moves.add(new Point(destination));
            } else
                break;
        }

        destination = new Point(origin);

        while (isInBounds(destination.y+1) && isInBounds(destination.x+1)){
            destination.y++;
            destination.x++;
            if(hasEnemy(destination,board)){
                moves.add(new Point(destination));
                break;
            }
            if(!hasPlayerPiece(destination, origin, board)){
                moves.add(new Point(destination));
            } else
                break;
        }

        destination = new Point(origin);

        while (isInBounds(destination.x-1) && isInBounds(destination.y+1)){
            destination.x--;
            destination.y++;
            if(hasEnemy(destination,board)){
                moves.add(new Point(destination));
                break;
            }
            if(!hasPlayerPiece(destination, origin, board)){
                moves.add(new Point(destination));
            } else
                break;
        }


        destination = new Point(origin);

        while (isInBounds(destination.x+1) && isInBounds(destination.y-1)){
            destination.x++;
            destination.y--;
            if(hasEnemy(destination,board)){
                moves.add(new Point(destination));
                break;
            }
            if(!hasPlayerPiece(destination, origin, board)){
                moves.add(new Point(destination));
            } else
                break;
        }

        ///////////////////////////// Straight //////////////////////////////////////

        destination = new Point(origin);

        while (isInBounds(destination.y-1)){
            destination.y--;
            if(hasEnemy(destination,board)){
                moves.add(new Point(destination));
                break;
            }
            if(!hasPlayerPiece(destination, origin, board)){
                moves.add(new Point(destination));
            } else
                break;
        }

        destination = new Point(origin);

        while (isInBounds(destination.y+1)){
            destination.y++;
            if(hasEnemy(destination,board)){
                moves.add(new Point(destination));
                break;
            }
            if(!hasPlayerPiece(destination, origin, board)){
                moves.add(new Point(destination));
            } else
                break;
        }

        destination = new Point(origin);

        while (isInBounds(destination.x-1)){
            destination.x--;
            if(hasEnemy(destination,board)){
                moves.add(new Point(destination));
                break;
            }
            if(!hasPlayerPiece(destination, origin, board)){
                moves.add(new Point(destination));
            } else
                break;
        }


        destination = new Point(origin);

        while (isInBounds(destination.x+1)){
            destination.x++;
            if(hasEnemy(destination,board)){
                moves.add(new Point(destination));
                break;
            }
            if(!hasPlayerPiece(destination, origin, board)){
                moves.add(new Point(destination));
            } else
                break;
        }
        ///////////////////////////////////////////////////////////////////////////

        return moves;
    }

    private boolean hasPlayerPiece(Point destination, Point origin, BackendBoard board) {
        if(board.getPiece(destination) == null){
            return false;
        } else if(board.getPiece(destination).getColor() == board.getPiece(origin).getColor())
            return true;
        return false;
    }


    private boolean hasEnemy(Point destination, BackendBoard board) {
        if (board.getPiece(destination) == null) {
            return false;
        }
        return board.getPiece(destination).color != this.color;
    }

}

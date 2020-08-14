package ru.job4j.chess.figures.black;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.getX() - source.getX());
        int deltaX = (int) Math.signum(dest.getX() - source.getX());
        int deltaY = (int) Math.signum(dest.getY() - source.getY());
        Cell[] steps = new Cell[size];
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(source.getX() + deltaX * (index + 1), source.getY()  + deltaY * (index + 1));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (Math.abs(dest.getX() - source.getX()) == Math.abs(dest.getY() - source.getY())) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}

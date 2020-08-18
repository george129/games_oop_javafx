package ru.job4j.chess;

import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public boolean move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        boolean rst = false;
        Cell[] steps = figures[index].way(source, dest);
        if (steps.length > 0 && steps[steps.length - 1].equals(dest) && free(steps)) {
            figures[index] = figures[index].copy(dest);
            rst = true;
        }
        return rst;
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
        for (int i = 0; i < steps.length; i++) {
            for (int k = 0; k < 32; k++) {
                if (figures[k].position().getX() == steps[i].getX()
                        && figures[k].position().getY() == steps[i].getY()) {
                    throw new OccupiedCellException();
                }
            }
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException();
    }
}
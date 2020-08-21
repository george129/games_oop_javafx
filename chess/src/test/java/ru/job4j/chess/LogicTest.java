package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;
import ru.job4j.chess.figures.black.BishopBlack;
import ru.job4j.chess.figures.black.PawnBlack;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Ignore
    @Test
    public void add() {
        Logic l = new Logic();
        l.add(new BishopBlack(Cell.F8));
        boolean res = false;
        try {
            res = l.move(Cell.F8, Cell.E7);
        } catch (Exception ex1) {
            System.out.println(ex1.getMessage());
        }
        Assert.assertEquals(true, res);
    }

    @Test
    public void moveNormal() throws ImpossibleMoveException, FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        boolean rsl = logic.move(Cell.F8, Cell.C5);
        assertThat(rsl, is(true));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void moveFail() throws ImpossibleMoveException, FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new PawnBlack(Cell.E7));
        boolean rsl = logic.move(Cell.F8, Cell.E8);
        assertThat(rsl, is(false));
    }


    @Test(expected = OccupiedCellException.class)
    public void free() throws ImpossibleMoveException, FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new PawnBlack(Cell.D6));
        logic.move(Cell.F8, Cell.D6);
    }

    @Test(expected = FigureNotFoundException.class)
    public void clean() throws ImpossibleMoveException, FigureNotFoundException, OccupiedCellException {
        Logic l = new Logic();
        l.add(new BishopBlack(Cell.F8));
        l.add(new BishopBlack(Cell.C8));
        l.clean();
        Exception ex = new Exception();
        l.move(Cell.C8, Cell.E6);
    }

}
package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.figures.Cell;
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
    public void moveNormal() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        boolean rsl = false;
        try {
            rsl = logic.move(Cell.F8, Cell.C5);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        assertThat(rsl, is(true));
    }

    @Test
    public void moveFail() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new PawnBlack(Cell.E7));
        Exception ex = new Exception();
        boolean rsl = false;
        try {
            rsl = logic.move(Cell.F8, Cell.E8);
        } catch (Exception ex1) {
            ex = ex1;
        }
        assertEquals(ex.getClass(), new ImpossibleMoveException().getClass());
        assertThat(rsl, is(false));
    }


    @Test
    public void free() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.F8));
        logic.add(new PawnBlack(Cell.D6));
        Exception ex = new Exception();
        try {
            logic.move(Cell.F8, Cell.D6);
        } catch (Exception ex1) {
            ex = ex1;
        }
        assertEquals(new OccupiedCellException().getClass(), ex.getClass());
    }

    @Test
    public void clean() {
        Logic l = new Logic();
        l.add(new BishopBlack(Cell.F8));
        l.add(new BishopBlack(Cell.C8));
        l.clean();
        Exception ex = new Exception();
        try {
            l.move(Cell.C8, Cell.E6);
        } catch (Exception ex1) {
            ex = ex1;
        }
        assertEquals(new FigureNotFoundException().getClass(), ex.getClass());
    }

}
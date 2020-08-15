package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.black.BishopBlack;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LogicTest {

    @Ignore
    @Test
    public void move() {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        boolean rsl = false;
        try {
            rsl = logic.move(Cell.C1, Cell.H6);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        assertThat(rsl, is(true));
    }
}
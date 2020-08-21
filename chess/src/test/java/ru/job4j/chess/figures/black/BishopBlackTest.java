package ru.job4j.chess.figures.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.figures.Cell;
import ru.job4j.chess.figures.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        Assert.assertEquals(Cell.C1, bb.position());
    }

    @Test
    public void copy() {
        Figure bb = new BishopBlack(Cell.C1);
        bb = bb.copy(Cell.D2);
        Assert.assertEquals(Cell.D2, bb.position());
    }

    @Test
    public void way() {
        BishopBlack bb = new BishopBlack(Cell.C8);
//        Cell[] way = bb.way(Cell.C8, Cell.D7);
//        for (int i = 0; i < 3; i++) {
//            System.out.println(way[i]);
//        }
        try {
            Assert.assertEquals(Cell.D7, bb.way(Cell.C8, Cell.D7)[0]);
            Assert.assertEquals(Cell.B7, bb.way(Cell.C8, Cell.B7)[0]);
        } catch (Exception ex) {

        }

    }

    @Test
    public void wrongPos() {
        BishopBlack bb = new BishopBlack(Cell.C1);
        StringBuilder msg = new StringBuilder("");
        try {
            bb.way(Cell.C1, Cell.G4);
        } catch (Exception ex) {
            msg.append(ex.getMessage());
//            System.out.println(ex.getMessage());
        }
        Assert.assertEquals("Could not way by diagonal from C1 to G4", msg.toString());
    }

}
package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    void whenPositionThenCellDotC8() {
        BishopBlack figureBBlack = new BishopBlack(Cell.C8);
        Cell output = figureBBlack.position();

        Cell expected = Cell.C8;
        assertThat(output).isEqualTo(expected);
    }

    @Test
    void whenCopyThenCellDotA0() {
        BishopBlack figureBBlack = new BishopBlack(Cell.C8);
        Figure output = figureBBlack.copy(Cell.A7);
        Figure expected = new BishopBlack(Cell.A7);
        assertThat(output.position()).isEqualTo(expected.position());
    }

    @Test
    void whenWayThenCellDotG5() {
        BishopBlack figureBBlack = new BishopBlack(Cell.C1);
        Cell[] output = figureBBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(output).isEqualTo(expected);
    }

    @Test
    void whenIsDiagonalThenTrue() {
        BishopBlack figureBBlack = new BishopBlack(Cell.C1);
        boolean output = figureBBlack.isDiagonal(Cell.C1, Cell.G5);
        assertThat(output).isTrue();
    }

    @Test
    void whenIsDiagonalThenFalse() {
        BishopBlack figureBBlack = new BishopBlack(Cell.C1);
        boolean output = figureBBlack.isDiagonal(Cell.C1, Cell.B1);
        assertThat(output).isFalse();
    }
}
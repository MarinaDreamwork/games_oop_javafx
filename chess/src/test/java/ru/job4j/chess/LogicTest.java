package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    void whenMoveThenOccupiedCellException() throws OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.A3));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.A3, Cell.C1);
        });
        assertThat(exception.getMessage()).isEqualTo("The place is occupied!");
    }

    @Test
    void whenMoveThenImpossibleMoveException() throws ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A5));
        logic.add(new BishopBlack(Cell.A6));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.A5, Cell.A6);
        });
        assertThat(exception.getMessage()).isEqualTo(
                "Could not move by diagonal from %s to %s", Cell.A5, Cell.A6
        );
    }
}
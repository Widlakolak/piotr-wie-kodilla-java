package com.kodilla.patterns.builder.checkers;

public class Checkers {

    private final Board board;
    private final String playerOne;
    private final String playerTwo;

    private Checkers(Board board, String playerOne, String playerTwo) {
        this.board = board;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Board getBoard() {
        return board;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public static class CheckersBuilder {

        private Board board = new Board();
        private String playerOne = "";
        private String playerTwo = "";

        public CheckersBuilder playerOne(String playerOne) {
            this.playerOne = playerOne;
            return this;
        }

        public CheckersBuilder playerTwo(String playerTwo) {
            this.playerTwo = playerTwo;
            return this;
        }

        public CheckersBuilder figure(String figureType, String figureColor, int x, int y) {   // [17]
            if (x > Board.MAX_INDEX || x < Board.MIN_INDEX ||                                   // [18]
                    y > Board.MAX_INDEX || y < Board.MIN_INDEX) {                                    // [19]
                throw new IllegalStateException("x and y should be in range between " +          // [20]
                        Board.MIN_INDEX + " and " + Board.MAX_INDEX);                                 // [21]
            }                                                                                   // [22]
            if (board.getFigure(x, y) == null) {                                                // [23]
                board.setFigure(FigureFactory.makeFigure(figureType, figureColor), x, y);        // [24]
            } else {                                                                            // [25]
                throw new IllegalStateException("Position " + x + "," + y + " is already occupied");// [26]
            }                                                                                   // [27]
            return this;                                                                        // [28]
        }                                                                                      // [29]

        public Checkers build() {                                                              // [30]
            if (playerOne.length() == 0) {                                                      // [31]
                throw new IllegalStateException("There is no player One specified!");            // [32]
            }                                                                                   // [33]
            if (playerTwo.length() == 0) {                                                      // [34]
                throw new IllegalStateException("There is no player Two specified");             // [35]
            }                                                                                   // [36]
            boolean white = false, black = false;                                               // [37]
            for (int x = Board.MIN_INDEX; x <= Board.MAX_INDEX; x++) {                          // [38]
                for (int y = Board.MIN_INDEX; y <= Board.MAX_INDEX; y++) {                       // [39]
                    Figure figure = board.getFigure(x, y);                                        // [40]
                    if (figure != null) {                                                         // [41]
                        if (figure.getColor().equals(Figure.BLACK)) {                              // [42]
                            black = true;                                                           // [43]
                        } else {                                                                   // [44]
                            white = true;                                                           // [45]
                        }                                                                          // [46]
                    }                                                                             // [47]
                }                                                                                // [48]
            }                                                                                   // [49]
            if (!(black && white)) {                                                            // [50]
                throw new IllegalStateException("There are no figures of both colors on the board!");// [51]
            }                                                                                   // [52]
            return new Checkers(board, playerOne, playerTwo);                                   // [53]
        };                                                                                     // [54]
    }                                                                                         // [55]
}
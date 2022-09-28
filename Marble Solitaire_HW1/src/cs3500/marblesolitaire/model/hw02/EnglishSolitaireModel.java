package cs3500.marblesolitaire.model.hw02;

import cs3500.marblesolitaire.model.hw02.GamePiece;

/**
 * Creating the class EnglishSolitaireModel and its constructor.
 */
public class EnglishSolitaireModel {
  private int armThickness;
  private  int emptyrow;
  private int emptycolumn;
  private GamePiece[][] gameBoard;
  private int Score;

  //(IllegalArgumentException)
  // arm thickness is not a positive odd number, or the empty cell position is invalid.
  // contructor 4;

  /**
   * EnglishSolitaireModel and its constructor.
   *
   * @param armThickness
   * @param row
   * @param column
   */
  public EnglishSolitaireModel(int armThickness, int row, int column) {
    if (armThickness > 0 && armThickness % 2 == 1 && row < armThickness + 2
            && row > armThickness - 2 && column < armThickness + 2 && column > armThickness - 2) {

      this.armThickness = armThickness;
      this.emptyrow = row;
      this.emptycolumn = column;
      this.Score = 0;
      int start = (armThickness - (armThickness / 2));
      int end = (armThickness + (armThickness / 2));
      int length = armThickness * 2 + 1;
      for (int r = start; r <= end; r++) {
        for (int c = start; c <= end; c++) {
          gameBoard[r][c].setMarble(true);
          this.Score++;

        }
      }
    } else {
      throw new IllegalArgumentException(" Needs to be corrected ");


    }

  }

  /**
   * methode for creating the amount of game board's
   * armThickness, row, column.
   */
  public EnglishSolitaireModel() {
    this(3, 3, 3);

  }

  /**
   * methode for creating the game board,
   * specifically the row and column on the board.
   *
   * @param row
   * @param column
   */
  public EnglishSolitaireModel(int row, int column) {
    if (row < armThickness + 2
            && row > armThickness - 2 && column < armThickness + 2 && column > armThickness - 2) {
      this.armThickness = 3;
      this.emptyrow = row;
      this.emptycolumn = column;
      this.Score = 0;
      int start = (armThickness - (armThickness / 2));
      int end = (armThickness + (armThickness / 2));
      int length = armThickness * 2 + 1;
      for (int r = start; r <= end; r++) {
        for (int c = start; c <= end; c++) {
          gameBoard[r][c].setMarble(true);
          this.Score++;
        }
      }
    } else {
      throw new IllegalArgumentException("Invalid empty cell position (r,c)");

    }
  }

  /**
   * methode for creating the game board,
   * specifically armThickness on the board.
   *
   * @param armThickness
   */
  public EnglishSolitaireModel(int armThickness) {
    this(armThickness, armThickness * 2 + 1, armThickness * 2 + 1);
  }
  public int getArmThickness(){
    return this.armThickness;
  }
  public void setArmThickness(int armThickness){
    this.armThickness = armThickness;
  }
  public int getEmptyrow(){
    return this.emptyrow;
  }
  public int getEmptycolumn() {
    return this.emptycolumn;
  }
  public int getScore() {
    return this.Score;
  }

  public void setScore(int Score) {
    this.Score = Score;
  }
  public GamePiece[][] getGameBoard(){
    return this.gameBoard;
  }
  public void setGameBoard(GamePiece[][] gameBoard) {
    this.gameBoard = gameBoard;
  }



//the ''from" and ''to" positions are valid. done

  //there is a marble at the specified ''from" position.


  //the ''to" position is empty.

  //the ''to" and ''from" positions are exactly two positions away (horizontally or vertically).

  //there is a marble in the slot between the ''to" and ''from" positions.
// move the marble

  /**
   * Methode allowes player to move the game pieces fowards and backwards
   * and backwords and fowards.
   *
   * @param startX
   * @param startY
   * @param endX
   * @param endY
   */
  public void move(int startX, int startY, int endX, int endY) {
    if (ValidHelper(startX, startY, endX, endY)) {
      gameBoard[startX][startY].setMarble(false);
      gameBoard[middleXHelper(startX, startY, endX, endY)]
              [middleYHelper(startX, startY, endX, endY)].setMarble(false);
      gameBoard[endX][endY].setMarble(true);
      this.Score--;

    } else {
      throw new IllegalArgumentException("Unset");
    }
  }

  /**
   * moveHelper Methode to help support the mover methode.
   *
   * @param x
   * @param y
   * @return support to the move method by allowing
   * it to move foward one place and back one place.
   */
  public boolean moveHelper(int x, int y) {
    if (x < armThickness + 2
            && x > armThickness - 2 && y < armThickness + 2 && y > armThickness - 2) {
      return true;

    }
    return false;

  }

  public boolean startEndHelper(int startX, int startY, int endX, int endY) {
    if (startX == endX && gameBoard[startX][startY + 1].getMarble()) {
      return true;

    } else if (startY == endY && gameBoard[startX + 1][startY].getMarble()) {
      return true;
    } else {
      return false;
    }


  }

  public boolean detectHelper(int startX, int startY, int endX, int endY) {
    if (startX == endX && Math.abs(startY - endY) == 2) {
      return true;

    } else if (startY == endY && Math.abs(startX - endX) == 2) {
      return true;
    } else {
      return false;
    }
  }

  public int middleXHelper(int startX, int startY, int endX, int endY) {
    if (startX == endX && gameBoard[startX][startY + 1].getMarble()) {
      return startX;

    } else if (startY == endY && gameBoard[startX + 1][startY].getMarble()) {
      return startX + 1;
    } else {
      return 0;
    }

  }

  public int middleYHelper(int startX, int startY, int endX, int endY) {
    if (startX == endX && gameBoard[startX][startY + 1].getMarble()) {
      return startY + 1;

    } else if (startY == endY && gameBoard[startX + 1][startY].getMarble()) {
      return startY;
    } else {
      return 0;
    }

  }

  // the game is over when there is no more legal moves left,
  // 1) max 4 legal moves or less ever peg
  // 20 will probably need a 4 loop
  public boolean isGameOver() {
    int start = (armThickness - (armThickness / 2));
    int end = (armThickness + (armThickness / 2));
    int length = armThickness * 2 + 1;
    for (int r = start; r <= end; r++) {
      for (int c = start; c <= end; c++) {
        if ((ValidHelper(r, c, (r + 2), c)) || (ValidHelper(r, c, (r - 2), c)) ||
                (ValidHelper(r, c, r, (c + 2))) || (ValidHelper(r, c, r, (c - 2)))) {
          return false;


        }


      }

    }
    return true;


  }


  public boolean ValidHelper(int startX, int startY, int endX, int endY) {
    if (moveHelper(startX, startY) && moveHelper(endX, endX)
            && gameBoard[startX][startY].getMarble()
            && !gameBoard[endX][endY].getMarble()
            && startEndHelper(startX, startY, endX, endY)
            && detectHelper(startX, startY, endX, endY)) {
      return true;
    } else {
      return false;
    }

  }
}







package cs3500.marblesolitaire.model.hw02;

/**
 * This class represents the game piece for the Marble board.
 */
public class GamePiece {
  private boolean hasMarble = false;



  public GamePiece() {

  }

  public boolean getMarble() {
    return hasMarble;
  }

  public void setMarble(boolean hasMarble) {
    this.hasMarble = hasMarble;
  }


}

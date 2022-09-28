package cs3500.marblesolitaire.view;
import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModelState;

public class MarbleSolitaireTextView implements MarbleSolitaireView {
  EnglishSolitaireModel game;

  public MarbleSolitaireTextView( MarbleSolitaireModelState game ) {
    if ( game != null){
      this.game = (EnglishSolitaireModel) game;
    }
    else{
      throw new IllegalArgumentException( "null" );
    }


  }


  public String  toString() {
    String s = "";
    int start = game.getArmThickness() - (game.getArmThickness() / 2);
    int end = game.getArmThickness() + (game.getArmThickness() / 2);
    int length = game.getArmThickness() * 2 + 1;
    for (int r = 0; r <= length; r++) {
      for (int c = 0; c <= length; c++) {
        if (r == game.getEmptyrow() && c == game.getEmptycolumn()) {
          s += " _ ";
        } else if ((r < start && c < start) || (r > end && c < start)) {
          s += " ";
        } else if ((r < start && c > end) || (r > end && c > end) || (r > start && r < end &&
                c == length)) {
          s += "\n";

        } else {
          s += "0";
        }


      }

    }
    return s;
  }
}



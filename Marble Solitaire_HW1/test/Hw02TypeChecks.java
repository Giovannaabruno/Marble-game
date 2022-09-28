import cs3500.marblesolitaire.model.hw02.EnglishSolitaireModel;
import cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel;


/**
 * Do not modify this file. This file should compile correctly with your code!
 */
public class Hw02TypeChecks {

  /**
   * A sample main method.
   *
   * @param args the program arguments
   */
  public static void main(String[] args) {
    helper((MarbleSolitaireModel) new EnglishSolitaireModel());
    helper((MarbleSolitaireModel) new EnglishSolitaireModel(2, 2));
    helper((MarbleSolitaireModel) new EnglishSolitaireModel(5));
    helper((MarbleSolitaireModel) new EnglishSolitaireModel(3, 0, 4));
  }

  private static void helper(cs3500.marblesolitaire.model.hw02.MarbleSolitaireModel model) {
    model.move(1, 3, 3, 3);
  }

}

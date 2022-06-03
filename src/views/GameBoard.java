package views;

import engine.Game;
import engine.GameListener;
import engine.Player;
import engine.PriorityQueue;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.abilities.Ability;
import model.abilities.AbilityListener;
import model.world.Champion;
import model.world.ChampionListener;

/** Not sure if I should implement {@link ChampionListener} and {@link AbilityListener} here, in {@link Game}
 * or somewhere completely different
  */
public class GameBoard implements GameListener, ChampionListener, AbilityListener {
    public Scene scene(double width, double height, Game game) {
        // setting the listener of the game, each champion and each ability to this class
        game.setListener(this);
        game.getFirstPlayer().getTeam().forEach(champion -> {
            champion.setListener(this);
            champion.getAbilities().forEach(ability -> ability.setListener(this));
        });
        game.getSecondPlayer().getTeam().forEach(champion -> {
            champion.setListener(this);
            champion.getAbilities().forEach(ability -> ability.setListener(this));
        });

        BorderPane container = new BorderPane();


        return new Scene(container, width, height);
    }

    @Override
    public void onBoardUpdated(Object[][] board) {

    }

    @Override
    public void onGameOver(Player winner) {

    }

    @Override
    public void onTurnOrderUpdated(PriorityQueue turnOrder) {

    }

    @Override
    public void onPlayerTeamUpdated(Player player) {

    }

    @Override
    public void onAbilityDetailsUpdated(Ability ability) {

    }

    @Override
    public void onChampionDetailsUpdated(Champion champion) {

    }
}

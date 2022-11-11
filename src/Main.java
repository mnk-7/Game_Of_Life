import controller.GameOfLifeConsoleStarter;
import service.boardGenerators.GeneratorFromFile;
import controller.GameOfLifeConsoleLauncher;
import controller.GameLauncher;

public class Main {

    public static void main(String[] args) {

        GameOfLifeConsoleStarter interaction = new GameOfLifeConsoleStarter();
        interaction.startInteraction();

        GameLauncher gameOfLife = new GameOfLifeConsoleLauncher(interaction.getAliveCharDisplayed(),
                interaction.getDeadCharDisplayed(), interaction.getRounds(),
                new GeneratorFromFile(interaction.getFilePath(),
                        interaction.getAliveCharInFile(), interaction.getDeadCharInFile()));

        gameOfLife.launchGame();

    }

}
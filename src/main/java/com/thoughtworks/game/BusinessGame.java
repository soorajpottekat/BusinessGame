package com.thoughtworks.game;
/*
 * Copyright (c) Multichoice Technical Operations. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Multichoice Technical Operations. ("Confidential Information"). You
 * shall not disclose such Confidential Information and shall use it
 * only in accordance with the terms of the license agreement you
 * entered into with Multichoice Technical Operations.
 *
 * MULTICHOICE MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
 * SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE, OR NON-INFRINGEMENT. MULTICHOICE
 * SHALL NOT BE LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT
 * OF USING, MODIFYING OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.
 */

import com.thoughtworks.cell.Cell;
import com.thoughtworks.cell.CellFactory;
import com.thoughtworks.board.GameBoard;
import com.thoughtworks.input.PropertyFileReader;
import com.thoughtworks.output.Printer;
import com.thoughtworks.output.ResultsPrinter;
import com.thoughtworks.player.Player;
import com.thoughtworks.player.PlayerComparator;
import com.thoughtworks.settings.Settings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Sooraj.Pottekat on 12/3/2017.
 *
 * @author Sooraj Pottekat
 */
public class BusinessGame
{

    private static final String DEFAULT_PATH = "./src/main/resources/input.properties";
    private String filePath;

    public BusinessGame(String filePath)
    {
        if (filePath == null)
            this.filePath = DEFAULT_PATH;
        else
            this.filePath = filePath;
    }

    public void start(Printer printer)
    {
        Settings settings = readSettings();
        List<Cell> cells = new CellFactory().createCells(settings.getCells());
        ArrayList<Player> players = createPlayers(settings.getNumberOfPlayers());
        rollDice(settings, new GameBoard(cells, players));
        printResults(players, printer);
    }

    private Settings readSettings()
    {
        Map<Object, Object> input = new PropertyFileReader(filePath).load();
        return new Settings(input);
    }

    private ArrayList<Player> createPlayers(Integer numberOfPlayers)
    {
        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 0; i < numberOfPlayers; i++)
            players.add(new Player("Player-" + (i + 1)));
        return players;
    }

    private void rollDice(Settings settings, GameBoard gameBoard)
    {
        for (Integer roll : settings.getRolls())
            gameBoard.roll(roll);
    }

    private void printResults(ArrayList<Player> players, Printer printer)
    {
        Collections.sort(players, new PlayerComparator());
        printer.print(players);
    }
}

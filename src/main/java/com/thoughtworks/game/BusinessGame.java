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

import com.thoughtworks.player.Player;

import java.util.ArrayList;

/**
 * Created by Sooraj.Pottekat on 11/28/2017.
 *
 * @author Sooraj Pottekat
 */
public class BusinessGame
{
    private final ArrayList<Player> players;
    private ArrayList<String> board;
    private int currentPlayerIndex;
    public BusinessGame(ArrayList<Player> players)
    {
        if(players.size() < 2)
            throw new IllegalArgumentException("Minimum two players required to start the game");
        this.players = players;
        currentPlayerIndex = 0;
    }

    public void setBoard(ArrayList<String> board)
    {
        this.board = board;
    }

    public String roll(int value)
    {
        if(value < 2 || value > 12)
            throw new IllegalArgumentException("The value should be with in range 2-12");
        int playerPosition = movePlayer(value);
        selectNextPlayer();
        return board.get((playerPosition - 1) % board.size());
    }
    private int movePlayer(int value)
    {
        Player player = players.get(currentPlayerIndex);
        int lastPosition = player.position();
        int playerPosition = lastPosition + value;
        player.move(playerPosition);
        return playerPosition;
    }
    private void selectNextPlayer()
    {
        currentPlayerIndex = ++currentPlayerIndex%players.size();
    }
}

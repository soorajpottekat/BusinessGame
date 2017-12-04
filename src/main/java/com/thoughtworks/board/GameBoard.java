package com.thoughtworks.board;
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
import com.thoughtworks.player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sooraj.Pottekat on 11/28/2017.
 *
 * @author Sooraj Pottekat
 */
public class GameBoard
{
    private final List<Player> players;
    private List<Cell> board;
    private int currentPlayerIndex;
    public GameBoard(List<Cell> board, List<Player> players)
    {
        if(players.size() < 2)
            throw new IllegalArgumentException("Minimum two players required to start the game");
        this.players = players;
        currentPlayerIndex = 0;
        this.board = board;
    }

    public void roll(int roll)
    {
        if(roll < 2 || roll > 12)
            throw new IllegalArgumentException("The value should be with in range 2-12");
        Player player = players.get(currentPlayerIndex);
        movePlayer(player,roll,player.position());
        board.get(player.position() -1).land(player);
        selectNextPlayer();
    }

    private void movePlayer(Player player, int roll, int lastPosition)
    {
        int effectivePosition = (lastPosition + roll) % board.size();
        effectivePosition = effectivePosition == 0 ? board.size() : effectivePosition;
        player.move(effectivePosition);
    }
    private void selectNextPlayer()
    {
        currentPlayerIndex = ++currentPlayerIndex%players.size();
    }
}

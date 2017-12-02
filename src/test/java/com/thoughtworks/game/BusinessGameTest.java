package com.thoughtworks.game;/*
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

import com.thoughtworks.game.BusinessGame;
import com.thoughtworks.player.Player;
import org.junit.Before;
import org.junit.Test;

import java.awt.image.VolatileImage;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by Sooraj.Pottekat on 11/28/2017.
 *
 * @author Sooraj Pottekat
 */
public class BusinessGameTest
{
    private BusinessGame businessGame;
    private Player firstPlayer;
    private Player secondPlayer;

    @Before
    public void setUp()
    {
        ArrayList<Player> players = new ArrayList<Player>();
        firstPlayer = new Player();
        secondPlayer = new Player();
        players.add(firstPlayer);
        players.add(secondPlayer);
        businessGame = new BusinessGame(players);
    }

    private void initialiseBoard(String[] boardInput)
    {
        ArrayList<String> board = new ArrayList<String>(Arrays.asList(boardInput));
        businessGame.setBoard(board);
    }

    private void verifyRoll(String boardInput, int roll)
    {
        String cell = businessGame.roll(roll);
        assertEquals(boardInput,cell);
    }


    @Test(expected = IllegalArgumentException.class)
    public void rollInvalidZero() throws Exception
    {
        businessGame.roll(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rollInvalidTwenty() throws Exception
    {
        businessGame.roll(20);
    }

    @Test
    public void rollTwoAllEmptyBoard() throws Exception
    {
        initialiseBoard(new String[]{"E"});
        verifyRoll("E", 2);
    }

    @Test
    public void rollTwoAllHotelBoard() throws Exception
    {
        initialiseBoard(new String[]{"H"});
        verifyRoll("H", 2);
    }
    @Test
    public void rollTwelve() throws Exception
    {
        initialiseBoard(new String[]{"J"});
        verifyRoll("J",12);
    }
    @Test
    public void rollFiveOnAMixBoard() throws Exception
    {
        initialiseBoard(new String[]{"E","J","H","T","T","J"});
        verifyRoll("T",5);
    }
    @Test
    public void rollWrapAround() throws Exception
    {
        initialiseBoard(new String[]{"E","J","H","T","T","J"});
        verifyRoll("E",7);
    }
    @Test(expected = IllegalArgumentException.class)
    public void initialiseGameWithPlayers() throws Exception
    {
        new BusinessGame(new ArrayList<Player>());
    }

    @Test
    public void firstPlayerRollTwoTwos() throws Exception
    {
        initialiseBoard(new String[]{"E","J","H","T","T","J"});
        businessGame.roll(2);
        businessGame.roll(2);
        businessGame.roll(2);
        assertEquals(4,firstPlayer.position());
    }

    @Test
    public void secondPlayerRollsOneTwo() throws Exception
    {
        initialiseBoard(new String[]{"E","J","H","T","T","J"});
        businessGame.roll(2);
        businessGame.roll(2);
        assertEquals(2,secondPlayer.position());
    }
}

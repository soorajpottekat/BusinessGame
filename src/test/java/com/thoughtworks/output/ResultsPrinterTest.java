package com.thoughtworks.output;

import com.thoughtworks.player.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

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

/**
 * Created by Sooraj.Pottekat on 12/4/2017.
 *
 * @author Sooraj Pottekat
 */
public class ResultsPrinterTest
{
    private ByteArrayOutputStream outPut;
    private ResultsPrinter printer;

    @Before
    public void setUp() throws Exception
    {
        outPut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outPut));
        printer = new ResultsPrinter();
    }

    @After
    public void cleanUp() throws Exception
    {
        System.setOut(System.out);
    }

    private void verifyResult(ArrayList<Player> players, String result)
    {
        printer.print(players);
        assertEquals(result,outPut.toString().trim());
    }

    @Test
    public void print1PlayerList() throws Exception
    {
        Player player = new Player("Player 1");
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player);
        verifyResult(players, "Player 1 has total worth 1000");
    }

    @Test
    public void multiplePlayersList() throws Exception
    {
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);
        printer.print(players);
        assertEquals("Player 1 has total worth 1000\r\nPlayer 2 has total worth 1000\r\n",outPut.toString());
    }
    @Test
    public void increasedPlayerAmount() throws Exception
    {
        Player name = new Player("Name");
        name.updateBalance(200);
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(name);
        verifyResult(players, "Name has total worth 1200");
    }

    @Test
    public void decreasedPlayerAmount() throws Exception
    {
        Player name = new Player("Name");
        name.updateBalance(-200);
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(name);
        verifyResult(players, "Name has total worth 800");
    }
}
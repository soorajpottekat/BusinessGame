package com.thoughtworks.game;

import com.thoughtworks.output.Printer;
import com.thoughtworks.player.Player;
import org.junit.Before;
import org.junit.Test;

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
public class BusinessGameTest
{

    private MockPrinter printer;

    @Before
    public void setUp() throws Exception
    {
        printer = new MockPrinter();
    }
    @Test
    public void defaultInput() throws Exception
    {
        String filePath = null;
        BusinessGame businessGame = new BusinessGame(filePath);
        businessGame.start(printer);
        assertEquals("Player-1 1200 Player-2 1200 Player-3 1050 ",printer.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void withInvalidUserInput() throws Exception
    {
        String filePath = "invalid";
        BusinessGame businessGame = new BusinessGame(filePath);
        businessGame.start(printer);
    }

    @Test
    public void withUserInput() throws Exception
    {
        String filePath = "./src/test/java/resources/testData.properties";
        BusinessGame businessGame = new BusinessGame(filePath);
        businessGame.start(printer);
        assertEquals("Player-1 1600 Player-2 1250 Player-4 950 Player-3 800 ",printer.toString());
    }
}
class MockPrinter implements Printer
{
    private String result = "";
    public void print(ArrayList<Player> players)
    {
        for (Player player: players)
            result += player.getName() +" " + player.effectiveBalance() + " ";
    }

    @Override
    public String toString()
    {
        return result;
    }
}
package com.thoughtworks.player;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
public class PlayerComparatorTest
{
    private Player firstPlayer;
    private List<Player> players;
    private Player secondPlayer;
    private Player thirdPlayer;
    private PlayerComparator comparator;

    @Before
    public void setUp() throws Exception
    {
        firstPlayer = new Player("");
        secondPlayer = new Player("");
        thirdPlayer = new Player("");
        players = new ArrayList<Player>();
        comparator = new PlayerComparator();
    }
    @Test
    public void oneEntryComparator() throws Exception
    {
        players.add(firstPlayer);
        Collections.sort(players,comparator);
        ArrayList<Player>expected = new ArrayList<Player>();
        expected.add(firstPlayer);
        assertEquals(expected,players);
    }
    @Test
    public void twoEntryWithSameValue() throws Exception
    {
        players = Arrays.asList(firstPlayer,secondPlayer);
        Collections.sort(players,comparator);
        List<Player>expected = Arrays.asList(firstPlayer,secondPlayer);
        assertEquals(expected,players);
    }
    @Test
    public void twoPlayerWithDifferentValue() throws Exception
    {
        players = Arrays.asList(firstPlayer,secondPlayer);
        firstPlayer.updateBalance(-1);
        Collections.sort(players,comparator);
        List<Player>expected = Arrays.asList(secondPlayer,firstPlayer);
        assertEquals(expected,players);
    }
    @Test
    public void threePlayersWithDifferentValues() throws Exception
    {
        players = Arrays.asList(firstPlayer,secondPlayer,thirdPlayer);
        firstPlayer.updateBalance(50);
        thirdPlayer.updateBalance(200);
        Collections.sort(players,comparator);
        List<Player>expected = Arrays.asList(thirdPlayer,firstPlayer,secondPlayer);
        assertEquals(expected,players);
    }
    @Test
    public void threePlayersWithNullValues() throws Exception
    {
        players = Arrays.asList(null,secondPlayer,null);
        Collections.sort(players,comparator);
        List<Player> expected = Arrays.asList(null,secondPlayer,null);
        assertEquals(expected,players);
    }
}

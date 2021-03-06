package com.thoughtworks.player;

import org.junit.Test;

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
 * Created by Sooraj.Pottekat on 12/2/2017.
 *
 * @author Sooraj Pottekat
 */
public class PlayerTest
{

    private Purchasable getPurchasableItem(final int value)
    {
        Purchasable purchasable = new Purchasable()
        {
            public int getValue()
            {
                return value;
            }
        };
        return purchasable;
    }

    @Test
    public void position() throws Exception
    {
        int position = new Player("").position();
        assertEquals(0,position);
    }
    @Test
    public void movePlayer() throws Exception
    {
        Player player = new Player("");
        player.move(4);
        assertEquals(4,player.position());
    }
    @Test
    public void testInitialBalance() throws Exception
    {
        Player player = new Player("");
        assertEquals(1000,player.accountBalance());
    }
    @Test
    public void addPositiveBalance() throws Exception
    {
        Player player = new Player("");
        player.updateBalance(200);
        assertEquals(1200,player.accountBalance());
    }
    @Test
    public void buyItem() throws Exception
    {
        Player player = new Player("");
        Purchasable purchasableItem = getPurchasableItem(200);
        player.purchaseItem(purchasableItem);
        assertEquals(1000,player.effectiveBalance());
        assertEquals(800,player.accountBalance());
    }
    @Test
    public void buyMultipleItem() throws Exception
    {
        Player player = new Player("");
        Purchasable purchasableItem1 = getPurchasableItem(200);
        Purchasable purchasableItem2 = getPurchasableItem(300);
        player.purchaseItem(purchasableItem1);
        player.purchaseItem(purchasableItem2);
        assertEquals(1000,player.effectiveBalance());
        assertEquals(500,player.accountBalance());
    }

    @Test(expected = IllegalArgumentException.class)
    public void maximumChances() throws Exception
    {
        Player player = new Player("");
        for (int i = 0; i < 11; i++)
        {
            player.move(3);
        }
    }
}
package com.thoughtworks.player;
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

import java.util.ArrayList;

/**
 * Created by Sooraj.Pottekat on 12/2/2017.
 *
 * @author Sooraj Pottekat
 */
public class Player
{
    private final String name;
    private int balance;
    private int position;
    private ArrayList<Purchasable> ownedItems;
    public Player(String name)
    {
        this.position = 0;
        this.balance = 1000;
        this.name = name;
        this.ownedItems = new ArrayList<Purchasable>();
    }

    public int position()
    {
        return position;
    }

    public void move(int position)
    {
        this.position = position;
    }

    public int accountBalance()
    {
        return balance;
    }

    public void updateBalance(int amount)
    {
        balance += amount;
    }

    public void purchaseItem(Purchasable item)
    {
        balance -= item.getValue();
        ownedItems.add(item);
    }

    public int effectiveBalance()
    {
        int effectiveBalance=balance;
        for (Purchasable item:ownedItems)
        {
            effectiveBalance += item.getValue();
        }
        return effectiveBalance;
    }

    public String getName()
    {
        return name;
    }
}

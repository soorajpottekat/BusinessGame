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

/**
 * Created by Sooraj.Pottekat on 12/2/2017.
 *
 * @author Sooraj Pottekat
 */
public class Player
{
    private int balance;
    private int position;
    public Player()
    {
        this.position = 0;
        this.balance = 1000;
    }

    public int position()
    {
        return position;
    }

    public void move(int position)
    {
        this.position = position;
    }

    public int getBalance()
    {
        return balance;
    }

    public void updateBalance(int amount)
    {
        balance += amount;
    }
}

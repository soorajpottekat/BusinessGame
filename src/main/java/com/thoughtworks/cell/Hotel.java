package com.thoughtworks.cell;
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

/**
 * Created by Sooraj.Pottekat on 12/2/2017.
 *
 * @author Sooraj Pottekat
 */
public class Hotel implements Cell
{
    private Player owner;
    public void land(Player player)
    {
        if(canBuy(player))
        {
            player.updateBalance(-200);
            this.owner = player;
        }
        else if(owner!= null && !player.equals(owner))
        {
            player.updateBalance(-50);
            owner.updateBalance(50);
        }

    }

    private boolean canBuy(Player player)
    {
        return owner == null && player.getBalance() >= 200;
    }
}

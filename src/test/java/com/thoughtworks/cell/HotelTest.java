package com.thoughtworks.cell;

import com.thoughtworks.player.Player;
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
public class HotelTest
{
    @Test
    public void landNonOwnedHotel() throws Exception
    {
        Player player = new Player("");
        new Hotel().land(player);
        assertEquals(800,player.accountBalance());
    }

    @Test
    public void landNonOwnedHotelWithNotEnoughBalance() throws Exception
    {
        Player player = new Player("");
        player.updateBalance(-801);
        new Hotel().land(player);
        assertEquals(199,player.accountBalance());
    }

    @Test
    public void landOnPreOwnedHotel() throws Exception
    {
        Player owner = new Player("");
        Player visitor = new Player("");
        Hotel hotel = new Hotel();
        hotel.land(owner);
        hotel.land(visitor);
        assertEquals(950,visitor.accountBalance());
        assertEquals(850,owner.accountBalance());
    }

    @Test
    public void ownerLandsOnTheHotel() throws Exception
    {
        Player owner = new Player("");
        Hotel hotel = new Hotel();
        hotel.land(owner);
        hotel.land(owner);
        assertEquals(800,owner.accountBalance());
    }

}
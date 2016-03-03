package com.epam.preprod.kushnarenko.serverCommands;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import java.math.BigDecimal;

import org.junit.Test;

import com.epam.preprod.kushnarenko.entity.MountainBike;
import com.epam.preprod.kushnarenko.logic.Shop;
import com.epam.preprod.kushnarenko.util.Const;

public class GetItemCommandTest {

	@Test
	public void test() throws Exception {
		int temp = 5;
		MountainBike mtb=new MountainBike();
		mtb.setPrice(new BigDecimal(temp));
		mtb.setId(temp);
		
		Shop shop = mock(Shop.class);

		when(shop.getItem(temp)).thenReturn(mtb);
		whenNew(Shop.class).withAnyArguments().thenReturn(shop);

		GetItemCommand c = spy(new GetItemCommand());
		when(c.getShopInstance()).thenReturn(shop);

		String actualResponse = c.execute(new Integer(temp).toString(), Const.TCP);

		assertEquals(temp +"|" + temp, actualResponse);
	}
}

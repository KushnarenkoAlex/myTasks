package com.epam.preprod.kushnarenko.serverCommands;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.epam.preprod.kushnarenko.logic.Shop;
import com.epam.preprod.kushnarenko.util.Const;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Shop.class)
public class GetCountCommandTest {

	@Test
	public void test() throws Exception {
		String size = "5";

		Shop shop = mock(Shop.class);
		
		when(shop.getCount()).thenReturn(size);
		whenNew(Shop.class).withAnyArguments().thenReturn(shop);
		
		GetCountCommand c = spy(new GetCountCommand());
		when(c.getShopInstance()).thenReturn(shop);

		String actualResponse = c.execute("", Const.TCP);
		
		assertEquals("Count: "+size, actualResponse);
	}

}
/*******************************************************************************
 * Copyright (c) 2001, 2008 Mathew A. Nelson and Robocode contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://robocode.sourceforge.net/license/cpl-v10.html
 *
 * Contributors:
 *     Pavel Savara
 *     - Initial implementation
 *******************************************************************************/
package components;


import org.junit.Test;
import helpers.Assert;
import robocode.peer.ExecCommands;
import robocode.peer.BulletCommand;
import robocode.peer.DebugProperty;
import robocode.peer.robot.TeamMessage;
import robocode.peer.serialize.RbSerializer;
import robocode.common.ObjectCloner;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ByteArrayInputStream;


/**
 * @author Pavel Savara (original)
 */
public class RbSerializerTest {
	@Test
	public void empty() throws IOException {
		ExecCommands ec = new ExecCommands();

		ec.setBodyTurnRemaining(150.123);
		ec.setTryingToPaint(true);

		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
		RbSerializer rbs = new RbSerializer();

		rbs.serialize(out, RbSerializer.ExecCommands_TYPE, ec);
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		ExecCommands ec2 = (ExecCommands) rbs.deserialize(in);

		Assert.assertNear(ec2.getBodyTurnRemaining(), ec.getBodyTurnRemaining());
		Assert.assertEquals(ec2.isTryingToPaint(), true);
	}

	@Test
	public void withBullets() throws IOException {
		ExecCommands ec = new ExecCommands();

		ec.setBodyTurnRemaining(150.123);
		ec.getBullets().add(new BulletCommand(1.0, true, 0.9354, 11));
		ec.getBullets().add(new BulletCommand(1.0, false, 0.9454, 12));
		ec.getBullets().add(new BulletCommand(1.0, true, 0.9554, -128));

		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
		RbSerializer rbs = new RbSerializer();

		rbs.serialize(out, RbSerializer.ExecCommands_TYPE, ec);
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		ExecCommands ec2 = (ExecCommands) rbs.deserialize(in);

		Assert.assertNear(ec2.getBodyTurnRemaining(), ec.getBodyTurnRemaining());
		Assert.assertNear(ec2.getBullets().get(0).getPower(), 1.0);
		Assert.assertEquals(ec2.getBullets().get(1).isFireAssistValid(), false);
		Assert.assertEquals(ec2.getBullets().get(2).isFireAssistValid(), true);
		Assert.assertEquals(ec2.getBullets().get(2).getBulletId(), -128);
	}

	@Test
	public void withMessages() throws IOException {
		ExecCommands ec = new ExecCommands();

		ec.setBodyTurnRemaining(150.123);
		ec.getBullets().add(new BulletCommand(1.0, true, 0.9354, 11));
		final byte[] data = new byte[20];

		data[10] = 10;
		ec.getTeamMessages().add(new TeamMessage("Foo", "Bar", data));
		ec.getTeamMessages().add(new TeamMessage("Foo", "Bar", null));

		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
		RbSerializer rbs = new RbSerializer();

		rbs.serialize(out, RbSerializer.ExecCommands_TYPE, ec);
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		ExecCommands ec2 = (ExecCommands) rbs.deserialize(in);

		Assert.assertEquals(ec2.getTeamMessages().get(0).message[0], 0);
		Assert.assertEquals(ec2.getTeamMessages().get(0).message[10], 10);
		Assert.assertEquals(ec2.getTeamMessages().get(0).sender, "Foo");
		Assert.assertEquals(ec2.getTeamMessages().get(0).recipient, "Bar");
		Assert.assertEquals(ec2.getTeamMessages().get(1).message, null);
	}

	@Test
	public void withProperties() throws IOException {
		ExecCommands ec = new ExecCommands();

		ec.setBodyTurnRemaining(150.123);
		ec.getBullets().add(new BulletCommand(1.0, true, 0.9354, 11));
		ec.getTeamMessages().add(new TeamMessage("Foo", "Bar", null));
		ec.getDebugProperties().add(
				new DebugProperty("UTF8 Native characters", "P��li� �lu�ou�k� k�� �p�l ��belsk� �dy"));

		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
		RbSerializer rbs = new RbSerializer();

		rbs.serialize(out, RbSerializer.ExecCommands_TYPE, ec);
		ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
		ExecCommands ec2 = (ExecCommands) rbs.deserialize(in);

		Assert.assertEquals(ec2.getDebugProperties().get(0).key, "UTF8 Native characters");
		Assert.assertEquals(ec2.getDebugProperties().get(0).value, "P��li� �lu�ou�k� k�� �p�l ��belsk� �dy");
	}

	@Test
	// 14 seconds for 1000 000,
	// 15x faster
	public void speed() throws IOException {
		ExecCommands ec = new ExecCommands();

		ec.setBodyTurnRemaining(150.123);
		ec.getBullets().add(new BulletCommand(1.0, true, 0.9354, 11));
		ec.getBullets().add(new BulletCommand(1.0, true, 0.9354, 11));
		ec.getBullets().add(new BulletCommand(1.0, true, 0.9354, 11));
		ec.getTeamMessages().add(new TeamMessage("Foo", "Bar", null));
		ec.getDebugProperties().add(new DebugProperty("ooooh", "aaaah"));

		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);

		for (int i = 0; i < 1000000; i++) {
			out.reset();
			ec.setGunColor(i);
			RbSerializer rbs = new RbSerializer();

			rbs.serialize(out, RbSerializer.ExecCommands_TYPE, ec);
			ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
			ExecCommands ec2 = (ExecCommands) rbs.deserialize(in);

			Assert.assertEquals(ec2.getGunColor(), i);
		}
	}

	// @Test
	// 21 seconds for 100 000
	public void speed2() throws IOException {
		ExecCommands ec = new ExecCommands();

		ec.setBodyTurnRemaining(150.123);
		ec.getBullets().add(new BulletCommand(1.0, true, 0.9354, 11));
		ec.getBullets().add(new BulletCommand(1.0, true, 0.9354, 11));
		ec.getBullets().add(new BulletCommand(1.0, true, 0.9354, 11));
		ec.getTeamMessages().add(new TeamMessage("Foo", "Bar", null));
		ec.getDebugProperties().add(new DebugProperty("ooooh", "aaaah"));

		ByteArrayOutputStream out = new ByteArrayOutputStream(1024);

		for (int i = 0; i < 100000; i++) {
			out.reset();
			ec.setGunColor(i);
			ExecCommands ec2 = (ExecCommands) ObjectCloner.deepCopy(ec);

			Assert.assertEquals(ec2.getGunColor(), i);
		}
	}

}
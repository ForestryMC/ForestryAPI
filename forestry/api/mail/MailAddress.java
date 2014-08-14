/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 * 
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.mail;

import java.util.Locale;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.entity.player.EntityPlayer;

import com.mojang.authlib.GameProfile;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

import forestry.api.core.INBTTagable;
import forestry.core.proxy.Proxies;
import forestry.core.network.EntityNetData;

public class MailAddress implements INBTTagable {
	@EntityNetData
	private String type;
	@EntityNetData
	private GameProfile gameProfile; // gameProfile is a fake GameProfile for traders, and real for players

	private static final MailAddress invalidAddress = new MailAddress();

	public MailAddress() {
		this.type = "invalid";
		this.gameProfile = new GameProfile(new UUID(0,0), "");
	}

	public MailAddress(GameProfile gameProfile) {
		this.type = "player";
		this.gameProfile = gameProfile;
	}

	public MailAddress(String name) {
		GameProfile profile = new GameProfile(new UUID(0, 0), name);
		this.type = "trader";
		this.gameProfile = profile;
	}

	public static MailAddress makeMailAddress(String name, String type) {
		if (StringUtils.isBlank(name)) return null;
		if (StringUtils.isBlank(type)) return null;

		if ("player".equals(type)) {
			GameProfile gameProfile = MinecraftServer.getServer().func_152358_ax().func_152655_a(name);
			return new MailAddress(gameProfile);
		} else {
			return new MailAddress(name);
		}
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return gameProfile.getName();
	}

	@Override
	public String toString() {
		String name = gameProfile.getName().toLowerCase(Locale.ENGLISH);
		if (isPlayer()) {
			return type + "-" + name + "-" + gameProfile.getId().toString();
		} else {
			return type + "-" + name;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof MailAddress))
			return false;

		MailAddress address = (MailAddress)o;
		return address.gameProfile.equals(gameProfile);
	}

	@Override
	public int hashCode() {
		return gameProfile.hashCode();
	}

	public boolean isPlayer() {
		return "player".equals(type);
	}

	public boolean isValid() {
		return !"invalid".equals(type);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbttagcompound) {
		if(nbttagcompound.hasKey("TP"))
			type = nbttagcompound.getString("TP");

		if ("invalid".equals(type)) {
			gameProfile = invalidAddress.gameProfile;
		} else if(nbttagcompound.hasKey("profile")) {
			NBTTagCompound profileTag = nbttagcompound.getCompoundTag("profile");
			gameProfile = NBTUtil.func_152459_a(profileTag);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbttagcompound) {
		nbttagcompound.setString("TP", type);

		if (gameProfile != null) {
			NBTTagCompound profileNbt = new NBTTagCompound();
			NBTUtil.func_152460_a(profileNbt, gameProfile);
			nbttagcompound.setTag("profile", profileNbt);
		}
	}

	public static MailAddress loadFromNBT(NBTTagCompound nbttagcompound) {
		MailAddress address = new MailAddress();
		address.readFromNBT(nbttagcompound);
		return address;
	}

	public EntityPlayer getPlayer(World world) {
		if (!this.isPlayer())
			throw new IllegalArgumentException("Address must be a player");

		GameProfile playerProfile = (GameProfile)this.gameProfile;

		return world.func_152378_a(playerProfile.getId());
	}

	public boolean isClientPlayer(World world) {
		if (!this.isPlayer())
			throw new IllegalArgumentException("Address must be a player");

		EntityPlayer addressPlayer = this.getPlayer(world);
		EntityPlayer clientPlayer = Proxies.common.getPlayer();

		return addressPlayer != null && clientPlayer != null && clientPlayer.equals(addressPlayer);
	}
}

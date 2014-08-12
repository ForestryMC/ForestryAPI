/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 * 
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.mail;

import forestry.core.utils.StringUtil;
import forestry.mail.EnumAddressee;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;

import com.mojang.authlib.GameProfile;

import forestry.api.core.INBTTagable;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.lang3.StringUtils;

public class MailAddress implements INBTTagable {
	private String type;
	private Object identifier; // identifier is a GameProfile if this.type is "player" and String for traders

	private MailAddress() {
	}

	public MailAddress(GameProfile identifier) {
		this(identifier, "player");
	}

    public MailAddress(String identifier) {
        this(identifier, "trader");
    }

    private MailAddress(Object identifier, String type) {
        this.identifier = identifier;
        this.type = type;
    }

    public static MailAddress makeMailAddress(String identifier, String type) {
        if (StringUtils.isBlank(identifier)) throw new IllegalArgumentException("identifier can't be blank.");
        if (StringUtils.isBlank(type)) throw new IllegalArgumentException("type can't be blank.");

        MailAddress mailAddress = new MailAddress();
        mailAddress.type = type;
        if (mailAddress.isPlayer())
            mailAddress.identifier = MinecraftServer.getServer().func_152358_ax().func_152655_a(identifier);
        else
            mailAddress.identifier = identifier;

        if (mailAddress.identifier == null)
            return null;
        return mailAddress;
    }

	public String getType() {
		return type;
	}

	public Object getIdentifier() {
		return this.identifier;
	}

    public String getIdentifierName() {
        if (isPlayer())
            return ((GameProfile)this.identifier).getName();
        else
            return (String)this.identifier;
    }

    @Override
    public String toString() {
        if (isPlayer()) {
            GameProfile profile = (GameProfile)this.identifier;
            return profile.getName() + ":" + profile.getId().toString();
        } else {
            return (String) this.identifier;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MailAddress))
            return false;

        MailAddress address = (MailAddress)o;
        return (address.getIdentifier().equals(this.getIdentifier()));
    }

    @Override
    public int hashCode() {
        return this.identifier.hashCode();
    }

	public boolean isPlayer() {
		return "player".equals(type);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbttagcompound) {
		if(nbttagcompound.hasKey("TP"))
			type = nbttagcompound.getString("TP");
		else
			type = nbttagcompound.getShort("TYP") == 0 ? "player" : "trader";

        if (isPlayer()) {
            if (nbttagcompound.hasKey("identifier")) {
                identifier = NBTUtil.func_152459_a(nbttagcompound.getCompoundTag("identifier"));
            }
        } else {
            identifier = nbttagcompound.getString("identifier");
        }
	}

	@Override
	public void writeToNBT(NBTTagCompound nbttagcompound) {
		nbttagcompound.setString("TP", type);

        if (isPlayer()) {
            NBTTagCompound profileNbt = new NBTTagCompound();
            NBTUtil.func_152460_a(profileNbt, (GameProfile)identifier);
            nbttagcompound.setTag("identifier", profileNbt);
        } else {
            nbttagcompound.setString("identifier", (String)identifier);
        }
	}

	public static MailAddress loadFromNBT(NBTTagCompound nbttagcompound) {
		MailAddress address = new MailAddress();
		address.readFromNBT(nbttagcompound);
		return address;
	}
}

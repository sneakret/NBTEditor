/*
 * Copyright (C) 2013-2015 Gonçalo Baltazar <me@goncalomb.com>
 *
 * This file is part of NBTEditor.
 *
 * NBTEditor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * NBTEditor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with NBTEditor.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.goncalomb.bukkit.nbteditor.bos;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import com.goncalomb.bukkit.nbteditor.nbt.ThrownPotionNBT;

public final class InventoryForThownPotion extends InventoryForSingleItem<ThrownPotionNBT> {
	
	private static ItemStack placeholder = createPlaceholder(Material.GLASS_BOTTLE, "§6The potion goes here.");
	
	public InventoryForThownPotion(BookOfSouls bos, Player owner) {
		super(bos, owner, "Define the potion here...", placeholder);
	}
	
	@Override
	protected boolean isValidItem(Player player, ItemStack item) {
		if (item.getType() != Material.POTION) {
			player.sendMessage("§cThat must be a must be a potion!");
			return false;
		}
		return true;
	}
	
	@Override
	protected void inventoryClose(InventoryCloseEvent event) {
		super.inventoryClose(event);
		((Player)event.getPlayer()).sendMessage("§aPotion set.");
	}

}

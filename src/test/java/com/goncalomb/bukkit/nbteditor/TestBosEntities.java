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

package com.goncalomb.bukkit.nbteditor;

import java.util.Arrays;
import java.util.HashSet;

import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.EntityType;
import org.junit.Test;

import com.goncalomb.bukkit.nbteditor.nbt.EntityNBT;

public class TestBosEntities {
	
	@Test
	public void testBosEntities() {
		HashSet<EntityType> entityTypes = new HashSet<EntityType>();
		entityTypes.addAll(Arrays.asList(EntityType.values()));
		entityTypes.removeAll(EntityNBT.getValidEntityTypes());
		if (!entityTypes.isEmpty()) {
			System.out.print("Missing BoS entities: ");
			System.out.print(StringUtils.join(entityTypes, ", "));
			System.out.println(".");
		}
	}

}

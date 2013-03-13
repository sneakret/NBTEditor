package com.goncalomb.bukkit.nbteditor.commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

import com.goncalomb.bukkit.betterplugin.BetterCommandException;
import com.goncalomb.bukkit.lang.Lang;

public abstract class HandItemWrapper<T extends ItemMeta> {
	
	public static final class Item extends HandItemWrapper<ItemMeta> {
		
		public Item(Player player) throws BetterCommandException {
			super(ItemMeta.class, player, true);
		}
		
	}
	
	public static final class Potion extends HandItemWrapper<PotionMeta> {
		
		public Potion(Player player) throws BetterCommandException {
			super(PotionMeta.class, player, true);
		}
		
	}
	
	public static final class Book extends HandItemWrapper<BookMeta> {
		
		public static enum BookType { BOTH, BOOK_AND_QUILL, WRITTEN }
		
		public Book(Player player, BookType bookType) throws BetterCommandException {
			super(BookMeta.class, player, (bookType == BookType.BOTH));
			if (meta == null) {
				throw new BetterCommandException(Lang._format("nbt.meta-error.format", Lang._("nbt.meta-error.book-" + (bookType == BookType.BOOK_AND_QUILL ? "quill" : "written"))));
			}
		}
		
	}
	
	public final ItemStack item;
	public final T meta;
	
	@SuppressWarnings("unchecked")
	private HandItemWrapper(Class<T> clazz, Player player, boolean throwEx) throws BetterCommandException {
		item = player.getItemInHand();
		if (item.getType() != Material.AIR) {
			ItemMeta m = item.getItemMeta();
			if (clazz.isInstance(m)) {
				meta = (T) m;
				return;
			}
		}
		meta = null;
		if (throwEx) {
			throw new BetterCommandException(Lang._format("nbt.meta-error.format", Lang._("nbt.meta-error." + this.getClass().getSimpleName().toLowerCase())));
		}
	}
	
	public void save() {
		item.setItemMeta(meta);
	}
	
}
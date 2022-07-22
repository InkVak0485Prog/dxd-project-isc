package net.mcreator.bvv.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.bvv.BvvMod;

import java.util.Random;
import java.util.Map;

public class KillProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BvvMod.LOGGER.warn("Failed to load dependency entity for procedure Kill!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				BvvMod.LOGGER.warn("Failed to load dependency itemstack for procedure Kill!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double xp = 0;
		xp = ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0);
		while (5 <= xp) {
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("\u043C\u0430\u0433\u0438\u0438").setDamageBypassesArmor(), (float) 5);
			}
			{
				ItemStack _ist = itemstack;
				if (_ist.attemptDamageItem((int) (5 * 1.25), new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		}
	}
}

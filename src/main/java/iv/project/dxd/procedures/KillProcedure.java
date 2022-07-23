package iv.project.dxd.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import java.util.Random;
import java.util.Map;

import iv.project.dxd.DxdProjectMod;

public class KillProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				DxdProjectMod.LOGGER.warn("Failed to load dependency entity for procedure Kill!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				DxdProjectMod.LOGGER.warn("Failed to load dependency itemstack for procedure Kill!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		double xp = 0;
		DxdProjectMod.LOGGER.info(("\u043F\u0440\u043E\u0432\u0435\u0440\u043A\u0430 XP:"
				+ ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0)));
		xp = ((entity instanceof PlayerEntity) ? ((PlayerEntity) entity).experienceLevel : 0);
		if (xp > 29) {
			DxdProjectMod.LOGGER.info("\u0430\u0442\u0430\u043A\u0430 50");
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("\u043C\u0430\u0433\u0438\u0438").setDamageBypassesArmor(), (float) 50);
			}
			{
				ItemStack _ist = itemstack;
				if (_ist.attemptDamageItem((int) (30 * 1.25), new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		} else if (xp > 14) {
			DxdProjectMod.LOGGER.info("\u0410\u0442\u0430\u043A\u0430 25");
			if (entity instanceof LivingEntity) {
				((LivingEntity) entity).attackEntityFrom(new DamageSource("\u043C\u0430\u0433\u0438\u0438").setDamageBypassesArmor(), (float) 25);
			}
			{
				ItemStack _ist = itemstack;
				if (_ist.attemptDamageItem((int) (15 * 1.25), new Random(), null)) {
					_ist.shrink(1);
					_ist.setDamage(0);
				}
			}
		} else if (xp > 4) {
			DxdProjectMod.LOGGER.info("\u0410\u0442\u0430\u043A\u0430 5");
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
		DxdProjectMod.LOGGER.info("\u0417\u0430\u0432\u0435\u0440\u0448\u0435\u043D\u043E");
	}
}

package net.mcreator.bvv.procedures;

import net.minecraftforge.energy.CapabilityEnergy;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;

import net.mcreator.bvv.BvvMod;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Map;

public class PowerKrasnyiKamienVklProcedure {

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BvvMod.LOGGER.warn("Failed to load dependency world for procedure PowerKrasnyiKamienVkl!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BvvMod.LOGGER.warn("Failed to load dependency x for procedure PowerKrasnyiKamienVkl!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BvvMod.LOGGER.warn("Failed to load dependency y for procedure PowerKrasnyiKamienVkl!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BvvMod.LOGGER.warn("Failed to load dependency z for procedure PowerKrasnyiKamienVkl!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		while (new Object() {
			public boolean canReceiveEnergy(IWorld world, BlockPos pos) {
				AtomicBoolean _retval = new AtomicBoolean(false);
				TileEntity _ent = world.getTileEntity(pos);
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> _retval.set(capability.canReceive()));
				return _retval.get();
			}
		}.canReceiveEnergy(world, new BlockPos(x, y, z))) {
			{
				TileEntity _ent = world.getTileEntity(new BlockPos(x, y, z));
				int _amount = (int) 1;
				if (_ent != null)
					_ent.getCapability(CapabilityEnergy.ENERGY, null).ifPresent(capability -> capability.receiveEnergy(_amount, false));
			}
		}
	}
}

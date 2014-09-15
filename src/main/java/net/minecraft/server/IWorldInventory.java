package net.minecraft.server;

public interface IWorldInventory extends IInventory {

   int[] a(EnumFacing var1);

   boolean a(int var1, ItemStack var2, EnumFacing var3);

   boolean b(int var1, ItemStack var2, EnumFacing var3);
}

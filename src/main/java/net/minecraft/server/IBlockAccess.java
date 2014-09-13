package net.minecraft.server;

public interface IBlockAccess {

   TileEntity s(Location var1);

   IBlock getData(Location var1);

   boolean d(Location var1);

   int a(Location var1, EnumFacing var2);
}

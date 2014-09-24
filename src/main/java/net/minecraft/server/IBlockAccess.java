package net.minecraft.server;

public interface IBlockAccess {

   TileEntity getTileEntity(Location var1);

   IBlockData getData(Location var1);

   boolean isEmpty(Location var1);

   int a(Location var1, EnumFacing var2);
}

package net.minecraft.server;
import java.util.Iterator;

public abstract class BlockLogAbstract extends BlockRotatable {

   public static final bev a = bev.a("axis", axo.class);


   public BlockLogAbstract() {
      super(Material.WOOD);
      this.a(CreativeModeTab.b);
      this.c(2.0F);
      this.a(f);
   }

   public void remove(World var1, Location var2, IBlockData var3) {
      byte var4 = 4;
      int var5 = var4 + 1;
      if(var1.a(var2.a(-var5, -var5, -var5), var2.a(var5, var5, var5))) {
         Iterator var6 = Location.a(var2.a(-var4, -var4, -var4), var2.a(var4, var4, var4)).iterator();

         while(var6.hasNext()) {
            Location var7 = (Location)var6.next();
            IBlockData var8 = var1.getData(var7);
            if(var8.c().getMaterial() == Material.LEAVES && !((Boolean)var8.b(BlockLeaves.b)).booleanValue()) {
               var1.a(var7, var8.a(BlockLeaves.b, Boolean.valueOf(true)), 4);
            }
         }

      }
   }

   public IBlockData getPlacedData(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return super.getPlacedData(var1, var2, var3, var4, var5, var6, var7, var8).a(a, axo.a(var3.k()));
   }

}

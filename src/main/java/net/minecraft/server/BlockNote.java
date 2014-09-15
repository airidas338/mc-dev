package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.List;

public class BlockNote extends BlockContainer {

   private static final List a = Lists.newArrayList(new String[]{"harp", "bd", "snare", "hat", "bassattack"});


   public BlockNote() {
      super(Material.WOOD);
      this.a(CreativeModeTab.d);
   }

   public void a(World var1, Location var2, IBlockData var3, Block var4) {
      boolean var5 = var1.z(var2);
      TileEntity var6 = var1.s(var2);
      if(var6 instanceof TileEntityNote) {
         TileEntityNote var7 = (TileEntityNote)var6;
         if(var7.f != var5) {
            if(var5) {
               var7.a(var1, var2);
            }

            var7.f = var5;
         }
      }

   }

   public boolean interact(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var1.isStatic) {
         return true;
      } else {
         TileEntity var9 = var1.s(var2);
         if(var9 instanceof TileEntityNote) {
            TileEntityNote var10 = (TileEntityNote)var9;
            var10.b();
            var10.a(var1, var2);
         }

         return true;
      }
   }

   public void a(World var1, Location var2, EntityHuman var3) {
      if(!var1.isStatic) {
         TileEntity var4 = var1.s(var2);
         if(var4 instanceof TileEntityNote) {
            ((TileEntityNote)var4).a(var1, var2);
         }

      }
   }

   public TileEntity a(World var1, int var2) {
      return new TileEntityNote();
   }

   private String b(int var1) {
      if(var1 < 0 || var1 >= a.size()) {
         var1 = 0;
      }

      return (String)a.get(var1);
   }

   public boolean a(World var1, Location var2, IBlockData var3, int var4, int var5) {
      float var6 = (float)Math.pow(2.0D, (double)(var5 - 12) / 12.0D);
      var1.a((double)var2.n() + 0.5D, (double)var2.o() + 0.5D, (double)var2.p() + 0.5D, "note." + this.b(var4), 3.0F, var6);
      var1.a(ew.x, (double)var2.n() + 0.5D, (double)var2.o() + 1.2D, (double)var2.p() + 0.5D, (double)var5 / 24.0D, 0.0D, 0.0D, new int[0]);
      return true;
   }

   public int b() {
      return 3;
   }

}

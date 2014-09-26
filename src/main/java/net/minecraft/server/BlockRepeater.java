package net.minecraft.server;
import java.util.Random;

public class BlockRepeater extends BlockDiodeAbstract {

   public static final bet a = bet.a("locked");
   public static final bew b = bew.a("delay", 1, 4);


   protected BlockRepeater(boolean var1) {
      super(var1);
      this.j(this.L.b().a(N, EnumFacing.NORTH).a(b, Integer.valueOf(1)).a(a, Boolean.valueOf(false)));
   }

   public IBlockData a(IBlockData var1, IBlockAccess var2, Location var3) {
      return var1.a(a, Boolean.valueOf(this.b(var2, var3, var1)));
   }

   public boolean interact(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      if(!var4.abilities.e) {
         return false;
      } else {
         var1.setTypeAndData(var2, var3.a(b), 3);
         return true;
      }
   }

   protected int d(IBlockData var1) {
      return ((Integer)var1.b(b)).intValue() * 2;
   }

   protected IBlockData e(IBlockData var1) {
      Integer var2 = (Integer)var1.b(b);
      Boolean var3 = (Boolean)var1.b(a);
      EnumFacing var4 = (EnumFacing)var1.b(N);
      return Blocks.DIODE_ON.P().a(N, var4).a(b, var2).a(a, var3);
   }

   protected IBlockData k(IBlockData var1) {
      Integer var2 = (Integer)var1.b(b);
      Boolean var3 = (Boolean)var1.b(a);
      EnumFacing var4 = (EnumFacing)var1.b(N);
      return Blocks.DIODE_OFF.P().a(N, var4).a(b, var2).a(a, var3);
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return Items.bb;
   }

   public boolean b(IBlockAccess var1, Location var2, IBlockData var3) {
      return this.c(var1, var2, var3) > 0;
   }

   protected boolean c(Block var1) {
      return d(var1);
   }

   public void remove(World var1, Location var2, IBlockData var3) {
      super.remove(var1, var2, var3);
      this.h(var1, var2, var3);
   }

   public IBlockData a(int var1) {
      return this.P().a(N, EnumFacing.b(var1)).a(a, Boolean.valueOf(false)).a(b, Integer.valueOf(1 + (var1 >> 2)));
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((EnumFacing)var1.b(N)).b();
      var3 |= ((Integer)var1.b(b)).intValue() - 1 << 2;
      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{N, b, a});
   }

}

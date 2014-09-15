package net.minecraft.server;
import java.util.Random;

public class BlockCommand extends atg {

   public static final bet a = bet.a("triggered");


   public BlockCommand() {
      super(Material.ORE);
      this.j(this.L.b().a(a, Boolean.valueOf(false)));
   }

   public TileEntity a(World var1, int var2) {
      return new bct();
   }

   public void a(World var1, Location var2, IBlockData var3, Block var4) {
      if(!var1.isStatic) {
         boolean var5 = var1.z(var2);
         boolean var6 = ((Boolean)var3.b(a)).booleanValue();
         if(var5 && !var6) {
            var1.a(var2, var3.a(a, Boolean.valueOf(true)), 4);
            var1.a(var2, (Block)this, this.a(var1));
         } else if(!var5 && var6) {
            var1.a(var2, var3.a(a, Boolean.valueOf(false)), 4);
         }
      }

   }

   public void b(World var1, Location var2, IBlockData var3, Random var4) {
      TileEntity var5 = var1.s(var2);
      if(var5 instanceof bct) {
         ((bct)var5).b().a(var1);
         var1.e(var2, this);
      }

   }

   public int a(World var1) {
      return 1;
   }

   public boolean a(World var1, Location var2, IBlockData var3, EntityHuman var4, EnumFacing var5, float var6, float var7, float var8) {
      TileEntity var9 = var1.s(var2);
      return var9 instanceof bct?((bct)var9).b().a(var4):false;
   }

   public boolean N() {
      return true;
   }

   public int l(World var1, Location var2) {
      TileEntity var3 = var1.s(var2);
      return var3 instanceof bct?((bct)var3).b().j():0;
   }

   public void a(World var1, Location var2, IBlockData var3, EntityLiving var4, ItemStack var5) {
      TileEntity var6 = var1.s(var2);
      if(var6 instanceof bct) {
         CommandBlockListenerAbstract var7 = ((bct)var6).b();
         if(var5.s()) {
            var7.b(var5.q());
         }

         if(!var1.isStatic) {
            var7.a(var1.Q().b("sendCommandFeedback"));
         }

      }
   }

   public int a(Random var1) {
      return 0;
   }

   public int b() {
      return 3;
   }

   public IBlockData a(int var1) {
      return this.P().a(a, Boolean.valueOf((var1 & 1) > 0));
   }

   public int c(IBlockData var1) {
      int var2 = 0;
      if(((Boolean)var1.b(a)).booleanValue()) {
         var2 |= 1;
      }

      return var2;
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

   public IBlockData a(World var1, Location var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLiving var8) {
      return this.P().a(a, Boolean.valueOf(false));
   }

}
